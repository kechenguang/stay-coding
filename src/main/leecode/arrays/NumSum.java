package arrays;

import java.util.*;

public class NumSum {

    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        if (nums == null || nums.length == 0) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int j = target - nums[i];
            if (map.containsKey(j)) {
                result[0] = i;
                result[1] = map.get(j);
                break;
            } else {
                map.put(i, nums[i]);
            }
        }
        return result;
    }

    /**
     * 杨辉三角
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {

        List<Integer> row1 = new ArrayList<>(Arrays.asList(1));
        List<Integer> row2 = new ArrayList<>(Arrays.asList(1, 1));
        List<List<Integer>> result = new ArrayList<>();
        result.add(row1);
        result.add(row2);
        if (numRows <= 2) {
            return result.subList(0, numRows);
        } else {
            for (int i = 1; i < numRows - 1; i++) {
                List<Integer> baseList = result.get(i);
                List<Integer> midResult = new ArrayList<>();
                midResult.add(1);
                for (int j = 0, k = 1; k < baseList.size(); j++, k++) {
                    midResult.add(baseList.get(j) + baseList.get(k));
                }
                midResult.add(1);
                result.add(midResult);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        generateV2(2);
    }

    public static List<List<Integer>> generateV2(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        // First base case; if user requests zero rows, they get zero rows.
        if (numRows == 0) {
            return triangle;
        }

        // Second base case; first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);
            System.out.println(prevRow.size());
            // The first row element is always 1.
            row.add(1);

            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // The last row element is always 1.
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }

}
