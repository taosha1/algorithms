public class Test05 {
    public static class ListNode {
        int val; // 结点的值
        ListNode nxt; // 下一个结点
    }

    /**
     * 输入个链表的头结点，从尾到头反过来打印出每个结点的值
     * 使用栈的方式进行
     * @param root 链表头结点
     */
    public static void printListInverselyUsingIteration(ListNode root) {
        if (root==null){
            return;
        }
        StringBuilder builder = new StringBuilder();
        ListNode head = root;
        while (head!=null){
            builder.append(head.val);
            head = head.nxt;
        }
        reverse(builder);
    }

    private static void reverse(StringBuilder builder){
        int length = builder.length();
        for (int i = length-1; i >= 0 ; i--) {
            System.out.println(builder.charAt(i));
        }
    }

    public static void main(String[] args) {
        ListNode root = new ListNode();
        root.val = 1;
        root.nxt = new ListNode();
        root.nxt.val = 2;
        root.nxt.nxt = new ListNode();
        root.nxt.nxt.val = 3;
        root.nxt.nxt.nxt = new ListNode();
        root.nxt.nxt.nxt.val = 4;
        root.nxt.nxt.nxt.nxt = new ListNode();
        root.nxt.nxt.nxt.nxt.val = 5;

        printListInverselyUsingIteration(root);
    }

}
