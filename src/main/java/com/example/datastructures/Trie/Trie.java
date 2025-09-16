package com.example.datastructures.Trie;

/**
 * @version 1.0
 * @description:
 * @author: sonhoangthanh
 * @date: 15/09/2025 13:25
 */
public class Trie {
    private TrieNode root; // Root of the Trie

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }

        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.isEnd;
    }

    public boolean delete(String word) {
        return canDelete(root, word, 0);
    }

    private boolean canDelete(TrieNode node, String word, int depth) {

        if (node == null) {
            //node.children[index] == null; -> not found
            return false;
        }

        if (depth == word.length()) {
            if (!node.isEnd) return false;
            node.isEnd = false;
            return hasNoChild(node);
        }

        int index = word.charAt(depth) - 'a';
        boolean canDeleteChild = canDelete(node.children[index], word, depth + 1);

        if (canDeleteChild) {
            node.children[index] = null;

            return !node.isEnd && hasNoChild(node);
        }

        return false ;
    }

    private boolean hasNoChild(TrieNode node) {
        for (TrieNode child : node.children) {
            if (child != null) {
                return false;
            }
        }
        return true;
    }

}
