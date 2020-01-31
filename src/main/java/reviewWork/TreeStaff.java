package reviewWork;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeStaff {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int maxRes = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        gainMax(root);
        return maxRes;
    }

    private int gainMax(TreeNode node) {

        if (node == null) {
            return 0;
        }
        int leftMax = Math.max(0, gainMax(node.left));
        int rightMax = Math.max(0, gainMax(node.right));
        int sum = node.val + leftMax + rightMax;
        maxRes = Math.max(sum, maxRes);
        return Math.max(leftMax, rightMax) + node.val;
    }

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queueA = new LinkedList<>();
        Queue<TreeNode> queueB = new LinkedList<>();
        if (root == null) {
            return res;
        }
        queueA.offer(root);
        TreeNode node = null;
        while (!queueA.isEmpty()) {
            while (!queueA.isEmpty()) {
                node = queueA.poll();
                if (node.left != null) {
                    queueB.offer(node.left);
                }
                if (node.right != null) {
                    queueB.offer(node.right);
                }
            }
            res.add(node.val);
            Queue<TreeNode> temp = queueA;
            queueA = queueB;
            queueB = temp;
        }
        return res;
    }
}
