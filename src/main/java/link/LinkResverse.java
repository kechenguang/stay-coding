package link;

import java.util.concurrent.locks.ReentrantLock;

public class LinkResverse {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public synchronized void test() {

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void testLock(Thread linkResverse) {

        synchronized (linkResverse) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String args[]) throws InterruptedException {

        /*LinkResverse linkResverse = new LinkResverse();
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("0000");
            }
        });
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("thread1 start");
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("get 111");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                linkResverse.testLock(thread);
                System.out.println("aaa");
            }
        });
        thread2.start();
        thread1.start();*/
        LinkResverse linkResverse = new LinkResverse();
        linkResverse.notifyAll();
        Thread.interrupted();
        Thread.interrupted();
    }


}
