package com.ds.algo.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StroboGrammaticNumber11_LeetCode_Akhil123maha {


    public static void main(String[] args) {

        StroboGrammaticNumber11_LeetCode_Akhil123maha solution = new StroboGrammaticNumber11_LeetCode_Akhil123maha();
        int length = 2;
        System.out.println(solution.findStroboGrammaticNumbers(length));
    }

    private List<String> findStroboGrammaticNumbers(int n) {
        HashMap<Character, Character> charMap = new HashMap<>();
        charMap.put('1','1');
        charMap.put('0','0');
        charMap.put('8','8');
        charMap.put('6','9');
        charMap.put('9','6');
        return findStroboGrammaticNumbers(charMap, 0, n-1, false);
    }

    private List<String> findStroboGrammaticNumbers(HashMap<Character, Character> map, int left, int right, boolean zero) {
        List<String> result = new ArrayList<>();
        if(left > right){
            result.add("");
            return result;
        }
        if(left==right){
            result.add("1");
            result.add("0");
            result.add("8");
            return result;
        }
        List<String> inner = findStroboGrammaticNumbers(map, left + 1, right - 1, true);
        for (String s: inner) {
            for(Character c : map.keySet()){
                if(zero || c!= '0'){
                    result.add(c + s + map.get(c));
                }
            }
        }
        return result;
    }


}
