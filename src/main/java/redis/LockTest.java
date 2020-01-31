package redis;

public class LockTest {

    public static int i = 0;

    public static void main(String[] args) throws InterruptedException {

        for (int x = 0; x < 3; x++) {
            AddThread newThread = new AddThread();
            newThread.start();
        }
        Thread.sleep(5000);
        System.out.println(i);

    }

    private static class AddThread extends Thread {

       /* Integer integer;

        public AddThread(Integer i) {
            integer = i;
        }*/

        @Override
        public void run() {

            RedisDistributedLockV1 redisDistributedLockV1 = new RedisDistributedLockV1();
            redisDistributedLockV1.lock();
            System.out.println("开始执行加操作: " + Thread.currentThread().getId());
            try {
                for (int j = 0; j < 10; j++) {
                    i++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                redisDistributedLockV1.unLock();
            }
        }
    }
}
