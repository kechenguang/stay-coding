package Proxy.JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target) {

        this.target = target;
    }

    public Object getProxyInstance() {

        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {

            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                System.out.print("get start");
                Object returnValue = method.invoke(target, args);
                System.out.print("get end");
                return returnValue;
            }
        });

    }

}
