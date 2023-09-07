package com.yt.yya.string;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class N1081_smallestSubsequence {
    public String smallestSubsequence(String s) {
        Deque<Character> stack = new LinkedList<>();
        boolean[] isInStack = new boolean[256];
        int[] count = new int[256];

        for (char c : s.toCharArray()) {
            count[c]++;
        }

        for (char c : s.toCharArray()) {
            count[c]--;
            if (isInStack[c]) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > c) {
                if (count[stack.peek()] == 0) {
                    break;
                }

                isInStack[stack.peek()] = false;
                stack.pop();
            }

            stack.push(c);
            isInStack[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        N1081_smallestSubsequence obj = new N1081_smallestSubsequence();

        obj.smallestSubsequence("bcabc");
    }
}
