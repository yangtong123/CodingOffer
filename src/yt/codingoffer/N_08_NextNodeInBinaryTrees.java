package yt.codingoffer;

public class N_08_NextNodeInBinaryTrees {
	
	static class BinaryTreeNode {
		int value;
		BinaryTreeNode left;
		BinaryTreeNode right;
		BinaryTreeNode parent;
	}
	
	private static BinaryTreeNode nextNode(BinaryTreeNode node) {
		if (node == null) {
			return null;
		}
		BinaryTreeNode next = null;

		if (node.right != null) {
			while (node.left != null) {
				node = node.left;
			}
			next = node;
		} else if (node.parent != null) {
			BinaryTreeNode cur = node;
			BinaryTreeNode par = node.parent;
			while (par != null && cur == par.right) {
				cur = par;
				par = par.parent;
			}
			next = par;
		}
		
		return next;
	}
	
	public static void main(String[] args) {
		
	}
}
