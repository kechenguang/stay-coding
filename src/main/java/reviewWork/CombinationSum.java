package reviewWork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        Stack<Integer> midRes = new Stack<>();
        searchBackTrack(candidates, target, res, midRes, 0);
        return res;

    }

    public void searchBackTrack(int[] candidates, int target, List<List<Integer>> res, Stack<Integer> midRes, int start) {

        if (target == 0) {
            res.add(new ArrayList<>(midRes));
            return;
        }
        if (target < candidates[start]) {
            return;
        }
        for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
            midRes.push(candidates[i]);
            searchBackTrack(candidates, target - candidates[i], res, midRes, i);
            midRes.pop();
        }
    }
}
