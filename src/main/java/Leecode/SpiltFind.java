package Leecode;

public class SpiltFind {

    /**
     * 循环有序数组：【5，6，7，8，1，2，3】以最快的速度找target
     */


    public static void main(String args[]) {

        int[] a = {1, 3, 10, 30, 90, 100, 109, 400};
        int start = 0;
        int end = a.length - 1;
        int target = 50;
        System.out.println(findNearest(a, 0, end, target));
    }


    public static int findNearest(int[] array, int start, int end, int num) {
        int midIndex = (start + end) / 2;
        if (start >= end) {
            return start;
        }
        /*int mid = array[midIndex];
        int left = array[(midIndex - 1) < start ? start : (midIndex - 1)];
        int right = array[(midIndex + 1) > end ? end : (midIndex + 1)];
        int sm = Math.abs(num - mid);
        int sl = Math.abs(num - left);
        int sr = Math.abs(num - right);
        if (sm < sl && sm < sr) {
            return midIndex;
        } else*/
        if (array[midIndex] >= num) {
            return findNearest(array, start, midIndex, num);
        } else {
            int tmp = findNearest(array, midIndex + 1, end, num);
            int gap1 = Math.abs(array[midIndex] - num);
            int gap2 = Math.abs(array[tmp] - num);
            if (gap1 > gap2) {
                return tmp;
            } else {
                return midIndex;
            }
        }

        /*else{
            int li=findNearest(array,start,midIndex-1, num);
            int ri=findNearest(array,midIndex+1, end, num);
            if(Math.abs(num-array[li]) < Math.abs(num-array[ri])){
                return li;
            }
            return ri;
        }*/
    }


    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left) / 2;

        while (left <= right) {
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {  //左边升序
                if (target >= nums[left] && target <= nums[mid]) {//在左边范围内
                    right = mid - 1;
                } else {//只能从右边找
                    left = mid + 1;
                }

            } else { //右边升序
                if (target >= nums[mid] && target <= nums[right]) {//在右边范围内
                    left = mid + 1;
                } else {//只能从左边找
                    right = mid - 1;
                }

            }
            mid = left + (right - left) / 2;
        }

        return -1;  //没找到
    }

    public int[] searchRange(int[] nums, int target) {

        int[] range = {-1, -1};
        int leftIndex = findRange(nums, target, true);
        if (leftIndex == nums.length || nums[leftIndex] != target) {
            return range;
        }
        range[0] = leftIndex;
        range[1] = findRange(nums, target, false) - 1;
        return range;

    }

    public int findRange(int[] nums, int target, boolean left) {

        int start = 0;
        int end = nums.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target || (left && nums[mid] == target)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return start;
    }
}
