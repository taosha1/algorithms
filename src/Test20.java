//public class Test20 {
//    /**
//     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印每一个数字
//     *
//     * @param numbers 输入的二维数组，二维数组必须是N*M的，否则出错
//     */
//    public static void printMatrixClockWisely(int[][] numbers) {
//        if (numbers == null || numbers.length < 1 || numbers[0].length < 1) {
//            return;
//        }
//        int left = 0, right = numbers[0].length, top = 0, boom = numbers.length;//记录四个角的位置
//
//        while (left<right-1 || top<boom-1){
//            // ->
//            for (int i = left; i < right-1; i++) {
//                System.out.print(numbers[top][i]);
//            }
//            System.out.println();
//            for (int i = top; i < boom-1; i++) {
//                System.out.print(numbers[i][right - 1]);
//            }
//            System.out.println();
//            // <-
//            for (int i = right - 1; i > left; i--) {
//                System.out.print(numbers[boom - 1][i]);
//            }
//            System.out.println();
//            for (int i = boom - 1 ; i > top; i--) {
//                System.out.print(numbers[i][left]);
//            }
//            System.out.println();
//            left++;
//            right--;
//            top++;
//            boom--;
//
//        }
////        if (left == right-1 && top == boom-1) {
////            System.out.println(numbers[left][top]);
////        }
//    }
//
//    public static void main(String[] args) {
////        int[][] numbers = new int[][]{
////                {1, 2, 3, 4, 5},
////                {16, 17, 18, 19, 6},
////                {15, 24, 25, 20, 7},
////                {14, 23, 22, 21, 8},
////                {13, 12, 11, 10, 9},
////        };
////        printMatrixClockWisely(numbers);
////
////        int[][] numbers2 = {
////                {1, 2, 3, 4, 5, 6, 7, 8},
////                {22, 23, 24, 25, 26, 27, 28, 9},
////                {21, 36, 37, 38, 39, 40, 29, 10},
////                {20, 35, 34, 33, 32, 31, 30, 11},
////                {19, 18, 17, 16, 15, 14, 13, 12},
////
////        };
////        printMatrixClockWisely(numbers2);
////        System.out.println();
//
//
////        int[][] numbers3 = {
////                {1, 2, 3, 4, 5, 6, 7, 8}
////        };
////        printMatrixClockWisely(numbers3);
////        System.out.println();
//
////        int[][] numbers4 = {
////                {1, 2, 3, 4, 5, 6, 7, 8},
////                {16, 15, 14, 13, 12, 11, 10, 9}
////        };
////        printMatrixClockWisely(numbers4);
////        System.out.println();
//
//
//        int[][] numbers5 = {
//                {1},
//                {2},
//                {3},
//                {4},
//                {5},
//                {6},
//                {7},
//                {8}
//        };
//        printMatrixClockWisely(numbers5);
//        System.out.println();
//
////        int[][] numbers6 = {
////                {0, 1},
////                {15, 2},
////                {14, 3},
////                {13, 4},
////                {12, 5},
////                {11, 6},
////                {10, 7},
////                {9, 8}
////        };
////        printMatrixClockWisely(numbers6);
////        System.out.println();
////
////
////        int[][] numbers7 = {
////                {1, 2},
////                {4, 3}
////        };
////        printMatrixClockWisely(numbers7);
////        System.out.println();
////
////        int[][] numbers8 = {
////                {1}
////        };
////        printMatrixClockWisely(numbers8);
////        System.out.println();
////
////        // 0个元素的数组
////        printMatrixClockWisely(new int[][]{{}});
////        // 空数组
////        printMatrixClockWisely(null);
//    }
//}
