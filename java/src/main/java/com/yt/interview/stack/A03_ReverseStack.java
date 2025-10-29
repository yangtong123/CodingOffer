package com.yt.interview.stack;

import java.util.Stack;

public class A03_ReverseStack {

    Stack<Integer> stack;

    public A03_ReverseStack() {
        this.stack = new Stack<>();
    }

    public int getAndRemoveLastElement(Stack<Integer> stack) {
        Integer result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        }

        int val = getAndRemoveLastElement(stack);
        stack.push(result);
        return val;
    }

    public void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int val = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(val);
    }
}
