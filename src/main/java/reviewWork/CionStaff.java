package reviewWork;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CionStaff {

    public int coinChange(int[] coins, int amount) {

        return findCoin(coins, amount, new int[amount]);
    }

    private int findCoin(int[] coins, int amount, int[] record) {

        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (record[amount - 1] != 0) {
            return record[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = findCoin(coins, amount - coins[i], record);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        record[amount - 1] = min;
        return record[amount - 1];
    }
}
