package yt.codingoffer;

import yt.codingoffer.utils.BinaryTreeNode;

public class N_26_SubstructureInTree {
	
	private static boolean hasSubTree(BinaryTreeNode root1, BinaryTreeNode root2) {
		boolean result = false;
		
		if (root1 != null && root2 != null) {
			if (equal(root1.value, root2.value)) {
				result = doesTree1HasTree2(root1, root2);
			} 
			if (!result) {
				result = hasSubTree(root1.left, root2);
			}
			if (!result) {
				result = hasSubTree(root1.right, root2);
			}
		}
		
		return result;
	}
	
	private static boolean doesTree1HasTree2(BinaryTreeNode root1, BinaryTreeNode root2) {
		if (root2 == null) {
			return true;
		}
		
		if (root1 == null) {
			return false;
		}
		
		if (!equal(root1.value, root2.value)) {
			return false;
		}
		
		return doesTree1HasTree2(root1.left, root2.left) && doesTree1HasTree2(root1.right, root2.right);
	}
	
	private static boolean equal(double value1, double value2) {
		if ((value1 - value2 < 0.0000001) && (value1 - value2 > -0.0000001)) {
			return true;
		} else {
			return false;
		}
	}
	
	// ====================辅助测试代码====================
	private static BinaryTreeNode CreateBinaryTreeNode(double dbValue)
	{
	    BinaryTreeNode pNode = new BinaryTreeNode();
	    pNode.value = dbValue;
	    pNode.left = null;
	    pNode.right = null;

	    return pNode;
	}

	private static void ConnectTreeNodes(BinaryTreeNode pParent, BinaryTreeNode pLeft, BinaryTreeNode pRight)
	{
	    if(pParent != null)
	    {
	        pParent.left = pLeft;
	        pParent.right = pRight;
	    }
	}



	// ====================测试代码====================
	private static void Test(String testName, BinaryTreeNode pRoot1, BinaryTreeNode pRoot2, boolean expected)
	{
	    if(hasSubTree(pRoot1, pRoot2) == expected)
	        System.out.printf("%s passed.\n", testName);
	    else
	        System.out.printf("%s failed.\n", testName);
	}

	// 树中结点含有分叉，树B是树A的子结构
//	                  8                8
//	              /       \           / \
//	             8         7         9   2
//	           /   \
//	          9     2
//	               / \
//	              4   7
	private static void Test1()
	{
	    BinaryTreeNode pNodeA1 = CreateBinaryTreeNode(8);
	    BinaryTreeNode pNodeA2 = CreateBinaryTreeNode(8);
	    BinaryTreeNode pNodeA3 = CreateBinaryTreeNode(7);
	    BinaryTreeNode pNodeA4 = CreateBinaryTreeNode(9);
	    BinaryTreeNode pNodeA5 = CreateBinaryTreeNode(2);
	    BinaryTreeNode pNodeA6 = CreateBinaryTreeNode(4);
	    BinaryTreeNode pNodeA7 = CreateBinaryTreeNode(7);

	    ConnectTreeNodes(pNodeA1, pNodeA2, pNodeA3);
	    ConnectTreeNodes(pNodeA2, pNodeA4, pNodeA5);
	    ConnectTreeNodes(pNodeA5, pNodeA6, pNodeA7);

	    BinaryTreeNode pNodeB1 = CreateBinaryTreeNode(8);
	    BinaryTreeNode pNodeB2 = CreateBinaryTreeNode(9);
	    BinaryTreeNode pNodeB3 = CreateBinaryTreeNode(2);

	    ConnectTreeNodes(pNodeB1, pNodeB2, pNodeB3);

	    Test("Test1", pNodeA1, pNodeB1, true);

	}

	// 树中结点含有分叉，树B不是树A的子结构
//	                  8                8
//	              /       \           / \
//	             8         7         9   2
//	           /   \
//	          9     3
//	               / \
//	              4   7
	private static void Test2()
	{
	    BinaryTreeNode pNodeA1 = CreateBinaryTreeNode(8);
	    BinaryTreeNode pNodeA2 = CreateBinaryTreeNode(8);
	    BinaryTreeNode pNodeA3 = CreateBinaryTreeNode(7);
	    BinaryTreeNode pNodeA4 = CreateBinaryTreeNode(9);
	    BinaryTreeNode pNodeA5 = CreateBinaryTreeNode(3);
	    BinaryTreeNode pNodeA6 = CreateBinaryTreeNode(4);
	    BinaryTreeNode pNodeA7 = CreateBinaryTreeNode(7);

	    ConnectTreeNodes(pNodeA1, pNodeA2, pNodeA3);
	    ConnectTreeNodes(pNodeA2, pNodeA4, pNodeA5);
	    ConnectTreeNodes(pNodeA5, pNodeA6, pNodeA7);

	    BinaryTreeNode pNodeB1 = CreateBinaryTreeNode(8);
	    BinaryTreeNode pNodeB2 = CreateBinaryTreeNode(9);
	    BinaryTreeNode pNodeB3 = CreateBinaryTreeNode(2);

	    ConnectTreeNodes(pNodeB1, pNodeB2, pNodeB3);

	    Test("Test2", pNodeA1, pNodeB1, false);

	}

	// 树中结点只有左子结点，树B是树A的子结构
//	                8                  8
//	              /                   / 
//	             8                   9   
//	           /                    /
//	          9                    2
//	         /      
//	        2        
//	       /
//	      5
	private static void Test3()
	{
	    BinaryTreeNode pNodeA1 = CreateBinaryTreeNode(8);
	    BinaryTreeNode pNodeA2 = CreateBinaryTreeNode(8);
	    BinaryTreeNode pNodeA3 = CreateBinaryTreeNode(9);
	    BinaryTreeNode pNodeA4 = CreateBinaryTreeNode(2);
	    BinaryTreeNode pNodeA5 = CreateBinaryTreeNode(5);

	    ConnectTreeNodes(pNodeA1, pNodeA2, null);
	    ConnectTreeNodes(pNodeA2, pNodeA3, null);
	    ConnectTreeNodes(pNodeA3, pNodeA4, null);
	    ConnectTreeNodes(pNodeA4, pNodeA5, null);

	    BinaryTreeNode pNodeB1 = CreateBinaryTreeNode(8);
	    BinaryTreeNode pNodeB2 = CreateBinaryTreeNode(9);
	    BinaryTreeNode pNodeB3 = CreateBinaryTreeNode(2);

	    ConnectTreeNodes(pNodeB1, pNodeB2, null);
	    ConnectTreeNodes(pNodeB2, pNodeB3, null);

	    Test("Test3", pNodeA1, pNodeB1, true);

	}

	// 树中结点只有左子结点，树B不是树A的子结构
//	                8                  8
//	              /                   / 
//	             8                   9   
//	           /                    /
//	          9                    3
//	         /      
//	        2        
//	       /
//	      5
	private static void Test4()
	{
	    BinaryTreeNode pNodeA1 = CreateBinaryTreeNode(8);
	    BinaryTreeNode pNodeA2 = CreateBinaryTreeNode(8);
	    BinaryTreeNode pNodeA3 = CreateBinaryTreeNode(9);
	    BinaryTreeNode pNodeA4 = CreateBinaryTreeNode(2);
	    BinaryTreeNode pNodeA5 = CreateBinaryTreeNode(5);

	    ConnectTreeNodes(pNodeA1, pNodeA2, null);
	    ConnectTreeNodes(pNodeA2, pNodeA3, null);
	    ConnectTreeNodes(pNodeA3, pNodeA4, null);
	    ConnectTreeNodes(pNodeA4, pNodeA5, null);

	    BinaryTreeNode pNodeB1 = CreateBinaryTreeNode(8);
	    BinaryTreeNode pNodeB2 = CreateBinaryTreeNode(9);
	    BinaryTreeNode pNodeB3 = CreateBinaryTreeNode(3);

	    ConnectTreeNodes(pNodeB1, pNodeB2, null);
	    ConnectTreeNodes(pNodeB2, pNodeB3, null);

	    Test("Test4", pNodeA1, pNodeB1, false);

	}

	// 树中结点只有右子结点，树B是树A的子结构
//	       8                   8
//	        \                   \ 
//	         8                   9   
//	          \                   \
//	           9                   2
//	            \      
//	             2        
//	              \
//	               5
	private static void Test5()
	{
	    BinaryTreeNode pNodeA1 = CreateBinaryTreeNode(8);
	    BinaryTreeNode pNodeA2 = CreateBinaryTreeNode(8);
	    BinaryTreeNode pNodeA3 = CreateBinaryTreeNode(9);
	    BinaryTreeNode pNodeA4 = CreateBinaryTreeNode(2);
	    BinaryTreeNode pNodeA5 = CreateBinaryTreeNode(5);

	    ConnectTreeNodes(pNodeA1, null, pNodeA2);
	    ConnectTreeNodes(pNodeA2, null, pNodeA3);
	    ConnectTreeNodes(pNodeA3, null, pNodeA4);
	    ConnectTreeNodes(pNodeA4, null, pNodeA5);

	    BinaryTreeNode pNodeB1 = CreateBinaryTreeNode(8);
	    BinaryTreeNode pNodeB2 = CreateBinaryTreeNode(9);
	    BinaryTreeNode pNodeB3 = CreateBinaryTreeNode(2);

	    ConnectTreeNodes(pNodeB1, null, pNodeB2);
	    ConnectTreeNodes(pNodeB2, null, pNodeB3);

	    Test("Test5", pNodeA1, pNodeB1, true);

	}

	// 树A中结点只有右子结点，树B不是树A的子结构
//	       8                   8
//	        \                   \ 
//	         8                   9   
//	          \                 / \
//	           9               3   2
//	            \      
//	             2        
//	              \
//	               5
	private static void Test6()
	{
	    BinaryTreeNode pNodeA1 = CreateBinaryTreeNode(8);
	    BinaryTreeNode pNodeA2 = CreateBinaryTreeNode(8);
	    BinaryTreeNode pNodeA3 = CreateBinaryTreeNode(9);
	    BinaryTreeNode pNodeA4 = CreateBinaryTreeNode(2);
	    BinaryTreeNode pNodeA5 = CreateBinaryTreeNode(5);

	    ConnectTreeNodes(pNodeA1, null, pNodeA2);
	    ConnectTreeNodes(pNodeA2, null, pNodeA3);
	    ConnectTreeNodes(pNodeA3, null, pNodeA4);
	    ConnectTreeNodes(pNodeA4, null, pNodeA5);

	    BinaryTreeNode pNodeB1 = CreateBinaryTreeNode(8);
	    BinaryTreeNode pNodeB2 = CreateBinaryTreeNode(9);
	    BinaryTreeNode pNodeB3 = CreateBinaryTreeNode(3);
	    BinaryTreeNode pNodeB4 = CreateBinaryTreeNode(2);

	    ConnectTreeNodes(pNodeB1, null, pNodeB2);
	    ConnectTreeNodes(pNodeB2, pNodeB3, pNodeB4);

	    Test("Test6", pNodeA1, pNodeB1, false);

	}

	// 树A为空树
	private static void Test7()
	{
	    BinaryTreeNode pNodeB1 = CreateBinaryTreeNode(8);
	    BinaryTreeNode pNodeB2 = CreateBinaryTreeNode(9);
	    BinaryTreeNode pNodeB3 = CreateBinaryTreeNode(3);
	    BinaryTreeNode pNodeB4 = CreateBinaryTreeNode(2);

	    ConnectTreeNodes(pNodeB1, null, pNodeB2);
	    ConnectTreeNodes(pNodeB2, pNodeB3, pNodeB4);

	    Test("Test7", null, pNodeB1, false);

	}

	// 树B为空树
	private static void Test8()
	{
	    BinaryTreeNode pNodeA1 = CreateBinaryTreeNode(8);
	    BinaryTreeNode pNodeA2 = CreateBinaryTreeNode(9);
	    BinaryTreeNode pNodeA3 = CreateBinaryTreeNode(3);
	    BinaryTreeNode pNodeA4 = CreateBinaryTreeNode(2);

	    ConnectTreeNodes(pNodeA1, null, pNodeA2);
	    ConnectTreeNodes(pNodeA2, pNodeA3, pNodeA4);

	    Test("Test8", pNodeA1, null, false);

	}

	// 树A和树B都为空
	private static void Test9()
	{
	    Test("Test9", null, null, false);
	}
	
	public static void main(String[] args) {
		Test1();
		Test2();
		Test3();
		Test4();
		Test5();
		Test6();
		Test7();
		Test8();
		Test9();
	}
}
