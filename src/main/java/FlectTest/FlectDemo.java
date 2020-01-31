package FlectTest;

import annotation.AnnotationAnalysis;
import annotation.FiledTest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class FlectDemo {

    public static void main(String[] args) {

        try {
            //获取class对象的3种方式
            Class annotationAnalysis = Class.forName("annotation.AnnotationAnalysis");
            Class annotationAnalysis01 = new AnnotationAnalysis().getClass();
            Class annotationAnalysis02 = AnnotationAnalysis.class;

            //获取到这个类相关的属性
            Field[] privateField = annotationAnalysis.getFields();
            Field[] allField = annotationAnalysis.getDeclaredFields();
            for (Field filed : privateField) {
                System.out.println(filed.getName());
            }
            System.out.println("-------");
            for (Field field : allField) {
                System.out.println(field.getName());
                //获取注解信息
                field.getAnnotations();
            }

            //获取方法,无法获取到默认构造方法
            Method[] methods = annotationAnalysis01.getMethods();
            Method[] allMethods = annotationAnalysis01.getDeclaredMethods();
            for (Method method : allMethods) {
                System.out.println(method.getName());
                if (method.getName().equals("main")) {
                    //method.invoke(AnnotationAnalysis.class, new String("aaa"));
                    Class[] classes = method.getParameterTypes();
                    for (Class c : classes) {
                        c.getName();
                    }
                    Class returnType = method.getReturnType();
                    System.out.println("return type " + returnType.getName());
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
