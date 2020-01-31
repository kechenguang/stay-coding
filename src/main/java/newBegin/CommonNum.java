package newBegin;

public class CommonNum {

    public static int findDuplicate(int[] nums) {

        int start = 1;
        int end = nums.length - 1;
        int mid = (start + end) / 2;
        while (start <= end) {
            int count = 0;
            for (int num : nums) {
                if (num < mid) {
                    count++;
                }
            }
            if (count>= mid) {
                end = mid-1;
            } else {
                start = mid;
            }
            mid = (start + end) / 2;
        }
        return start;
    }


    public int minSubArrayLen(int s, int[] nums) {

        int left = 0;
        int min = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                min = Math.min(min, i - left + 1);
                sum -= nums[left++];
            }
        }
        return min;
    }

}
