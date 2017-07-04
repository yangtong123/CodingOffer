package yt.codingoffer;

import yt.codingoffer.utils.ListNode;
import static yt.codingoffer.utils.List.*;

public class N_23_EntryNodeInListLoop {
	private static ListNode meetingNode(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode pSlow = head.next;
		if (pSlow == null) {
			return null;
		}
		ListNode pFast = pSlow.next;
		while (pFast != null && pSlow != null) {
			if (pFast == pSlow) {
				return pFast;
			}
			pSlow = pSlow.next;
			pFast = pFast.next;
			if (pFast != null) {
				pFast = pFast.next;
			}
		}
		
		return null;
	}
	
	private static ListNode entryNodeOfLoop(ListNode head) {
		ListNode meetingNode = meetingNode(head);
		if (meetingNode == null) {
			return null;
		}
		
		// 得到环中的节点数目
		int nodesInLoop = 1;
		ListNode pNode1 = meetingNode;
		while (pNode1.next != meetingNode) {
			pNode1 = pNode1.next;
			++nodesInLoop;
		}
		
		// 先移动pNode1，次数为环中节点数目
		pNode1 = head;
		ListNode pNode2 = head;
		for (int i = 0; i < nodesInLoop; i++) {
			pNode1 = pNode1.next;
		}
		while (pNode1 != pNode2) {
			pNode1 = pNode1.next;
			pNode2 = pNode2.next;
		}
		
		return pNode1;
	}
	
	// ==================== Test Code ====================
	private static void Test(String testName, ListNode pHead, ListNode entryNode)
	{
	    if(testName != null)
	        System.out.printf("%s begins: ", testName);

	    if(entryNodeOfLoop(pHead) == entryNode)
	        System.out.printf("Passed.\n");
	    else
	        System.out.printf("FAILED.\n");
	}

	// A list has a node, without a loop
	private static void test1()
	{
	    ListNode pNode1 = createListNode(1);

	    Test("Test1", pNode1, null);

	}

	// A list has a node, with a loop
	private static void test2()
	{
	    ListNode pNode1 = createListNode(1);
	    connectListNodes(pNode1, pNode1);

	    Test("Test2", pNode1, pNode1);

	}

	// A list has multiple nodes, with a loop 
	private static void test3()
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
	    connectListNodes(pNode5, pNode3);

	    Test("Test3", pNode1, pNode3);

	}

	// A list has multiple nodes, with a loop 
	private static void test4()
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
	    connectListNodes(pNode5, pNode1);

	    Test("Test4", pNode1, pNode1);

	}

	// A list has multiple nodes, with a loop 
	private static void test5()
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
	    connectListNodes(pNode5, pNode5);

	    Test("Test5", pNode1, pNode5);

	}

	// A list has multiple nodes, without a loop 
	private static void test6()
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

	    Test("Test6", pNode1, null);

	}

	// Empty list
	private static void test7()
	{
	    Test("Test7", null, null);
	}
	
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
		test7();
	}
}
