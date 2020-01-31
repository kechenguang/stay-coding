package newBegin;


import java.util.List;

public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {

        if (matrix.length == 0) {
            return 0;
        }
        int res = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (matrix[i][j] == '1') {
                    if (j > 0) {
                        dp[i][j] = dp[i][j - 1] + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                    int width = dp[i][j];
                    for (int x = i; x >= 0; x--) {
                        int maxWith = Math.min(width, dp[x][j]);
                        res = Math.max(maxWith * (i - x + 1), res);
                    }
                }
            }
        }
        return res;
    }


    public int[][] generateMatrix(int n) {

        int[][] res = new int[n][n];
        int stat = 0;
        int x = 0;
        int y = 0;
        int count = 0;
        for (int i = 1; i <= n * n; i++) {
            res[x][y] = i;
            count++;
            int[] oldIndex = getIndexByStats(x, y, stat);
            if (count == n || res[oldIndex[0]][oldIndex[1]] != 0) {
                stat = (stat + 1) % 4;
                count = 1;
                int[] newIndex = getIndexByStats(x, y, stat);
                x = newIndex[0];
                y = newIndex[1];
            } else {
                x = oldIndex[0];
                y = oldIndex[1];
            }
        }
        return res;
    }

    public int[] getIndexByStats(int i, int j, int stats) {

        int[] res = new int[2];
        if (stats == 0) {
            res[0] = i;
            res[1] = j + 1;
        } else if (stats == 1) {
            res[0] = i + 1;
            res[1] = j;
        } else if (stats == 2) {
            res[0] = i;
            res[1] = j - 1;
        } else {
            res[0] = i - 1;
            res[1] = j;
        }
        return res;
    }
}
