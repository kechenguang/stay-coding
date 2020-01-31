package newBegin;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Tree {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    class Solution {

        int maxValue = Integer.MIN_VALUE;

        public int maxDepth(TreeNode root) {

            if (root == null) {
                return 0;
            } else {
                return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
            }
        }


        public int maxPathSum(TreeNode root) {

            maxRootValue(root);
            return maxValue;
        }

        /**
         * 递归遍历，计算出已node为最高节点时，所能获取到的最大路径和
         *
         * @param node
         * @return
         */
        public int maxRootValue(TreeNode node) {

            int left = Math.max(maxRootValue(node.left), 0);
            int right = Math.max(maxRootValue(node.right), 0);

            maxValue = Math.max(maxValue, node.val + left + right);
            return node.val + Math.max(maxRootValue(node.left), maxRootValue(node.right));
        }


        public List<Integer> rightSideView(TreeNode root) {

            Stack<TreeNode> nodeStack = new Stack<>();
            List<Integer> integers = new ArrayList<>();
            Stack<TreeNode> midStack = new Stack<>();
            if (root == null) return integers;
            nodeStack.push(root);
            while (!nodeStack.isEmpty()) {
                integers.add(nodeStack.peek().val);
                while (!nodeStack.isEmpty()) {
                    midStack.push(nodeStack.pop());
                }
                while (!midStack.isEmpty()) {
                    TreeNode top = midStack.pop();
                    if (top.left != null) nodeStack.push(top.left);
                    if (top.right != null) nodeStack.push(top.right);
                }
            }
            return integers;
        }

        int maxLength = 1;

        public int diameterOfBinaryTree(TreeNode root) {

            getMaxDepth(root);
            return maxLength - 1;
        }

        public int getMaxDepth(TreeNode node) {

            if (node == null) {
                return 0;
            }
            int leftDepth = getMaxDepth(node.left);
            int rightDepth = getMaxDepth(node.right);
            maxLength = Math.max(maxLength, 1 + leftDepth + rightDepth);
            return 1 + Math.max(leftDepth, rightDepth);
        }

    }
}
