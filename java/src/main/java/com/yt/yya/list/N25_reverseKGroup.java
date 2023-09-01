package com.yt.yya.list;

import com.yt.yya.utils.ListNode;

public class N25_reverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;

        while (head != null) {
            ListNode tail = pre;

            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return dummy.next;
                }
            }

            ListNode next = tail.next;
            ListNode[] reverseNodes = reverse(head, tail);
            head = reverseNodes[0];
            tail = reverseNodes[1];

            pre.next = head;
            tail.next = next;

            pre = tail;
            head = tail.next;
        }

        return dummy.next;
    }

    private ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode pre = tail.next;
        ListNode p = head;
        while (pre != tail) {
            ListNode temp = p.next;
            p.next = pre;
            pre = p;
            p = temp;
        }

        return new ListNode[] {tail, head};
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(6);
        head.next = n1;
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;

        N25_reverseKGroup obj = new N25_reverseKGroup();
        obj.reverseKGroup(head, 2);
    }
}
