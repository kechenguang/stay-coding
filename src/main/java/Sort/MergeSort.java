package Sort;


/**
 * 归并排序：递归的对两个已经有序的子数组进行合并，是稳定的排序算法
 * 时间复杂度：o(n*logn)
 */
public class MergeSort {

    private void merge(int[] array, int[] axu, int left, int mid, int right) {

        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            if (array[i] < array[j]) {
                axu[k++] = array[i++];
            } else {
                array[k++] = array[j++];
            }
        }
        while (i <= mid + 1) {
            array[k++] = array[i++];
        }
        while (j <= right) {
            array[k++] = array[j++];
        }
        for (int x = left; x <= right; x++) {
            array[x] = axu[x];
        }
    }

    public void sort(int[] array, int left, int right) {

        if (left <= right) {
            int[] axu = new int[array.length];
            int mid = left + (right - left) / 2;
            sort(array, left, mid);
            sort(array, mid + 1, right);
            merge(array, axu, left, mid, right);
        }
    }

}
