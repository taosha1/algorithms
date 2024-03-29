package old;

public class Test03 {
    /**
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * <p/>
     * 规律：首先选取数组中右上角的数字。如果该数字等于要查找的数字，查找过程结束：
     * 如果该数字大于要查找的数字，剔除这个数字所在的列：如果该数字小于要查找的数字，剔除这个数字所在的行。
     * 也就是说如果要查找的数字不在数组的右上角，则每－次都在数组的查找范围中剔除）行或者一列，这样每一步都可以缩小
     * 查找的范围，直到找到要查找的数字，或者查找范围为空。
     *
     * @param matrix 待查找的数组
     * @param number 要查找的数
     * @return 查找结果，true找到，false没有找到
     */
    public static boolean find(int[][] matrix, int number) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int row = matrix.length - 1;
        int column = matrix[0].length - 1;
        int j = 0;
        int i = column;

        while (j <= row && i >= 0) {
            if (matrix[j][i] == number) {
                return true;
            } else if (matrix[j][i] < number) {
                j++;
            } else {
                i--;
            }
        }
        return false;
//        for (; j <= row; ) {
//            if (j == row + 1 || i == -1) {
//                return false;
//            }
//            for (; i >= 0; ) {
//                if (j == row + 1 || i == -1) {
//                    return false;
//                }
//                if (matrix[j][i] == number) {
//                    return true;
//                } else if (matrix[j][i] < number) {
//                    j++;
//                } else {
//                    i--;
//                }
//
//            }
//        }
    }

    private static void test1() {
        int[][] matrix = {{1, 4, 7, 9}, {2, 5, 8, 11}};
        boolean b = find(null, 11);
//        boolean b = find(matrix, -1);
//        boolean b = find(matrix, 8);
//        boolean b = find(matrix, 11);
//        boolean b = find(matrix, 1);
//        boolean b = find(matrix, 15);
        System.out.println(b);
    }

    public static void main(String[] args) {
        Test03.test1();
    }


}
