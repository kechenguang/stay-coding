package someTest;

public class swapTest {

    public static void swap(int[] array, int i, int j) {

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4};
        int i = 0;
        int j = 2;
        swap(array, i, j++);
        for (int x = 0; x < array.length; x++) {
            System.out.println(array[x]);
        }
    }
}
