package effectiveJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

public class chapter2 {


    public static void main(String[] args) {

        int i = 1;
        int j = -2;
        System.out.println(Integer.toBinaryString(j));
        System.out.println(Integer.toBinaryString(j >>> 1));
        System.out.println(i << 32);
        System.out.println(j << 2);
    }
}
