package com.example.algorithms.tree;

import com.example.algorithms.levelordertraversal.TreeNode;

public class _110_BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode curNode) {
        if (curNode == null) return 0;

        int leftHeight = getHeight(curNode.left);
        if (-1 == leftHeight) return -1;

        int rightHeight = getHeight(curNode.right);
        if (-1 == rightHeight) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
