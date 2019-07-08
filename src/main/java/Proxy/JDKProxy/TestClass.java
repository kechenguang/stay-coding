package Proxy.JDKProxy;

//被代理类
public class TestClass implements Say {


    public void sayA() {

        System.out.print("say a");
    }

    public void sayB() {

        System.out.print("say b");
    }
}
