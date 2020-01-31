package newBegin;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.*;

public class AllSubSet {


    public static void main(String[] args) {

        int nums[] = {1, 1, 2};
        permuteUnique(nums);
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        backTrack(0, res, new ArrayList<>(), nums);
        return res;
    }

    public void backTrack(int begin, List<List<Integer>> res, List<Integer> tmp, int[] nums) {

        res.add(new ArrayList<>(tmp));
        for (int i = begin; i < nums.length; i++) {
            tmp.add(nums[i]);
            backTrack(begin + 1, res, tmp, nums);
            tmp.remove(tmp.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();
        if (n == 0 || k == 0) {
            return res;
        }
        backTrack(n, 1, k, new LinkedList<Integer>(), res);
        return res;

    }

    public void backTrack(int n, int start, int k, LinkedList<Integer> midList, List<List<Integer>> res) {

        if (midList.size() == k) {
            res.add(new ArrayList<>(midList));
            return;
        }
        for (int i = start; i <= n; i++) {
            midList.add(i);
            backTrack(n, start + 1, k, midList, res);
            midList.removeLast();
        }

    }

    public static List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        ArrayList<Integer> newNums = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            newNums.add(nums[i]);
        }
        backTrackPremute(newNums, new LinkedList<Integer>(), nums.length, res);
        return res;

    }

    public static void backTrackPremute(ArrayList<Integer> nums, LinkedList<Integer> mid, int n, List<List<Integer>> res) {

        if (mid.size() == n) {
            res.add(new ArrayList<>(mid));
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.size(); i++) {
            int x = nums.get(i);
            if (set.contains(x)) {
                continue;
            }
            set.add(x);
            mid.add(nums.get(i));
            nums.remove(i);
            System.out.println("aaa" + nums.toString());
            backTrackPremute(nums, mid, n, res);
            mid.removeLast();
            nums.add(i, x);
        }
    }

    public int countNumbersWithUniqueDigits(int n) {

        if (n == 0) {
            return 1;
        }
        Integer[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(nums));
        List<Integer> res = new ArrayList<>();
        backTrackCount(list, n, res, 0, 0);
        return res.size();

    }

    public void backTrackCount(List<Integer> nums, int n, List<Integer> res, int s, int k) {

        if (k > n) {
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            int x = nums.get(i);
            nums.remove(i);
            int r = (int) Math.pow(10, k) * x;
            if ((s + r) != s || s == 0) {
                res.add(r + s);
            }
            backTrackCount(nums, n, res, r + s, k + 1);
            nums.add(i, x);
        }
    }

    public String getPermutation(int n, int k) {

        String res = null;
        if (n == 0 || k == 0) {
            return res;
        }
        boolean[] used = new boolean[n+1];
        List<String> list = new ArrayList<>();
        backTrackPermutation(used, k, n, "", list);
        return list.get(k - 1);
    }

    public void backTrackPermutation(boolean[] used, int k, int n, String s, List<String> list) {

        if (s.length() == n) {
            list.add(s);
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (list.size() == k) {
                break;
            }
            if (!used[i]) {
                used[i] = true;
                String newString = s + i;
                backTrackPermutation(used, k, n, newString, list);
                used[i] = false;
            }
        }
    }


}
