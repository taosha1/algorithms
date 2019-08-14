package old;

public class Test01 {

    //二叉树的下一个节点
    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode parent;
    }

    public BinaryTreeNode getNext(BinaryTreeNode node) {
        if (node == null) {
            return null;
        }
        BinaryTreeNode next = null;
        if (node.right != null) {
            BinaryTreeNode right = node.right;
            while (right.left != null) {
                right = right.left;
            }
            return right;
        } else if (node.parent != null) {
            BinaryTreeNode parent = node.parent;
            BinaryTreeNode cur = node;
            while (parent != null && cur == parent.right) {
                cur = parent;
                parent = parent.parent;
            }
            next = parent;
        }
        return next;
    }

}
