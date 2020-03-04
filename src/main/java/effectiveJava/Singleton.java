package effectiveJava;

import effectiveJava.beans.Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

public class Singleton {

    public static final Singleton singleton = new Singleton();
    private long id;
    private String name;

    static {

        System.out.println("start to initialize");
    }

    private Singleton() {

        this.id = Thread.currentThread().getId();
        this.name = this.getClass().getName();
        System.out.println("constructor invoked");
    }

    public void showInfo() {

        System.out.println(String.format("id is %d,name is %s", id, name));
    }


    public static void main(String[] args) {

        /*try (MyInputStream myInputStream = new MyInputStream()) {
            System.out.println("111");
            myInputStream.equals(new MyInputStream());
        } catch (Exception e) {
            System.out.println("aaa");
        } finally {
            System.out.println("finally");
        }*/
        List<Integer> l = new ArrayList(10);
        List<Data> datas = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        l.add(10);
        int[] a = {10};
        int[] b = a.clone();
        System.out.println(b[0]);
        Data[] data2 = {new Data(1, 1), new Data(2, 2)};
        Collections.addAll(datas, data2);
        TreeSet<Integer> set = new TreeSet<>();
        set.add(10);
    }


}
