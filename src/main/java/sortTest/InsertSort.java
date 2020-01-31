package sortTest;

public class InsertSort {

    public static void sort(int[] a) {

        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0 && a[j - 1] < a[j]; j--) {
                SortUtils.sweep(a, j - 1, j);
            }
        }
    }

    public static void main(String[] args) {

        int[] a = {5, 4, 3, 10, 100, 3, 20};
        sort(a);
        SortUtils.printArray(a);

    }

}
