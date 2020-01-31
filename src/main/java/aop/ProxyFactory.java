package aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory implements InvocationHandler {

    private Object target;
    private Interceptor interceptor;

    public ProxyFactory(Object target, Interceptor interceptor) {
        this.target = target;
        this.interceptor = interceptor;
    }

    public Object getProxyBean() {

        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new ProxyFactory(target, interceptor));
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object o;
        try {
            interceptor.before();
            if (interceptor.useAround()) {
                Invocation invocation = new Invocation(target, method, args);
                o = interceptor.around(invocation);
            } else {
                o = method.invoke(target, args);
            }
            interceptor.after();
        } catch (Exception e) {
            interceptor.beforeException();
            e.printStackTrace();
            throw e;
        }
        interceptor.beforeReturn();
        return o;
    }


}
