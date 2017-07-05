package yt.codingoffer;

import static yt.codingoffer.utils.BinaryTree.ConnectTreeNodes;
import static yt.codingoffer.utils.BinaryTree.CreateBinaryTreeNode;
import static yt.codingoffer.utils.BinaryTree.PrintTree;

import java.util.Stack;

import yt.codingoffer.utils.BinaryTreeNode;

public class N_27_MirrorOfBinaryTree {
	private static void mirrorRecursively(BinaryTreeNode pNode) {
		if(pNode == null) {
			return;
		}
		if (pNode.left == null && pNode.right == null) {
			return;
		}
		
		BinaryTreeNode temp = pNode.left;
		pNode.left = pNode.right;
		pNode.right = temp;
		
		if (pNode.left != null) {
			mirrorRecursively(pNode.left);
		}
		
		if (pNode.right != null) {
			mirrorRecursively(pNode.right);
		}
	}
	
	private static void mirrorIteratively(BinaryTreeNode pRoot) {
		if (pRoot == null) {
			return;
		}
		
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		
		stack.push(pRoot);
		while (stack.size() > 0) {
			BinaryTreeNode pNode = stack.pop();
			
			BinaryTreeNode temp = pNode.left;
			pNode.left = pNode.right;
			pNode.right = temp;
			
			if (pNode.left != null) {
				stack.push(pNode.left);
			}
			if (pNode.right != null) {
				stack.push(pNode.right);
			}
		}
	}
	
	
	// ====================测试代码====================
	// 测试完全二叉树：除了叶子节点，其他节点都有两个子节点
//	            8
//	        6      10
//	       5 7    9  11
	void Test1()
	{
	    System.out.printf("=====Test1 starts:=====\n");
	    BinaryTreeNode pNode8 = CreateBinaryTreeNode(8);
	    BinaryTreeNode pNode6 = CreateBinaryTreeNode(6);
	    BinaryTreeNode pNode10 = CreateBinaryTreeNode(10);
	    BinaryTreeNode pNode5 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode7 = CreateBinaryTreeNode(7);
	    BinaryTreeNode pNode9 = CreateBinaryTreeNode(9);
	    BinaryTreeNode pNode11 = CreateBinaryTreeNode(11);

	    ConnectTreeNodes(pNode8, pNode6, pNode10);
	    ConnectTreeNodes(pNode6, pNode5, pNode7);
	    ConnectTreeNodes(pNode10, pNode9, pNode11);

	    PrintTree(pNode8);

	    System.out.printf("=====Test1: mirrorRecursively=====\n");
	    mirrorRecursively(pNode8);
	    PrintTree(pNode8);

	    System.out.printf("=====Test1: mirrorIteratively=====\n");
	    mirrorIteratively(pNode8);
	    PrintTree(pNode8);

	}

	// 测试二叉树：出叶子结点之外，左右的结点都有且只有一个左子结点
//	            8
//	          7   
//	        6 
//	      5
//	    4
	void Test2()
	{
		System.out.printf("=====Test2 starts:=====\n");
	    BinaryTreeNode pNode8 = CreateBinaryTreeNode(8);
	    BinaryTreeNode pNode7 = CreateBinaryTreeNode(7);
	    BinaryTreeNode pNode6 = CreateBinaryTreeNode(6);
	    BinaryTreeNode pNode5 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode4 = CreateBinaryTreeNode(4);

	    ConnectTreeNodes(pNode8, pNode7, null);
	    ConnectTreeNodes(pNode7, pNode6, null);
	    ConnectTreeNodes(pNode6, pNode5, null);
	    ConnectTreeNodes(pNode5, pNode4, null);

	    PrintTree(pNode8);

	    System.out.printf("=====Test2: mirrorRecursively=====\n");
	    mirrorRecursively(pNode8);
	    PrintTree(pNode8);

	    System.out.printf("=====Test2: mirrorIteratively=====\n");
	    mirrorIteratively(pNode8);
	    PrintTree(pNode8);

	}

	// 测试二叉树：出叶子结点之外，左右的结点都有且只有一个右子结点
//	            8
//	             7   
//	              6 
//	               5
//	                4
	void Test3()
	{
		System.out.printf("=====Test3 starts:=====\n");
	    BinaryTreeNode pNode8 = CreateBinaryTreeNode(8);
	    BinaryTreeNode pNode7 = CreateBinaryTreeNode(7);
	    BinaryTreeNode pNode6 = CreateBinaryTreeNode(6);
	    BinaryTreeNode pNode5 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode4 = CreateBinaryTreeNode(4);

	    ConnectTreeNodes(pNode8, null, pNode7);
	    ConnectTreeNodes(pNode7, null, pNode6);
	    ConnectTreeNodes(pNode6, null, pNode5);
	    ConnectTreeNodes(pNode5, null, pNode4);

	    PrintTree(pNode8);

	    System.out.printf("=====Test3: mirrorRecursively=====\n");
	    mirrorRecursively(pNode8);
	    PrintTree(pNode8);

	    System.out.printf("=====Test3: mirrorIteratively=====\n");
	    mirrorIteratively(pNode8);
	    PrintTree(pNode8);

	}

	// 测试空二叉树：根结点为空指针
	void Test4()
	{
	    System.out.printf("=====Test4 starts:=====\n");
	    BinaryTreeNode pNode = null;

	    PrintTree(pNode);

	    System.out.printf("=====Test4: mirrorRecursively=====\n");
	    mirrorRecursively(pNode);
	    PrintTree(pNode);

	    System.out.printf("=====Test4: mirrorIteratively=====\n");
	    mirrorIteratively(pNode);
	    PrintTree(pNode);
	}

	// 测试只有一个结点的二叉树
	void Test5()
	{
	    System.out.printf("=====Test5 starts:=====\n");
	    BinaryTreeNode pNode8 = CreateBinaryTreeNode(8);

	    PrintTree(pNode8);

	    System.out.printf("=====Test4: mirrorRecursively=====\n");
	    mirrorRecursively(pNode8);
	    PrintTree(pNode8);

	    System.out.printf("=====Test4: mirrorIteratively=====\n");
	    mirrorIteratively(pNode8);
	    PrintTree(pNode8);
	}

	public static void main(String[] args) {
		N_27_MirrorOfBinaryTree test = new N_27_MirrorOfBinaryTree();
		test.Test1();
		test.Test2();
		test.Test3();
		test.Test4();
		test.Test5();
	}
}
