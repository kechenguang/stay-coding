package Sort;


/**
 * 插入排序，时间复制度o(n^2),是否稳定？
 * 稳定性的定义：排序前后两个相等的数相对位置不变，则算法稳定
 */
public class InsertSort {

    public static void sort(int[] array) {

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0 && array[j] > array[j - 1]; j--) {
                count++;
                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
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
