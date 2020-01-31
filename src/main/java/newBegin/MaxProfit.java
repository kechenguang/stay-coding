package newBegin;

public class MaxProfit {

    public int maxProfit(int[] prices) {

        int[] max = new int[prices.length];
        max[0] = 0;
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            max[i] = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (prices[i] > prices[j]) {
                    max[i] = Math.max(max[i], max[j] + (prices[i] - prices[j]));
                }
            }
            res = Math.max(res, max[i]);
        }
        return res;
    }
}
