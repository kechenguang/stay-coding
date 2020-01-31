package newBegin;

import java.util.Arrays;
import java.util.Collections;

public class Permutation {

    public static void nextPermutation(int[] nums) {

        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] < nums[j]) {
                    System.out.println(nums[i]);
                    System.out.println(nums[j]);
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    Arrays.sort(nums, i + 1, nums.length);
                    return;
                }
            }
        }
        Arrays.sort(nums);
    }

    public static void main(String[] args) {

        int[] nums = {3, 2, 1};
        nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
