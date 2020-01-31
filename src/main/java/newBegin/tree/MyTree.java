package newBegin.tree;

import java.util.*;

public class MyTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int numTrees(int n) {

        int res = 0;
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        map.put(1, new ArrayList<TreeNode>(Arrays.asList(new TreeNode(1))));
        for (int i = 2; i <= n; i++) {
            List<TreeNode> trees = map.get(i - 1);
            List<TreeNode> list = new ArrayList<>();
            for (TreeNode treeNod : trees) {
                TreeNode newTree = new TreeNode(i);
                newTree.left = treeNod;
                list.add(newTree);
                TreeNode right = treeNod;
                while (right != null) {

                }
            }
        }
        return res;
    }
}
