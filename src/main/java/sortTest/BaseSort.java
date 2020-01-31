package sortTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 只能是基于正整数的排序,时间复杂度是常熟
 */
public class BaseSort {

    public static void sort(int[] a) {

        boolean shouldEnd = true;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int dev = 10;
        for (int i = 1; ; i *= 10) {
            dev *= i;
            for (int j = 0; j < a.length; j++) {
                int res = (a[j] % dev) / i;
                if (res > 0) {
                    shouldEnd = false;
                }
                List<Integer> array = map.get(res);
                if (array != null) {
                    array.add(a[j]);
                } else {
                    array = new ArrayList<>();
                    array.add(a[j]);
                    map.put(res, array);
                }
            }
            System.out.println(map.toString());
            int k = 0;
            for (int r = 0; r <= 9; r++) {
                List<Integer> list = map.get(r);
                if (list != null) {
                    for (Integer x : list) {
                        a[k++] = x;
                    }
                }
            }
            map.clear();
            if (shouldEnd) {
                break;
            } else {
                shouldEnd = true;
            }
        }
    }

    public static void main(String[] args) {

        int[] a = {5, 4, 3, 10, 100, 3, 20};
        sort(a);
        SortUtils.printArray(a);

    }
}
