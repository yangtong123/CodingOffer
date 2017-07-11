package yt.codingoffer;

import java.util.Stack;

public class N_31_StackPushPopOrder {
	private static boolean isPopOrder(int[] push, int[] pop) {
		boolean possible = false;
		if (push != null && pop != null && push.length == pop.length && push.length > 0) {

			Stack<Integer> dataStack = new Stack<Integer>();

			int i = 0;
			int j = 0;
			int length = push.length;

			while (j < length) {
				while (dataStack.isEmpty() || dataStack.peek() != pop[j]) {
					if (i == length || j == length) {
						break;
					}
					dataStack.push(push[i]);
					i++;
				}

				if (dataStack.peek() != pop[j]) {
					break;
				}

				dataStack.pop();
				j++;
			}

			if (dataStack.isEmpty() && i == length && j == length) {
				possible = true;
			}
		}

		return possible;
	}

	// ====================测试代码====================
	private static void Test(String testName, int[] pPush, int[] pPop, boolean expected) {
		if (testName != null)
			System.out.printf("%s begins: ", testName);

		if (isPopOrder(pPush, pPop) == expected)
			System.out.printf("Passed.\n");
		else
			System.out.printf("failed.\n");
	}

	private static void Test1() {
		int push[] = { 1, 2, 3, 4, 5 };
		int pop[] = { 4, 5, 3, 2, 1 };

		Test("Test1", push, pop, true);
	}

	private static void Test2() {
		int push[] = { 1, 2, 3, 4, 5 };
		int pop[] = { 3, 5, 4, 2, 1 };

		Test("Test2", push, pop, true);
	}

	private static void Test3() {
		int push[] = { 1, 2, 3, 4, 5 };
		int pop[] = { 4, 3, 5, 1, 2 };

		Test("Test3", push, pop, false);
	}

	private static void Test4() {
		int push[] = { 1, 2, 3, 4, 5 };
		int pop[] = { 3, 5, 4, 1, 2 };

		Test("Test4", push, pop, false);
	}

	// push和pop序列只有一个数字
	private static void Test5() {
		int push[] = { 1 };
		int pop[] = { 2 };

		Test("Test5", push, pop, false);
	}

	private static void Test6() {
		int push[] = { 1 };
		int pop[] = { 1 };

		Test("Test6", push, pop, true);
	}

	private static void Test7() {
		Test("Test7", null, null, false);
	}

	public static void main(String[] args) {
		Test1();
		Test2();
		Test3();
		Test4();
		Test5();
		Test6();
		Test7();
	}
}
