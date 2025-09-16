package com.example.datastructures.trie;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @version 1.0
 * @description:
 * @author: sonhoangthanh
 * @date: 15/09/2025 13:25
 */
public class Trie {
    TrieNode root; // Root of the Trie

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
//        return canDelete(root, word, 0);
        return deleteIterative(root, word);
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

    private boolean deleteIterative(TrieNode root, String word) {
        if (root == null || word == null || word.isEmpty()) {return false;}
        Deque<Pair> stack = new ArrayDeque<>();
        TrieNode currNode = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (currNode.children[index] == null) {
                return false;
            }
            stack.push(new Pair(currNode, index));
            currNode = currNode.children[index];
        }

        if (!currNode.isEnd) {return false;}
        currNode.isEnd = false;

        if (!hasNoChild(currNode)) return true;

        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            TrieNode parent = pair.node;
            int index = pair.index;
            parent.children[index] = null;

            if (parent.isEnd || !hasNoChild(parent)) { break; }
        }

        return true;
    }

    private TrieNode deleteKey(TrieNode node, String key, int depth) {
        if ( node == null ) return null;

        if ( depth == key.length() ) {
            if (!node.isEnd) return null;
            node.isEnd = false;

            if (hasNoChild(node)) {
                node = null;
            }
        }

        int index = key.charAt(depth) - 'a';
        node.children[index] = deleteKey(node.children[index], key, depth + 1);

        if (!node.isEnd && hasNoChild(node)) {
            node = null;
        }

        return node;

    }

    public TrieNode deleteKey(String key) {
        return deleteKey(root, key, 0);
    }

}
