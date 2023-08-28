package com.yt.yya.list;

import com.yt.yya.utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class N23_MergeKLists {
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            queue.offer(list);
        }

        ListNode result = new ListNode(-1);
        ListNode pNode = result;
        while (!queue.isEmpty()) {
            ListNode temp = queue.poll();
            pNode.next = temp;
            pNode = pNode.next;

            if (temp.next != null) {
                queue.offer(temp.next);
            }
        }

        return result.next;
    }


    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        for (ListNode list : lists) {
            result = mergeTwoLists(result, list);
        }

        return result;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if (list1 != null) {
            tail.next = list1;
        }

        if (list2 != null) {
            tail.next = list2;
        }

        return head.next;
    }
}
