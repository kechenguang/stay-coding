package reviewWork;

public class WaterStaff {

    public int trap(int[] height) {

        int l = height.length;
        if (l <= 1) {
            return 0;
        }
        int[] rightMax = new int[l];
        int[] leftMax = new int[l];
        int res = 0;
        for (int i = 1; i < l; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        rightMax[l - 1] = height[l - 1];
        for (int j = l - 2; j >= 0; j--) {
            rightMax[j] = Math.max(rightMax[j + 1], height[j]);
        }
        for (int x = 0; x < l - 1; x++) {
            res += Math.max(leftMax[x], rightMax[x]) - height[x];
        }
        return res;
    }

    public int maxArea(int[] height) {

        if (height.length <= 1) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0, j = height.length - 1; i < j; ) {
            max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            if (height[i] > height[j]) {
                while (i < j && height[--j] < height[j]) ;
            }else {
                while (i < j && height[i] > height[++i]) ;
            }
            //while (i <= j && height[i] > height[++i]) ;
            //while (i <= j && height[--j] < height[j]) ;
        }
        return max;
    }
}
