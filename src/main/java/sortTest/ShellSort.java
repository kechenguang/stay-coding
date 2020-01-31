package sortTest;

public class ShellSort {

    public static void sort(int a[]) {

        int l = a.length;
        for (int gap = l / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < l; i++) {
                for (int j = i; j >= gap && a[j] > a[j - gap]; j -= gap) {
                    int tmp = a[j];
                    a[j] = a[j - gap];
                    a[j - gap] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] a = {5, 4, 3, 10, 100, 3, 20};
        sort(a);
        SortUtils.printArray(a);

    }

}
