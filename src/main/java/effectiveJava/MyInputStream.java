package effectiveJava;

public class MyInputStream implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("close 方法被调用");
        throw new Exception();
    }


}
