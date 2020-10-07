package com.ds.algo.facebook.leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {

    private class TrieNode{
        Map<Character, TrieNode> children;
        boolean isEndOfWord;

        TrieNode(){
            this.children = new HashMap<>();
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    private WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    private void addWord(String word) {
        TrieNode current = root;
        int length = word.length();
        for (int i = 0; i < length; i++) {
            char c = word.charAt(i);
            TrieNode temp;
            if(current.children.containsKey(c)){
                temp = current.children.get(c);
            } else{
                temp = new TrieNode();
                current.children.put(c, temp);
            }
            current = temp;
        }
        current.isEndOfWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    private boolean search(String word) {
       return search(word, root);
    }

    private boolean search(String word, TrieNode node) {
        if (word == null || (word.isEmpty())) {
            return node.isEndOfWord;
        }
        char c = word.charAt(0);
        if (c != '.') {
            if (!node.children.containsKey(c)) {
                return false;
            }
            else {
                return search(word.substring(1), node.children.get(c));
            }
        }
        else {
            // Collection<TrieNode> children = node.children.values();
            for (TrieNode child : node.children.values()) {
                if (search(word.substring(1), child)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        boolean pad = wordDictionary.search("pad");// return False
        System.out.println("pad = " + pad);
        boolean bad = wordDictionary.search("bad");// return True
        System.out.println("bad = " + bad);
        boolean search = wordDictionary.search(".ad");// return True
        System.out.println("search = " + search);
        boolean search1 = wordDictionary.search("b..");// return True
        System.out.println("search1 = " + search1);
    }

}
