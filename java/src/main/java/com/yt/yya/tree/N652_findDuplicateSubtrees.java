package com.yt.yya.tree;

import com.yt.yya.utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N652_findDuplicateSubtrees {
    Map<String, Integer> map;
    List<TreeNode> result;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        result = new ArrayList<>();

        traverse(root);
        return result;
    }

    private String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }

        String left = traverse(root.left);
        String right = traverse(root.right);

        String str = left + ", " + right + ", " + root.val;

        int num = map.getOrDefault(str, 0);
        if (num == 1) {
            result.add(root);
        }

        map.put(str, ++num);

        return str;
    }
}
