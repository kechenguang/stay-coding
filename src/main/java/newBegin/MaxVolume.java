package newBegin;

public class MaxVolume {

    public int maxArea(int[] height) {

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length - 1; i++) {
            if ((i > 0 && height[i] > height[i - 1]) || i == 0) {
                for (int j = i + 1; j < height.length; j++) {
                    max = Math.max(Math.min(height[i], height[j]) * (j - i), max);
                }
            }
        }
        return max;
    }
}
