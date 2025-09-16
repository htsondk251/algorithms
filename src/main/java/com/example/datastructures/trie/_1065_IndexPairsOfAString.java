package com.example.datastructures.trie;

import java.util.*;

/**
 * @version 1.0
 * @description:
 * @author: sonhoangthanh
 * @date: 16/09/2025 16:08
 */
public class _1065_IndexPairsOfAString {
    public List<List<Integer>> indexPairs(String text, List<String> words) {
        List<List<Integer>> result = new ArrayList<>();

        Trie trie = new Trie();
        words.forEach(trie::insert);
        for (int i = 0; i < text.length(); i++) {
            TrieNode node = trie.root;
            int currI = i;
            int index = text.charAt(currI) - 'a';
            while (node.children[index] != null) {
                node = node.children[index];
                if (node.isEnd) {
                    result.add(Arrays.asList(i, currI));
                    break;
                }
                index = text.charAt(++currI) - 'a';
            }
        }
        return result; // Return a list of lists containing index pairs
    }

    public static void main(String[] args) {
        _1065_IndexPairsOfAString i = new _1065_IndexPairsOfAString();
//        System.out.println(i.indexPairs("aaabbbccc", Arrays.asList("aa", "bb", "cc"))); //[[0,1], [1,2], [3,4], [4,
        // 5], [6,7], [7,8]

//        System.out.println(i.indexPairs("bluebirdskyscraper", Arrays.asList("blue", "bird", "sky")));
        System.out.println(i.indexPairs("programmingisfun", Arrays.asList("pro", "is", "fun", "gram")));
    }


}
