package someTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestThread {

    public static void main(String args[]) {

        Lock lock = new ReentrantLock();
        Thread thread01 = new Thread(new Runnable() {

            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("get lock thread01");
                    try {
                        lock.wait(1000);
                        System.out.println("wait return");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread thread02 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("get lock thread02");
                    try {
                        Thread.sleep(2000);
                        lock.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("release lock thread02");
            }
        });

        thread01.start();
        thread02.start();
    }

}
