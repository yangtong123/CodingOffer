package com.yt.yya.tree;

import com.yt.yya.utils.TreeNode;

public class N104_MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxLeft = maxDepth(root.left) + 1;
        int maxRight = maxDepth(root.right) + 1;

        return Math.max(maxLeft, maxRight);
    }
}
