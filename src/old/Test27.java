package old;

public class Test27 {

    /**
     * 二叉树的树结点
     */
    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    /**
     * 题目：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
     * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
     *
     * @param root 二叉树的根结点
     * @return 双向链表的头结点
     */
    public static BinaryTreeNode convert(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        BinaryTreeNode mostLeft = findMostLeft(root);
        BinaryTreeNode[] lastNode = {new BinaryTreeNode()};
        convert(root, lastNode);


        return mostLeft;
    }

    private static BinaryTreeNode findMostLeft(BinaryTreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    private static void convert(BinaryTreeNode root, BinaryTreeNode[] lastNode) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            convert(root.left, lastNode);
        }
        //对最左边的节点来说 前驱为空
        root.left = lastNode[0];

        if (lastNode != null) {
            lastNode[0].right = root;
        }
        //调整指向最后链表一个结点的指针
        lastNode[0] = root;

        if (root.right != null) {
            convert(root.right, lastNode);
        }

    }

    private static void printTree(BinaryTreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.value + "->");
            printTree(root.right);
        }
    }

    public static void main(String[] args) {
        test01();
        test02();
        test03();
        test04();
        test05();

    }

    //            10
    //         /      \
    //        6        14
    //       /\        /\
    //      4  8     12  16
    private static void test01() {
        BinaryTreeNode node10 = new BinaryTreeNode();
        node10.value = 10;

        BinaryTreeNode node6 = new BinaryTreeNode();
        node6.value = 6;

        BinaryTreeNode node14 = new BinaryTreeNode();
        node14.value = 14;

        BinaryTreeNode node4 = new BinaryTreeNode();
        node4.value = 4;

        BinaryTreeNode node8 = new BinaryTreeNode();
        node8.value = 8;

        BinaryTreeNode node12 = new BinaryTreeNode();
        node12.value = 12;

        BinaryTreeNode node16 = new BinaryTreeNode();
        node16.value = 16;
        node16.left =  new BinaryTreeNode();
        node16.left.value = 15;

        node10.left = node6;
        node10.right = node14;

        node6.left = node4;
        node6.right = node8;

        node14.left = node12;
        node14.right = node16;

        System.out.print("Before convert: ");
        printTree(node10);
        System.out.println("null");
        BinaryTreeNode head = convert(node10);
        System.out.print("After convert : ");
        printList(head);
        System.out.println();

    }

    private static void printList(BinaryTreeNode head) {

        while (head != null) {
            System.out.print(head.value + "->");
            head = head.right;
        }
        System.out.println();
    }

    //               5
    //              /
    //             4
    //            /
    //           3
    //          /
    //         2
    //        /
    //       1
    private static void test02() {
        BinaryTreeNode node1 = new BinaryTreeNode();
        node1.value = 1;

        BinaryTreeNode node2 = new BinaryTreeNode();
        node2.value = 2;

        BinaryTreeNode node3 = new BinaryTreeNode();
        node3.value = 3;

        BinaryTreeNode node4 = new BinaryTreeNode();
        node4.value = 4;

        BinaryTreeNode node5 = new BinaryTreeNode();
        node5.value = 5;

        node5.left = node4;
        node4.left = node3;
        node3.left = node2;
        node2.left = node1;

        System.out.print("Before convert: ");
        printTree(node5);
        System.out.println("null");
        BinaryTreeNode head = convert(node5);
        System.out.print("After convert : ");
        printList(head);
        System.out.println();
    }

    // 1
    //  \
    //   2
    //    \
    //     3
    //      \
    //       4
    //        \
    //         5
    private static void test03() {
        BinaryTreeNode node1 = new BinaryTreeNode();
        node1.value = 1;

        BinaryTreeNode node2 = new BinaryTreeNode();
        node2.value = 2;

        BinaryTreeNode node3 = new BinaryTreeNode();
        node3.value = 3;

        BinaryTreeNode node4 = new BinaryTreeNode();
        node4.value = 4;

        BinaryTreeNode node5 = new BinaryTreeNode();
        node5.value = 5;

        node1.right = node2;
        node2.right = node3;
        node3.right = node4;
        node4.right = node5;

        System.out.print("Before convert: ");
        printTree(node1);
        System.out.println("null");
        BinaryTreeNode head = convert(node1);
        System.out.print("After convert : ");
        printList(head);
        System.out.println();
    }

    // 只有一个结点
    private static void test04() {
        BinaryTreeNode node1 = new BinaryTreeNode();
        node1.value = 1;

        System.out.print("Before convert: ");
        printTree(node1);
        System.out.println("null");
        BinaryTreeNode head = convert(node1);
        System.out.print("After convert : ");
        printList(head);
        System.out.println();
    }

    // 没有结点
    private static void test05() {
        System.out.print("Before convert: ");
        printTree(null);
        System.out.println("null");
        BinaryTreeNode head = convert(null);
        System.out.print("After convert : ");
        printList(head);
        System.out.println();
    }


}
