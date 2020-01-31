package newBegin;

public class MergeSort {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (n == 0) {
            return;
        }
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
        if (m == 0) {
            return;
        }
        for (int j = m; j < m + n; j++) {
            for (int x = j; x >= 1; x--) {
                if (nums1[x - 1] > nums1[x]) {
                    int tep = nums1[x];
                    nums1[x] = nums1[x - 1];
                    nums1[x - 1] = tep;
                } else {
                    break;
                }
            }
        }
    }

}
