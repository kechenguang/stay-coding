package redis;


import org.slf4j.LoggerFactory;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;
import org.slf4j.Logger;
import redis.clients.jedis.params.set.SetParams;

import java.util.HashSet;
import java.util.Set;


public class RedisClient {

    private volatile static JedisCluster jedisCluster = null;
    private volatile static Jedis jedis = null;
    //private static Logger logger = LoggerFactory.getLogger(RedisClient.class);

    public static JedisCluster getJedisCluster(Set<HostAndPort> jedisClusterNodes, JedisPoolConfig poolConfig) {
        if (null == jedisCluster) {
            synchronized (RedisClient.class) {
                if (null == jedisCluster) {
                    try {
                        jedisCluster = new JedisCluster(jedisClusterNodes, poolConfig);
                        //logger.info("create JedisCluster success");
                    } catch (Exception e) {
                        //logger.error("create JedisCluster failed", e);
                    }
                }
            }
        }
        return jedisCluster;
    }

    public static Jedis getJedis() {

        if (jedis == null) {
            synchronized (RedisClient.class) {
                if (jedis == null) {
                    jedis = new Jedis("10.38.161.190", 7000);
                }
            }
        }
        return jedis;
    }

    private static void resetJedis() {

        Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
        String[] hosts = {
                "10.38.161.190:7004",
                "10.38.163.209:7000",
                "10.38.161.190:7003"
                /*"10.132.33.7:16362",
                "10.132.33.4:16360",
                "10.132.30.44:16359",
                "10.132.32.47:16361",
                "10.132.32.47:16365",
                "10.132.33.25:16380",
                "10.132.33.7:16367",
                "10.132.30.44:16364",
                "10.132.32.44:16363",
                "10.132.33.25:16379",
                "10.132.33.4:16366",
                "10.132.32.44:16371"*/
        };

        for (String hostPort : hosts) {
            String[] parts = hostPort.split(":", 2);
            jedisClusterNodes.add(new HostAndPort(parts[0], Integer.parseInt(parts[1].trim())));
        }
        //}
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        getJedisCluster(jedisClusterNodes, poolConfig);
    }

    public static JedisCluster getInstance() {

        if (jedisCluster == null) {
            resetJedis();
        }
        return jedisCluster;
    }


    public static void main(String[] args) {

        JedisCluster jedis = RedisClient.getInstance();
        if (jedis == null) {
            throw new RuntimeException("get redis client failed");
        }

        SetParams setParams = SetParams.setParams();
        setParams.ex(100);
        setParams.nx();
        System.out.println(jedis.set("aadaxx", "ccc", setParams));

    }
}