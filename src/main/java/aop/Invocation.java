package aop;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Invocation {

    private Object o;
    private Method method;
    private Object[] objects;

    public Invocation(Object o, Method method, Object[] objects) {
        this.o = o;
        this.method = method;
        this.objects = objects;
    }

    public Object process() {

        try {
            return method.invoke(o, objects);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
