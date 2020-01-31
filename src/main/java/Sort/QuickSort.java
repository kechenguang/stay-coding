package Sort;

import java.util.*;

/**
 * 快速排序：取数组中的一个值，把大于它的值放在左边，小于它的值放在右边，再递归的对左右两个子数组进行相同的排序；
 * 属于不稳定的排序算法，时间复杂度：最好的情况下为n（已经有序），正常情况下是nlogn，逆序情况为n^2
 */
public class QuickSort {

    //这个逻辑比较绕，主要是在变量j的理解上；
    public int getMid(int[] array, int left, int right) {

        int x = array[right];
        int i;
        int j;
        for (i = j = left; i < right; i++) {
            if (array[i] < x) {
                SortUtils.swap(array, i, j++);
            }
        }
        SortUtils.swap(array, j, right);
        return j;
    }

    public void sort(int[] array, int left, int right) {

        if (left < right) {
            int mid = getMid(array, left, right);
            sort(array, left, mid - 1);
            sort(array, mid, right);
        }
    }

    public boolean isValidSudoku(char[][] board) {

        Map<Character, List<int[]>> keyInfo = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            Set<Character> numSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                Character a = board[i][j];
                if (a == '.') {
                    continue;
                }
                if (numSet.contains(a)) {
                    System.out.println(a + "_" + 43);
                    return false;
                }
                numSet.add(a);
                if (keyInfo.containsKey(a)) {
                    List<int[]> info = keyInfo.get(a);
                    for (int[] x : info) {
                        if (x[0] == i || x[1] == j) {
                            System.out.println(a + "_" + 51);
                            return false;
                        }
                        if (x[0] / 3 == i / 3 && x[1] / 3 == j / 3) {
                            System.out.println(a + "_" + 55);
                            return false;
                        }
                    }
                    info.add(new int[]{i, j});
                } else {
                    List<int[]> info = new ArrayList<>();
                    info.add(new int[]{i, j});
                    keyInfo.put(a, info);
                }
            }
            numSet.clear();
        }
        return true;
        /*for (Map.Entry<Character, List<int[]>> entry : keyInfo.entrySet()) {

            List<int[]> values = entry.getValue();
            if (values.size() < 2) {
                continue;
            }
            for (int[] info : values) {

            }
        }*/
    }

    public String countAndSay(int n) {

        if (n < 1) {
            return "";
        }
        if (n == 1) {
            return "1";
        } else {
            String mid = countAndSay(n - 1);
            Queue<Character> queue = new LinkedList<>();
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < mid.length(); i++) {
                Character a = mid.charAt(i);
                if (queue.isEmpty()) {
                    queue.offer(a);
                    continue;
                } else {
                    if (queue.peek().equals(a)) {
                        queue.offer(a);
                        continue;
                    } else {
                        int x = (int) queue.peek();
                        int count = 0;
                        while (!queue.isEmpty()) {
                            count++;
                            queue.poll();
                        }
                        builder.append(count);
                        builder.append(x);
                    }
                }
            }
            if (!queue.isEmpty()) {
                int x = (int) queue.peek();
                int count = 0;
                while (!queue.isEmpty()) {
                    count++;
                    queue.poll();
                }
                builder.append(count);
                builder.append(x);
            }
            return builder.toString();
        }
    }


}
