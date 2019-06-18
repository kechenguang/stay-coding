package tree.AVLTree;

import tree.common.BalanceTree;
import tree.common.TreeNode;

public class AVLTree<T> extends BalanceTree<T> {


    public void addByValue(T v) {

        setRootNode(addNode(v, getRootNode()));
    }

    public AVLTreeNode<T> addNode(T value, AVLTreeNode node) {

        AVLTreeNode newNode = new AVLTreeNode(value);
        if (node == null) {
            node = newNode;
        }
        if (node.compareTo(newNode) > 0) {
            node.setRightNode(addNode(value, node.getRightNode()));
            if (height(node.getRightNode()) - height(node.getLeftNode()) == 2) {
                AVLTreeNode rightNode = node.getRightNode();
                if (rightNode.getRightNode().getHeight() > rightNode.getLeftNode().getHeight()) {
                    node = rollLeft(node);
                } else {
                    node = rightLeftRoll(node);
                }
            }
        } else if (node.compareTo(newNode) < 0) {
            node.setLeftNode(addNode(value, node.getLeftNode()));
            if (height(node.getLeftNode()) - height(node.getRightNode()) == 2) {
                AVLTreeNode leftNode = node.getLeftNode();
                if (leftNode.getLeftNode().getHeight() > leftNode.getRightNode().getHeight()) {
                    node = rollRight(node);
                } else {
                    node = leftRightRoll(node);
                }
            }
        }
        node.setHeight(Math.max(height(node.getRightNode()), height(node.getLeftNode())) + 1);
        return node;

    }

    public AVLTreeNode<T> rollLeft(AVLTreeNode node) {

        AVLTreeNode a = node.getRightNode();
        node.setRightNode(a.getLeftNode());
        a.setLeftNode(node);
        node.setHeight(Math.max(height(node.getRightNode()), height(node.getLeftNode())) + 1);
        a.setHeight(Math.max(height(a.getLeftNode()), height(a.getRightNode())) + 1);
        return a;

    }

    public AVLTreeNode<T> rollRight(AVLTreeNode node) {

        AVLTreeNode a = node.getLeftNode();
        node.setLeftNode(a.getRightNode());
        a.setRightNode(node);

        node.setHeight(Math.max(height(node.getRightNode()), height(node.getLeftNode())) + 1);
        a.setHeight(Math.max(height(a.getLeftNode()), height(a.getRightNode())) + 1);
        return a;
    }

    public AVLTreeNode<T> leftRightRoll(AVLTreeNode node) {

        node.setRightNode(rollLeft(node.getRightNode()));
        return rollRight(node);
    }

    public AVLTreeNode<T> rightLeftRoll(AVLTreeNode node) {

        node.setLeftNode(rollRight(node.getLeftNode()));
        return rollLeft(node);
    }


    public int height(AVLTreeNode node) {

        if (node == null) {
            return -1;
        } else {
            return node.getHeight();
        }
    }


}
