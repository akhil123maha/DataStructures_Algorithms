package com.ds.algo.facebook.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinRemoveToMakeValid {

    public static void main(String[] args) {

        String input = "(a(b(c)d)";
        String validString = MinRemoveToMakeValid.minRemoveToMakeStringValid(input);
        System.out.println("s = " + validString);

    }

    private static String minRemoveToMakeStringValid(String input) {
        Stack<Integer> characterStackIndex = new Stack<>();
        Set<Integer> indexesToRemove = new HashSet<>();
        //process the string here.
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i)=='('){
                characterStackIndex.push(i);
            } else if (input.charAt(i) == ')') {
                if(characterStackIndex.isEmpty()){
                    indexesToRemove.add(i);
                } else
                    characterStackIndex.pop();
            }
        }
        //process the stack.
        while(!characterStackIndex.isEmpty()){
            Integer characterIndex = characterStackIndex.pop();
            indexesToRemove.add(characterIndex);
        }
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if(!indexesToRemove.contains(i)){
                output.append(input.charAt(i));
            }
        }
        return output.toString();
    }

}
