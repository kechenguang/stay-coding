package reviewWork;

import java.util.Stack;

/**
 * @author kechenguang
 */
public class OverviewSequence {

    public String countAndSay(int n) {

        if (n == 1) {
            return "1";
        } else {
            String per = countAndSay(n - 1);
            Stack<Character> stats = new Stack<>();
            int count = 0;
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < per.length(); i++) {
                if (stats.isEmpty()) {
                    count++;
                } else if (stats.peek() == per.charAt(i)) {
                    count++;
                } else {
                    res.append(count);
                    res.append(stats.peek());
                    stats.clear();
                    count = 1;
                }
                stats.push(per.charAt(i));
            }
            if (!stats.isEmpty()) {
                res.append(count);
                res.append(stats.peek());
            }
            return res.toString();
        }
    }
}
