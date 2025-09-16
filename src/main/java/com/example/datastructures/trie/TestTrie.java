package com.example.datastructures.trie;

/**
 * @version 1.0
 * @description:
 * @author: sonhoangthanh
 * @date: 16/09/2025 10:29
 */
public class TestTrie {
    public static void main(String[] args) {
        Trie trie = new Trie();

        // Insert words
        String[] words = {"cat", "can", "cap", "bat", "bar", "barn"};
        for (String w : words) {
            trie.insert(w);
        }

        // Search before delete
        System.out.println("Search cat: " + trie.search("cat"));  // true
        System.out.println("Search bar: " + trie.search("bar"));  // true
        System.out.println("Search barn: " + trie.search("barn"));// true
        System.out.println("Search dog: " + trie.search("dog"));  // false
        System.out.println("Search can: " + trie.search("can"));    //true

        // Delete test cases
        System.out.println(trie.delete("dog")); // not exist -> false
        System.out.println(trie.delete("bar")); // prefix of "barn" -> false
        System.out.println(trie.delete("barn")); // has prefix "bar" -> false
        System.out.println(trie.delete("cap")); // independent word -> false

        // Search after delete
        System.out.println("Search bar: " + trie.search("bar"));   // false
        System.out.println("Search barn: " + trie.search("barn")); // false
        System.out.println("Search cap: " + trie.search("cap"));   // false
        System.out.println("Search can: " + trie.search("can"));   // true
        System.out.println("Search cat: " + trie.search("cat"));   // true

        // Delete all
        trie.delete("cat");
        trie.delete("can");
        trie.delete("bat");

        System.out.println("Search cat: " + trie.search("cat"));   // false
        System.out.println("Search can: " + trie.search("can"));   // false
        System.out.println("Search bat: " + trie.search("bat"));   // false
    }
}

