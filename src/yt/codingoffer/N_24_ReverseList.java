package yt.codingoffer;

import yt.codingoffer.utils.ListNode;
import static yt.codingoffer.utils.List.*;

public class N_24_ReverseList {
	private static ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}

		
		ListNode pre = null;
		ListNode cur = head;
		ListNode next = null;

		ListNode reverseHead = null;
		
		while (cur != null) {
			next = cur.next;
			if (next == null) {
				reverseHead = cur;
			}
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		
		return reverseHead;
	}
	
	// ====================测试代码====================
	private static ListNode Test(ListNode pHead)
	{
	    System.out.printf("The original list is: \n");
	    printList(pHead);

	    ListNode pReversedHead = reverseList(pHead);

	    System.out.printf("The reversed list is: \n");
	    printList(pReversedHead);

	    return pReversedHead;
	}

	// 输入的链表有多个结点
	private static void Test1()
	{
		ListNode pNode1 = createListNode(1);
	    ListNode pNode2 = createListNode(2);
	    ListNode pNode3 = createListNode(3);
	    ListNode pNode4 = createListNode(4);
	    ListNode pNode5 = createListNode(5);

	    connectListNodes(pNode1, pNode2);
	    connectListNodes(pNode2, pNode3);
	    connectListNodes(pNode3, pNode4);
	    connectListNodes(pNode4, pNode5);

	    ListNode pReversedHead = Test(pNode1);

	}

	// 输入的链表只有一个结点
	private static void Test2()
	{
	    ListNode pNode1 = createListNode(1);

	    ListNode pReversedHead = Test(pNode1);

	}

	// 输入空链表
	private static void Test3()
	{
	    Test(null);
	}
	
	public static void main(String[] args) {
		Test1();
		Test2();
		Test3();
	}
}
