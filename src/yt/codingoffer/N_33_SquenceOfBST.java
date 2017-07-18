package yt.codingoffer;

public class N_33_SquenceOfBST {
	private static boolean verifySequenceOfBST(int[] sequence, int start, int end) {
		if (sequence == null || (end - start) <= 0) {
			return false;
		}
		
		int root = sequence[end - 1];
		
		int i = start;
		for (; i < end - 1; i++) {
			if (sequence[i] > root) {
				break;
			}
		}
		
		int j = i;
		for (; j < end - 1; j++) {
			if (sequence[j] < root) {
				return false;
			}
		}
		
		boolean left = true;
		if (i > 0) {
			left = verifySequenceOfBST(sequence, 0, i);
		}
		
		boolean right = true;
		if (j < end - 1) {
			right = verifySequenceOfBST(sequence, i, end - 1);
		}
		
		return (left && right);
	}
	
	// ====================测试代码====================
	private static void Test(String testName, int sequence[], int length, boolean expected)
	{
	    if(testName != null)
	        System.out.printf("%s begins: ", testName);

	    if(verifySequenceOfBST(sequence, 0, length) == expected)
	        System.out.printf("passed.\n");
	    else
	        System.out.printf("failed.\n");
	}

//	            10
//	         /      \
//	        6        14
//	       /\        /\
//	      4  8     12  16
	private static void Test1()
	{
	    int data[] = {4, 8, 6, 12, 16, 14, 10};
	    Test("Test1", data, data.length, true);
	}

//	           5
//	          / \
//	         4   7
//	            /
//	           6
	private static void Test2()
	{
	    int data[] = {4, 6, 7, 5};
	    Test("Test2", data, data.length, true);
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
	private static void Test3()
	{
	    int data[] = {1, 2, 3, 4, 5};
	    Test("Test3", data, data.length, true);
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
	private static void Test4()
	{
	    int data[] = {5, 4, 3, 2, 1};
	    Test("Test4", data, data.length, true);
	}

	// 树中只有1个结点
	private static void Test5()
	{
	    int data[] = {5};
	    Test("Test5", data, data.length, true);
	}

	private static void Test6()
	{
	    int data[] = {7, 4, 6, 5};
	    Test("Test6", data, data.length, false);
	}

	private static void Test7()
	{
	    int data[] = {4, 6, 12, 8, 16, 14, 10};
	    Test("Test7", data, data.length, false);
	}

	private static void Test8()
	{
	    Test("Test8", null, 0, false);
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
	}
}
