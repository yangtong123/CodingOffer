package com.yt.yya.tree;

import com.yt.yya.utils.TreeNode;

public class N543_diameterOfBinaryTree {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);

        return ans - 1;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int l = depth(node.left);
        int r = depth(node.right);

        ans = Math.max(ans, l + r + 1);

        return Math.max(l, r) + 1;
    }
}
