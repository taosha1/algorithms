package old;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Test29 {
    /**
     * 题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字
     *
     * @param numbers 输入数组
     * @return 找到的数字
     */
    public static int moreThanHalfNum(int[] numbers) {
        if (numbers == null || numbers.length <= 0) {
            throw new RuntimeException("invalid input");
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int n = 0; n < numbers.length; n++) {
            if (map.get(numbers[n]) == null) {
                map.put(numbers[n], 1);
            } else {
                map.put(numbers[n], map.get(numbers[n]) + 1);
            }
        }
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (map.get(next) > numbers.length / 2) {
                return next;
            }
        }
        throw new RuntimeException("cannot find");
    }

    public static void main(String[] args) {
        // 存在出现次数超过数组长度一半的数字
        int numbers[] = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(moreThanHalfNum(numbers));

        // 出现次数超过数组长度一半的数字都出现在数组的前半部分
        int numbers2[] = {2, 2, 2, 2, 2, 1, 3, 4, 5};
        System.out.println(moreThanHalfNum(numbers2));

        // 出现次数超过数组长度一半的数字都出现在数组的后半部分
        int numbers3[] = {1, 3, 4, 5, 2, 2, 2, 2, 2};
        System.out.println(moreThanHalfNum(numbers3));

        // 只有一个数
        int numbers4[] = {1};
        System.out.println(moreThanHalfNum(numbers4));

        // 不存在出现次数超过数组长度一半的数字
        int numbers5[] = {1, 2, 3, 2, 4, 2, 5, 2, 3};
        System.out.println(moreThanHalfNum(numbers5));
        // 输入空指针
        moreThanHalfNum(null);
    }
}
