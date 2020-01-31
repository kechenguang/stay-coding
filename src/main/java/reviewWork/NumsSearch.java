package reviewWork;

public class NumsSearch {


    /**
     * 不含重复项的循环有序数组的search
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {

        int l = nums.length;
        if (l == 0) {
            return -1;
        }
        int start = 0;
        int end = l - 1;
        while (start <= end) {
            if (start == end) {
                if (nums[start] == target) {
                    return start;
                } else {
                    return -1;
                }
            }
            int mid = start + (end - start) / 2;
            if (nums[start] >= nums[mid]) {
                if (target <= nums[start] && nums[mid] >= target) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target >= nums[mid + 1] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
        }
        return -1;
    }
}
