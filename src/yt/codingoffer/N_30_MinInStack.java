package yt.codingoffer;

import java.util.Stack;

class StackWithMin<T extends Comparable<? super T>> {
	Stack<T> dataStack = new Stack<T>();
	Stack<T> minStack = new Stack<T>();

	public void push(T value) {
		dataStack.push(value);
		if (minStack.isEmpty() || value.compareTo(minStack.peek()) < 0) {
			minStack.push(value);
		} else {
			minStack.push(minStack.peek());
		}
	}

	public T pop() {
		minStack.pop();
		return dataStack.pop();
	}

	public T min() {
		return minStack.peek();
	}

}

public class N_30_MinInStack {
	private static void Test(String testName, StackWithMin<Integer> stack, int expected) {
		if (testName != null)
			System.out.printf("%s begins: ", testName);

		if (stack.min() == expected)
			System.out.printf("Passed.\n");
		else
			System.out.printf("Failed.\n");
	}
	
	public static void main(String[] args) {
		StackWithMin<Integer> stack = new StackWithMin<>();

	    stack.push(3);
	    Test("Test1", stack, 3);

	    stack.push(4);
	    Test("Test2", stack, 3);

	    stack.push(2);
	    Test("Test3", stack, 2);

	    stack.push(3);
	    Test("Test4", stack, 2);

	    stack.pop();
	    Test("Test5", stack, 2);

	    stack.pop();
	    Test("Test6", stack, 3);

	    stack.pop();
	    Test("Test7", stack, 3);

	    stack.push(0);
	    Test("Test8", stack, 0);
	}
}
