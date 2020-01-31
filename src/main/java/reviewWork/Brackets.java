package reviewWork;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Brackets {

    public boolean isValid(String s) {

        int l = s.length();
        if (l % 2 != 0) {
            return false;
        }
        Map<Character, Character> info = new HashMap<>();
        info.put(')', '(');
        info.put('{', '}');
        info.put('[', ']');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            } else {
                char z = info.get(c);
                if (stack.isEmpty() || stack.peek() != z) {
                    return false;
                }
                if (stack.peek() == z) {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();

    }
}
