import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Test40 {
    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] nums, int k) {
        if (k > nums.length || k <= 0)
            return new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int num : nums) {
            maxHeap.add(num);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }
        return new ArrayList<>(maxHeap);
    }

    private int partition(int[] nums, int l, int h) {
        int index = (int) (Math.random() * (h - l) + l);
        swap(nums, index, h);
        int num = l - 1;
        for (int i = l; i <= h; i++) {
            if (nums[i] < nums[h]) {
                num++;
                if (num != i) {
                    swap(nums, num, i);
                }
            }
        }
        num++;
        swap(nums, num, h);
        return num;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (nums == null || nums.length < 1) {
            return null;
        }

        int start = 0;
        int end = nums.length - 1;
        int index = partition(nums, start, end);
        while (index + 1 != k) {
            if (index + 1 > k) {
                end = index - 1;
                index = partition(nums, start, end);
            } else {
                start = index + 1;
                index = partition(nums, start, end);
            }
        }

        for (int i = 0; i < k; i++) {
            list.add(nums[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 6, 5, 6, 72, 7, 3, 8};
//        new Test40().partition(arr, 0, arr.length - 1);
        System.out.println(new Test40().GetLeastNumbers_Solution2(arr, 4));
//        for (int i = 0; i < 100; i++) {
//            System.out.println(new Test40().GetLeastNumbers_Solution(arr, 6).toString());
//        }
    }
}
