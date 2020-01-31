package sortTest;

public class QuickSort {

    public static int getMid(int[] a, int left, int right) {

        int x = a[right];
        int i, j;
        for (i = j = left; i < right; i++) {
            if (a[i] < x) {
                SortUtils.sweep(a, i, j++);
            }
        }
        SortUtils.sweep(a, j, right);
        return j;
    }

    public static void sort(int[] a, int start, int end) {

        if (start >= end) {
            return;
        }
        int mid = getMid(a, start, end);
        sort(a, start, mid - 1);
        sort(a, mid + 1, end);
    }

    public static void main(String[] args) {

        int[] a = {5, 4, 3, 10, 100, 3, 20};
        sort(a, 0, a.length - 1);
        SortUtils.printArray(a);

    }
}
