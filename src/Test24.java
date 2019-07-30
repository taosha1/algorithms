import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Test24 {

    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 如果是则返回true。否则返回false。假设输入的数组的任意两个数字都互不相同。
     *
     * @param sequence 某二叉搜索树的后序遍历的结果
     * @return true：该数组是某二叉搜索树的后序遍历的结果。false：不是
     */
    public static boolean verifySequenceOfBST(int[] sequence) {
        if (sequence.length <= 0 || sequence == null) {
            return false;
        }

        int leftIndex = 0;
        int root = sequence[sequence.length - 1];
        for (int i = 0; i < sequence.length; i++) {
            if (root <= sequence[i]) {
                leftIndex = i;
                break;
            }
        }
        int rightIndex = leftIndex;
        for (int i = rightIndex; i < sequence.length - 1; i++) {
            if (sequence[i] < root) {
                return false;
            }
        }

        boolean leftFlag = true;
        if (leftIndex > 0)
            leftFlag = verifySequenceOfBST(Arrays.copyOfRange(sequence, 0, leftIndex));
        boolean rightFlag = true;
        if (leftIndex < sequence.length - 1) {
            rightFlag = verifySequenceOfBST(Arrays.copyOfRange(sequence, leftIndex, sequence.length - 1));
        }

        return leftFlag && rightFlag;


    }
//    public static boolean verifySequenceOfBST(int[] sequence) {
//        if (sequence.length == 1 || sequence.length == 0) {
//            return true;
//        }
//        int root = sequence[sequence.length - 1];
//        int left = 0;
//        for (int i = 0; i < sequence.length; i++) {
//            if (sequence[i] < root && sequence[i + 1] > root) {
//                left = i;
//                break;
//            }
//        }
//        int right = sequence.length-2;
//        int[] leftArr = new int[left + 1];
//        int[] rightArr = new int[right - left];
//        Arrays.copyOfRange()
//        for (int i = 0; i <= left; i++) {
//            leftArr[i] = sequence[i];
//        }
//        for (int i = left + 1; i <= right; i++) {
//            rightArr[i - left - 1] = sequence[i];
//        }
//
//
//        if (root < sequence[right] && root > sequence[left]) {
//            return verifySequenceOfBST(leftArr) && verifySequenceOfBST(rightArr);
//        } else {
//            return false;
//        }
//    }

    public static void main(String[] args) {
        //           10
        //         /   \
        //        6     14
        //       /\     /\
        //      4  8  12  16

//        int[] data = {4, 8, 6, 12, 16, 14, 10};
//        System.out.println("true: " + verifySequenceOfBST(data));
        //           5
        //          / \
        //         4   7
        //            /
        //           6
        int[] data2 = {4, 6, 7, 5};
        System.out.println("true: " + verifySequenceOfBST(data2));

        //               5
        //              /
        //             4
        //            /
        //           3
        //          /
        //         2
        //        /
        //       1
        int[] data3 = {1, 2, 3, 4, 5};
        System.out.println("true: " + verifySequenceOfBST(data3));

        // 1
        //  \
        //   2
        //    \
        //     3
        //      \
        //       4
        //        \
        //         5
        int[] data4 = {5, 4, 3, 2, 1};
        System.out.println("true: " + verifySequenceOfBST(data4));

        // 树中只有1个结点
        int[] data5 = {5};
        System.out.println("true: " + verifySequenceOfBST(data5));

        int[] data6 = {7, 4, 6, 5};
        System.out.println("false: " + verifySequenceOfBST(data6));

        int[] data7 = {4, 6, 12, 8, 16, 14, 10};
        System.out.println("false: " + verifySequenceOfBST(data7));

    }

}
