package com.yt.yya.tree;

import com.yt.yya.utils.TreeNode;

import java.util.*;

public class N144_PreorderTraversal {
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                list.add(node.val);
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            node = node.right;
        }

        return list;
    }


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        preorder(root, list);

        return list;
    }

    private void preorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }
}
