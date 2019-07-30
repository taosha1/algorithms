public class Test17 {
    public static class ListNode {
        int value;
        ListNode next;
    }

    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的
     *
     * @param head1 第一个有序链表
     * @param head2 第二个有序链表
     * @return 合并后的有序链表头
     */
    // 0 1 3     2 4
    // 0  null
    // null 0
    public static ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        if (head1 == head2) {
            return head1;
        }
        ListNode newHead;

        if (head1.value <= head2.value) {
            newHead = head1;
            head1 = head1.next;
        } else {
            newHead = head2;
            head2 = head2.next;
        }
        ListNode temp = newHead;
        while (head1 != null || head2 != null) {
            if (head1 == null) {
                temp.next = head2;
                break;
            } else if (head2 == null) {
                temp.next = head1;
                break;
            }
            if (head1.value <= head2.value) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        return newHead;
    }

    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的
     * 【使用的是递归的解法，不推荐，递归调用的时候会有方法入栈，需要更多的内存】
     *
     * @param head1 第一个有序链表
     * @param head2 第二个有序链表
     * @return 合并后的有序链表头
     */
    public static ListNode merge2(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        ListNode temp = head1;
        if (temp.value <= head2.value) {
            temp.next = merge2(head1.next,head2);
        } else {
            temp = head2;
            temp.next = merge2(head1,head2.next);
        }
        return temp;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }

    //
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


        ListNode head2 = new ListNode();
        head2.value = 1;

        head2.next = new ListNode();
        head2.next.value = 3;

        head2.next.next = new ListNode();
        head2.next.next.value = 5;

        head2.next.next.next = new ListNode();
        head2.next.next.next.value = 6;

        head2.next.next.next.next = new ListNode();
        head2.next.next.next.next.value = 7;

        ListNode head3 = new ListNode();
        head3.value = 1;

        head3.next = new ListNode();
        head3.next.value = 3;

        head3.next.next = new ListNode();
        head3.next.next.value = 5;

        head3.next.next.next = new ListNode();
        head3.next.next.next.value = 6;

        head3.next.next.next.next = new ListNode();
        head3.next.next.next.next.value = 7;

        ListNode head4 = new ListNode();
//        head4.value = 88;
        head4.value = -1;
        head4.next = new ListNode();
        head4.next.value = 3;

//        head = merge(head2, head3);
//        head = merge(head, head4);
//        head = merge(head, null);
        head = merge2(head, head2);
        printList(head);
    }
}
