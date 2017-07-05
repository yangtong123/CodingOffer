package yt.codingoffer.utils;

public class BinaryTree {
	public static BinaryTreeNode CreateBinaryTreeNode(int value) {
		BinaryTreeNode pNode = new BinaryTreeNode();
		pNode.value = value;
		pNode.left = null;
		pNode.right = null;

		return pNode;
	}

	public static void ConnectTreeNodes(BinaryTreeNode pParent, BinaryTreeNode pLeft, BinaryTreeNode pRight) {
		if (pParent != null) {
			pParent.left = pLeft;
			pParent.right = pRight;
		}
	}

	public static void PrintTreeNode(BinaryTreeNode pNode) {
		if (pNode != null) {
//			System.out.printf("value of this node is: lf\n", pNode.value);
			System.out.println("value of this node is: " + pNode.value);

			if (pNode.left != null)
				System.out.println("value of its left child is: " + pNode.left.value);
			else
				System.out.println("left child is null");

			if (pNode.right != null)
				System.out.println("value of its right child is: " + pNode.right.value);
			else
				System.out.println("right child is null");
		} else {
			System.out.println("this node is null");
		}

		// printf("\n");
		System.out.println();
	}

	public static void PrintTree(BinaryTreeNode pRoot) {
		PrintTreeNode(pRoot);

		if (pRoot != null) {
			if (pRoot.left != null)
				PrintTree(pRoot.left);

			if (pRoot.right != null)
				PrintTree(pRoot.right);
		}
	}
}
