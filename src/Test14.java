public class Test14 {
    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有奇数位于数组的前半部分，所有偶数位予数组的后半部分。
     *
     * @param arr 输入的数组
     */
    public static void reorderOddEven(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int low = 0;
        int high = arr.length - 1;

        while (low<high){
            if ((arr[low] & 1) == 1) {
                low++;
            } else {
                int temp = arr[high];
                arr[high] = arr[low];
                arr[low] = temp;
            }
            if ((arr[high] & 1) == 1) {
                int temp =  arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
            }else {
                high--;
            }
        }

    }

    public static void printArray(int[] arr) {
        if (arr != null && arr.length > 0) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 222, 3, 4, 534, 6, 7, 8, 9};
        reorderOddEven(array);
        printArray(array);
    }
}
