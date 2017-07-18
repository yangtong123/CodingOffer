package yt.codingoffer;

import java.util.Queue;
import java.util.Stack;

import yt.codingoffer.utils.BinaryTreeNode;
import static yt.codingoffer.utils.BinaryTree.*;

public class N_34_PathInTree {
	private static void findPath(BinaryTreeNode root, int expectedSum) {
		if (root == null) {
			return;
		}
		Stack<Integer> path = new Stack<>();
		int currentSum = 0;
		
		findPath(root, path, currentSum, expectedSum);
	}
	
	private static void findPath(BinaryTreeNode node, Stack<Integer> path, 
			int currentSum, int expectedSum) {
		currentSum += node.value;
		path.push((int) node.value);
		
		boolean isLeaf = node.left == null && node.right == null;
		
		if (currentSum == expectedSum && isLeaf) {
			System.out.print("A path is found: ");
			for (int i : path) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		
		if (node.left != null) {
			findPath(node.left, path, currentSum, expectedSum);
		}
		if (node.right != null) {
			findPath(node.right, path, currentSum, expectedSum);
		}
		
		path.pop();
	}
	
	// ====================测试代码====================
	private static void Test(String testName, BinaryTreeNode pRoot, int expectedSum)
	{
	    if(testName != null)
	        System.out.printf("%s begins:\n", testName);

	    findPath(pRoot, expectedSum);

	    System.out.printf("\n");
	}

//	            10
//	         /      \
//	        5        12
//	       /\        
//	      4  7     
	// 有两条路径上的结点和为22
	private static void Test1()
	{
	    BinaryTreeNode pNode10 = CreateBinaryTreeNode(10);
	    BinaryTreeNode pNode5 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode12 = CreateBinaryTreeNode(12);
	    BinaryTreeNode pNode4 = CreateBinaryTreeNode(4);
	    BinaryTreeNode pNode7 = CreateBinaryTreeNode(7);

	    ConnectTreeNodes(pNode10, pNode5, pNode12);
	    ConnectTreeNodes(pNode5, pNode4, pNode7);

	    System.out.printf("Two paths should be found in Test1.\n");
	    Test("Test1", pNode10, 22);

	}

//	            10
//	         /      \
//	        5        12
//	       /\        
//	      4  7     
	// 没有路径上的结点和为15
	private static void Test2()
	{
	    BinaryTreeNode pNode10 = CreateBinaryTreeNode(10);
	    BinaryTreeNode pNode5 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode12 = CreateBinaryTreeNode(12);
	    BinaryTreeNode pNode4 = CreateBinaryTreeNode(4);
	    BinaryTreeNode pNode7 = CreateBinaryTreeNode(7);

	    ConnectTreeNodes(pNode10, pNode5, pNode12);
	    ConnectTreeNodes(pNode5, pNode4, pNode7);

	    System.out.printf("No paths should be found in Test2.\n");
	    Test("Test2", pNode10, 15);

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
	// 有一条路径上面的结点和为15
	private static void Test3()
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

	    System.out.printf("One path should be found in Test3.\n");
	    Test("Test3", pNode5, 15);

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
	// 没有路径上面的结点和为16
	private static void Test4()
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

	    System.out.printf("No paths should be found in Test4.\n");
	    Test("Test4", pNode1, 16);

	}

	// 树中只有1个结点
	private static void Test5()
	{
	    BinaryTreeNode pNode1 = CreateBinaryTreeNode(1);

	    System.out.printf("One path should be found in Test5.\n");
	    Test("Test5", pNode1, 1);

	}

	// 树中没有结点
	private static void Test6()
	{
	    System.out.printf("No paths should be found in Test6.\n");
	    Test("Test6", null, 0);
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
