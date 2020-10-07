package com.ds.algo.patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithNoRepeat {
    public static void main(String[] args) {

        int longestSubstringWithNoRepeat = LongestSubstringWithNoRepeat.longestSubstringWithNoRepeat("aabccbb");
        System.out.println("longestSubstringWithNoRepeat = " + longestSubstringWithNoRepeat);
    }

    public static int longestSubstringWithNoRepeat(String input){
        Map<Character, Integer> characterFrequency = new HashMap<>();
        int maxLength  = 0;
        int j = 0;
        for (int i = 0; i < input.length(); i++) {
            if(characterFrequency.containsKey(input.charAt(i))){
              j = Math.max(j, characterFrequency.get(input.charAt(i))+1);
            }
            characterFrequency.put(input.charAt(i), i);
            maxLength = Math.max(maxLength, i - j + 1);
        }
        return maxLength;
    }

}
