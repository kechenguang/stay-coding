package sortTest;

public class SelectSort {

    public static void sort(int[] a) {

        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            SortUtils.sweep(a, i, min);
        }
    }

    public static void main(String[] args) {

        int[] a = {5, 4, 3, 10, 100, 3, 20};
        sort(a);
        SortUtils.printArray(a);

    }
}
