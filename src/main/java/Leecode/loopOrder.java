package Leecode;

public class loopOrder {


    public static void main(String args[]) {

        int[] a = {2, 5, 6, 0, 0, 1, 2};
        System.out.println(findLoopOrder(a, 0, a.length - 1, 20));
    }

    public static int findLoopOrder(int[] array, int start, int end, int num) {

        int mid = start + (end - start) / 2;
        while (start <= end) {
            if (array[mid] == num) {
                return mid;
            }
            if (array[mid] > num) {
                if (array[start] <= array[mid]) {
                    return findOrder(array, start, mid, num);
                } else {
                    return findLoopOrder(array, start, mid, num);
                }
            } else {
                if (array[start] <= array[mid]) {
                    return findLoopOrder(array, mid, end, num);
                } else {
                    //int find1 = findLoopOrder(array, start, mid, num);
                    int find2 = findOrder(array, mid, end, num);
                    if (find2 == -1) {
                        return findLoopOrder(array, start, mid, num);
                    } else {
                        return find2;
                    }
                }
            }
        }
        return -1;

    }


    public static int findOrder(int[] a, int start, int end, int num) {

        int mid = start + (end - start) / 2;
        while (start <= end) {
            if (a[mid] == num) {
                return mid;
            }
            if (a[mid] > num) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = start + (end - start) / 2;
        }
        return -1;
    }

    public static int findMin(int[] nums) {

        int start = 0;
        int end = nums.length - 1;
        if (nums.length == 1) {
            return nums[0];
        }
        int mid = start + (end - start) / 2;
        while (start <= end) {
            if (mid > 0) {
                if (nums[mid] > nums[mid - 1]) {
                    return nums[mid - 1];
                }
            }
            if (mid < nums.length - 1) {
                if (nums[mid + 1] < nums[mid]) {
                    return nums[mid + 1];
                }
            }
            if (nums[start] < nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = start + (end - start) / 2;
        }
        return -1;
    }


}
