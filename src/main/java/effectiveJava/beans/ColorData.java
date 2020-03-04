package effectiveJava.beans;

import java.util.Comparator;

import static java.util.Comparator.comparingInt;

public class ColorData extends Data {

    private int color;

    public ColorData(int x, int y) {
        super(x, y);
    }

    public static void main(String[] args) {

        System.out.println(new ColorData(10, 10).compareTo(new ColorData(20, 10)));
    }

    private static final Comparator<Data> COMPARATOR = comparingInt((Data d) -> d.x);
}
