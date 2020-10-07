package com.ds.algo.facebook.leetcode;

public class ValidPalindrome {
    public static void main(String[] args) {
        boolean b = ValidPalindrome.validPalindromeChecker("A man, a plan, a canal: Panama");
        System.out.println("b = " + b);
    }

    private static boolean validPalindromeChecker(String input) {
        int i = 0;
        int j = input.length()-1;
        while(i < j){
            char leftChar = input.charAt(i);
            char rightChar = input.charAt(j);
            if(Character.isLetterOrDigit(leftChar) && Character.isLetterOrDigit(rightChar)){
                if(Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)){
                    return false;
                }
                i++;
                j--;
            } else if(!Character.isLetterOrDigit(leftChar)){
                i++;
            } else if (!Character.isLetterOrDigit(rightChar)){
                j--;
            }
        }
        return true;
    }
}
