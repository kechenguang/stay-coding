package newBegin;

public class Temperature {

    public int[] dailyTemperatures(int[] T) {

        int l = T.length;
        int[] res = new int[l];
        if (l <= 1) {
            return res;
        }
        for (int i = l - 2; i >= 0; i--) {
            int j = i + 1;
            while (j <= l - 1) {
                if (T[j] > T[i]) {
                    res[i] = j - i;
                    break;
                } else {
                    int tmp = j;
                    j = j + res[j];
                    if (j == tmp) {
                        res[i]=0;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
