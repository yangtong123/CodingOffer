package com.yt.yya.tree;

import com.yt.yya.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class N105_buildTree {
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        int len = preorder.length;
        return build(preorder, inorder, 0, len - 1, 0, len - 1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }

        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);

        int inRootIndex = map.get(rootVal);

        int leftSize = inRootIndex - inLeft;
        int rightSize = inRight - inRootIndex;

        root.left = build(preorder, inorder, preLeft + 1, preLeft + leftSize, inLeft, inRootIndex - 1);
        root.right = build(preorder, inorder, preRight - rightSize + 1, preRight, inRight - rightSize + 1, inRight);

        return root;
    }
}
