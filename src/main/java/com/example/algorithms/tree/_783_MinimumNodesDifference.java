package com.example.algorithms.tree;

import com.example.algorithms.levelordertraversal.TreeNode;

/**
 * @version 1.0
 * @description:
 * @author: sonhoangthanh
 * @date: 11/08/2025 12:36
 */
public class _783_MinimumNodesDifference {

    private int minDiff = Integer.MAX_VALUE;
    private Integer prev;


    public int minDiffInBST(TreeNode root) {
        inOrderDfs(root);
        return minDiff;
    }

    private void inOrderDfs(TreeNode current) {
        if (current == null) return;
        inOrderDfs(current.left);
        if (prev != null) {
            minDiff = Math.min(minDiff, current.val - prev);
        }
        prev = current.val;
        inOrderDfs(current.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        _783_MinimumNodesDifference minimumNodesDifference = new _783_MinimumNodesDifference();
        System.out.println(minimumNodesDifference.minDiffInBST(root));
    }
}
