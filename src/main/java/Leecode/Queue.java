package Leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Queue {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> r = new ArrayList<>();
        addQueue(0, n, new Stack<Integer>());
        if (res.size() > 0) {
            for (List<Integer> list : res) {
                List<String> resStrig = new ArrayList<>();
                for (Integer integer : list) {
                    StringBuilder builder = new StringBuilder();
                    for (int i = 0; i < n; i++) {
                        if (i == integer) {
                            builder.append("Q");
                        } else {
                            builder.append(".");
                        }
                    }
                    resStrig.add(builder.toString());
                }
                r.add(resStrig);
            }
        }
        return r;
    }

    public void addQueue(int start, int size, Stack<Integer> stack) {

        if (stack.size() == size && check(stack, size - 1)) {
            res.add(new ArrayList<Integer>(stack));
            return;
        }
        for (int i = 0; i < size; i++) {
            stack.push(i);
            if (check(stack, start)) {
                addQueue(start + 1, size, stack);
            }
            stack.pop();
        }
    }

    public boolean check(Stack<Integer> stack, int end) {

        if (end == 0) {
            return true;
        }
        if (stack.size() == 4) {
            System.out.println(stack.toString());
        }
        List<Integer> integers = new ArrayList<>(stack);
        for (int i = 0; i < end; i++) {
            int x1 = i;
            int y1 = integers.get(i);
            for (int j = i + 1; j <= end; j++) {
                int x2 = j;
                int y2 = integers.get(j);
                if (y1 == y2 || Math.abs(x1 - x2) == Math.abs(y1 - y2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Queue queue = new Queue();
        Stack<Integer> a = new Stack<>();
        a.push(1);
        a.push(1);
        a.push(0);
        a.push(2);
        System.out.println(a.toString());
        System.out.println(queue.check(a, 3));
    }

    public int maxSubArray(int[] nums) {

        int ans = nums[0];
        int sum = 0;
        for (int n : nums) {
            if (sum > 0) {
                sum += n;
            } else {
                sum = n;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
