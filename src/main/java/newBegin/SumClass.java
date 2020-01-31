package newBegin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SumClass {


    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length < 3 || nums[0] * nums[nums.length - 1] > 0) {
            return res;
        }
        for (int i = 0; i < nums.length - 3; i++) {
            for (int first = i + 1; first < nums.length - 2; ) {
                System.out.println(nums[i]);
                if (nums[i] > 0) {
                    break;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int last = nums.length - 1;
                int sum = nums[i] + nums[first] + nums[last];
                System.out.println("sum is " + sum);
                while (sum != 0) {
                    if (sum > 0) {
                        while (last > first && nums[last] == nums[--last]) {
                        }
                        if (last <= first) {
                            break;
                        }
                    } else {
                        while (first < last && nums[first] == nums[++first]) {
                        }
                        if (first >= last) {
                            break;
                        }
                    }
                    System.out.println("first is " + first + " last is " + last);
                    sum = nums[i] + nums[first] + nums[last];
                }
                if (first != last) {
                    List<Integer> a = new ArrayList<>();
                    a.add(nums[i]);
                    a.add(nums[first]);
                    a.add(nums[last]);
                    res.add(a);
                }
                first = first++;
                last = nums.length - 1;
            }
        }
        return res;
    }

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int l = nums.length;
        int ans = nums[0] + nums[1] + nums[2];
        int sum = 0;
        for (int i = 0; i < l - 2; i++) {
            if (nums[i] < target) {
                int first = i + 1;
                int last = l - 1;
                while (first < last) {
                    sum = nums[i] + nums[first] + nums[last];
                    if (Math.abs(target - sum) < Math.abs(target - ans)) {
                        ans = sum;
                    }
                    if (sum > target) {
                        last--;
                    } else if (sum < target) {
                        first++;
                    } else {
                        return sum;
                    }
                }
            } else {
                sum = nums[i] + nums[i + 1] + nums[i - 1];
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
            }
        }
        return ans;
    }

}
