package someTest;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.*;

public class ThreadC implements Callable, Serializable {

    private int x = 1111;

    @Override
    public Object call() throws Exception {
        System.out.println("cccc");
        return null;
    }

    public synchronized void a() {

    }

    public static synchronized void b() {


    }

    public void c() {

        synchronized (ThreadC.class) {

        }
    }

    public static void main(String[] args) throws Exception {

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("a.txt"));
        objectOutputStream.writeObject(new ThreadC());

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("a.txt"));
        ThreadC threadC = (ThreadC) objectInputStream.readObject();
        System.out.println(threadC.x);
        /*new Thread(new ThreadA()).start();
        new ThreadA().start();            //ThreadA继承了Thread类
        new Thread(new ThreadB()).start(); //ThreadB实现了Runnable接口
        new Thread(new FutureTask<ThreadC>(new ThreadC())).start();//ThreadC实现了Callable接口

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Executors.newCachedThreadPool();
        Executors.newScheduledThreadPool(10);

        Class a = ThreadC.class;
        Class b = new ThreadC().getClass();

        Method[] c = a.getDeclaredMethods();
        Method[] d = a.getMethods(); //只获取public方法
        for (Method method : d) {
            method.getName();
            method.getParameters();
        }
        Field[] e = a.getFields();*/

    }
}
