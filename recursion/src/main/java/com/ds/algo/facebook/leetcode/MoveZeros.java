package com.ds.algo.facebook.leetcode;


import java.util.Arrays;

/***
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 */
public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        int[] output = MoveZeros.moveZeros(nums);
        System.out.println("output = " + Arrays.toString(output));
    }

    public static int[] moveZeros(int[] nums){
        int index  = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] !=  0){
                nums[index] = nums[i];
                index++;
            }
        }

        for (int i = index; i < nums.length; i++) {
            nums[i]= 0;
        }
        return nums;
    }
}
