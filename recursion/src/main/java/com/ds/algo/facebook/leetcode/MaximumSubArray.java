package com.ds.algo.facebook.leetcode;

public class MaximumSubArray {


    public int maxSubArraySum(int[] input){

        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;

        for (int i = 0; i < input.length; i++) {
            max_ending_here = max_ending_here + input[i];
            if(max_so_far < max_ending_here)
                max_so_far = max_ending_here;

            if(max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }
}
