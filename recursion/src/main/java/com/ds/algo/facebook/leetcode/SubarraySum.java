package com.ds.algo.facebook.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {

    public static void main(String[] args) {
        int[] arr = {10, 2, -2, -20, 10};
        int sum = -10;
        int count = SubarraySum.subArraySumWithPrefixSum(arr, sum);
        System.out.println("count = " + count);
    }

    private static int subArraySumWithPrefixSum(int[] nums, int k) {
        int count = 0 ;
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum = prefixSum + nums[i];
            if(prefixSum == k)
                count ++;
            if(map.containsKey(prefixSum - k)){
                count = count + map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
