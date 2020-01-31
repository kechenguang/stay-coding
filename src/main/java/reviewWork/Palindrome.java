package reviewWork;

import java.util.HashSet;
import java.util.Set;

public class Palindrome {

    public String longestPalindrome(String s) {

        int n = s.length();
        if (n <= 1) {
            return s;
        }
        String res = "";
        for (int i = 0; i < n; i++) {
            char start = s.charAt(i);
            for (int j = n - 1; j >= i; j--) {
                while (j >= i && s.charAt(j) != start) {
                    j--;
                }
                if (j < i) {
                    break;
                }
                if (checkPalindrome(s.substring(i, j + 1))) {
                    res = j - i + 1 > res.length() ? s.substring(i, j + 1) : res;
                    break;
                }
            }
        }
        return s;
    }

    private boolean checkPalindrome(String s) {

        String newString = new StringBuilder(s).reverse().toString();
        return newString.equals(s);
    }
}
