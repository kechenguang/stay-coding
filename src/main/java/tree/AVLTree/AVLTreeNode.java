package tree.AVLTree;


import tree.common.TreeNode;

public class AVLTreeNode<T>  {


    private T value;
    private AVLTreeNode<T> leftNode;
    private AVLTreeNode<T> rightNode;
    private int height;

    public AVLTreeNode(T value) {
        this.value = value;
    }

    public AVLTreeNode(T value, AVLTreeNode<T> leftNode, AVLTreeNode<T> rightNode, int height) {
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.height = height;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public AVLTreeNode<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(AVLTreeNode<T> leftNode) {
        this.leftNode = leftNode;
    }

    public AVLTreeNode<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(AVLTreeNode<T> rightNode) {
        this.rightNode = rightNode;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    //需要自己实现比较逻辑
    public int compareTo(T o) {

        return 0;
    }


}
