package lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.stream.Collectors;

public class User<T> {

    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getInt(T a) {

        return 10;

    }

    FutureTask<Integer> futureTaskc = new FutureTask<>(new Callable<Integer>() {
        @Override
        public Integer call() throws Exception {
            return 10;
        }
    });
    Thread thread = new Thread(futureTaskc);


    public static void main(String args[]) {

        List<User> users = new ArrayList<>();
        users.add(new User(1, "aaa"));
        users.add(new User(2, "cccc"));
        users.add(new User(10, "1111"));
        List<User> res = new ArrayList<>();
        HashMap<String, User> re = new HashMap<>();
        users.stream().mapToInt(x -> x.getAge());
        res = users.stream().sorted((x, y) -> x.getAge() - y.getAge()).filter(x -> x.getAge() > 5).collect(Collectors.toList());

    }
}
