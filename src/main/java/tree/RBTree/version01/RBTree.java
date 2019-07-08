package tree.RBTree.version01;

public class RBTree {

    public RBTreeNode root;

    /*
     * 增加节点，可能会造成红黑树结构被破坏，分为以下三种case
     * 1.插入节点的父节点是红色，叔父节点也会红色；
     * 2.插入节点的父节点是红色，叔父节点为黑色或者为空，插入节点，父节点和祖父节点在一条斜线上；
     * 3.插入节点的父节点是红色，叔父节点为黑色或者为空，插入节点，父节点和祖父节点不在一条斜线上；
     */

    public void addNode(RBTreeNode newNode, RBTreeNode rootNode) {


        if (rootNode == null) {
            rootNode = newNode;
            return;
        }
        int value = newNode.getValue();
        if (rootNode.getValue() > value) {
            if (rootNode.getRightNode() == null) {
                rootNode.setRightNode(newNode);
                newNode.setParent(rootNode);
                return;
            } else {
                addNode(newNode, rootNode.getRightNode());
            }
        } else {
            if (rootNode.getLeftNode() == null) {
                rootNode.setLeftNode(newNode);
                newNode.setParent(rootNode);
                return;
            } else {
                addNode(newNode, rootNode.getRightNode());
            }
        }
    }

    public void fixTree(RBTreeNode treeNode) {

        if (treeNode == null) {
            return;
        }
        if (treeNode.getParent() == null && treeNode.isRed()) {
            treeNode.setRed(false);
        }
        //自己是红节点，父亲也是红节点的时候，需要进行修复
        if (treeNode.getParent() != null && treeNode.getParent().isRed() && treeNode.isRed()) {
            RBTreeNode parentNode = treeNode.getParent();
            RBTreeNode uncleNode = getUncle(treeNode);
            if (uncleNode != null && uncleNode.isRed()) {
                parentNode = treeNode.getParent();
                parentNode.setRed(false);
                uncleNode.setRed(false);
                RBTreeNode grandParentNode = parentNode.getParent();
                grandParentNode.setRed(true);
                fixTree(grandParentNode);
            } else {
                //四种情况，左旋，右旋，左右旋，右左旋
                if (treeNode.equals(parentNode.getRightNode())) {
                    RBTreeNode grandParentNode = parentNode.getParent();
                    RBTreeNode grandgrandParentNode = grandParentNode.getParent();
                    if (parentNode.equals(grandParentNode.getRightNode())) {
                        RBTreeNode newNode = rollLeft(parentNode);
                        if (grandgrandParentNode != null) {
                            if (grandParentNode.equals(grandgrandParentNode.getRightNode())) {
                                grandgrandParentNode.setRightNode(newNode);
                                newNode.setParent(grandgrandParentNode);
                            }
                        }
                    } else {
                        RBTreeNode newNode = rollRight(treeNode);
                        grandParentNode.setRightNode(newNode);
                        newNode.setParent(grandgrandParentNode);
                        RBTreeNode newNode02 = rollLeft(parentNode);
                        if (grandgrandParentNode != null) {
                            if (grandParentNode.equals(grandgrandParentNode.getRightNode())) {
                                grandgrandParentNode.setRightNode(newNode02);
                                newNode.setParent(grandgrandParentNode);
                            }
                        }
                    }
                } else {
                    //操作与上述两个操作对称
                    RBTreeNode grandParentNode = parentNode.getParent();
                    RBTreeNode grandgrandParentNode = grandParentNode.getParent();
                    if (parentNode.equals(grandParentNode.getLeftNode())) {
                        RBTreeNode newNode = rollRight(parentNode);
                        if (grandgrandParentNode != null) {
                            if (grandParentNode.equals(grandgrandParentNode.getLeftNode())) {
                                grandgrandParentNode.setLeftNode(newNode);
                                newNode.setParent(grandgrandParentNode);
                            }
                        }
                    } else {
                        RBTreeNode newNode = rollLeft(treeNode);
                        grandParentNode.setLeftNode(newNode);
                        newNode.setParent(grandgrandParentNode);
                        RBTreeNode newNode02 = rollRight(parentNode);
                        if (grandgrandParentNode != null) {
                            if (grandParentNode.equals(grandgrandParentNode.getRightNode())) {
                                grandgrandParentNode.setLeftNode(newNode02);
                                newNode.setParent(grandgrandParentNode);
                            }
                        }
                    }
                }
            }
        }

    }

    public RBTreeNode getUncle(RBTreeNode node) {

        RBTreeNode parentNode = node.getParent();
        RBTreeNode grandParentNode = parentNode.getParent();
        if (grandParentNode == null) {
            return null;
        }
        if (grandParentNode.getLeftNode().equals(parentNode)) {
            return grandParentNode.getRightNode();
        } else {
            return grandParentNode.getLeftNode();
        }
    }

    //左旋（从右边被提升到父节点的操作）
    public RBTreeNode rollLeft(RBTreeNode node) {

        RBTreeNode parentNode = node.getParent();
        //RBTreeNode grandParentNode = parentNode.getParent();
        RBTreeNode leftNode = node.getLeftNode();

        node.setLeftNode(parentNode);
        parentNode.setParent(node);

        if (leftNode != null) {
            parentNode.setRightNode(leftNode);
            leftNode.setParent(parentNode);
        }
        return node;
    }

    //右旋（从左边被提升到父节点的操作）
    public RBTreeNode rollRight(RBTreeNode node) {

        RBTreeNode parentNode = node.getParent();
        RBTreeNode rightNode = node.getRightNode();

        node.setRightNode(parentNode);
        parentNode.setParent(node);

        if (rightNode != null) {
            parentNode.setLeftNode(rightNode);
            rightNode.setParent(parentNode);
        }

        return node;
    }

}
