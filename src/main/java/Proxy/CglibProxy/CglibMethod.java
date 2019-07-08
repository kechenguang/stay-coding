package Proxy.CglibProxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibMethod implements MethodInterceptor {


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("i came from class CglibMethod ");
        Object o1 = methodProxy.invokeSuper(o, objects);
        //Object o1 = methodProxy.invoke(o, objects);
        return o1;
    }
}
