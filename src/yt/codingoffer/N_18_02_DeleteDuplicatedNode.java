package yt.codingoffer;

import yt.codingoffer.utils.ListNode;
import static yt.codingoffer.utils.List.*;

public class N_18_02_DeleteDuplicatedNode {
	public static void main(String[] args) {
		Test1();
		Test2();
		Test3();
		Test4();
		Test5();
		Test6();
		Test7();
		Test8();
		Test9();
		Test10();
	}
	
	private static ListNode deleteDuplication(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode preNode = null;
		ListNode curNode = head;

		while (curNode != null) {
			ListNode nextNode = curNode.next;
			boolean isNeedDel = false;
			if (nextNode != null && curNode.value == nextNode.value) {
				isNeedDel = true;
			}

			if (!isNeedDel) {
				preNode = curNode;
				curNode = curNode.next;
			} else {
				int value = curNode.value;
				while (curNode != null && curNode.value == value) {
					nextNode = curNode.next;
					curNode = nextNode;
				}
				if (preNode != null) {
					preNode.next = curNode;
				} else {
					head = curNode;
				}
			}

		}
		return head;
	}

	// ====================测试代码====================
	private static void Test(String testName, ListNode pHead, int[] expectedValues, int expectedLength) {
		if (testName != null)
			System.out.printf("%s begins: ", testName);

		ListNode head = deleteDuplication(pHead);

		int index = 0;
		ListNode pNode = head;
		while (pNode != null && index < expectedLength) {
			if (pNode.value != expectedValues[index])
				break;

			pNode = pNode.next;
			index++;
		}

		if (pNode == null && index == expectedLength)
			System.out.printf("Passed.\n");
		else
			System.out.printf("FAILED.\n");
	}

	// 某些结点是重复的
	private static void Test1() {
		ListNode pNode1 = createListNode(1);
		ListNode pNode2 = createListNode(2);
		ListNode pNode3 = createListNode(3);
		ListNode pNode4 = createListNode(3);
		ListNode pNode5 = createListNode(4);
		ListNode pNode6 = createListNode(4);
		ListNode pNode7 = createListNode(5);

		connectListNodes(pNode1, pNode2);
		connectListNodes(pNode2, pNode3);
		connectListNodes(pNode3, pNode4);
		connectListNodes(pNode4, pNode5);
		connectListNodes(pNode5, pNode6);
		connectListNodes(pNode6, pNode7);

		ListNode pHead = pNode1;

		int expectedValues[] = { 1, 2, 5 };
		Test("Test1", pHead, expectedValues, expectedValues.length);

		destroyList(pHead);
	}

	// 没有重复的结点
	private static void Test2() {
		ListNode pNode1 = createListNode(1);
		ListNode pNode2 = createListNode(2);
		ListNode pNode3 = createListNode(3);
		ListNode pNode4 = createListNode(4);
		ListNode pNode5 = createListNode(5);
		ListNode pNode6 = createListNode(6);
		ListNode pNode7 = createListNode(7);

		connectListNodes(pNode1, pNode2);
		connectListNodes(pNode2, pNode3);
		connectListNodes(pNode3, pNode4);
		connectListNodes(pNode4, pNode5);
		connectListNodes(pNode5, pNode6);
		connectListNodes(pNode6, pNode7);

		ListNode pHead = pNode1;

		int expectedValues[] = { 1, 2, 3, 4, 5, 6, 7 };
		Test("Test2", pHead, expectedValues, expectedValues.length);

		destroyList(pHead);
	}

	// 除了一个结点之外其他所有结点的值都相同
	private static void Test3() {
		ListNode pNode1 = createListNode(1);
		ListNode pNode2 = createListNode(1);
		ListNode pNode3 = createListNode(1);
		ListNode pNode4 = createListNode(1);
		ListNode pNode5 = createListNode(1);
		ListNode pNode6 = createListNode(1);
		ListNode pNode7 = createListNode(2);

		connectListNodes(pNode1, pNode2);
		connectListNodes(pNode2, pNode3);
		connectListNodes(pNode3, pNode4);
		connectListNodes(pNode4, pNode5);
		connectListNodes(pNode5, pNode6);
		connectListNodes(pNode6, pNode7);

		ListNode pHead = pNode1;

		int expectedValues[] = { 2 };
		Test("Test3", pHead, expectedValues, expectedValues.length);

		destroyList(pHead);
	}

	// 所有结点的值都相同
	private static void Test4() {
		ListNode pNode1 = createListNode(1);
		ListNode pNode2 = createListNode(1);
		ListNode pNode3 = createListNode(1);
		ListNode pNode4 = createListNode(1);
		ListNode pNode5 = createListNode(1);
		ListNode pNode6 = createListNode(1);
		ListNode pNode7 = createListNode(1);

		connectListNodes(pNode1, pNode2);
		connectListNodes(pNode2, pNode3);
		connectListNodes(pNode3, pNode4);
		connectListNodes(pNode4, pNode5);
		connectListNodes(pNode5, pNode6);
		connectListNodes(pNode6, pNode7);

		ListNode pHead = pNode1;

		Test("Test4", pHead, null, 0);

		destroyList(pHead);
	}

	// 所有结点都成对出现
	private static void Test5() {
		ListNode pNode1 = createListNode(1);
		ListNode pNode2 = createListNode(1);
		ListNode pNode3 = createListNode(2);
		ListNode pNode4 = createListNode(2);
		ListNode pNode5 = createListNode(3);
		ListNode pNode6 = createListNode(3);
		ListNode pNode7 = createListNode(4);
		ListNode pNode8 = createListNode(4);

		connectListNodes(pNode1, pNode2);
		connectListNodes(pNode2, pNode3);
		connectListNodes(pNode3, pNode4);
		connectListNodes(pNode4, pNode5);
		connectListNodes(pNode5, pNode6);
		connectListNodes(pNode6, pNode7);
		connectListNodes(pNode7, pNode8);

		ListNode pHead = pNode1;

		Test("Test5", pHead, null, 0);

		destroyList(pHead);
	}

	// 除了两个结点之外其他结点都成对出现
	private static void Test6() {
		ListNode pNode1 = createListNode(1);
		ListNode pNode2 = createListNode(1);
		ListNode pNode3 = createListNode(2);
		ListNode pNode4 = createListNode(3);
		ListNode pNode5 = createListNode(3);
		ListNode pNode6 = createListNode(4);
		ListNode pNode7 = createListNode(5);
		ListNode pNode8 = createListNode(5);

		connectListNodes(pNode1, pNode2);
		connectListNodes(pNode2, pNode3);
		connectListNodes(pNode3, pNode4);
		connectListNodes(pNode4, pNode5);
		connectListNodes(pNode5, pNode6);
		connectListNodes(pNode6, pNode7);
		connectListNodes(pNode7, pNode8);

		ListNode pHead = pNode1;

		int expectedValues[] = { 2, 4 };
		Test("Test6", pHead, expectedValues, expectedValues.length);

		destroyList(pHead);
	}

	// 链表中只有两个不重复的结点
	private static void Test7() {
		ListNode pNode1 = createListNode(1);
		ListNode pNode2 = createListNode(2);

		connectListNodes(pNode1, pNode2);

		ListNode pHead = pNode1;

		int expectedValues[] = { 1, 2 };
		Test("Test7", pHead, expectedValues, expectedValues.length);

		destroyList(pHead);
	}

	// 结点中只有一个结点
	private static void Test8() {
		ListNode pNode1 = createListNode(1);

		connectListNodes(pNode1, null);

		ListNode pHead = pNode1;

		int expectedValues[] = { 1 };
		Test("Test8", pHead, expectedValues, expectedValues.length);

		destroyList(pHead);
	}

	// 结点中只有两个重复的结点
	private static void Test9() {
		ListNode pNode1 = createListNode(1);
		ListNode pNode2 = createListNode(1);

		connectListNodes(pNode1, pNode2);

		ListNode pHead = pNode1;

		Test("Test9", pHead, null, 0);

		destroyList(pHead);
	}

	// 空链表
	private static void Test10() {
		ListNode pHead = null;

		Test("Test10", pHead, null, 0);
	}

	
}
