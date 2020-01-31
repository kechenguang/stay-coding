package Leecode;

import java.util.LinkedHashMap;

public class DoubleProxy {

    public double myPow(double x, int n) {

        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double ans = 1;
        double mid = x;
        for (int i = n; i > 0; i /= 2) {
            if (n % 2 == 1) {
                ans = ans * mid;
            }
            mid = mid * mid;
        }

        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.entrySet();
        return ans;

    }



}
