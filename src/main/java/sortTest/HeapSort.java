package sortTest;

public class HeapSort {

    public static void keepHeap(int[] arrays, int i, int length) {

        if (2 * i + 1 > length) {
            return;
        }
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = i;
        if (left < length) {
            if (arrays[i] < arrays[left]) {
                max = left;
            }
        }
        if (right < length) {
            if (arrays[i] < arrays[right]) {
                max = right;
            }
        }
        if (max != i) {
            SortUtils.sweep(arrays, i, max);
            keepHeap(arrays, max, length);
        }
    }

    public static void buildHeap(int[] array) {

        for (int i = (array.length - 1) / 2; i >= 0; i--) {
            keepHeap(array, i, array.length-1);
        }
    }

    public static void sort(int[] array) {

        buildHeap(array);
        int length = array.length - 1;
        for (int i = array.length - 1; i > 0; i--) {
            SortUtils.sweep(array, 0, i);
            length--;
            keepHeap(array, 0, length);
        }

    }

    public static void main(String[] args) {

        int[] a = {5, 4, 3, 10, 100, 3, 20};
        sort(a);
        SortUtils.printArray(a);

    }

}
