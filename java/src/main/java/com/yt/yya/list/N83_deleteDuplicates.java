package com.yt.yya.list;

import com.yt.yya.utils.ListNode;

public class N83_deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode p1 = head, p2 = head.next;

        while (p2 != null) {
            if (p2.val != p1.val) {
                p1.next = p2;
                p1 = p2;
            }
            p2 = p2.next;
        }

        p1.next = null;

        return head;
    }
}
