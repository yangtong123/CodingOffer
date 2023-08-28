package com.yt.yya.list;

import com.yt.yya.utils.ListNode;

public class N19_RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode pa = head, pb = head;

        int i = n;
        while (i-- > 0) {
            pa = pa.next;
        }

        if (pa == null) {
            return pb.next;
        }

        while (pa.next != null) {
            pa = pa.next;
            pb = pb.next;
        }

        pb.next = pb.next.next;
        return head;
    }
}
