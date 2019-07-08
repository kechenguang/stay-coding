package tree.RBTree.version01;

public class RBTreeNode {

    private int value;
    private RBTreeNode parent;
    private RBTreeNode leftNode;
    private RBTreeNode rightNode;
    private boolean isRed;

    public RBTreeNode(int value, RBTreeNode parent, RBTreeNode leftNode, RBTreeNode rightNode, boolean isRed) {
        this.value = value;
        this.parent = parent;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.isRed = isRed;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public RBTreeNode getParent() {
        return parent;
    }

    public void setParent(RBTreeNode parent) {
        this.parent = parent;
    }

    public RBTreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(RBTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public RBTreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(RBTreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public boolean isRed() {
        return isRed;
    }

    public void setRed(boolean red) {
        isRed = red;
    }
}
