package Leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class sumList {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        if (candidates == null || candidates.length == 0) {
            return res;
        } else {
            Arrays.sort(candidates);
            if (candidates[0] > target) {
                return res;
            }
            getList(candidates, target, 0, new Stack<Integer>());
            return res;
        }
    }

    public void getList(int[] subInt, int red, int start, Stack<Integer> pre) {

        if (red == 0) {
            res.add(new ArrayList<Integer>(pre));
            return;
        }
        for (int i = start; i < subInt.length && red - subInt[i] >= 0; i++) {
                if (i - 1 >= start && subInt[i] == subInt[i - 1]) {
                    continue;
                }
                pre.push(subInt[i]);
                System.out.println(pre.toString());
                getList(subInt, red - subInt[i], i + 1, pre);
                pre.pop();
            }
        }



}
