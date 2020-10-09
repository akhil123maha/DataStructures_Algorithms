package com.ds.algo.facebook.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/***
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 */
public class IsAnagram {
    public static void main(String[] args) {

    }

    public static boolean isAnagram(String s, String t){
        if(s.length() != t.length())
            return false;
        char[] firstCharSequence = s.toCharArray();
        char[] secondCharSequence = t.toCharArray();
        Arrays.sort(secondCharSequence);
        Arrays.sort(firstCharSequence);
        return Arrays.equals(firstCharSequence, secondCharSequence);
    }
}
