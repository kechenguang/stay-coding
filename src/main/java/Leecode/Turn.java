package Leecode;

public class Turn {

    public void rotate(int[][] matrix) {

        int n = matrix[0].length;
        //先转置矩阵，在翻转每一行
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int tem = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tem;
            }
        }
        for (int k = 0; k < n; k++) {
            for (int x = 0; x < n / 2; x++) {
                int tem = matrix[k][x];
                matrix[k][x] = matrix[k][n - x-1];
                matrix[k][n - x-1] = tem;
            }
        }
    }
}
