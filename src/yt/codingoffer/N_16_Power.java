package yt.codingoffer;

public class N_16_Power {
	static boolean g_invalidInput = false;
	
	private static double power(double base, int exponent) {
		g_invalidInput = false;
		
		if (equal(base, 0.0) && exponent < 0) {
			g_invalidInput = true;
			return 0.0;
		}
		
		double result = powerWithUnsignedExponent_2(base, Math.abs(exponent));
		
		if (exponent < 0) {
			result = 1.0 / result;
		}
		
		return result;
	}
	
	private static double powerWithUnsignedExponent(double base, int absExponent) {
		double result = 1.0;
		for (int i = 1; i <= absExponent; i++) {
			result *= base;
		}
		return result;
	}
	
	private static double powerWithUnsignedExponent_2(double base, int absExponent) {
		if (absExponent == 0) {
			return 1.0;
		}
		if (absExponent == 1) {
			return base;
		}
		
		double result = powerWithUnsignedExponent_2(base, absExponent >>> 1);
		result *= result;
		if ((absExponent & 0x1) == 1) {
			result *= base;
		}
		return result;
	}
	
	private static boolean equal(double num1, double num2) {
		if ((num1 - num2 > -0.0000001) && (num1 - num2 < 0.0000001)) {
			return true;
		}
		return false;
	}
	
	// ====================测试代码====================
	private static void Test(String testName, double base, int exponent, double expectedResult, boolean expectedFlag)
	{
	    double result = power(base, exponent);
	    if (equal(result, expectedResult) && g_invalidInput == expectedFlag)
//	        std::cout << testName << " passed" << std::endl;
	    	System.out.println(testName + " passed");
	    else
//	        std::cout << testName << " FAILED" << std::endl;
	    	System.out.println(testName + " FAILED");
	}
	
	public static void main(String[] args) {
	    // 底数、指数都为正数
	    Test("Test1", 2, 3, 8, false);

	    // 底数为负数、指数为正数
	    Test("Test2", -2, 3, -8, false);

	    // 指数为负数
	    Test("Test3", 2, -3, 0.125, false);

	    // 指数为0
	    Test("Test4", 2, 0, 1, false);

	    // 底数、指数都为0
	    Test("Test5", 0, 0, 1, false);

	    // 底数为0、指数为正数
	    Test("Test6", 0, 4, 0, false);

	    // 底数为0、指数为负数
	    Test("Test7", 0, -4, 0, true);
	}
}
