public class Test16 {
    public static class ListNode {
        int value;
        ListNode next;
    }

    /**
     * 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
     *
     * @param head 链表的头结点
     * @return 反转后的链表的头结点
     */
    //从第2个节点到第N个节点，依次逐节点插入到第1个节点(head节点)之后，最后将第一个节点挪到新表的表尾
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next != null && head.next.next == null) {
            return head.next;
        }
        ListNode first = head.next;
        ListNode second ;
        // 1 2 3 4
        ListNode nodeFirst = head.next; //不断向前 直到末尾
        ListNode nodeSecond; //不断将后面的节点往后挪
        while (nodeFirst.next != null) {
            nodeSecond= nodeFirst.next;
            nodeFirst.next = nodeSecond.next;
            nodeSecond.next = head.next;
            head.next = nodeSecond;
        }
        nodeFirst.next = head;
        head = nodeFirst.next.next;
        nodeFirst.next.next = null;
        return head;
    }

    public static ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newhead = reverseList3(head.next);	//先递后归，从后往前遍历每个节点进行反转
        head.next.next = head;	//将当前节点的后一个节点的  next 指向当前结点
        head.next = null;			//断开当前节点指向后一个节点
        return newhead;

    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    //使用3个指针遍历单链表，逐个链接点进行反转。
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next != null && head.next.next == null) {
            return head.next;
        }
        ListNode nodeFirst = head;
        ListNode nodeSecond = head.next;
        ListNode nodeThird = head.next.next;
        while (nodeThird.next != null) {
            nodeSecond.next = nodeFirst;
            nodeFirst = nodeSecond;
            nodeSecond = nodeThird;
            nodeThird = nodeThird.next;
        }
        //翻转到头 再手动翻转一次
        nodeSecond.next = nodeFirst;
        nodeThird.next = nodeSecond;
        //重复出现 1 2 1 2 1
        head.next = null;
        return nodeThird;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.value = 1;

        head.next = new ListNode();
        head.next.value = 2;

        head.next.next = new ListNode();
        head.next.next.value = 3;

        head.next.next.next = new ListNode();
        head.next.next.next.value = 4;

        head.next.next.next.next = new ListNode();
        head.next.next.next.next.value = 5;

        head.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.value = 6;

        head.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.value = 7;

        head.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.value = 8;

        head.next.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.next.value = 9;

        printList(head);
        head = reverseList(head);
        printList(head);
//        head = reverseList3(head);
//        printList(head);
//        head = reverseList2(head);
//        printList(head);
    }
}
