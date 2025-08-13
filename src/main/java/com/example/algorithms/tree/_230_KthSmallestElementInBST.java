package com.example.algorithms.tree;

import com.example.algorithms.levelordertraversal.TreeNode;

import java.util.PriorityQueue;

public class _230_KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((v1, v2) -> v2 - v1);
        inOrder(root, k, maxHeap);
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }

    private void inOrder(TreeNode current, int k, PriorityQueue<Integer> maxHeap) {
        if (current == null) return;
        inOrder(current.left, k, maxHeap);
        if (maxHeap.size() < k) {
            maxHeap.offer(current.val);
        } else if (current.val < maxHeap.peek()) {
            maxHeap.poll();
            maxHeap.offer(current.val);
        }
        inOrder(current.right, k, maxHeap);
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
