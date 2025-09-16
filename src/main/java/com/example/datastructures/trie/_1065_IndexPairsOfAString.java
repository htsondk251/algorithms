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
        // ToDo: Write Your Code Here.
        Trie trie = new Trie();
        words.forEach(trie::insert);

        int n = text.length();
        for (int i = 0; i < n; i++) {
            TrieNode node = trie.root;
            int textIndex = i;

            while (textIndex < n) {
                int index = text.charAt(textIndex) - 'a';

                if (node.children[index] == null) {
                    break;
                }


                node = node.children[index];

                if (node.isEnd) {
                    result.add(Arrays.asList(i, textIndex));
                }

                textIndex++;
            }
        }

        return result; // Return a list of lists containing index pairs
    }

    public static void main(String[] args) {
        _1065_IndexPairsOfAString i = new _1065_IndexPairsOfAString();
//        System.out.println(i.indexPairs("aaabbbccc", Arrays.asList("aa", "bb", "cc"))); //[[0,1], [1,2], [3,4], [4,
        // 5], [6,7], [7,8]

        System.out.println(i.indexPairs("bluebirdskyscraper", Arrays.asList("blue", "bird", "sky")));
//        System.out.println(i.indexPairs("programmingisfun", Arrays.asList("pro", "is", "fun", "gram")));
    }


}
