package Proxy.JDKProxy;

public class ProxyTest {

    public static void main(String[] args) {

        Say testClass1 = new TestClass();
        testClass1.sayA();
        testClass1.sayB();
        ProxyFactory factory = new ProxyFactory(testClass1);
        Say testClass2 = (Say) factory.getProxyInstance();
        testClass2.sayA();
        testClass2.sayB();
    }

}
