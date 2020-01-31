package someTest;


import com.sun.org.apache.xpath.internal.functions.Function;
import sun.misc.Unsafe;

import java.lang.ref.WeakReference;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Bclass {

    //public static int a = 10;
    public static final Integer a = 20;
    private int c = 0;
    private Aclass aclass;

    public Bclass(Aclass aclass) {
        this.aclass = aclass;
    }

    public static void a() {

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        System.out.println("".length());
        Map<String, String> a = new ConcurrentHashMap<>();
        StringBuilder builder = new StringBuilder("a");
        StringBuffer buffer = new StringBuffer("a");
        //ExecutorService service = Executors.newFixedThreadPool();
        //Executors.newFixedThreadPool();、 = new String("aaa");
        /*ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
        stringThreadLocal.set(new String("aaa"));
        WeakReference<String> w1 = new WeakReference<>(new String("bbb"));
        System.out.println(stringThreadLocal.get());
        System.out.println(w1.get());
        System.gc();
        //System.out.println(stringThreadLocal.get());
        System.out.println(w1.get());*/
        /*Map<String, String> hashMap = new ConcurrentHashMap<>();
        hashMap.put("aaa", "aaa");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        FutureTask futureTask = new FutureTask();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println(Thread.currentThread().getId());
                getLocalThread().set("String");
                for (int i = 100000; i > 0; i--) {
                }
            }
        });
        thread1.start();
        System.gc();
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        AtomicInteger integer = new AtomicInteger(10);
        integer.addAndGet(200);
        integer.getAndIncrement();
        *//*Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println(Thread.currentThread().getId() + " " + a.hashCode());
                System.out.println();
            }
        });*//*
        // a = null;
        System.gc();*/
        /*Callable callable = new myCallable();
        ExecutorService pool = Executors.newFixedThreadPool(10);
        //pool.execute();
        Future<String> future = pool.submit(callable);
        //future.get(1, TimeUnit.SECONDS);
        FutureTask<String> futureTask = new FutureTask<String>(new myCallable());
        new Thread(futureTask).start();
        futureTask.get();
        System.out.println("aaa");
        Thread thread = new Thread();
        AtomicStampedReference astomicStampedReference = new AtomicStampedReference(thread, 10);
        Thread.yield();
        thread.interrupt();*/

    }

    private static class myCallable implements Callable<String> {


        @Override
        public String call() throws Exception {
            System.out.println(Thread.currentThread().getId());
            Thread.sleep(2000);
            return null;
        }
    }

    public void b(int[] a) {

        System.out.println("a");
    }

    public static ThreadLocal<String> getLocalThread() {

        return new ThreadLocal<>();
    }


    public static void length(int[] array) {

        int[] DP = new int[array.length];
        int maxLength = 1, bestEnd = 0;
        DP[0] = 1;
        //prev[0] = -1;
        for (int i = 0; i < array.length; i++) {
            DP[i] = 1;
            //prev[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (DP[j] + 1 > DP[i] && array[j] < array[i]) {
                    DP[i] = DP[j] + 1;
                    //prev[i] = j;
                }

                if (DP[i] > maxLength) {
                    bestEnd = i;
                    maxLength = DP[i];
                }
            }

        }
        System.out.println("bestEnd is " + bestEnd);
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n;
    }
}