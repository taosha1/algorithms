package old;

import java.util.Stack;

public class Test07 {
    /**
     * 用两个栈模拟的队列
     * 用两个核实现一个队列。队列的声明如下，诸实现它的两个函数appendTail和deleteHead，
     * 分别完成在队列尾部插入结点和在队列头部删除结点的功能。
     */

    public static class MQueue<T> {

        private Stack<T> stack1 = new Stack<>();

        private Stack<T> stack2 = new Stack<>();

        public void appendTail(T t) {

            stack1.push(t);
        }

        public T deleteHead() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    T pop = stack1.pop();
                    stack2.push(pop);
                }
            }
            if (stack2.isEmpty()) {
                throw new RuntimeException("No more element.");
            }
            return stack2.pop();

        }
    }


    public static void main(String[] args) {

        MQueue<Integer> queue = new MQueue<>();
        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);
        queue.appendTail(4);
        System.out.println(queue.deleteHead());
        queue.appendTail(6);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }

}
