package com.example.test.medium;

import com.example.algorithms.levelordertraversal.TreeNode;

/**
 * @version 1.0
 * @description:
 * @author: sonhoangthanh
 * @date: 03/09/2025 13:38
 */
public class _98_ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        //in-order traversal
        //check if prev < cur

        return false;
    }

    public static void main(String[] args) {
        _98_ValidateBinarySearchTree i = new _98_ValidateBinarySearchTree();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(8);

        System.out.println(i.isValidBST(root));

//        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(3);
//        System.out.println(i.isValidBST(root));

//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(4);
//        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(6);
//
//        System.out.println(i.isValidBST(root));
    }
}
