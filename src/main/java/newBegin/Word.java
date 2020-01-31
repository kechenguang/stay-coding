package newBegin;

public class Word {

    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private int l;
    private int w;

    public boolean exist(char[][] board, String word) {

        int l = board.length;
        if (l == 0) {
            return false;
        }
        int w = board[0].length;
        if (l * w < word.length()) {
            return false;
        }
        int[][] path = new int[l][w];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < w; j++) {
                if (trackBack(board, word, i, j, path, 1)) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean trackBack(char[][] board, String word, int x, int y, int[][] path, int begin) {

        char nextChar = word.charAt(begin);
        if (begin == word.length() - 1) {
            return board[x][y] == nextChar;
        }
        if (board[x][y] == nextChar) {
            path[x][y] = 1;
            for (int a = 0; a < 4; a++) {
                int nextX = x + direction[a][0];
                int nextY = y + direction[a][1];
                if (inArea(nextX, nextY) && path[nextX][nextY] == 0) {
                    if (trackBack(board, word, nextX, nextY, path, begin + 1)) {
                        return true;
                    }
                }
            }
            path[x][y] = 0;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < l && y >= 0 && y < w;
    }


}
