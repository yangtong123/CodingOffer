package yt.codingoffer.utils;

public class BinaryTree {
	public static BinaryTreeNode createBinaryTreeNode(int value) {
		BinaryTreeNode pNode = new BinaryTreeNode();
		pNode.value = value;
		pNode.left = null;
		pNode.right = null;

		return pNode;
	}

	public static void connectTreeNodes(BinaryTreeNode pParent, BinaryTreeNode pLeft, BinaryTreeNode pRight) {
		if (pParent != null) {
			pParent.left = pLeft;
			pParent.right = pRight;
		}
	}

	public static void printTreeNode(BinaryTreeNode pNode) {
		if (pNode != null) {
			System.out.printf("value of this node is: %d\n", pNode.value);

			if (pNode.left != null)
				System.out.printf("value of its left child is: %d.\n", pNode.left.value);
			else
				System.out.printf("left child is nullptr.\n");

			if (pNode.right != null)
				System.out.printf("value of its right child is: %d.\n", pNode.right.value);
			else
				System.out.printf("right child is nullptr.\n");
		} else {
			System.out.printf("this node is nullptr.\n");
		}

		// printf("\n");
		System.out.println();
	}

	public static void printTree(BinaryTreeNode pRoot) {
		printTreeNode(pRoot);

		if (pRoot != null) {
			if (pRoot.left != null)
				printTree(pRoot.left);

			if (pRoot.right != null)
				printTree(pRoot.right);
		}
	}
}
