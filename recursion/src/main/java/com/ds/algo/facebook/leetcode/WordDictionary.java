package com.ds.algo.facebook.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WordDictionary {

    public class TrieNode{
        Map<Character, TrieNode> children;
        boolean isEndOfWord;

        TrieNode(){
            this.children = new HashMap<>();
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
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
    public boolean search(String word) {
        TrieNode current = root;
        int length = word.length();
        for (int i = 0; i < length; i++) {
            char character = word.charAt(i);
            if(character == '.'){
                Set<Character> characters = current.children.keySet();

            } else {
                TrieNode temp = current.children.get(character);
                if(temp == null){
                    return false;
                }
                current = temp;
            }
        }
        return current.isEndOfWord;
    }

}
