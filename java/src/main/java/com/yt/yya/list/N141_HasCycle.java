package com.yt.yya.list;

import com.yt.yya.utils.ListNode;

public class N141_HasCycle {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode first = head.next;
        ListNode second = head;

        while (first != second) {
            if (first.next == null || second == null) {
                return false;
            }

            first = first.next.next;
            second = second.next;
        }

        return true;
    }
}
