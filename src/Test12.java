public class Test12 {

    /**
     * 输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则打印出1、2、3 一直到最大的3位数即999。
     *
     * @param n 数字的最大位数
     */
    public static void printOneToNthDigits(int n) {

        if (n < 1) {
            throw new RuntimeException("invalid input");
        }
        int[] arr = new int[n];
        printOneToNthDigits(0, arr);


    }

    private static void printOneToNthDigits(int n, int[] arr) {
        if (n >= arr.length) {
            printArr(arr);
        } else {
            for (int i = 0; i <= 9; i++) {
                arr[n] = i;
                printOneToNthDigits(n + 1, arr);
            }
        }

    }

    private static void printArr(int[] arr) {
        int index = 0;
        for (int i = 0; i < arr.length && arr[i] == 0; i++) {
            index++;
        }
        for (int i = index; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    public static void printOneToNthDigits2(int n) {
        if (n < 1) {
            throw new RuntimeException("invalid input");
        }
        int[] arr = new int[n];
        while (!increment(arr)) {
            printArr(arr);
        }

    }


    public static void main(String[] args) {
        printOneToNthDigits2(3);

    }

    private static boolean increment(int[] arr) {
        boolean isOverFlow = false;
        int takeOver = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int sum = arr[i] + takeOver;
            if (arr.length - 1 == i) {
                sum++;
            }
            if (sum >= 10) {
                if (i == 0) {
                    isOverFlow = true;
                } else {
                    sum -= 10;
                    takeOver=1;
                    arr[i] = sum;
                }
            }else {
                arr[i] = sum;
                break;
            }
        }
        return isOverFlow;
    }
}
