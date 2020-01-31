package annotation;

public class FiledTest {

    @Name(filedName = "100")
    public static String name;

    @Name(filedAge = 100)
    public static int age;

    public void saySomething() {
        System.out.println("gogogo");
    }


}
