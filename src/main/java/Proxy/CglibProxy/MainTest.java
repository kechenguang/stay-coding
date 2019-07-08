package Proxy.CglibProxy;

import net.sf.cglib.proxy.Enhancer;

public class MainTest {

    public static void main(String[] args) {

        CglibMethod cglibMethod = new CglibMethod();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CglibTest.class);
        enhancer.setCallback(cglibMethod);

        CglibTest cglibTest = (CglibTest) enhancer.create();
        cglibTest.sayAWord();


    }

}
