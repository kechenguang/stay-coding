package Sort;


/**
 * 堆排序：通过维护一个堆的数据结构，每次堆顶的元素是最大的，把这个元素移动到队尾，在重新构建堆；
 * 详见：https://blog.csdn.net/long_lance/article/details/82381991
 * 是稳定的排序算法，时间复杂度
 */
public class HeapSort {

    private void keepHeap(int[] array, int length, int i) {

        if (2 * i + 1 > length) {
            return;
        }
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = i;
        if (left < length) {
            if (array[i] < array[left]) {
                max = left;
            }
        }
        if (right < length) {
            if (array[i] < array[right]) {
                max = right;
            }
        }
        if (max != i) {
            SortUtils.swap(array, i, max);
            keepHeap(array, length, max);

        }
    }

    private void buildHeap(int[] array) {

        for (int i = (array.length - 1) / 2; i >= 0; i--) {
            keepHeap(array, array.length, i);
        }
    }

    public void sort(int[] array) {

        buildHeap(array);
        for (int i = 1; i < array.length - 1; i++) {
            SortUtils.swap(array, 0, array.length - 1);
            keepHeap(array, array.length - 1, 0);
        }
    }


}
