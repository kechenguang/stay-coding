package reviewWork;

public class MaxStaff {

    public int maximalRectangle(char[][] matrix) {

        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] width = new int[m][n];
        int maxRectangle = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    width[i][j] = j > 0 ? width[i][j - 1] + matrix[i][j] - '0' : matrix[i][j] - '0';
                    int w = width[i][j];
                    for (int hight = i - 1; hight >= 0; hight--) {
                        int h = i - hight + 1;
                        w = Math.min(w, width[hight][j]);
                        maxRectangle = Math.max(h * w, maxRectangle);
                    }
                }
            }
        }
        return maxRectangle;
    }


    public int maximalSquare(char[][] matrix) {

        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] width = new int[m][n];
        int maxSquare = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    width[i][j] = j > 0 ? width[i][j - 1] + matrix[i][j] - '0' : matrix[i][j] - '0';
                    int w = width[i][j];
                    for (int h = i; h >= 0; h--) {
                        int hight = i - h + 1;
                        w = Math.min(w, width[h][j]);
                        if (w < hight) {
                            break;
                        }
                        if (w >= hight) {
                            maxSquare = Math.max(hight * hight, maxSquare);
                        }
                    }
                }
            }
        }
        return maxSquare;
    }

    public int largestRectangleArea(int[] heights) {

        if (heights.length == 0) {
            return 0;
        }
        return fenzhi(heights, 0, heights.length - 1);
    }

    private int fenzhi(int[] heights, int start, int end) {

        if (start > end) {
            return 0;
        }
        int shortestIndex = start;
        for (int i = start; i <= end; i++) {
            if (heights[shortestIndex] < heights[i]) {
                shortestIndex = i;
            }
        }
        return Math.max((end - start + 1) * heights[shortestIndex], Math.max(fenzhi(heights, start, shortestIndex - 1), fenzhi(heights, shortestIndex + 1, end)));
    }
}
