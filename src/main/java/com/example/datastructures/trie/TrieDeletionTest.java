package com.example.datastructures.trie;

/**
 * @version 1.0
 * @description:
 * @author: sonhoangthanh
 * @date: 16/09/2025 14:58
 */
public class TrieDeletionTest {
    public static void main(String[] args) {
        Trie trie = new Trie();

        // Insert words
        String[] words = {"cat", "can", "cap", "bat", "bar", "barn"};
        for (String w : words) {
            trie.insert(w);
        }

        // Search before deleteKey
        System.out.println("Search cat: " + trie.search("cat"));  // true
        System.out.println("Search bar: " + trie.search("bar"));  // true
        System.out.println("Search barn: " + trie.search("barn"));// true
        System.out.println("Search dog: " + trie.search("dog"));  // false
        System.out.println("Search can: " + trie.search("can"));    //true

        // Delete test cases
        System.out.println(trie.deleteKey("dog")); // not exist -> false
        System.out.println(trie.deleteKey("bar")); // prefix of "barn" -> false
        System.out.println(trie.deleteKey("barn")); // has prefix "bar" -> false
        System.out.println(trie.deleteKey("cap")); // independent word -> false

        // Search after deleteKey
        System.out.println("Search bar: " + trie.search("bar"));   // false
        System.out.println("Search barn: " + trie.search("barn")); // false
        System.out.println("Search cap: " + trie.search("cap"));   // false
        System.out.println("Search can: " + trie.search("can"));   // true
        System.out.println("Search cat: " + trie.search("cat"));   // true

        // Delete all
        trie.deleteKey("cat");
        trie.deleteKey("can");
        trie.deleteKey("bat");

        System.out.println("Search cat: " + trie.search("cat"));   // false
        System.out.println("Search can: " + trie.search("can"));   // false
        System.out.println("Search bat: " + trie.search("bat"));   // false
    }
}
