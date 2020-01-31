package newBegin.tree;

import java.util.*;


/**
 * 这个类用来练习树的各种遍历方法（非递归）
 * 1.中序遍历：左--》中--》右
 * 2.先序遍历：中--》左--》右
 * 3.后序遍历：左--》右--》中
 */
public class Tree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return res;
        }
        stack.push(root);
        TreeNode node = root.left;
        while (!stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                res.add(node.val);
                node = node.right;
                if (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
        return res;
    }

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return res;
        }
        res.add(root.val);
        stack.push(root);
        TreeNode node = root.left;
        while (!stack.isEmpty()) {
            if (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                node = node.right;
                if (node != null) {
                    res.add(node.val);
                    stack.push(node);
                    node = node.left;
                }
            }
        }
        return res;
    }

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return res;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(0, node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return res;
    }


}
