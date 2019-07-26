public class Test18 {
    /**
     * 二叉树的树结点
     */
    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    /**
     * 输入两棵二叉树A和B，判断B是不是A的子结构。
     * 该方法是在A树中找到一个与B树的根节点相等的元素的结点，
     * 从这个相等的结点开始判断树B是不是树A的子结构，如果找到其的一个就返回，
     * 否则直到所有的结点都找完为止。
     *
     * @param root1 树A的根结点
     * @param root2 树B的根结点
     * @return true：树B是树A的子结构，false：树B是不树A的子结构
     */
    public static boolean hasSubtree(BinaryTreeNode root1, BinaryTreeNode root2) {
        String s1 = preOrder(root1).toString();
        String s2 = preOrder(root2).toString();
        if (s1.contains(s2)) {
            return true;
        }
        return false;
    }

    public static boolean hasSubtree2(BinaryTreeNode root1, BinaryTreeNode root2) {

        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        boolean flag = false;

        if (root1.value == root2.value) {
            flag = match(root1, root2) ;
//            flag = match(root1.left, root2.left) && match(root1.right, root2.right);
        }
        if (flag) {
            return true;
        }
        return hasSubtree2(root1.left, root2) || hasSubtree2(root1.right, root2);
    }

    public static boolean match(BinaryTreeNode root1, BinaryTreeNode root2) {
        // 只要树B的根结点点为空就返回true
        if (root2 == null) {
            return true;
        }
        // 树B的根结点不为空，如果树A的根结点为空就返回false
        if (root1 == null) {
            return false;
        }
        if (root1.value == root2.value) {
            return match(root1.left, root2.left) && match(root1.right, root2.right);
        }
        return false;
    }
//    public static boolean match(BinaryTreeNode root1, BinaryTreeNode root2) {
//        if (root1 == null) {
//            return false;
//        }
//        if (root2 == null) {
//            return true;
//        }
//        if (root1.value == root2.value) {
//            return true;
//        }
//
//        return false;
//    }

    public static StringBuilder preOrder(BinaryTreeNode tree) {
        StringBuilder string = new StringBuilder();
        if (tree != null) {
            string.append(tree.value);
            string.append(preOrder(tree.left));
            string.append(preOrder(tree.right));
//            preOrder(tree.right);
        }
        return string;
    }

    public static void main(String[] args) {
        BinaryTreeNode root1 = new BinaryTreeNode();
        root1.value = 8;
        root1.right = new BinaryTreeNode();
        root1.right.value = 7;
        root1.left = new BinaryTreeNode();
        root1.left.value = 8;
        root1.left.left = new BinaryTreeNode();
        root1.left.left.value = 9;
        root1.left.right = new BinaryTreeNode();
        root1.left.right.value = 2;
        root1.left.right.left = new BinaryTreeNode();
        root1.left.right.left.left = new BinaryTreeNode();
        root1.left.right.left.left.value = 4;
        root1.left.right.left.right = new BinaryTreeNode();
        root1.left.right.left.right.value = 7;

        BinaryTreeNode root2 = new BinaryTreeNode();
        root2.value = 8;
        root2.left = new BinaryTreeNode();
        root2.left.value = 19;
        root2.right = new BinaryTreeNode();
        root2.right.value = 2;

        System.out.println(preOrder(root1));
        System.out.println(hasSubtree2(root1, root2));
    }
}
