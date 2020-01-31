package reviewWork;

public class SearchWord {

    int[][] direction = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public boolean exist(char[][] board, String word) {

        int l = board.length;
        if (l == 0) {
            return false;
        }
        if (word == null) {
            return false;
        }
        int w = board[0].length;
        int[][] road = new int[l][w];
        boolean res = false;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < w; j++) {
                if (board[i][j] == word.charAt(0)) {
                    road[i][j] = 1;
                    res = search(board, road, word, 1, i, j);
                    if (res) {
                        return res;
                    }
                    road[i][j] = 0;
                }
            }
        }
        return res;
    }

    public boolean search(char[][] board, int[][] road, String word, int start, int x, int y) {

        if (start == word.length()) {
            return true;
        }
        char target = word.charAt(start);
        boolean res = false;
        for (int i = 0; i < 4; i++) {
            int nextx = x + direction[i][0];
            int nexty = y + direction[i][1];
            if (nextx >= board.length || nextx < 0 || nexty >= board[0].length || nexty < 0) {
                continue;
            }
            if (road[nextx][nexty] != 1 && board[nextx][nexty] == target) {
                road[nextx][nexty] = 1;
                res = search(board, road, word, start + 1, nextx, nexty);
                road[nextx][nexty] = 0;
            }
            if (res == true) {
                break;
            }
        }
        return res;
    }



}
