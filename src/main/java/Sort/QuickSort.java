package Sort;

/**
 *
 * 快速排序：取数组中的一个值，把大于它的值放在左边，小于它的值放在右边，再递归的对左右两个子数组进行相同的排序；
 * 属于不稳定的排序算法
 */
public class QuickSort {

    //这个逻辑比较绕，主要是在变量j的理解上；
    public int getMid(int[] array, int left, int right) {

        int x = array[right];
        int i;
        int j;
        for (i = j = left; i < right; i++) {
            if (array[i] < x) {
                SortUtils.swap(array, i, j++);
            }
        }
        SortUtils.swap(array, j, right);
        return j;
    }

    public void sort(int[] array, int left, int right) {

        if (left < right) {
            int mid = getMid(array, left, right);
            sort(array, left, mid - 1);
            sort(array, mid, right);
        }
    }

}
