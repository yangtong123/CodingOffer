package com.yt.interview.stack;

import java.util.Stack;

public class A02_TwoStackQueue {
    Stack<Integer> stackPush;
    Stack<Integer> stackPop;

    public A02_TwoStackQueue() {
        this.stackPush = new Stack<>();
        this.stackPop = new Stack<>();
    }

    public void add(int val) {
        stackPush.add(val);
    }

    public int poll() {
        if (!stackPop.isEmpty()) {
            return stackPop.pop();
        }

        if (!stackPush.isEmpty()) {
            stackPop.push(stackPush.pop());
        }

        return stackPop.pop();
    }

    public int peek() {
        if (!stackPop.isEmpty()) {
            return stackPop.peek();
        }

        if (!stackPush.isEmpty()) {
            stackPop.push(stackPush.pop());
        }

        return stackPop.peek();
    }
}
