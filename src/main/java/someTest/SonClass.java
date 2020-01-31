package someTest;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.util.*;

import static java.lang.invoke.MethodHandles.lookup;

public class SonClass extends FatherClass {

    @Override
    public void sayHello() {

        System.out.println("man");
    }


    public static void main(String[] args) {

        /*FatherClass fatherClass = new SonClass();
        SonClass sonClass = new SonClass();
        fatherClass.sayHello();
        sonClass.sayHello();*/
        HashSet<String> s = new HashSet<>();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.remove("ccc");
        Hashtable<String, String> stringStringHashtable = new Hashtable<>();
        stringStringHashtable.put("aaa", "aaa");
        stringStringHashtable.put("BBB", "NNN");
        stringStringHashtable.remove("ccc");
        for (Map.Entry entry : stringStringHashtable.entrySet()) {
            stringStringHashtable.remove(entry.getKey());
        }
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>(10, 0.75f, true);
        map.put("aaa", "aaa");
        map.put("bbb", "bbb");
        Set<Map.Entry<String, String>> set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            map.get("aaa");
        }
        //stringStringHashtable.put(
        /*human man = new man();
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
        }*/
     /*  f.sayHello(man);
       f.sayHello(woman);*/

    }

    public MethodHandle getHadnle(Object obj) throws NoSuchMethodException, IllegalAccessException {

        MethodType type = MethodType.methodType(void.class, String.class);
        return lookup().findVirtual(obj.getClass(), "print", type).bindTo(obj);

    }


}
