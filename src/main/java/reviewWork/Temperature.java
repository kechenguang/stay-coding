package reviewWork;

public class Temperature {

    public int[] dailyTemperatures(int[] T) {

        int[] res = new int[T.length];
        if (T.length <= 1) {
            return res;
        }
        int[][] mid = new int[T.length][2];
        for (int i = T.length - 1; i >= 0; i++) {
            for (int j = i + 1; j < T.length; ) {
                if (T[i] >= T[j]) {
                    if (mid[j][0] > 0) {
                        j = mid[j][1];
                    } else {
                        mid[i][0] = 0;
                    }
                } else {
                    res[i] = mid[i][0] = j - i;
                    mid[i][j] = j;
                }
            }
        }
        return res;
    }
}
