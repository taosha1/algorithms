package old;

import com.sun.org.apache.regexp.internal.RE;

public class Test26 {
    /**
     * 复杂链表结点
     */
    public static class ComplexListNode {
        int value;
        ComplexListNode next;
        ComplexListNode sibling;
    }

    /**
     * 实现函复制一个复杂链表。在复杂链表中，每个结点除了有一个next字段指向下一个结点外，
     * 还有一个sibling字段指向链表中的任意结点或者NULL
     *
     * @param head 链表表头结点
     * @return 复制结点的头结点
     */
    public static ComplexListNode clone(ComplexListNode head) {
        if (head == null) {
            return null;
        }
        cloneNodes(head);
        cloneSibling(head);
        return chaifeiNodes(head);
    }

    private static ComplexListNode chaifeiNodes(ComplexListNode head) {
        ComplexListNode cur = head;
        ComplexListNode newHead = cur.next;
        ComplexListNode node = newHead;

        cur.next = newHead.next;
        cur = cur.next;
        while (cur != null) {
            node.next = cur.next;
            node = node.next;

            cur.next = node.next;
            cur = cur.next;
        }
        return newHead;
    }
    public static void printList(ComplexListNode head) {
        while (head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static boolean isSame(ComplexListNode h1, ComplexListNode h2) {
        while (h1 != null && h2 != null) {
            if (h1 == h2) {
                h1 = h1.next;
                h2 = h2.next;
            } else {
                return false;
            }
        }

        return h1 == null && h2 == null;
    }

    public static void main(String[] args) {
        //          -----------------
        //         \|/              |
        //  1-------2-------3-------4-------5
        //  |       |      /|\             /|\
        //  --------+--------               |
        //          -------------------------
        ComplexListNode head = new ComplexListNode();
        head.value = 1;
        head.next = new ComplexListNode();
        head.next.value = 2;
        head.next.next = new ComplexListNode();
        head.next.next.value = 3;
        head.next.next.next = new ComplexListNode();
        head.next.next.next.value = 4;
        head.next.next.next.next = new ComplexListNode();
        head.next.next.next.next.value = 5;

        head.sibling = head.next.next;
        head.next.sibling = head.next.next.next.next.next;
        head.next.next.next.sibling = head.next;

        ComplexListNode tmp = head;
        printList(head);
        ComplexListNode newHead = clone(head);
        printList(head);
        System.out.println(isSame(head, tmp));
        printList(newHead);
        System.out.println(isSame(head, newHead));


        // 有指向自身的情况
        //          -----------------
        //         \|/              |
        //  1-------2-------3-------4-------5
        //         |       | /|\           /|\
        //         |       | --             |
        //         |------------------------|
        ComplexListNode head2 = new ComplexListNode();
        head2.value = 1;
        head2.next = new ComplexListNode();
        head2.next.value = 2;
        head2.next.next = new ComplexListNode();
        head2.next.next.value = 3;
        head2.next.next.next = new ComplexListNode();
        head2.next.next.next.value = 4;
        head2.next.next.next.next = new ComplexListNode();
        head2.next.next.next.next.value = 5;

        head2.next.sibling = head2.next.next.next.next;
        head2.next.next.next.sibling = head2.next.sibling;
        head2.next.next.sibling = head2.next.next;

        System.out.println("\n");
        tmp = head2;
        printList(head2);
        ComplexListNode newHead2 = clone(head2);
        printList(head2);
        System.out.println(isSame(head2, tmp));
        printList(newHead2);
        System.out.println(isSame(head2, newHead2));


        ComplexListNode head3 = new ComplexListNode();
        head3.value = 1;

        System.out.println("\n");
        tmp = head3;
        printList(head3);
        ComplexListNode newHead3 = clone(head3);
        printList(head3);
        System.out.println(isSame(head3, tmp));
        printList(newHead3);
        System.out.println(isSame(head3, newHead3));

        System.out.println("\n");
        ComplexListNode head4 = clone(null);
        printList(head4);
    }


    private static void cloneSibling(ComplexListNode head) {
        ComplexListNode cur = head;
        while (cur != null) {
            ComplexListNode clone = cur.next;
            if (cur.sibling != null) {
                clone.sibling = cur.sibling.next;
            }
            cur = clone.next;
        }
    }

    public static void cloneNodes(ComplexListNode head) {
        ComplexListNode cur = head;
        while (cur != null) {
            ComplexListNode clone = new ComplexListNode();
            clone.value = cur.value;
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }
    }
    //    方法二：哈希表法，复杂度o(n)，空间换时间
//    public static RandomListNode Clone2(RandomListNode pHead) {
//        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
//        RandomListNode cur = pHead;
//        while (cur != null) {
//            map.put(cur, new RandomListNode(cur.label)); // 将新旧结点配对在哈希表里
//            cur = cur.next;
//        }
//        cur = pHead;
//        while (cur != null) {
//            map.get(cur).next = map.get(cur.next);
//            map.get(cur).random = map.get(cur.random);
//            cur = cur.next;
//        }
//        return map.get(pHead);
//    }
}
