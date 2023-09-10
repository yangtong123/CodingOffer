package com.yt.yya.tree;

import com.yt.yya.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class N106_buildTree {

    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        int len = inorder.length;
        return build(inorder, postorder, 0, len - 1, 0, len - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int inLeft, int inRight, int postLeft, int postRight) {
        if (postLeft > postRight) {
            return null;
        }

        int rootVal = postorder[postRight];
        TreeNode root = new TreeNode(rootVal);

        int inRootIndex = map.get(rootVal);
        int leftSize = inRootIndex - inLeft;

        root.left = build(inorder, postorder, inLeft, inLeft + leftSize - 1, postLeft, postLeft + leftSize - 1);
        root.right = build(inorder, postorder, inRootIndex + 1, inRight, postLeft + leftSize, postRight - 1);

        return root;
    }


}
