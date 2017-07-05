package yt.codingoffer;

import yt.codingoffer.utils.ListNode;
import static yt.codingoffer.utils.List.*;

public class N_25_MergeSortedLists {
	private static ListNode merge(ListNode head1, ListNode head2) {
		if (head1 == null) {
			return head2;
		} else if (head2 == null) {
			return head1;
		}
		
		ListNode pMergedHead = null;
		
		if (head1.value <= head2.value) {
			pMergedHead = head1;
			pMergedHead.next = merge(head1.next, head2);
		} else {
			pMergedHead = head2;
			pMergedHead.next = merge(head1, head2.next);
		}
		
		return pMergedHead;
	}
	
	// ====================测试代码====================
	private static ListNode Test(String testName, ListNode pHead1, ListNode pHead2)
	{
	    if(testName != null)
	        System.out.printf("%s begins:\n", testName);

	    System.out.printf("The first list is:\n");
	    printList(pHead1);

	    System.out.printf("The second list is:\n");
	    printList(pHead2);

	    System.out.printf("The merged list is:\n");
	    ListNode pMergedHead = merge(pHead1, pHead2);
	    printList(pMergedHead);
	    
//	    printf("\n\n");
	    System.out.println();
	    System.out.println();
	    
	    return pMergedHead;
	}

	// list1: 1->3->5
	// list2: 2->4->6
	private static void Test1()
	{
	    ListNode pNode1 = createListNode(1);
	    ListNode pNode3 = createListNode(3);
	    ListNode pNode5 = createListNode(5);

	    connectListNodes(pNode1, pNode3);
	    connectListNodes(pNode3, pNode5);

	    ListNode pNode2 = createListNode(2);
	    ListNode pNode4 = createListNode(4);
	    ListNode pNode6 = createListNode(6);

	    connectListNodes(pNode2, pNode4);
	    connectListNodes(pNode4, pNode6);

	    ListNode pMergedHead = Test("Test1", pNode1, pNode2);
	    
	}

	// 两个链表中有重复的数字
	// list1: 1->3->5
	// list2: 1->3->5
	private static void Test2()
	{
	    ListNode pNode1 = createListNode(1);
	    ListNode pNode3 = createListNode(3);
	    ListNode pNode5 = createListNode(5);

	    connectListNodes(pNode1, pNode3);
	    connectListNodes(pNode3, pNode5);

	    ListNode pNode2 = createListNode(1);
	    ListNode pNode4 = createListNode(3);
	    ListNode pNode6 = createListNode(5);

	    connectListNodes(pNode2, pNode4);
	    connectListNodes(pNode4, pNode6);

	    ListNode pMergedHead = Test("Test2", pNode1, pNode2);

	}

	// 两个链表都只有一个数字
	// list1: 1
	// list2: 2
	private static void Test3()
	{
	    ListNode pNode1 = createListNode(1);
	    ListNode pNode2 = createListNode(2);

	    ListNode pMergedHead = Test("Test3", pNode1, pNode2);

	}

	// 一个链表为空链表
	// list1: 1->3->5
	// list2: 空链表
	private static void Test4()
	{
	    ListNode pNode1 = createListNode(1);
	    ListNode pNode3 = createListNode(3);
	    ListNode pNode5 = createListNode(5);

	    connectListNodes(pNode1, pNode3);
	    connectListNodes(pNode3, pNode5);

	    ListNode pMergedHead = Test("Test4", pNode1, null);

	}

	// 两个链表都为空链表
	// list1: 空链表
	// list2: 空链表
	private static void Test5()
	{
	    ListNode pMergedHead = Test("Test5", null, null);
	}
	
	public static void main(String[] args) {
		Test1();
		Test2();
		Test3();
		Test4();
		Test5();
	}
}
