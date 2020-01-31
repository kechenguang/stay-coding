package Leecode;

public class LongestString {

    public String longestPalindrome(String s) {

        String s1 = new StringBuilder(s).reverse().toString();
        int max = 0;
        int[][] res = new int[s.length()][s.length()];
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            for (int j = 0; j < s1.length(); j++) {
                char b = s.charAt(j);
                if (a == b) {
                    if (i > 0 && j > 0) {
                        res[i][j] = res[i - 1][j - 1] + 1;
                    } else {
                        res[i][j] = 1;
                    }
                } else {
                    res[i][j] = 0;
                }
                if (res[i][j] > max) {
                    int beforeRev = s.length() - 1 - j;
                    if (beforeRev + res[i][j] - 1 == i) {
                        max = res[i][j];
                        start = i;
                    }
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (; max > 0; max--) {
            builder.append(s.charAt(start));
            start--;
        }
        return builder.toString();
    }
}
