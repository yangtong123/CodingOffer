package yt.codingoffer;

import java.util.Deque;
import java.util.LinkedList;

import yt.codingoffer.utils.BinaryTreeNode;
import static yt.codingoffer.utils.BinaryTree.*;

public class N_32_01_PrintTreeFromTopToBottom {
	private static void printFromTopToBottom(BinaryTreeNode root) {
		if (root == null) {
			return;
		}
		
		Deque<BinaryTreeNode> deque = new LinkedList<BinaryTreeNode>();
		
		deque.push(root);
		
		while (!deque.isEmpty()) {
			BinaryTreeNode node = deque.poll();
			System.out.print(node.value + " ");
			if (node.left != null) {
//				deque.push(node.left);
				deque.add(node.left);
			}
			if (node.right != null) {
//				deque.push(node.right);
				deque.add(node.right);
			}
		}
	}
	
	// ====================测试代码====================
	private static void Test(String testName, BinaryTreeNode pRoot)
	{
	    if(testName != null)
	        System.out.printf("%s begins: \n", testName);

	    PrintTree(pRoot);

	    System.out.printf("The nodes from top to bottom, from left to right are: \n");
	    printFromTopToBottom(pRoot);

	    System.out.println();
	    System.out.println();
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
