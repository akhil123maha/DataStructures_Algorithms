package com.ds.algo.facebook.leetcode;

import java.util.*;

public class FindAnagramsForString {
    public static void main(String[] args) {
        List<Integer> anagrams = FindAnagramsForString.findAnagrams("abbcabc", "abc");
        System.out.println("anagrams = " + Arrays.toString(anagrams.toArray()));
    }

    public static List<Integer> findAnagrams(String input, String pattern){
        Map<Character,Integer> charFrequencyMap = new HashMap<>();
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c,0) + 1);
        }
        int j = 0;
        int matched= 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(charFrequencyMap.containsKey(c)){
                charFrequencyMap.put(c, charFrequencyMap.get(c)-1);
                if(charFrequencyMap.get(c) == 0){
                    matched ++;
                }
            }
            if(matched == charFrequencyMap.size()){
                indices.add(j);
            }
            if(i >= pattern.length()-1){
                char r = input.charAt(j++);
                if(charFrequencyMap.containsKey(r)){
                    if(charFrequencyMap.get(r) == 0){
                        matched --;
                    }
                }
                charFrequencyMap.put(r, charFrequencyMap.get(r)+1);
            }
        }
        return indices;
    }
}
