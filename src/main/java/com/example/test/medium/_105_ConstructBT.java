package com.example.test.medium;

import com.example.algorithms.levelordertraversal.TreeNode;

public class _105_ConstructBT {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //preorder[0] = root
        //rootIndex = inorder.get(root);
        //inorder[0..rootIndex] = left
        //inorder[rootIndex+1..n-1] = right;
        return buildTreeRecursive(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode buildTreeRecursive(int[] preorder, int preStart, int preEnd,
                                        int[] inorder, int inStart, int inEnd) {
        if (preEnd < preStart ) return null;
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = findRootIndex(inorder, inStart, inEnd, rootVal);
        int leftLen = rootIndex - inStart;
        //left preorder, prestart+1, prestart+1+leftLen-1, inorder, inStart, inStart+leftLen-1
        root.left = buildTreeRecursive(preorder, preStart+1, preStart+leftLen,
                inorder, inStart, rootIndex - 1);
        //right preorder,
        root.right = buildTreeRecursive(preorder, preStart+leftLen+1, preEnd,
                inorder, rootIndex+1, inEnd);
        return root;
    }

    private int findRootIndex(int[] inorder, int inStart, int inEnd, int rootVal) {
        for (int i = inStart; i <= inEnd; i++) {
            if (rootVal == inorder[i]) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        _105_ConstructBT i = new _105_ConstructBT();
        System.out.println(i.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));
    }
}
