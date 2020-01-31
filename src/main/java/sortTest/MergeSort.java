package sortTest;

public class MergeSort {


    public static void merge(int[] a, int left, int right, int mid, int[] axu) {

        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            if (a[i] < a[j]) {
                axu[k++] = a[i++];
            } else {
                axu[k++] = a[j++];
            }
        }
        while (i <= mid) {
            axu[k++] = a[i++];
        }
        while (j <= right) {
            axu[k++] = a[j++];
        }
        for (int x = left; x <= right; x++) {
            a[x] = axu[x];
        }

    }

    public static void sort(int[] a, int start, int end) {

        if (start >= end) {
            return;
        }
        int[] axu = new int[a.length];
        int mid = start + (end - start) / 2;
        sort(a, start, mid);
        sort(a, mid + 1, end);
        merge(a, start, end, mid, axu);
    }

    public static void main(String[] args) {

        int[] a = {5, 4, 3, 10, 100, 3, 20};
        sort(a, 0, a.length - 1);
        SortUtils.printArray(a);

    }
}
