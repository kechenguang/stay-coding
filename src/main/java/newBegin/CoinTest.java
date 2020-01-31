package newBegin;

public class CoinTest {

    public static void main(String args) {


    }


    public static int coinChange(int[] coins, int amount) {

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > amount) {
                continue;
            } else if (coins[i] > amount) {
                int tmp = coinChange(coins, amount - coins[i]);
                if (tmp != -1) {
                    min = Math.min(min, 1 + tmp);
                }
            } else {
                return 1;
            }
        }
        return min < Integer.MAX_VALUE ? min : -1;
    }

    public  int coinChangeIndex(int[] coins, int amount, int[] record) {

        int min = Integer.MAX_VALUE;
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (record[amount - 1] != 0) {
            return record[amount - 1];
        }
        for (int i = 0; i < coins.length; i++) {
            int tmp = coinChangeIndex(coins, amount - coins[i], record);
            if (tmp > -1) {
                min = Math.min(min, tmp + 1);
            }
        }
        record[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return record[amount - 1];

    }
}
