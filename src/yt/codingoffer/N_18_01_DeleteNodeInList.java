package yt.codingoffer;

import static yt.codingoffer.utils.List.connectListNodes;
import static yt.codingoffer.utils.List.createListNode;
import static yt.codingoffer.utils.List.destroyList;
import static yt.codingoffer.utils.List.printList;
import static yt.codingoffer.utils.List.printListNode;

import org.junit.Test;

import yt.codingoffer.utils.ListNode;

public class N_18_01_DeleteNodeInList {
	

	private static ListNode deleteNode(ListNode head, ListNode pToBeDelete) {
		if (head == null || pToBeDelete == null) {
			return null;
		}

		// 要删除的节点不是尾节点
		if (pToBeDelete.next != null) {
			ListNode next = pToBeDelete.next;
			pToBeDelete.value = next.value;
			pToBeDelete.next = next.next;
		} else if (head == pToBeDelete) { 
			head = head.next; 
		} else { // 是尾节点
			ListNode node = head;
			while (node.next != pToBeDelete) {
				node = node.next;
			}
			node.next = null;
		}
		return head;
	}

	// ====================测试代码====================
	private static void Test(ListNode pListHead, ListNode pNode) {
		System.out.println();
		System.out.printf("The original list is: \n");
		printList(pListHead);

		System.out.printf("The node to be deleted is: \n");
		printListNode(pNode);

		ListNode head = deleteNode(pListHead, pNode);

		System.out.printf("The result list is: \n");
		printList(head);
		System.out.println();
	}

	// 链表中有多个结点，删除中间的结点
	private static void Test1() {
		ListNode pNode1 = createListNode(1);
		ListNode pNode2 = createListNode(2);
		ListNode pNode3 = createListNode(3);
		ListNode pNode4 = createListNode(4);
		ListNode pNode5 = createListNode(5);

		connectListNodes(pNode1, pNode2);
		connectListNodes(pNode2, pNode3);
		connectListNodes(pNode3, pNode4);
		connectListNodes(pNode4, pNode5);

		Test(pNode1, pNode3);

		destroyList(pNode1);
	}

	// 链表中有多个结点，删除尾结点
	private static void Test2() {
		ListNode pNode1 = createListNode(1);
		ListNode pNode2 = createListNode(2);
		ListNode pNode3 = createListNode(3);
		ListNode pNode4 = createListNode(4);
		ListNode pNode5 = createListNode(5);

		connectListNodes(pNode1, pNode2);
		connectListNodes(pNode2, pNode3);
		connectListNodes(pNode3, pNode4);
		connectListNodes(pNode4, pNode5);

		Test(pNode1, pNode5);

		destroyList(pNode1);
	}

	// 链表中有多个结点，删除头结点
	private static void Test3() {
		ListNode pNode1 = createListNode(1);
		ListNode pNode2 = createListNode(2);
		ListNode pNode3 = createListNode(3);
		ListNode pNode4 = createListNode(4);
		ListNode pNode5 = createListNode(5);

		connectListNodes(pNode1, pNode2);
		connectListNodes(pNode2, pNode3);
		connectListNodes(pNode3, pNode4);
		connectListNodes(pNode4, pNode5);

		Test(pNode1, pNode1);

		destroyList(pNode1);
	}

	// 链表中只有一个结点，删除头结点
	private static void Test4() {
		ListNode pNode1 = createListNode(1);

		Test(pNode1, pNode1);
	}

	// 链表为空
	private static void Test5() {
		Test(null, null);
	}

	public static void main(String[] args) {
		Test1();
	    Test2();
	    Test3();
	    Test4();
	    Test5();
	}
	
	
}
