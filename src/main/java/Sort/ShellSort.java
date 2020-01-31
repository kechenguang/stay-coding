package Sort;

/**
 * 希尔排序，改良版本的插入排序，根据变化的增量间隔，进行插入排序，是不稳定的排序
 * 为何是改良的插入排序：插入排序在待排序队列少或者序列有序的情况下效率高：
 * 在刚开始排序的时候步长大，插入排序的元素少，所以效率高，越到后边虽然步长变短，但是变得更有序，插入排序的效率也会更高；
 * 时间复杂度小于n^2
 */
public class ShellSort {

    public static void sort(int[] array) {

        int l = array.length;
        int count = 0;
        for (int inc = l / 2; inc > 0; inc = inc / 2) {
            for (int i = inc; i < l; i++) {
                for (int j = i; j >= inc && array[j] > array[j - inc]; j = j - inc) {
                    count++;
                    int temp = array[j];
                    array[j] = array[j - inc];
                    array[j - inc] = temp;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println(count);
    }

    public static void main(String[] args) {

        int[] array01 = {10, 9, 8, 7, 6, 5};
        int[] array02 = {5, 6, 7, 8, 9, 10};
        int[] array03 = {9, 6, 7, 4, 3, 10, 18};
        sort(array01);
        sort(array02);
        sort(array03);
    }

}
