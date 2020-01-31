package reviewWork;

public class JumpStaff {

    public int jump(int[] nums) {

        int count = 0;
        if (nums.length == 0) {
            return count;
        }
        for (int i = 0; i < nums.length; ) {
            int step = nums[i];
            if (i + step >= nums.length - 1) {
                return ++count;
            }
            int nextStep = i + 1;
            for (int j = 1; j <= step; j++) {
                if (nums[i + j] + (i + j) >= nums[nextStep] + nextStep) {
                    nextStep = i + j;
                }
            }
            i = nextStep;
            count++;
        }
        return count;
    }
}
