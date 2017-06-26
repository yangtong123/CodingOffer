package yt.codingoffer;

import java.util.Stack;

public class N_09_QueueWithTwoStacks {
	static Stack<Integer> stack1 = new Stack<>();
	static Stack<Integer> stack2 = new Stack<>();
	
	private static void appendTail(int element) {
		stack1.push(element);
	}
	
	private static int deleteHead(int element) {
		if (stack2.size() == 0) {
			while (stack1.size() > 0) {
				int tmp = stack1.pop();
				stack2.push(tmp);
			}
		}
		
		if (stack2.size() == 0) {
			throw new RuntimeException("");
		}
		
		int data = stack2.pop();
		
		return data;
	}
	

}
