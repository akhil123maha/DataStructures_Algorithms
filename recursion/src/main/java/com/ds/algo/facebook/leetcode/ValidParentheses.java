package com.ds.algo.facebook.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        boolean valid = ValidParentheses.isValid("([)]");
        System.out.println("valid = " + valid);
    }

    public static boolean isValid(String input) {
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
        Stack<Character> characterStack = new Stack<>();
        for (Character c : input.toCharArray()) {
            switch (c) {
                case '{':
                case '(':
                case '[':
                    characterStack.push(c);
                    break;
                case '}':
                case ']':
                case ')':
                    Character character = map.get(c);
                    Character pop = characterStack.pop();
                    if (!character.equals(pop)) {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
}
