package old;

public class Test13 {

    /**
     * 链表结点
     */
    public static class ListNode {
        int value; // 保存链表的值
        ListNode next; // 下一个结点
    }

    /**
     * 给定单向链表的头指针和一个结点指针，定义一个函数在0(1)时间删除该结点,
     * 【注意1：这个方法和文本上的不一样，书上的没有返回值，这个因为JAVA引用传递的原因，
     * 如果删除的结点是头结点，如果不采用返回值的方式，那么头结点永远删除不了】
     * 【注意2：输入的待删除结点必须是待链表中的结点，否则会引起错误，这个条件由用户进行保证】
     *
     * @param head        链表表的头
     * @param toBeDeleted 待删除的结点
     * @return 删除后的头结点
     */
    public static ListNode deleteNode(ListNode head, ListNode toBeDeleted) {
        if (head == null || toBeDeleted == null) {
            return head;
        }
        if (head == toBeDeleted) {
            return head.next;
        }
        if (toBeDeleted.next != null) {
            ListNode next = toBeDeleted.next;
            toBeDeleted.value = next.value;
            toBeDeleted.next = next.next;
//            toBeDeleted = toBeDeleted.next; 引用变量 同样按值传递，虽然改变了 但是不会输出66 而是56，修改的只是副本而已
        } else {
            ListNode cur = head;
            while (cur != null) {
                if (cur.next == toBeDeleted) {
                    cur.next = null;
                }
                cur = cur.next;
            }
        }
        return head;
    }

    /*
     * null
     * 删除头 尾 中间节点
     * 删除节点不在链表中
     * 删除的节点为空
     * */
    public static ListNode deleteNode2(ListNode head, ListNode toBeDeleted) {
        if (toBeDeleted == head || head == null) {
            return null;
        }
        ListNode root = head;
        if (toBeDeleted == null) {
            return root;
        }
        while (head != null) {
            if (toBeDeleted == head.next) {
                if (head.next.next != null) {
                    ListNode next = head.next.next;
                    head.next = next;
                } else {
                    head.next = null;
                }
            } else {
                head = head.next;
            }
            //toBeDeleted NOT FOUND
            if (head == null) {
                throw new RuntimeException("invalid input");
            }
        }
        return root;
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

        ListNode middle = head.next.next.next.next = new ListNode();
        head.next.next.next.next.value = 5;

        head.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.value = 6;

        head.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.value = 7;

        head.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.value = 8;

        ListNode last = head.next.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.next.value = 9;
//
//        head = deleteNode(head, null); // 删除的结点为空
//        printList(head);
//        ListNode node = new ListNode();
//        node.value = 12;
//        head = deleteNode(head, head); // 删除头结点
//        printList(head);
//        head = deleteNode(head, last); // 删除尾结点
//        printList(head);
//        head = deleteNode(head, node); // 删除的结点不在链表中
//        printList(head);
        head = deleteNode(head, middle); // 删除中间结点
        printList(head);

    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value);
            head = head.next;
        }
        System.out.println();
    }
}
