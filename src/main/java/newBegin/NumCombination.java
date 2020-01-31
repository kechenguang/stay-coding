package newBegin;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NumCombination {


    String[][] chars = {{"a", "b", "c"},
            {"d", "e", "f"},
            {"g", "h", "i"},
            {"j", "k", "l"},
            {"m", "n", "o"},
            {"p", "q", "r", "s"},
            {"t", "u", "v"},
            {"w", "x", "y", "z"}};

    public List<String> letterCombinations(String digits, int start) {

        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        int num = '0' - digits.charAt(start) - 2;
        String[] strings = chars[num];
        if (start == digits.length() - 1) {
            for (int i = 0; i < strings.length; i++) {
                res.add(strings[i]);
            }
        } else {
            List<String> mid = letterCombinations(digits, start + 1);
            for (int i = 0; i < strings.length; i++) {
                for (int j = 0; j < mid.size(); j++) {
                    res.add(strings[i] + mid.get(j));
                }
            }
        }
        return res;
    }


    public List<List<String>> partition(String s) {

        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        partition(s, 0, res, new Stack<>());
        return res;

    }

    public void partition(String s, int start, List<List<String>> res, Stack<String> stringStack) {

        if (start == s.length()) {
            res.add(new ArrayList<>(stringStack));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isVaild(s.substring(start, i + 1))) {
                continue;
            }
            stringStack.push(s.substring(start, i + 1));
            partition(s, start + 1, res, stringStack);
            stringStack.pop();
        }
    }

    public boolean isVaild(String a) {

        if (a.length() == 0) {
            return false;
        }
        StringBuilder builder = new StringBuilder(a);
        String a2 = builder.reverse().toString();
        if (a.equals(a2)) {
            return true;
        } else {
            return false;
        }
    }


    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        Stack<Character> a = new Stack<>();
        Stack<Character> b = new Stack<>();
        for (int i = 0; i < n; i++) {
            a.push('(');
            b.push(')');
        }
        a.pop();
        List<Stack<Character>> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        backTrack("(", list, res, n * 2);
        return res;
    }

    public void backTrack(String baseStr, List<Stack<Character>> list, List<String> res, int finalLength) {

        if (baseStr.length() == finalLength) {
            if (checkParenthesis(baseStr)) {
                res.add(baseStr);
            }
            return;
        }
        for (int i = 0; i < 2; i++) {
            Stack<Character> stack = list.get(i);
            if (!stack.isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder(baseStr);
                char c = stack.pop();
                stringBuilder.append(c);
                backTrack(stringBuilder.toString(), list, res, finalLength);
                stack.push(c);
            }
        }
    }

    private boolean checkParenthesis(String a) {

        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '(') {
                characters.push('(');
            } else {
                if (characters.isEmpty()) {
                    return false;
                } else {
                    characters.pop();
                }
            }
        }
        return true;
    }


    public List<String> generateParenthesisV2(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max) {

        System.out.println(cur);
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur + "(", open + 1, close, max);
        if (close < open)
            backtrack(ans, cur + ")", open, close + 1, max);
    }

    public static void main(String args[]) {

        NumCombination combination = new NumCombination();
        combination.generateParenthesisV2(3);
    }
}
