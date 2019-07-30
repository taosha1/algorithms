import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test21 {
    /**
     * 定义栈的数据结构，请在该类型中实现一个能够得到校的最小元素的min函数。
     * 在该栈中，调用pop、push 及min的时间复杂度都是0(1)
     *
     * @param <T> 泛型参数
     */
    class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> min_stack;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            min_stack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if(min_stack.isEmpty() || x <= min_stack.peek())
                min_stack.push(x);
        }

        public void pop() {
            if(stack.pop().equals(min_stack.peek()))
                min_stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min_stack.peek();
        }
    }

    public static class StackWithMin<T extends Comparable<T>> {
        private Stack<T> stack = new Stack<>();
        private List<T> list = new ArrayList<>();

        public T getMin() {
            return list.get(list.size() - 1);
        }

        public void push(T t) {
            if (list.size() == 0) {
                list.add(t);
            }
            stack.push(t);
            //<= 连续几个相同的最小值
            if (t.compareTo(list.get(list.size() - 1)) <= 0) {
                list.add(t);
            }
        }

        public T pop() {
            T t = list.get(list.size() - 1);
            T pop = stack.pop();
            if (t == pop) {
                list.remove(t);
            }
            return pop;
        }
    }

    public static void main(String[] args) {
//        StackWithMin<Integer> stack = new StackWithMin<>();
//        stack.push(3);
//        System.out.println(stack.getMin() == 3);
//        stack.push(4);
//        System.out.println(stack.getMin() == 3);
//        stack.push(2);
//        System.out.println(stack.getMin() == 2);
//        stack.push(3);
//        System.out.println(stack.getMin() == 2);
//        stack.pop();
//        System.out.println(stack.getMin() == 2);
//        stack.pop();
//        System.out.println(stack.getMin() == 3);
//        stack.push(0);
//        System.out.println(stack.getMin() == 0);
        StackWithMin<Integer> minStack = new StackWithMin<>();
        minStack.push(3);
        minStack.push(5);
        System.out.println(minStack.getMin());
        minStack.push(2);
        minStack.push(2);
        minStack.push(2);
        System.out.println(minStack.getMin());
        minStack.push(7);

        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());


    }
}
