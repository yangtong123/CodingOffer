package com.yt.yya.list;

import com.yt.yya.utils.ListNode;

public class N234_isPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head, fast = head;

        while (fast != null) {
            if (fast.next == null) {
                break;
            }

            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode tail = reverseList(slow);

        while (head != tail && tail != null) {
            if (head.val != tail.val) {
                return false;
            }
            head = head.next;
            tail = tail.next;
        }

        return true;
    }

    public ListNode reverseList(ListNode node) {
        ListNode pre = null;
        ListNode p = node;

        while (p != null) {
            ListNode temp = p.next;
            p.next = pre;
            pre = p;
            p = temp;
        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;

        N234_isPalindrome obj = new N234_isPalindrome();
        System.out.println(obj.isPalindrome(head));
    }
}
