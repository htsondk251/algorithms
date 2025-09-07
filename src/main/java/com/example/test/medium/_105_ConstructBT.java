package com.example.test.medium;

import com.example.algorithms.levelordertraversal.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class _105_ConstructBT {
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = inorderIndexMap.get(rootVal);
        int leftSize = rootIndex - inStart;

        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inStart, rootIndex - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                rootIndex + 1, inEnd);

        return root;
    }

    public static void main(String[] args) {
        _105_ConstructBT i = new _105_ConstructBT();
        System.out.println(i.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));
    }
}
