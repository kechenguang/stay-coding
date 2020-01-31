package Proxy.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy {

    private Object object;

    public JdkProxy(Object o) {
        this.object = o;
    }

    public Object getJdkProxy() {

        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                System.out.println("JdkProxy");
                return method.invoke(object, args);

            }
        });
    }

    public static void main(String args[]) {

        /*JdkProxy proxy = new JdkProxy(new Proxy.XiaoMi());
        Proxy.Company company = (Proxy.Company) proxy.getJdkProxy();
        company.work();*/
    }

}
