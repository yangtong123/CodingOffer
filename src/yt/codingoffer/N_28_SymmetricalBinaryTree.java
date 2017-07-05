package yt.codingoffer;

import yt.codingoffer.utils.BinaryTreeNode;
import static yt.codingoffer.utils.BinaryTree.*;

public class N_28_SymmetricalBinaryTree {
	private static boolean isSymmetrical(BinaryTreeNode root) {
		return isSymmetrical(root, root);
	}
	
	private static boolean isSymmetrical(BinaryTreeNode root1, BinaryTreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}
		if (!equal(root1.value, root2.value)) {
			return false;
		}
		
		return isSymmetrical(root1.left, root2.right)
				&& isSymmetrical(root1.right, root2.left);
	}
	
	private static boolean equal(double value1, double value2) {
		if ((value1 - value2 < 0.0000001) && (value1 - value2 > -0.0000001)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	// ====================测试代码====================
	void Test(String testName, BinaryTreeNode pRoot, boolean expected)
	{
	    if(testName != null)
	        System.out.printf("%s begins: ", testName);

	    if(isSymmetrical(pRoot) == expected)
	        System.out.printf("Passed.\n");
	    else
	        System.out.printf("FAILED.\n");
	}

//	            8
//	        6      6
//	       5 7    7 5
	void Test1()
	{
	    BinaryTreeNode pNode8 = CreateBinaryTreeNode(8);
	    BinaryTreeNode pNode61 = CreateBinaryTreeNode(6);
	    BinaryTreeNode pNode62 = CreateBinaryTreeNode(6);
	    BinaryTreeNode pNode51 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode71 = CreateBinaryTreeNode(7);
	    BinaryTreeNode pNode72 = CreateBinaryTreeNode(7);
	    BinaryTreeNode pNode52 = CreateBinaryTreeNode(5);

	    ConnectTreeNodes(pNode8, pNode61, pNode62);
	    ConnectTreeNodes(pNode61, pNode51, pNode71);
	    ConnectTreeNodes(pNode62, pNode72, pNode52);

	    Test("Test1", pNode8, true);

	}

//	            8
//	        6      9
//	       5 7    7 5
	void Test2()
	{
	    BinaryTreeNode pNode8 = CreateBinaryTreeNode(8);
	    BinaryTreeNode pNode61 = CreateBinaryTreeNode(6);
	    BinaryTreeNode pNode9 = CreateBinaryTreeNode(9);
	    BinaryTreeNode pNode51 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode71 = CreateBinaryTreeNode(7);
	    BinaryTreeNode pNode72 = CreateBinaryTreeNode(7);
	    BinaryTreeNode pNode52 = CreateBinaryTreeNode(5);

	    ConnectTreeNodes(pNode8, pNode61, pNode9);
	    ConnectTreeNodes(pNode61, pNode51, pNode71);
	    ConnectTreeNodes(pNode9, pNode72, pNode52);

	    Test("Test2", pNode8, false);

	}

//	            8
//	        6      6
//	       5 7    7
	void Test3()
	{
	    BinaryTreeNode pNode8 = CreateBinaryTreeNode(8);
	    BinaryTreeNode pNode61 = CreateBinaryTreeNode(6);
	    BinaryTreeNode pNode62 = CreateBinaryTreeNode(6);
	    BinaryTreeNode pNode51 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode71 = CreateBinaryTreeNode(7);
	    BinaryTreeNode pNode72 = CreateBinaryTreeNode(7);

	    ConnectTreeNodes(pNode8, pNode61, pNode62);
	    ConnectTreeNodes(pNode61, pNode51, pNode71);
	    ConnectTreeNodes(pNode62, pNode72, null);

	    Test("Test3", pNode8, false);

	}

//	               5
//	              / \
//	             3   3
//	            /     \
//	           4       4
//	          /         \
//	         2           2
//	        /             \
//	       1               1
	void Test4()
	{
	    BinaryTreeNode pNode5 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode31 = CreateBinaryTreeNode(3);
	    BinaryTreeNode pNode32 = CreateBinaryTreeNode(3);
	    BinaryTreeNode pNode41 = CreateBinaryTreeNode(4);
	    BinaryTreeNode pNode42 = CreateBinaryTreeNode(4);
	    BinaryTreeNode pNode21 = CreateBinaryTreeNode(2);
	    BinaryTreeNode pNode22 = CreateBinaryTreeNode(2);
	    BinaryTreeNode pNode11 = CreateBinaryTreeNode(1);
	    BinaryTreeNode pNode12 = CreateBinaryTreeNode(1);

	    ConnectTreeNodes(pNode5, pNode31, pNode32);
	    ConnectTreeNodes(pNode31, pNode41, null);
	    ConnectTreeNodes(pNode32, null, pNode42);
	    ConnectTreeNodes(pNode41, pNode21, null);
	    ConnectTreeNodes(pNode42, null, pNode22);
	    ConnectTreeNodes(pNode21, pNode11, null);
	    ConnectTreeNodes(pNode22, null, pNode12);

	    Test("Test4", pNode5, true);

	}


//	               5
//	              / \
//	             3   3
//	            /     \
//	           4       4
//	          /         \
//	         6           2
//	        /             \
//	       1               1
	void Test5()
	{
	    BinaryTreeNode pNode5 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode31 = CreateBinaryTreeNode(3);
	    BinaryTreeNode pNode32 = CreateBinaryTreeNode(3);
	    BinaryTreeNode pNode41 = CreateBinaryTreeNode(4);
	    BinaryTreeNode pNode42 = CreateBinaryTreeNode(4);
	    BinaryTreeNode pNode6 = CreateBinaryTreeNode(6);
	    BinaryTreeNode pNode22 = CreateBinaryTreeNode(2);
	    BinaryTreeNode pNode11 = CreateBinaryTreeNode(1);
	    BinaryTreeNode pNode12 = CreateBinaryTreeNode(1);

	    ConnectTreeNodes(pNode5, pNode31, pNode32);
	    ConnectTreeNodes(pNode31, pNode41, null);
	    ConnectTreeNodes(pNode32, null, pNode42);
	    ConnectTreeNodes(pNode41, pNode6, null);
	    ConnectTreeNodes(pNode42, null, pNode22);
	    ConnectTreeNodes(pNode6, pNode11, null);
	    ConnectTreeNodes(pNode22, null, pNode12);

	    Test("Test5", pNode5, false);

	}

//	               5
//	              / \
//	             3   3
//	            /     \
//	           4       4
//	          /         \
//	         2           2
//	                      \
//	                       1
	void Test6()
	{
	    BinaryTreeNode pNode5 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode31 = CreateBinaryTreeNode(3);
	    BinaryTreeNode pNode32 = CreateBinaryTreeNode(3);
	    BinaryTreeNode pNode41 = CreateBinaryTreeNode(4);
	    BinaryTreeNode pNode42 = CreateBinaryTreeNode(4);
	    BinaryTreeNode pNode21 = CreateBinaryTreeNode(2);
	    BinaryTreeNode pNode22 = CreateBinaryTreeNode(2);
	    BinaryTreeNode pNode12 = CreateBinaryTreeNode(1);

	    ConnectTreeNodes(pNode5, pNode31, pNode32);
	    ConnectTreeNodes(pNode31, pNode41, null);
	    ConnectTreeNodes(pNode32, null, pNode42);
	    ConnectTreeNodes(pNode41, pNode21, null);
	    ConnectTreeNodes(pNode42, null, pNode22);
	    ConnectTreeNodes(pNode21, null, null);
	    ConnectTreeNodes(pNode22, null, pNode12);

	    Test("Test6", pNode5, false);

	}

	// 只有一个结点
	void Test7()
	{
	    BinaryTreeNode pNode1 = CreateBinaryTreeNode(1);
	    Test("Test7", pNode1, true);

	}

	// 没有结点
	void Test8()
	{
	    Test("Test8", null, true);
	}

	// 所有结点都有相同的值，树对称
//	               5
//	              / \
//	             5   5
//	            /     \
//	           5       5
//	          /         \
//	         5           5
	void Test9()
	{
	    BinaryTreeNode pNode1 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode21 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode22 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode31 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode32 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode41 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode42 = CreateBinaryTreeNode(5);

	    ConnectTreeNodes(pNode1, pNode21, pNode22);
	    ConnectTreeNodes(pNode21, pNode31, null);
	    ConnectTreeNodes(pNode22, null, pNode32);
	    ConnectTreeNodes(pNode31, pNode41, null);
	    ConnectTreeNodes(pNode32, null, pNode42);
	    ConnectTreeNodes(pNode41, null, null);
	    ConnectTreeNodes(pNode42, null, null);

	    Test("Test9", pNode1, true);

	}

	// 所有结点都有相同的值，树不对称
//	               5
//	              / \
//	             5   5
//	            /     \
//	           5       5
//	          /       /
//	         5       5
	void Test10()
	{
	    BinaryTreeNode pNode1 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode21 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode22 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode31 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode32 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode41 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode42 = CreateBinaryTreeNode(5);

	    ConnectTreeNodes(pNode1, pNode21, pNode22);
	    ConnectTreeNodes(pNode21, pNode31, null);
	    ConnectTreeNodes(pNode22, null, pNode32);
	    ConnectTreeNodes(pNode31, pNode41, null);
	    ConnectTreeNodes(pNode32, pNode42, null);
	    ConnectTreeNodes(pNode41, null, null);
	    ConnectTreeNodes(pNode42, null, null);

	    Test("Test10", pNode1, false);

	}
	
	public static void main(String[] args) {
		N_28_SymmetricalBinaryTree test = new N_28_SymmetricalBinaryTree();
		test.Test1();
		test.Test2();
		test.Test3();
		test.Test4();
		test.Test5();
		test.Test6();
		test.Test7();
		test.Test8();
		test.Test9();
		test.Test10();
	}
}
