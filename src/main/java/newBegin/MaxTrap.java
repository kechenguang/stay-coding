package newBegin;

public class MaxTrap {

    public int trap(int[] height) {

        boolean forward = true;
        int res = 0;
        while (forward) {
            forward = false;
            int[] level = new int[height.length];
            for (int i = 0; i < height.length; i++) {
                if (height[i] > 0) {
                    level[i] = 1;
                    height[i] = height[i] - 1;
                    forward = true;
                } else {
                    level[i] = 0;
                }
            }
            res += sumTrap(level);
        }
        return res;
    }

    public int sumTrap(int[] nums) {

        int start = -1;
        int end = -1;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (start == -1) {
                    start = i;
                } else {
                    end = i;
                    res += end - start - 1;
                    start = end;
                }
            }
        }
        return res;
    }


    public int trapV2(int[] height) {

        int l = height.length;
        int[] leftMax = new int[l];
        int[] rightMax = new int[l];
        int res = 0;
        leftMax[0] = height[0];
        for (int i = 1; i < l; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        rightMax[0] = height[l - 1];
        for (int i = l - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        for (int j = 1; j < l - 1; j++) {
            res += Math.min(leftMax[j], rightMax[j]) - height[j];
        }
        return res;
    }
}
