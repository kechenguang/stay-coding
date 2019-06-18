package tree.common;

import tree.AVLTree.AVLTreeNode;

public class BalanceTree<T> {


    private AVLTreeNode<T> rootNode;

    public AVLTreeNode getRootNode() {
        return rootNode;
    }

    public void setRootNode(AVLTreeNode rootNode) {
        this.rootNode = rootNode;
    }


}
