package com.yt.yya.utils;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }
}
