package Leecode;

import java.util.*;
import java.util.Queue;

public class RemoveString {

    public String removeDuplicatesv2(String s, int k) {

        int beginLength = s.length();
        int finalLength = 0;
        String finalString = s;
        Stack<Character> stack = new Stack<>();
        while (beginLength != finalLength) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                Character c = s.charAt(i);
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    if (stack.size() == k) {
                        stack.clear();
                    } else if (!stack.peek().equals(c)) {
                        while (!stack.isEmpty()) {
                            builder.append(stack.pop());
                        }
                        stack.push(c);
                    } else {
                        stack.push(c);
                    }
                }
            }
            while (!stack.isEmpty()) {
                builder.append(stack.pop());
            }
            finalString = builder.toString();
            finalLength = finalString.length();
        }
        return finalString;
    }


    public String removeDuplicates(String s, int k) {

        Stack<Character> stack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (stack.isEmpty() || !stack.peek().equals(c)) {
                stack.push(c);
                countStack.push(1);
            } else {
                int count = countStack.peek();
                count++;
                if (count == k) {
                    for (int j = 0; j < k - 1; j++) {
                        stack.pop();
                        countStack.pop();
                    }
                } else {
                    stack.push(c);
                    countStack.push(count);
                }

            }
        }

        List<Character> list = new ArrayList<>(stack);
        StringBuilder builder = new StringBuilder();
        for (Character x : list) {
            builder.append(x);
        }
        return builder.toString();
    }



}
