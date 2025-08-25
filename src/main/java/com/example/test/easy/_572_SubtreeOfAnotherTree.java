package com.example.test.easy;

import com.example.algorithms.levelordertraversal.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @version 1.0
 * @description:
 * @author: sonhoangthanh
 * @date: 25/08/2025 10:02
 */
public class _572_SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;

        return isSameTree(root, subRoot) ||
                isSubtree(root.left, subRoot) ||
                isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode current, TreeNode subRoot) {
        if (current == null && subRoot == null) return true;
        if ((current == null) == (subRoot != null)) return false;
        if (current.val != subRoot.val) return false;

        return isSameTree(current.left, subRoot.left) && isSameTree(current.right, subRoot.right);
    }

    public static void main(String[] args) {
        _572_SubtreeOfAnotherTree i = new _572_SubtreeOfAnotherTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        TreeNode subRoot1 = new TreeNode(4);
        subRoot1.left = new TreeNode(2);
        subRoot1.right = new TreeNode(1);

        System.out.println(i.isSubtree(root, subRoot));
        System.out.println(i.isSubtree(root, subRoot1));
    }
}
