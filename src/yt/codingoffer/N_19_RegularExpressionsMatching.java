package yt.codingoffer;


public class N_19_RegularExpressionsMatching {
	private static boolean match(char[] str, char[] pattern) {
		if (str == null || pattern == null) {
			return false;
		}

		return matchCore(str, 0, pattern, 0);
	}

	private static boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {

		if (str[strIndex] == '\0' && pattern[patternIndex] == '\0') {
			return true;
		}

		if (str[strIndex] != '\0' && pattern[patternIndex] == '\0' ) {
			return false;
		}


		if (pattern[patternIndex + 1] == '*') {
			if ((pattern[patternIndex] == '.' && str[strIndex] != '\0') 
					|| pattern[patternIndex] == str[strIndex]) {

				return matchCore(str, strIndex + 1, pattern, patternIndex + 2) // 移到下一个状态
						|| matchCore(str, strIndex + 1, pattern, patternIndex) // 保持原来的状态
						|| matchCore(str, strIndex, pattern, patternIndex + 2); // 忽略pattern的第一个
			} else { // 不相等，所以就patternIndex+2
				return matchCore(str, strIndex, pattern, patternIndex + 2);
			}
		} else if ((pattern[patternIndex] == '.' && str[strIndex] != '\0')
				|| str[strIndex] == pattern[patternIndex]) {
			return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
		}

		return false;
	}

	// ====================测试代码====================
	private static void Test(String testName, String string, String pattern, boolean expected) {
		if (testName != null)
			System.out.printf("%s begins: ", testName);

		string = string + '\0'; // 增加一位\0不然会报错
		pattern = pattern + '\0';

		if (match(string.toCharArray(), pattern.toCharArray()) == expected)
			System.out.printf("Passed.\n");
		else
			System.out.printf("FAILED.\n");
	}

	public static void main(String[] args) {
		Test("Test01", "", "", true);
		Test("Test02", "", ".*", true);
		Test("Test03", "", ".", false);
		Test("Test04", "", "c*", true);
		Test("Test05", "a", ".*", true);
		Test("Test06", "a", "a.", false);
		Test("Test07", "a", "", false);
		Test("Test08", "a", ".", true);
		Test("Test09", "a", "ab*", true);
		Test("Test10", "a", "ab*a", false);
		Test("Test11", "aa", "aa", true);
		Test("Test12", "aa", "a*", true);
		Test("Test13", "aa", ".*", true);
		Test("Test14", "aa", ".", false);
		Test("Test15", "ab", ".*", true);
		Test("Test16", "ab", ".*", true);
		Test("Test17", "aaa", "aa*", true);
		Test("Test18", "aaa", "aa.a", false);
		Test("Test19", "aaa", "a.a", true);
		Test("Test20", "aaa", ".a", false);
		Test("Test21", "aaa", "a*a", true);
		Test("Test22", "aaa", "ab*a", false);
		Test("Test23", "aaa", "ab*ac*a", true);
		Test("Test24", "aaa", "ab*a*c*a", true);
		Test("Test25", "aaa", ".*", true);
		Test("Test26", "aab", "c*a*b", true);
		Test("Test27", "aaca", "ab*a*c*a", true);
		Test("Test28", "aaba", "ab*a*c*a", false);
		Test("Test29", "bbbba", ".*a*a", true);
		Test("Test30", "bcbbabab", ".*a*a", false);
	}

}
