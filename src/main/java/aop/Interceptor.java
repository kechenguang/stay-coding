package aop;

public interface Interceptor {

    public void before();

    public void after();

    public boolean useAround();

    public Object around(Invocation invocation);

    public void beforeReturn();

    public void beforeException();
}
