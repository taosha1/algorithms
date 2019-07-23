public class Test06 {

    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }
    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二节树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *
     * @param preorder 前序遍历
     * @param inorder  中序遍历
     * @return 树的根结点
     */
    public static BinaryTreeNode construct(int[] preorder, int[] inorder) {
        BinaryTreeNode root = new BinaryTreeNode();
        root.value =1;




    }
    /*
    *      1
    *   5      12
    * 6  8   11
    *   9
    * */
    public static void main(String[] args) {
        int[] preorder = new int[]{1,5,6,8,9,12,11};
        int[] inorder =  new int[]{6,5,9,8,1,11,12};


    }
}
