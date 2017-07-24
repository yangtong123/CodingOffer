package yt.codingoffer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class N_38_StringPermutation {
	private static void permutation(char[] chs, int i) {
		if (chs == null || i < 0) {
			return;
		} else if (i == chs.length) {
			System.out.println(Arrays.toString(chs));
		} else {
			char temp = 0;
			for (int j = i; j < chs.length; j++) {
				temp = chs[i];
				chs[i] = chs[j];
				chs[j] = temp;
				permutation(chs, i + 1);
				temp = chs[j];
				chs[j] = chs[i];
				chs[i] = temp;
			}
		}
	}

	// ====================测试代码====================
	private static void Test(String pStr) {
		if (pStr == null) {
			System.out.printf("Test for nullptr begins:\n");
			return;
		} else
			System.out.printf("Test for %s begins:\n", pStr);

		permutation(pStr.toCharArray(), 0);

		System.out.printf("\n");
	}

	public static void main(String[] args) {
		// Test(null);
		//
		// String string1 = "";
		// Test(string1);
		//
		// String string2 = "a";
		// Test(string2);
		//
		// String string3 = "ab";
		// Test(string3);
		//
		// String string4 = "abc";
		// Test(string4);

		// combination("abc".toCharArray());

		NQueen(4);
	}

	/**
	 * 组合问题
	 */
	private static void combination(char[] chs) {
		if (chs == null || chs.length <= 0) {
			return;
		}
		List<Character> list = new LinkedList<>();
		for (int i = 1; i <= chs.length; i++) {
			combine(chs, 0, i, list);
		}
	}

	// 求n个字符的长度为m(1 <= m <= n)的组合的时候，把这n个字符分成两部分
	// 第一个字符和其余字符。
	// 如果组合里包含第一个字符，则下一步在剩余的n-1个字符里选取m-1个字符。
	// 如果组合里不包含第一个字符，则下一步在剩余n-1个字符里选取m个字符。
	private static void combine(char[] chs, int start, int number, List<Character> list) {
		if (start < 0 || number < 0 || number > chs.length) {
			return;
		}
		if (number == 0) {
			System.out.println(list);
			return;
		}
		if (start == chs.length) {
			return;
		}
		list.add(chs[start]); // 相当于组合里有第一个字符
		combine(chs, start + 1, number - 1, list);
		list.remove((Character) chs[start]); // 相当于组合里没有第一个字符
		combine(chs, start + 1, number, list);
	}

	/*
	 * N 皇后问题
	 */
	private static void NQueen(int n) {
		if (n <= 0) {
			return;
		}

		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = i;
		}

		permutationForQueen(a, 0);
	}

	private static void permutationForQueen(int[] a, int i) {
		if (i == a.length && isValid(a)) {
			System.out.println(Arrays.toString(a));
		} else {
			for (int j = i; j < a.length; j++) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				permutationForQueen(a, i + 1);
				temp = a[j];
				a[j] = a[i];
				a[i] = temp;
			}
		}
	}

	private static boolean isValid(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (Math.abs(i - j) == Math.abs(a[i] - a[j])) {
					return false;
				}
			}
		}

		return true;
	}
}
