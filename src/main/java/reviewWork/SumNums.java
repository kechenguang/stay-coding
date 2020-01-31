package reviewWork;

import java.util.*;

public class SumNums {

    /**
     * 注意：坑的点是：我们需要返回数组的下标！
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        int[] res = new int[2];
        int n = nums.length;
        if (n <= 1) {
            return res;
        }
        int[][] index = new int[n][2];
        for (int i = 0; i < n; i++) {
            index[i][0] = nums[i];
            index[i][1] = i;
        }
        Arrays.sort(index, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0, j = n - 1; i != j; ) {
            int sum = index[i][0] + index[j][0];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                res[0] = index[i][1];
                res[1] = index[j][1];
                break;
            }
        }
        return res;
    }

    /**
     * 一遍hash法，可以解决数组中有重复元素的情况
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumV2(int[] nums, int target) {

        int[] res = new int[2];
        int n = nums.length;
        if (n <= 1) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int c = target - nums[i];
            if (map.get(c) != null) {
                res[0] = map.get(c);
                res[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }

    /**
     * 三数之和
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {

        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int first = nums[i];
            if (first > 0) {
                break;
            }
            for (int j = i + 1, x = n - 1; j < x; ) {
                int sum = first + nums[j] + nums[x];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    x--;
                } else {
                    res.add(Arrays.asList(first, nums[j], nums[x]));
                    while (j+1 < x && nums[j] == nums[++j]) ;
                    while (j < x-1 && nums[x] == nums[--x]) ;
                }
            }
        }
        return res;
    }
}
