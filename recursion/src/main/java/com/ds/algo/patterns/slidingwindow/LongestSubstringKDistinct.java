package com.ds.algo.patterns.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestSubstringKDistinct {

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("aabccbb", 0));
//        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
//        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
    }

    //aaabac , k = 3
    public static int findLength(String str, int k){
        Map<Character, Integer> hashMap = new HashMap<>();
        int maxLength  = 0;
        int j = 0;
        for(int i = 0; i < str.length() ; i++){
            char c = str.charAt(i);
            hashMap.put(c, hashMap.getOrDefault(c,0)+1);
            while(hashMap.size() > k){
                char d = str.charAt(j);
                hashMap.put(d, hashMap.get(d)-1);
                if(hashMap.get(d) == 0){
                    hashMap.remove(d);
                }
                j++;
            }
            maxLength = Math.max(maxLength, i-j+1);
        }
        return maxLength;
    }
}
