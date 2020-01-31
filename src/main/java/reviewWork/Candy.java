package reviewWork;

import java.util.Arrays;

public class Candy {

    public int candy(int[] ratings) {

        int l = ratings.length;
        if (l == 0) {
            return 0;
        }
        int[] left = new int[l];
        //int[] right = new int[l];
        int sum = 0;
        Arrays.fill(left, 1);
        //Arrays.fill(right, 1);
        for (int i = 1; i < l; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        for (int j = l - 2; j >= 0; j--) {
            if (ratings[j] > ratings[j + 1]) {
                left[j] = Math.max(left[j + 1] + 1, left[j]);
            }
        }
        for (int x = 0; x < l; x++) {
            sum += left[x];
        }
        return sum;
    }
}
