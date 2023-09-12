package com.yt.yya.tree;

import com.yt.yya.utils.TreeNode;

import java.util.*;

public class N297_ser_deser {
    public static void main(String[] args) {
        Codec obj = new Codec();

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        node4.left = node6;
        node4.right = node7;

        String str = obj.serialize(node1);
        System.out.println(str);
    }


    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();

            traverse(root, sb);
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }

        private void traverse(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("#").append(",");
                return;
            }

            sb.append(root.val).append(",");
            traverse(root.left, sb);
            traverse(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] dataArr = data.split(",");
            LinkedList<String> list = new LinkedList<>(Arrays.asList(dataArr));
            return deserialize(list);
        }

        private TreeNode deserialize(LinkedList<String> nodes) {
            if (nodes.isEmpty()) {
                return null;
            }

            String val = nodes.removeFirst();
            if ("#".equals(val)) {
                return null;
            }

            TreeNode root = new TreeNode(Integer.parseInt(val));

            root.left = deserialize(nodes);
            root.right = deserialize(nodes);

            return root;
        }
    }
}
