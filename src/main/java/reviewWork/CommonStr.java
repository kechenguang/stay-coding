package reviewWork;

import sun.swing.StringUIClientPropertyKey;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class CommonStr {

    /**
     * 最长公共子序列
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSequence(String text1, String text2) {

        if (text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        int[][] res = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    res[i][j] = res[i - 1][j - 1] + 1;
                } else {
                    res[i][j] = Math.max(res[i][j - 1], res[i - 1][j]);

                }
            }
        }
        return res[text1.length()][text2.length()];
    }

    /**
     * 最长的不重复子字符串
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 0) {
            return 0;
        }
        Queue<Character> characters = new LinkedList<>();
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (characters.contains(c)) {
                longest = Math.max(longest, characters.size());
                while (!characters.peek().equals(c)) {
                    characters.poll();
                }
                characters.poll();
            }
            characters.offer(c);
        }
        return longest;
    }

    /**
     * 最大和的连续子数组
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {

        int l = nums.length;
        if (l == 0) {
            return 0;
        }
        int[] mid = new int[l];
        mid[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < l; i++) {
            if (mid[i - 1] > 0) {
                mid[i] = mid[i - 1] + nums[i];
            } else {
                mid[i] = nums[i];
            }
            max = Math.max(mid[i], max);
        }
        return max;

    }

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return null;
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];
            while (s.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.length() == 0) {
                    return "";
                }
            }
        }
        return prefix;
    }


}
