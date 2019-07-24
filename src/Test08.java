public class Test08 {
    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾， 我们称之数组的旋转。
     * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3, 4, 5, 1, 2｝为｛l ,2, 3, 4, 5}的一个旋转，该数组的最小值为
     *
     * @param numbers 旋转数组
     * @return 数组的最小值
     */
    public static int min(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new RuntimeException("invalid input");
        }

        int low = 0;
        int high = numbers.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (numbers[mid] > numbers[low]) {
                low = mid;
            } else if (numbers[mid] < numbers[high]) {
                high = mid;
            }
            if (high - low == 1) {
                break;
            }
            if (numbers[mid] == numbers[high] && numbers[high] == numbers[low]) {
                int minNum = Integer.MAX_VALUE;
                for (int i = 0; i < numbers.length; i++) {
                    if (numbers[i] < minNum) {
                        minNum = numbers[i];
                    }
                }
                return minNum;
            }
        }
        return numbers[high];
    }

    public static void test1() {
        int[] arr = new int[]{3, 4, 5, 56, 1, 2};
        System.out.println(min(arr));
    }

    public static void test2() {
        int[] arr = new int[]{1, 1, 1, 1, 0, 1};
        System.out.println(min(arr));
        // 有重复数字，并且重复的数字刚好的最小的数字
        int[] array2 = {3, 4, 5, 1, 1, 2};
        System.out.println(min(array2));
        // 有重复数字，但重复的数字不是第一个数字和最后一个数字
        int[] array3 = {3, 4, 5, 1, 2, 2};
        System.out.println(min(array3));

        // 有重复的数字，并且重复的数字刚好是第一个数字和最后一个数字
        int[] array4 = {1, 0, 1, 1, 1};
        System.out.println(min(array4));

        // 数组中只有一个数字
        int[] array6 = {222};
        System.out.println(min(array6));

        // 数组中数字都相同
        int[] array7 = {1, 1, 1, 1, 1, 1, 1};
        System.out.println(min(array7));


        // 输入NULL
//        System.out.println(min(null));

    }

    public static void main(String[] args) {
//        test1();
        test2();

    }

}
