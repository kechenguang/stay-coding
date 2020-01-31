package Leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllTree {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> generateTrees(int n) {

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }
        return getAllTrees(array, 0, n - 1);

    }

    public List<TreeNode> getAllTrees(int[] array, int start, int end) {

        List<TreeNode> res = new ArrayList<>();
        if (start == end) {
            res.add(new TreeNode(array[start]));
            return res;
        }
        for (int i = start; i <= end; i++) {
            if (i == start) {
                List<TreeNode> others = getAllTrees(array, start + 1, end);
                if (others != null && others.size() > 0) {
                    for (TreeNode treeNode1 : others) {
                        TreeNode treeNode = new TreeNode(array[start]);
                        treeNode.right = treeNode1;
                        treeNode.left = null;
                        res.add(treeNode);
                    }
                }
            } else if (i == end) {
                List<TreeNode> others = getAllTrees(array, start, end - 1);
                if (others != null && others.size() > 0) {
                    for (TreeNode treeNode1 : others) {
                        TreeNode treeNode = new TreeNode(array[start]);
                        treeNode.left = treeNode1;
                        treeNode.right = null;
                        res.add(treeNode);
                    }
                }
            } else {
                List<TreeNode> leftNode = getAllTrees(array, start, i - 1);
                List<TreeNode> rightNode = getAllTrees(array, i + 1, end);
                if (leftNode != null && rightNode != null) {
                    for (TreeNode l : leftNode) {
                        for (TreeNode r : rightNode) {
                            TreeNode treeNode = new TreeNode(array[i]);
                            treeNode.right = r;
                            treeNode.left = l;
                            res.add(treeNode);
                        }
                    }
                }
            }
        }
        return res;
    }
}


