package rpc;

import java.io.*;

public class TestRpc {

    public static void main(String[] args) {

        User user = new User("kechenguang", 26, "dali", "male");

        try {
            ObjectOutputStream objectOutputStream = null;
            FileOutputStream outputStream = new FileOutputStream(new File("D:\\code\\home\\kechenguang\\code\\stay-coding\\src\\main\\resources\\kechenguang.txt"));
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(user);
            //读取对象
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("D:\\code\\home\\kechenguang\\code\\stay-coding\\src\\main\\resources\\kechenguang.txt")));
            User serializeUser = (User) objectInputStream.readObject();
            System.out.println(serializeUser.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
