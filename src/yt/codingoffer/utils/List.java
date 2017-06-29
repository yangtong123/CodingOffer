package yt.codingoffer.utils;


public class List {
	
	public static ListNode createListNode(int value) {
		ListNode pNode = new ListNode();
		pNode.value = value;
		pNode.next = null;
		
		return pNode;
	}
	
	

	public static void connectListNodes(ListNode pCurrent, ListNode pNext) {
	    if(pCurrent == null) {
	        System.out.printf("Error to connect two nodes.\n");
	        return;
	    }

	    pCurrent.next = pNext;
	}

	public static void printListNode(ListNode pNode) { 
	    if(pNode == null) {
	        System.out.printf("The node is nullptr\n");
	    } else {
	    	System.out.printf("The key in node is %d.\n", pNode.value);
	    }
	}

	public static void printList(ListNode pHead) {
		System.out.printf("PrintList starts.\n");
	    
	    ListNode pNode = pHead;
	    while(pNode != null) {
	    	System.out.printf("%d\t", pNode.value);
	        pNode = pNode.next;
	    }

	    System.out.printf("\nPrintList ends.\n");
	}

	public static void destroyList(ListNode pHead) {
	    ListNode pNode = pHead;
	    while(pNode != null) {
	        pHead = pHead.next;
	        pNode = pHead;
	    }
	}

	public static void addToTail(ListNode pHead, int value) {
	    ListNode pNew = new ListNode();
	    pNew.value = value;
	    pNew.next = null;

	    if(pHead == null) {
	        pHead = pNew;
	    } else {
	        ListNode pNode = pHead;
	        while(pNode.next != null)
	            pNode = pNode.next;

	        pNode.next = pNew;
	    }
	}

	public static void removeNode(ListNode pHead, int value) {
	    if(pHead == null)
	        return;

	    ListNode pToBeDeleted = null;
	    if(pHead.value == value) {
	        pToBeDeleted = pHead;
	        pHead = pHead.next;
	    } else {
	        ListNode pNode = pHead;
	        while(pNode.next != null && pNode.next.value != value)
	            pNode = pNode.next;

	        if(pNode.next != null && pNode.next.value == value) {
	            pToBeDeleted = pNode.next;
	            pNode.next = pNode.next.next;
	        }
	    }

	    if(pToBeDeleted != null) {
	        pToBeDeleted = null;
	    }
	}

}
