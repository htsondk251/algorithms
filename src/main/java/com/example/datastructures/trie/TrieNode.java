package com.example.datastructures.trie;

/**
 * @version 1.0
 * @description:
 * @author: sonhoangthanh
 * @date: 15/09/2025 13:24
 */
public class TrieNode {
    TrieNode[] children = new TrieNode[26]; // Array to store children nodes for each character
    boolean isEnd; // Flag to indicate if this node is the end of a word

    public TrieNode() {
        isEnd = false;
        for (int i = 0; i < 26; i++)
            children[i] = null;
    }

    public boolean isEmpty() {
        return false;
    }
}
