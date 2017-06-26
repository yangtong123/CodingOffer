package yt.codingoffer;

import org.junit.Test;

public class N_07_RebuildBinaryTree {
	
	static class BinaryTreeNode {
		char value;
		BinaryTreeNode left;
		BinaryTreeNode right;
	}
	
	private static BinaryTreeNode constructCore(String preOrder, String inOrder) {
		
		
		char[] preChs = preOrder.toCharArray();
		char[] inChs = inOrder.toCharArray();
		int preLength = preChs.length;
		int inLength = inChs.length;
		
		BinaryTreeNode root = new BinaryTreeNode();
		
		if (preLength == 0 && inLength == 0) {
			return root;
		}
		
		char rootValue = preChs[0];
		root.value = rootValue;
		root.left = null;
		root.right = null;
		
		// 在中序遍历中找到根节点的值
		int i = 0;
		for (; i < inLength; i++) {
			if (rootValue == inChs[i]) {
				break;
			}
		}
		
		if (i == inLength && inChs[i] != rootValue) {
			throw new RuntimeException("");
		}
		
		int leftLength = i;
		
		// 构建左子树
		if (leftLength > 0) {
			root.left = constructCore(preOrder.substring(1, leftLength+1), inOrder.substring(0, leftLength));
		}
		
		// 构建右子树
		if (leftLength < preLength) {
			root.right = constructCore(preOrder.substring(leftLength+1), inOrder.substring(leftLength+1));
		}
		
		return root;
	}
	
	public static void main(String[] args) {
		String pre = "12473568";
		String in = "47215386";
		BinaryTreeNode root = constructCore(pre, in);
		pos(root);
	}
	
	private static void pos(BinaryTreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			pos(root.left);
		}
		if (root.right != null) {
			pos(root.right);
		}
		System.out.println(root.value);
	}
	
	
}
