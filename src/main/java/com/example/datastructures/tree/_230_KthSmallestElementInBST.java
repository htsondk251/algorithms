package com.example.datastructures.tree;

import com.example.algorithms.levelordertraversal.TreeNode;

public class _230_KthSmallestElementInBST {
    private int result = 0;
    private int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return result;
    }

    private void inOrder(TreeNode current, int k) {
        if (current == null) return;
        inOrder(current.left, k);
        count++;

        if (count == k) {
            result = current.val;
            return;
        }

        inOrder(current.right, k);
    }

    public static void main(String[] args) {
        //[5,3,6,2,4,null,null,1], k = 3
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        _230_KthSmallestElementInBST i = new _230_KthSmallestElementInBST();
        System.out.println(i.kthSmallest(root, 3));
    }
}
