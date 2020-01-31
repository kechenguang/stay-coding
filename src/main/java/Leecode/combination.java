package Leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class combination {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        getAllCombinationsByArrays(nums, nums.length, new Stack<Integer>());
        return res;
    }

    public void getAllCombinationsByArrays(int[] arrays, int k, Stack<Integer> pre) {

        if (k <= 0) {
            res.add(new ArrayList<Integer>(pre));
            return;
        }
        for (int i = 0; i < arrays.length; i++) {
            pre.push(arrays[i]);

            getAllCombinationsByArrays(arrays, k - 1, pre);
            pre.pop();
        }
    }
}
