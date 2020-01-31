package reviewWork;

import java.util.*;

public class BackTrack {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        permuteBackTrack(nums, 0, list);
        return list;

    }

    private void permuteBackTrack(int[] nums, int first, List<List<Integer>> res) {

        if (first == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            res.add(list);
            return;
        }
        for (int i = first; i < nums.length; i++) {
            swap(nums, first, i);
            permuteBackTrack(nums, first + 1, res);
            swap(nums, first, i);
        }
    }

    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void nextPermutation(int[] nums) {

        int l = nums.length;
        if (l <= 1) {
            return;
        }
        for (int i = l - 1; i >= 1; i--) {
            int a = nums[i];
            int b = nums[i - 1];
            if (a > b) {
                int index = i;
                for (int j = l - 1; j >= i; j--) {
                    if (nums[j] > b) {
                        index = j;
                        break;
                    }
                }
                nums[i - 1] = nums[index];
                nums[index] = b;
                Arrays.sort(nums, i, l);
                return;
            }
        }
        Arrays.sort(nums);
        return;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {

        int l = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (l == 0) {
            return res;
        }
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            numList.add(nums[i]);
        }
        Stack<Integer> midRes = new Stack<>();
        backTrackpermuteUnique(numList, l, res, midRes);
        return res;
    }

    public void backTrackpermuteUnique(List<Integer> nums, int l, List<List<Integer>> res, Stack<Integer> midRes) {

        if (midRes.size() == l) {
            res.add(new ArrayList<>(midRes));
            return;
        }
        Set<Integer> usedNums = new HashSet<>();
        for (int i = 0; i < nums.size(); i++) {
            if (usedNums.contains(nums.get(i))) {
                continue;
            }
            int x = nums.get(i);
            usedNums.add(x);
            midRes.push(x);
            nums.remove(i);
            backTrackpermuteUnique(nums, l, res, midRes);
            nums.add(i, x);
            midRes.pop();
        }
    }


    //有多少种上楼梯的办法
    public int climbStairs(int n) {

        if (n == 0) {
            return 0;
        }
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        backTrackCountStairs(n, stack, res);
        return res.size();
    }

    public void backTrackCountStairs(int n, Stack<Integer> stack, List<List<Integer>> res) {

        if (n == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }
        if (n >= 2) {
            stack.push(2);
            backTrackCountStairs(n - 2, stack, res);
            stack.pop();
        }
        stack.push(1);
        backTrackCountStairs(n - 1, stack, res);
        stack.pop();
    }

    public int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {

        if (grid.length == 0) {
            return 0;
        }
        int count = 0;
        int[][] road = new int[grid.length][grid[0].length];
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == '1' && road[x][y] == 0) {
                    road[x][y] = ++count;
                    searchAndMark(road, count, x, y, grid);
                }
            }
        }
        return count;
    }

    public void searchAndMark(int[][] road, int markWord, int x, int y, char[][] grid) {

        for (int i = 0; i < 4; i++) {
            int nextX = x + direction[i][0];
            int nextY = y + direction[i][1];
            if (nextX >= road.length || nextX < 0 || nextY >= road[0].length || nextY < 0 || road[nextX][nextY] != 0 || grid[nextX][nextY] != '1') {
                continue;
            }
            road[nextX][nextY] = markWord;
            searchAndMark(road, markWord, nextX, nextY, grid);
        }
    }


    public List<String> restoreIpAddresses(String s) {

        List<String> res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }
        trackBackSearch(0, s, new Stack<String>(), res);
        return res;
    }

    public void trackBackSearch(int start, String s, Stack<String> midRes, List<String> res) {

        if (midRes.size() == 4) {
            res.add(buildIp(midRes));
            return;
        }
        for (int l = 1; l <= 3; l++) {
            int sunsquentCount = 4 - midRes.size() - 1;
            int remainLength = s.length() - start - l;
            if (sunsquentCount == 0) {
                if (remainLength != 0) {
                    continue;
                }
            } else {
                double averageLength = (double) remainLength / sunsquentCount;
                if (averageLength > 3.0 || averageLength < 1.0) {
                    continue;
                }
            }
            midRes.push(s.substring(start, start + l + 1));
            trackBackSearch(start + l, s, midRes, res);
            midRes.pop();
        }
    }

    public String buildIp(Stack<String> midRes) {

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            builder.append(midRes.get(i));
            if (i != 3) {
                builder.append('.');
            }
        }
        return builder.toString();
    }
}
