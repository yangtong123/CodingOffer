package yt.codingoffer;

import java.util.Deque;
import java.util.LinkedList;

import yt.codingoffer.utils.BinaryTreeNode;
import static yt.codingoffer.utils.BinaryTree.*;

public class N_32_02_PrintTreesInLines {
	private static void print(BinaryTreeNode root) {
		if (root == null) {
			return ;
		}
		
		Deque<BinaryTreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int toBePrint = 1;
		int nextLine = 0;
		while (!queue.isEmpty()) {
			BinaryTreeNode node = queue.pop();
			System.out.print(node.value + " ");
			if (node.left != null) {
				queue.offer(node.left);
				nextLine++;
			}
			if (node.right != null) {
				queue.offer(node.right);
				nextLine++;
			}
			toBePrint--;
			if (toBePrint == 0) {
				System.out.println();
				toBePrint = nextLine;
				nextLine = 0;
			}
		}
	}

	// ====================测试代码====================
	// 8
	// 6 10
	// 5 7 9 11
	private static void Test1() {
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

		System.out.printf("====Test1 Begins: ====\n");
		System.out.printf("Expected Result is:\n");
		System.out.printf("8 \n");
		System.out.printf("6 10 \n");
		System.out.printf("5 7 9 11 \n\n");

		System.out.printf("Actual Result is: \n");
		print(pNode8);
		System.out.printf("\n");

	}

	// 5
	// 4
	// 3
	// 2
	private static void Test2() {
		BinaryTreeNode pNode5 = CreateBinaryTreeNode(5);
		BinaryTreeNode pNode4 = CreateBinaryTreeNode(4);
		BinaryTreeNode pNode3 = CreateBinaryTreeNode(3);
		BinaryTreeNode pNode2 = CreateBinaryTreeNode(2);

		ConnectTreeNodes(pNode5, pNode4, null);
		ConnectTreeNodes(pNode4, pNode3, null);
		ConnectTreeNodes(pNode3, pNode2, null);

		System.out.printf("====Test2 Begins: ====\n");
		System.out.printf("Expected Result is:\n");
		System.out.printf("5 \n");
		System.out.printf("4 \n");
		System.out.printf("3 \n");
		System.out.printf("2 \n\n");

		System.out.printf("Actual Result is: \n");
		print(pNode5);
		System.out.printf("\n");

	}

	// 5
	// 4
	// 3
	// 2
	private static void Test3() {
		BinaryTreeNode pNode5 = CreateBinaryTreeNode(5);
		BinaryTreeNode pNode4 = CreateBinaryTreeNode(4);
		BinaryTreeNode pNode3 = CreateBinaryTreeNode(3);
		BinaryTreeNode pNode2 = CreateBinaryTreeNode(2);

		ConnectTreeNodes(pNode5, null, pNode4);
		ConnectTreeNodes(pNode4, null, pNode3);
		ConnectTreeNodes(pNode3, null, pNode2);

		System.out.printf("====Test3 Begins: ====\n");
		System.out.printf("Expected Result is:\n");
		System.out.printf("5 \n");
		System.out.printf("4 \n");
		System.out.printf("3 \n");
		System.out.printf("2 \n\n");

		System.out.printf("Actual Result is: \n");
		print(pNode5);
		System.out.printf("\n");

	}

	private static void Test4() {
		BinaryTreeNode pNode5 = CreateBinaryTreeNode(5);

		System.out.printf("====Test4 Begins: ====\n");
		System.out.printf("Expected Result is:\n");
		System.out.printf("5 \n\n");

		System.out.printf("Actual Result is: \n");
		print(pNode5);
		System.out.printf("\n");

	}

	private static void Test5() {
		System.out.printf("====Test5 Begins: ====\n");
		System.out.printf("Expected Result is:\n");

		System.out.printf("Actual Result is: \n");
		print(null);
		System.out.printf("\n");
	}

	// 100
	///
	// 50
	// \
	// 150
	private static void Test6() {
		BinaryTreeNode pNode100 = CreateBinaryTreeNode(100);
		BinaryTreeNode pNode50 = CreateBinaryTreeNode(50);
		BinaryTreeNode pNode150 = CreateBinaryTreeNode(150);

		ConnectTreeNodes(pNode100, pNode50, null);
		ConnectTreeNodes(pNode50, null, pNode150);

		System.out.printf("====Test6 Begins: ====\n");
		System.out.printf("Expected Result is:\n");
		System.out.printf("100 \n");
		System.out.printf("50 \n");
		System.out.printf("150 \n\n");

		System.out.printf("Actual Result is: \n");
		print(pNode100);
		System.out.printf("\n");
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
