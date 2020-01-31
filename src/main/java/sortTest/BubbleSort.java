package sortTest;

public class BubbleSort {

    public static void main(String[] args) {

        int[] a = {5, 4, 3, 10, 100, 3,20};
        sort(a);
        SortUtils.printArray(a);

    }

    public static void sort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[i]) {
                    SortUtils.sweep(array, i, j);
                }
            }
        }
    }
}
