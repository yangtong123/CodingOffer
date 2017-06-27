package yt.codingoffer;

public class N_14_CuttingRope {
	private static int maxProductAfterCutting_solution1(int length) {
		if (length < 2) {
			return 0;
		}
		if (length == 2) {
			return 1;
		}
		if (length == 3) {
			return 2;
		}
		// 动态规划的数组product[i]表示的是长度为i的绳子坚称若干段后各段长度乘积
		int[] products = new int[length + 1]; 
		products[0] = 0;
		products[1] = 1;
		products[2] = 2;
		products[3] = 3;
		
		int max = 0;
		for (int i = 4; i <= length; i++) {
			max = 0;
			for (int j = 1; j <= i/2; j++) {
				int product = products[j] * products[i-j];
				if (product > max) {
					max = product;
				}
				products[i] = max;
			}
		}
		max = products[length];
		return max;
	}
	
	// 贪婪算法
	private static int maxProductAfterCutting_solution2(int length) {
		if (length < 2) {
			return 0;
		}
		if (length == 2) {
			return 1;
		}
		if (length == 3) {
			return 2;
		}
		// 尽可能剪长度为3的绳子
		int timesOf3 = length / 3;
		// 当剩下绳子长度为4时，不能再去剪长度为3的绳子段
		// 应该剪为2的两段，因为 2*2 > 3*1
		if (length - timesOf3 * 3 == 1) {
			timesOf3 -= 1;
		}
		int timesOf2 = (length - timesOf3 * 3) / 2;
		
		return (int) Math.pow(3, timesOf3) * (int) Math.pow(2, timesOf2);
	}
	
	// ====================测试代码====================
	private static void test(String testName, int length, int expected)
	{
	    int result1 = maxProductAfterCutting_solution1(length);
	    if(result1 == expected)
//	        std::cout << "Solution1 for " << testName << " passed." << std::endl;
	    	System.out.println("Solution1 for " + testName + " passed.");
	    else
//	        std::cout << "Solution1 for " << testName << " FAILED." << std::endl;
	    	System.out.println("Solution1 for " + testName + " FAILED.");

	    int result2 = maxProductAfterCutting_solution2(length);
	    if(result2 == expected)
//	        std::cout << "Solution2 for " << testName << " passed." << std::endl;
	    	System.out.println("Solution2 for " + testName + " passed.");
	    else
//	        std::cout << "Solution2 for " << testName << " FAILED." << std::endl;
	    	System.out.println("Solution2 for " + testName + " FAILED.");
	}

	private static void test1()
	{
	    int length = 1;
	    int expected = 0;
	    test("test1", length, expected);
	}

	private static void test2()
	{
	    int length = 2;
	    int expected = 1;
	    test("test2", length, expected);
	}

	private static void test3()
	{
	    int length = 3;
	    int expected = 2;
	    test("test3", length, expected);
	}

	private static void test4()
	{
	    int length = 4;
	    int expected = 4;
	    test("test4", length, expected);
	}

	private static void test5()
	{
	    int length = 5;
	    int expected = 6;
	    test("test5", length, expected);
	}

	private static void test6()
	{
	    int length = 6;
	    int expected = 9;
	    test("test6", length, expected);
	}

	private static void test7()
	{
	    int length = 7;
	    int expected = 12;
	    test("test7", length, expected);
	}

	private static void test8()
	{
	    int length = 8;
	    int expected = 18;
	    test("test8", length, expected);
	}

	private static void test9()
	{
	    int length = 9;
	    int expected = 27;
	    test("test9", length, expected);
	}

	private static void test10()
	{
	    int length = 10;
	    int expected = 36;
	    test("test10", length, expected);
	}

	private static void test11()
	{
	    int length = 50;
	    int expected = 86093442;
	    test("test11", length, expected);
	}
	
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
		test7();
		test8();
		test9();
		test10();
		test11();
	}
}
