package newBegin;

import java.util.ArrayList;
import java.util.List;

public class RectangleOrder {

    private int m;
    private int n;
    private int[][] index = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();
        m = matrix.length;
        if (m == 0) {
            return res;
        }
        n = matrix[0].length;
        int[][] path = new int[m][n];
        int stats = 0;
        int x = 0, y = 0, num = m * n;
        for (int i = 0; i < num; i++) {
            res.add(matrix[x][y]);
            path[x][y] = 1;
            int nextX = x + index[stats][0];
            int nextY = y + index[stats][1];
            System.out.println("nextX: " + nextX + "nextY: " + nextY);
            if (nextX >= m || nextY >= n || path[nextX][nextY] == 1 || shouldTurn(x, y)) {
                stats = (stats + 1) % 4;
            }
            x = x + index[stats][0];
            y = y + index[stats][1];
        }
        return res;
    }

    public boolean shouldTurn(int x, int y) {

        if (x == 0 && y == n - 1) {
            return true;
        }
        if (x == m - 1 && y == n - 1) {
            return true;
        }
        if (x == m - 1 && y == 0) {
            return true;
        }
        if (x == 1 && y == 0) {
            return true;
        }
        return false;
    }


}
