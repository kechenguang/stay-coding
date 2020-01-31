package newBegin;

public class CheckJump {

    public boolean canJump(int[] nums) {

        int l = nums.length;
        if (l <= 1) {
            return true;
        }
        int lastStep = l - 1;
        for (int i = l - 2; i >= 0; i--) {
            if (nums[i] + i >= lastStep) {
                lastStep = i;
            }
        }
        return lastStep == 0;
    }

    public boolean jumpTrackBack(int[] nums, int end) {

        if (end == 0) {
            return true;
        }
        int distinct = 1;
        for (int i = end - 1; i >= 0; i--) {
            if (nums[i] >= distinct) {
                if (jumpTrackBack(nums, i)) {
                    return true;
                }
            }
            distinct++;
        }
        return false;
    }

    public int jump(int[] nums) {

        int count = 0;
        for (int i = 0; i < nums.length; ) {
            int nextIndex = i + 1;
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j >= nums.length - 1) {
                    count++;
                    break;
                }
                if (nums[i + j] >= nums[nextIndex]) {
                    nextIndex = i + j;
                }
            }
            count++;
            i = nextIndex;
        }
        return count;
    }
}
