package com.example.datastructures.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @description:
 * @author: sonhoangthanh
 * @date: 29/09/2025 18:22
 */
public class _1268_SearchSuggestionSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> suggestions = new ArrayList<>();
        Trie trie = new Trie();
        for (String product : products) {
            trie.insert(product);
        }

        for (int i = 0; i < searchWord.length(); i++) {
            String pre = searchWord.substring(0, i);
            suggestions.add(suggest(trie, pre));
        }

        return suggestions;
    }

    private List<String> suggest(Trie dictionary, String pre) {
        TrieNode node = dictionary.root;
        List<String> suggestions = new ArrayList<>();

        return null;
    }
}
