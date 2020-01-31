package Leecode;

import java.util.Stack;

public class ReverseString {

    public String reverseParentheses(String s) {

        Stack<Stack<Character>> bigStack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if ("(".equals(a)) {
                Stack<Character> stack = new Stack<>();
                bigStack.push(stack);
            } else if (")".equals(a)) {
                Stack<Character> s1 = bigStack.pop();
                if (bigStack.size() >= 2) {
                    Stack<Character> s2 = bigStack.peek();
                    while (!s1.isEmpty()) {
                        s2.push(s1.pop());
                    }
                } else {
                    while (!s1.isEmpty()) {
                        builder.append(s1.pop());
                    }
                }
            } else {
                if (bigStack.isEmpty()) {
                    builder.append(a);
                } else {
                    Stack<Character> s1 = bigStack.peek();
                    s1.push(a);
                }
            }
        }
        while (!bigStack.isEmpty()) {
            Stack<Character> s1 = bigStack.pop();
            if (bigStack.isEmpty()) {
                while (!s1.isEmpty()) {
                    builder.append(s1.pop());
                }
            } else {
                Stack<Character> s2 = bigStack.peek();
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
        }
        return builder.toString();
    }
}
