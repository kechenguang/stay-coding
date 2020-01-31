package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.params.Params;
import redis.clients.jedis.params.set.SetParams;

/**
 * 可重入，排他，分布式锁
 * <p>
 * 客户端A获取锁成功，过期时间30秒。
 * 客户端A在某个操作上阻塞了50秒。
 * 30秒时间到了，锁自动释放了。
 * 客户端B获取到了对应同一个资源的锁。
 * 客户端A从阻塞中恢复过来，释放掉了客户端B持有的锁。
 */
public class RedisDistributedLockV1 {

    private boolean master = false;
    //private boolean refresh = false;
    private static final int EXPIRE_TIME = 30;
    private final String lockKey = "tryLock";
    private final String lockValue = Thread.currentThread().getId() + "_" + System.currentTimeMillis();


    public void lock() {

        tryLockV1();
    }

    private void tryLockV1() {

        JedisCluster clusterClient = RedisClient.getInstance();
        if (clusterClient == null) {
            throw new RuntimeException("get redis client failed");
        }
        while (true) {
            if (master == true) {
                clusterClient.get(lockKey);
                return;
            }
            if (clusterClient.setnx(lockKey, lockValue) > 0) {
                //todo:1.如果执行到上一步服务异常，设置过期时间失效，则一直无法释放锁（解决办法见v2）
                //todo:2.如果执行完下一步，获取锁内的代码还没执行完，就已经释放锁了
                clusterClient.expire(lockKey, EXPIRE_TIME);
                master = true;
                return;
            }
        }
    }

    private void tryLockV2() {

        Jedis jedis = RedisClient.getJedis();
        if (jedis == null) {
            throw new RuntimeException("get redis client failed");
        }
        while (true) {
            if (master == true) {
                jedis.get(lockKey);
                //单独启动一个线程，定期刷新key的过期时间
                new RefreshKey(lockKey, lockValue).start();
                return;
            }
            SetParams setParams = SetParams.setParams();
            setParams.ex(EXPIRE_TIME);
            setParams.nx();
            if ("OK".equals(jedis.set(lockKey, lockValue, setParams))) {
                //todo:解决了上边的第一个问题
                //todo:第二个问题没有得到解决
                master = true;
                return;
            }
        }
    }

    public void unLock() {

        JedisCluster clusterClient = RedisClient.getInstance();
        if (clusterClient == null) {
            throw new RuntimeException("get redis client failed");
        }
        if (!master) {
            throw new RuntimeException("此线程未获取到锁");
        }
        clusterClient.del(lockKey);
        master = false;
    }

    //定期刷新key过期时间的线程
    private class RefreshKey extends Thread {

        private String expectKey;
        private String expectValue;

        public RefreshKey(String s1, String s2) {

            expectKey = s1;
            expectValue = s2;
        }

        @Override
        public void run() {

            JedisCluster clusterClient = RedisClient.getInstance();
            boolean stop = false;
            while (!stop) {
                String lua = "if redis.call('get', KEYS[1]) == ARGV[1] then " +
                        "return redis.call('expire',KEYS[1],ARGV[2]) " +
                        "else " +
                        "return 0 end";
                clusterClient.eval(lua, 1, expectKey, expectValue, "30");
                if (!expectValue.equals(clusterClient.get(expectKey))) {
                    stop = true;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
