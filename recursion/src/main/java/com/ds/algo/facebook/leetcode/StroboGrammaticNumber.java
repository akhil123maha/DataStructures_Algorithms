package com.ds.algo.facebook.leetcode;


import java.util.HashMap;
import java.util.Map;

/***
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 *
 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
 */
public class StroboGrammaticNumber {

    public static Map<Character, Character> referenceMap = new HashMap<>();
    static {
        referenceMap.put('0','0');
        referenceMap.put('1','1');
        referenceMap.put('8','8');
        referenceMap.put('6','9');
        referenceMap.put('9','6');
    }

    public static void main(String[] args) {
        boolean stroboGrammaticNumber = StroboGrammaticNumber.isStroboGrammaticNumber("916");
        System.out.println("stroboGrammaticNumber = " + stroboGrammaticNumber);
    }

    public static boolean isStroboGrammaticNumber(String number){
        int i = 0;
        int j = number.length()-1;

        while (i < j){
            if(!isMirror(number.charAt(i++), number.charAt(j--))){
               return false;
            }
        }
        return true;
    }

    private static boolean isMirror(Character start, Character end) {
        return referenceMap.get(start).equals(end);
    }

}
