package com.ds.algo.facebook.leetcode;

public class AddStrings {
    public static void main(String[] args) {
        String addStrings = AddStrings.addStrings("360", "640");
        System.out.println("addStrings = " + addStrings);
    }
    public static String addStrings(String num1, String num2){

        int  i =  num1.length()-1;
        int  j =  num2.length()-1;
        int carry = 0;
        StringBuilder  output = new StringBuilder();
        while(i>= 0 || j >= 0){
            int sum = carry;
            if ((i >= 0)) {
                sum += num1.charAt(i) - '0';
            }
            if ((j >= 0)) {
                sum += num2.charAt(j) - '0';
            }
            output.append(sum%10);
            carry = sum/10;
            i--;
            j--;
        }
        if(carry!= 0){
            output.append(carry);
        }
        return output.reverse().toString();
    }
}
