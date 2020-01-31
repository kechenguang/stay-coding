package someTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class InterfaceClass implements InterfaceTest {

    public static void main(String[] args) {

        System.out.println(a);
        InterfaceTest.testa();
        Map<String, String> map = new HashMap<String, String>(16, 0.75f);
        map.put(null, null);
        map.put(null, null);
        System.out.println(map.toString());
        Set<String> s = new HashSet<>();
        //s.add()
        Runnable runnable = () -> {
            System.out.println();
        };
        final InterfaceClass interfaceClass = new InterfaceClass();
        AtomicStampedReference<Integer> a = new AtomicStampedReference<>(100, 0);
        a.compareAndSet(100, 101, 10, 11);
        AtomicInteger integer = new AtomicInteger();
        integer.addAndGet(10);
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        ExecutorService executorService1 = Executors.newCachedThreadPool();

    }

    public void run() {

    }


}
