package aop;

import Proxy.Company;
import Proxy.XiaoMi;

public class TestClass {

    public static void main(String args[]) {

        ProxyFactory proxyFactory = new ProxyFactory(new XiaoMi(), new MyInterceptor());
        Company newXiaoMi = (Company) proxyFactory.getProxyBean();
        newXiaoMi.work();
    }
}
