package com.yt.yya.tree;

import com.yt.yya.utils.TreeNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class N654_constructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int max = Integer.MIN_VALUE;
        int rootIndex = 0;
        for (int i = start; i <= end; i++) {
            if (max < nums[i]) {
                max = nums[i];
                rootIndex = i;
            }
        }

        TreeNode root = new TreeNode(max);

        root.left = build(nums, start, rootIndex - 1);
        root.right = build(nums, rootIndex + 1, end);

        return root;
    }

    public static void main(String[] args) {
        N654_constructMaximumBinaryTree obj = new N654_constructMaximumBinaryTree();
        int[] nums = {3,2,1,6,0,5};
        obj.constructMaximumBinaryTree(nums);
    }
}
