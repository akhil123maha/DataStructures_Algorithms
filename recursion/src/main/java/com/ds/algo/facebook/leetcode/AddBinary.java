package com.ds.algo.facebook.leetcode;

public class AddBinary {
    public static void main(String[] args) {

        String num1 = "1110";
        String num2 = "1011";
        String binary = AddBinary.addBinary(num1, num2);
        System.out.println("binary = " + binary);
    }

    private static String addBinary(String num1, String num2) {
        StringBuilder output = new StringBuilder();
        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;
        while (i >= 0 || j >= 0){
            int sum = carry;
            if (i >= 0) sum += num1.charAt(i) - '0';
            if (j >= 0) sum += num2.charAt(j) - '0';
            output.append(sum%2);
            carry = sum/2;
            i--;
            j--;
        }
        if(carry!= 0){
            output.append(carry);
        }
        return output.reverse().toString();
    }


}
