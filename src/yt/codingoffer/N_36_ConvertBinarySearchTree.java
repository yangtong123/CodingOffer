package yt.codingoffer;

import yt.codingoffer.utils.BinaryTreeNode;
import static yt.codingoffer.utils.BinaryTree.*;

public class N_36_ConvertBinarySearchTree {
	
	static BinaryTreeNode lastNodeInList;
	
	private static BinaryTreeNode convert(BinaryTreeNode root) {
		if (root == null) {
			return null;
		}
		lastNodeInList = null;
		convertNode(root);
		BinaryTreeNode head = root;
		while (head != null && head.left != null) {
			head = head.left;
		}
		return head;
	}
	
	private static void convertNode(BinaryTreeNode node) {
		if (node == null) {
			return ;
		}
		
		BinaryTreeNode current = node;
		
		if (node.left != null) {
			convertNode(node.left);
		}
		
		current.left = lastNodeInList;
		
		if (lastNodeInList != null) {
			lastNodeInList.right = current;
		}
		
		lastNodeInList = current;
		
		if (node.right != null) {
			convertNode(node.right);
		}
	}
	
	// ====================测试代码====================
	private static void PrintDoubleLinkedList(BinaryTreeNode pHeadOfList)
	{
	    BinaryTreeNode pNode = pHeadOfList;

	    System.out.printf("The nodes from left to right are:\n");
	    while(pNode != null)
	    {
	        System.out.print(pNode.value + "\t");

	        if(pNode.right == null)
	            break;
	        pNode = pNode.right;
	    }

	    System.out.printf("\nThe nodes from right to left are:\n");
	    while(pNode != null)
	    {
	        System.out.print(pNode.value + "\t");

	        if(pNode.left == null)
	            break;
	        pNode = pNode.left;
	    }

	    System.out.printf("\n");
	}

	void DestroyList(BinaryTreeNode pHeadOfList)
	{
	    BinaryTreeNode pNode = pHeadOfList;
	    while(pNode != null)
	    {
	        BinaryTreeNode pNext = pNode.right;

	        pNode = pNext;
	    }
	}

	private static void Test(String testName, BinaryTreeNode pRootOfTree)
	{
	    if(testName != null)
	        System.out.printf("%s begins:\n", testName);

	    PrintTree(pRootOfTree);

	    BinaryTreeNode pHeadOfList = convert(pRootOfTree);
	    
	    PrintDoubleLinkedList(pHeadOfList);
	}

//	            10
//	         /      \
//	        6        14
//	       /\        /\
//	      4  8     12  16
	private static void Test1()
	{
	    BinaryTreeNode pNode10 = CreateBinaryTreeNode(10);
	    BinaryTreeNode pNode6 = CreateBinaryTreeNode(6);
	    BinaryTreeNode pNode14 = CreateBinaryTreeNode(14);
	    BinaryTreeNode pNode4 = CreateBinaryTreeNode(4);
	    BinaryTreeNode pNode8 = CreateBinaryTreeNode(8);
	    BinaryTreeNode pNode12 = CreateBinaryTreeNode(12);
	    BinaryTreeNode pNode16 = CreateBinaryTreeNode(16);

	    ConnectTreeNodes(pNode10, pNode6, pNode14);
	    ConnectTreeNodes(pNode6, pNode4, pNode8);
	    ConnectTreeNodes(pNode14, pNode12, pNode16);

	    Test("Test1", pNode10);

	}

//	               5
//	              /
//	             4
//	            /
//	           3
//	          /
//	         2
//	        /
//	       1
	private static void Test2()
	{
	    BinaryTreeNode pNode5 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode4 = CreateBinaryTreeNode(4);
	    BinaryTreeNode pNode3 = CreateBinaryTreeNode(3);
	    BinaryTreeNode pNode2 = CreateBinaryTreeNode(2);
	    BinaryTreeNode pNode1 = CreateBinaryTreeNode(1);

	    ConnectTreeNodes(pNode5, pNode4, null);
	    ConnectTreeNodes(pNode4, pNode3, null);
	    ConnectTreeNodes(pNode3, pNode2, null);
	    ConnectTreeNodes(pNode2, pNode1, null);

	    Test("Test2", pNode5);

	}

	// 1
	//  \
	//   2
//	    \
//	     3
//	      \
//	       4
//	        \
//	         5
	private static void Test3()
	{
	    BinaryTreeNode pNode1 = CreateBinaryTreeNode(1);
	    BinaryTreeNode pNode2 = CreateBinaryTreeNode(2);
	    BinaryTreeNode pNode3 = CreateBinaryTreeNode(3);
	    BinaryTreeNode pNode4 = CreateBinaryTreeNode(4);
	    BinaryTreeNode pNode5 = CreateBinaryTreeNode(5);

	    ConnectTreeNodes(pNode1, null, pNode2);
	    ConnectTreeNodes(pNode2, null, pNode3);
	    ConnectTreeNodes(pNode3, null, pNode4);
	    ConnectTreeNodes(pNode4, null, pNode5);

	    Test("Test3", pNode1);

	}

	// 树中只有1个结点
	private static void Test4()
	{
	    BinaryTreeNode pNode1 = CreateBinaryTreeNode(1);
	    Test("Test4", pNode1);

	}

	// 树中没有结点
	private static void Test5()
	{
	    Test("Test5", null);
	}
	
	public static void main(String[] args) {
		Test1();
		Test2();
		Test3();
		Test4();
		Test5();
	}
}
