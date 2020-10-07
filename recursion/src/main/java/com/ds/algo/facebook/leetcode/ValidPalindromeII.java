package com.ds.algo.facebook.leetcode;

/***
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 *
 * Example 1:
 * Input: "aba"
 * Output: True
 *
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 *
 * Note:
 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */
public class ValidPalindromeII {
    public static void main(String[] args) {

        String input = "abcedba";
        boolean test = ValidPalindromeII.validPalindromeChecker(input);
        System.out.println("test = " + test);
    }

    private static boolean validPalindromeChecker(String input) {
        int  i =0;
        int j = input.length() -1;
        while(i < j){
            if(input.charAt(i) != input.charAt(j)){
                return isPalindrome(input.substring(i+1, j+1)) || isPalindrome(input.substring(i, j));
            }
            i++;
            j--;
        }
        return true;
    }

    private static boolean isPalindrome(String input) {
        int  i =0;
        int j = input.length() -1;
        while(i < j){
            if(input.charAt(i) != input.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


}
