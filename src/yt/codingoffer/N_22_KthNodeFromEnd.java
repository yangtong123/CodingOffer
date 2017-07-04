package yt.codingoffer;

import yt.codingoffer.utils.ListNode;
import static yt.codingoffer.utils.List.*;

public class N_22_KthNodeFromEnd {
	private static ListNode findKthToTail(ListNode listHead, int k) {
		if (listHead == null || k == 0) {
			return null;
		}
		
		ListNode pHead = listHead;
		ListNode pBehind = null;
		
		for (int i = 0; i < k-1; i++) {
			if (pHead.next != null) {
				pHead = pHead.next;
			} else {
				return null;
			}
		}
		
		pBehind = listHead;
		
		while (pHead.next != null) {
			pHead = pHead.next;
			pBehind = pBehind.next;
		}
		return pBehind;
	}
	
	// ====================测试代码====================
	// 测试要找的结点在链表中间
	private static void Test1()
	{
	    System.out.printf("=====Test1 starts:=====\n");
	    ListNode pNode1 = createListNode(1);
	    ListNode pNode2 = createListNode(2);
	    ListNode pNode3 = createListNode(3);
	    ListNode pNode4 = createListNode(4);
	    ListNode pNode5 = createListNode(5);

	    connectListNodes(pNode1, pNode2);
	    connectListNodes(pNode2, pNode3);
	    connectListNodes(pNode3, pNode4);
	    connectListNodes(pNode4, pNode5);

	    System.out.printf("expected result: 4.\n");
	    ListNode pNode = findKthToTail(pNode1, 2);
	    printListNode(pNode);

	}

	// 测试要找的结点是链表的尾结点
	private static void Test2()
	{
	    System.out.printf("=====Test2 starts:=====\n");
	    ListNode pNode1 = createListNode(1);
	    ListNode pNode2 = createListNode(2);
	    ListNode pNode3 = createListNode(3);
	    ListNode pNode4 = createListNode(4);
	    ListNode pNode5 = createListNode(5);

	    connectListNodes(pNode1, pNode2);
	    connectListNodes(pNode2, pNode3);
	    connectListNodes(pNode3, pNode4);
	    connectListNodes(pNode4, pNode5);

	    System.out.printf("expected result: 5.\n");
	    ListNode pNode = findKthToTail(pNode1, 1);
	    printListNode(pNode);

	}

	// 测试要找的结点是链表的头结点
	private static void Test3()
	{
	    System.out.printf("=====Test3 starts:=====\n");
	    ListNode pNode1 = createListNode(1);
	    ListNode pNode2 = createListNode(2);
	    ListNode pNode3 = createListNode(3);
	    ListNode pNode4 = createListNode(4);
	    ListNode pNode5 = createListNode(5);

	    connectListNodes(pNode1, pNode2);
	    connectListNodes(pNode2, pNode3);
	    connectListNodes(pNode3, pNode4);
	    connectListNodes(pNode4, pNode5);

	    System.out.printf("expected result: 1.\n");
	    ListNode pNode = findKthToTail(pNode1, 5);
	    printListNode(pNode);

	}

	// 测试空链表
	private static void Test4()
	{
	    System.out.printf("=====Test4 starts:=====\n");
	    System.out.printf("expected result: nullptr.\n");
	    ListNode pNode = findKthToTail(null, 100);
	    printListNode(pNode);
	}

	// 测试输入的第二个参数大于链表的结点总数
	private static void Test5()
	{
	    System.out.printf("=====Test5 starts:=====\n");
	    ListNode pNode1 = createListNode(1);
	    ListNode pNode2 = createListNode(2);
	    ListNode pNode3 = createListNode(3);
	    ListNode pNode4 = createListNode(4);
	    ListNode pNode5 = createListNode(5);

	    connectListNodes(pNode1, pNode2);
	    connectListNodes(pNode2, pNode3);
	    connectListNodes(pNode3, pNode4);
	    connectListNodes(pNode4, pNode5);

	    System.out.printf("expected result: nullptr.\n");
	    ListNode pNode = findKthToTail(pNode1, 6);
	    printListNode(pNode);

	}

	// 测试输入的第二个参数为0
	private static void Test6()
	{
	    System.out.printf("=====Test6 starts:=====\n");
	    ListNode pNode1 = createListNode(1);
	    ListNode pNode2 = createListNode(2);
	    ListNode pNode3 = createListNode(3);
	    ListNode pNode4 = createListNode(4);
	    ListNode pNode5 = createListNode(5);

	    connectListNodes(pNode1, pNode2);
	    connectListNodes(pNode2, pNode3);
	    connectListNodes(pNode3, pNode4);
	    connectListNodes(pNode4, pNode5);

	    System.out.printf("expected result: nullptr.\n");
	    ListNode pNode = findKthToTail(pNode1, 0);
	    printListNode(pNode);

	}
	
	public static void main(String[] args) {
		Test1();
		Test2();
		Test3();
		Test4();
		Test5();
		Test6();
	}
}
