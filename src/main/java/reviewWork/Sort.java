package reviewWork;

public class Sort {

    public int findKthLargest(int[] nums, int k) {

        bulidHeap(nums);
        for (int i = 1; i <= k; i++) {
            int temp = nums[0];
            nums[0] = nums[nums.length - i];
            nums[nums.length - i] = temp;
            keepHeap(nums, nums.length - i, 0);
        }
        return nums[nums.length - k];
    }

    public void bulidHeap(int[] array) {

        for (int i = (array.length - 1) / 2; i >= 0; i--) {
            keepHeap(array, array.length, i);
        }
    }

    public void keepHeap(int[] array, int length, int i) {

        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = i;
        if (left < length && array[left] > array[max]) {
            max = left;
        }
        if (right < length && array[right] > array[max]) {
            max = right;
        }
        if (max != i) {
            int temp = array[i];
            array[i] = array[max];
            array[max] = temp;
            keepHeap(array, length, max);
        }
    }
}
