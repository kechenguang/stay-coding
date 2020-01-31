package newBegin;

public class MissingPositive {

    public int firstMissingPositive(int[] nums) {

        //符合要求的数一定小于等于n+1
        boolean contains = false;
        int l = nums.length;
        if (l == 0) {
            return 1;
        }
        for (int i = 0; i < l; i++) {
            if (nums[i] == 1) {
                contains = true;
                break;
            }
        }
        if (!contains) {
            return 1;
        }
        for (int j = 0; j < l; j++) {
            if (nums[j] <= 0 || nums[j] > l + 1) {
                nums[j] = 1;
            }
        }
        for (int k = 0; k < l; k++) {
            int a = Math.abs(nums[k]);
            if (a == l) {
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[a] = -Math.abs(nums[a]);
            }
        }
        for (int x = 0; x < l; x++) {
            if (nums[x] > 0) {
                return x;
            }
        }
        return l + 1;
    }
}
