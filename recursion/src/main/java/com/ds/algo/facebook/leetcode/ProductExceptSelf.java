package com.ds.algo.facebook.leetcode;

import java.util.Arrays;

public class ProductExceptSelf {

    //24,12,8,6

    //Left and Right multiply.
    //1,1,2,6
    //24,12,4,1


    public static void main(String[] args) {
        int[] nums = {2,5,7,9};
        int[] productExceptSelf = ProductExceptSelf.productExceptSelf(nums);
        System.out.println("productExceptSelf = " + Arrays.toString(productExceptSelf));
    }

    private static int[] productExceptSelf(int[] nums) {

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = right[nums.length-1] = 1;
        int leftProduct  = 1;
        for (int i = 1; i < nums.length; i++) {
            leftProduct = leftProduct * nums[i-1];
            left[i] = leftProduct;
        }
        int rightProduct  = 1;
        for (int i = nums.length-2; i >=0; i--) {
            rightProduct = rightProduct * nums[i+1];
            right[i] = rightProduct;
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }


}
