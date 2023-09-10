package com.yt.yya.tree;

import com.yt.yya.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class N889_constructFromPrePost {
    Map<Integer, Integer> map;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        map = new HashMap<>();

        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }

        int len = preorder.length;
        return build(preorder, postorder, 0, len - 1, 0, len - 1);
    }

    private TreeNode build(int[] preOrder, int[] postOrder, int preLeft, int preRight, int postLeft, int postRight) {
        if (preLeft > preRight) {
            return null;
        }

        int rootVal = preOrder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        if (preLeft + 1 > preRight) {
            return root;
        }

        int leftRootVal = preOrder[preLeft + 1];
        int postLeftRootIndex = map.get(leftRootVal);

        int leftSize = postLeftRootIndex - postLeft + 1;

        root.left = build(preOrder, postOrder, preLeft + 1, preLeft + leftSize, postLeft, postLeft + leftSize - 1);
        root.right = build(preOrder, postOrder, preLeft + leftSize + 1, preRight, postLeftRootIndex + 1, postRight);

        return root;
    }

    public static void main(String[] args) {
        N889_constructFromPrePost obj = new N889_constructFromPrePost();
//        int[] preOrder = {1,2,4,5,3,6,7};
//        int[] postOrder = {4,5,2,6,7,3,1};

        int[] preOrder = {2, 1};
        int[] postOrder = {1, 2};

        obj.constructFromPrePost(preOrder, postOrder);
    }
}
