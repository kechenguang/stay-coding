package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationAnalysis implements Ainterface {

    private static String name;
    private static int age;
    public static int l;
    private int a;


    public static void analysis() {

        FiledTest test = new FiledTest();
        Class filedTest = test.getClass();
        Field[] fields = filedTest.getFields();
        Field[] fields1 = filedTest.getDeclaredFields();
        System.out.println(fields.length);
        for (Field filed : fields) {
            Name name = (Name) filed.getAnnotation(Name.class);
            System.out.println(name.filedAge());
        }
    }

    public static void main(String args[]) {

        Class f = AnnotationAnalysis.class;
        Method[] methods = f.getMethods();
        for (Method method : methods) {
            try {
                String methodName = method.getName();
                if (methodName.equals("analysis")) {
                    method.invoke(AnnotationAnalysis.class);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    private void say() {
        System.out.println("aaa");
    }
}
