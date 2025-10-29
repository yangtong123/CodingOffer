package com.yt.interview.stack;

import java.util.Stack;

public class A01_MinStack {
    Stack<Integer> stackData;
    Stack<Integer> stackMin;


    public A01_MinStack() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int val) {
        stackData.push(val);
        if (stackMin.isEmpty()) {
            stackMin.push(val);
        } else {
            if (val <= stackMin.peek()) {
                stackMin.push(val);
            }
        }
    }

    public void pop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("");
        }

        Integer val = stackData.pop();
        if (val <= stackMin.peek()) {
            stackMin.pop();
        }
    }

    public int top() {
        return stackData.peek();
    }

    public int getMin() {
        return stackMin.peek();
    }
}
