package arrays;

public class FindMedian {

    public double findMedianSortedArrays(int[] A, int[] B) {

        if (A.length > B.length) {
            findMedianSortedArrays(B, A);
        }
        int m = A.length, n = B.length;
        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;
        }
    }
}
