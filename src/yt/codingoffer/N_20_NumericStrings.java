package yt.codingoffer;

public class N_20_NumericStrings {

	private static boolean isNumeric(String string) {
		if (string == null || string.length() <= 0) {
			return false;
		}
		char[] str = string.toCharArray();
		
		int[] numericAndIndex = scanInteger(str, 0);

		boolean numeric = numericAndIndex[0] == 1 ? true : false;
		int index = numericAndIndex[1];

		if (index == str.length) {
			return numeric;
		}

		if (str[index] == '.') {
			index++;

			numericAndIndex = scanUnsignedInteger(str, index);
			boolean numericTmp = numericAndIndex[0] == 1 ? true : false;
			index = numericAndIndex[1];
			// 下面一行代码用||的原因：
			// 1. 小数可以没有整数部分，例如.123等于0.123；
			// 2. 小数点后面可以没有数字，例如233.等于233.0；
			// 3. 当然小数点前面和后面可以有数字，例如233.666
			numeric = numericTmp || numeric;

			if (index == str.length) {
				return numeric;
			}

		}

		if (str[index] == 'e' || str[index] == 'E') {
			index++;

			if (index < str.length) {
				numericAndIndex = scanInteger(str, index);
				boolean numericTmp = numericAndIndex[0] == 1 ? true : false;
				index = numericAndIndex[1];
				// 下面一行代码用&&的原因：
				// 1. 当e或E前面没有数字时，整个字符串不能表示数字，例如.e1、e1；
				// 2. 当e或E后面没有整数时，整个字符串不能表示数字，例如12e、12e+5.4
				numeric = numericTmp && numeric;

				if (index == str.length) {
					return numeric;
				}
			} else {
				return false;
			}
		}

		return numeric && index == str.length;
	}

	private static int[] scanUnsignedInteger(char[] str, int i) {
		int tmp = i;
		while (i < str.length && str[i] >= '0' && str[i] <= '9') {
			i++;
		}
		int[] result = new int[2];
		result[0] = i > tmp ? 1 : 0;
		result[1] = i;

		return result; // 如果为true返回1，为false返回0
	}

	private static int[] scanInteger(char[] str, int i) {
		if (str[i] == '+' || str[i] == '-') {
			i++;
		}

		return scanUnsignedInteger(str, i);
	}

	// ====================测试代码====================
	private static void Test(String testName, String str, boolean expected) {
		if (testName != null)
			System.out.printf("%s begins: ", testName);
		
		if (isNumeric(str) == expected)
			System.out.printf("Passed.\n");
		else
			System.out.printf("FAILED.\n");
	}

	public static void main(String[] args) {
		Test("Test1", "100", true);
		Test("Test2", "123.45e+6", true);
		Test("Test3", "+500", true);
		Test("Test4", "5e2", true);
		Test("Test5", "3.1416", true);
		Test("Test6", "600.", true);
		Test("Test7", "-.123", true);
		Test("Test8", "-1E-16", true);
		Test("Test9", "1.79769313486232E+308", true);

		// printf("\n\n");
		System.out.println();
		System.out.println();

		Test("Test10", "12e", false);
		Test("Test11", "1a3.14", false);
		Test("Test12", "1+23", false);
		Test("Test13", "1.2.3", false);
		Test("Test14", "+-5", false);
		Test("Test15", "12e+5.4", false);
		Test("Test16", ".", false);
		Test("Test17", ".e1", false);
		Test("Test18", "e1", false);
		Test("Test19", "+.", false);
		Test("Test20", "", false);
		Test("Test21", null, false);
	}

}
