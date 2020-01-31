package aop;

public class MyInterceptor implements Interceptor {

    @Override
    public void before() {
        System.out.println("before...");
    }

    @Override
    public void after() {
        System.out.println("after...");
    }

    @Override
    public boolean useAround() {
        return true;
    }

    @Override
    public Object around(Invocation invocation) {
        System.out.println("running around");
        return invocation.process();
    }

    @Override
    public void beforeReturn() {
        System.out.println("before return");
    }

    @Override
    public void beforeException() {
        System.out.println("you are not important");
    }
}
