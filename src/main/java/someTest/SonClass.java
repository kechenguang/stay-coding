package someTest;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.lang.invoke.MethodHandles.lookup;

public class SonClass extends FatherClass {

    public static void sayHello() {

        System.out.println("i am son");
    }

    static abstract class human {

    }

    static class woman extends human {

    }

    static class man extends human {

    }

    public void sayHello(human human) {

        System.out.println("human");
    }

    public void sayHello(woman woman) {

        System.out.println("woman");
    }

    public void sayHello(man man) {

        System.out.println("man");
    }

    public void print(String a) {

        System.out.println(a);
    }


    public static void main(String[] args) {

        human man = new man();
        human woman = new woman();
        SonClass f = new SonClass();
        FatherClass haha = new FatherClass();
        FatherClass hahaha = new SonClass();
        List<String> a = new ArrayList<String>();
        Collections.sort(a, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        try {
            MethodHandle handle = f.getHadnle(haha);
            System.out.println(haha.getClass());
            handle.invokeExact("kekeke");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
     /*  f.sayHello(man);
       f.sayHello(woman);*/
    }

    public MethodHandle getHadnle(Object obj) throws NoSuchMethodException, IllegalAccessException {

        MethodType type = MethodType.methodType(void.class, String.class);
        return lookup().findVirtual(obj.getClass(), "print", type).bindTo(obj);

    }


}
