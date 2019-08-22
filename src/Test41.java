import java.util.PriorityQueue;

public class Test41 {

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private int N = 0;

    public void Insert(Integer val) {
        /* 插入要保证两个堆存于平衡状态 */
        if (N % 2 == 0) {
            /* N 为偶数的情况下插入到右半边。
             * 因为右半边元素都要大于左半边，但是新插入的元素不一定比左半边元素来的大，
             * 因此需要先将元素插入左半边，然后利用左半边为大顶堆的特点，取出堆顶元素即为最大元素，此时插入右半边 */
            maxHeap.add(val);
            minHeap.add(maxHeap.poll());
        } else {
            minHeap.add(val);
            maxHeap.add(minHeap.poll());
        }
        N++;

    }


    public Double GetMedian() {
        if (N > 0 && N % 2 == 0) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return (double) maxHeap.peek();
        }

    }
}
