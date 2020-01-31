package Proxy.Test;

import Proxy.XiaoMi;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy {

    private static XiaoMi xiaoMi = new XiaoMi();

    private static class method implements MethodInterceptor {


        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("CglibProxy");
            return method.invoke(xiaoMi, objects);
        }
    }

    public static void main(String args[]) {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(XiaoMi.class);
        enhancer.setCallback(new method());
        XiaoMi bigdata = (XiaoMi) enhancer.create();
        bigdata.work();
    }
}
