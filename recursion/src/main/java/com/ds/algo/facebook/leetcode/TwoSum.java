package com.ds.algo.facebook.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/***
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3,3};
        int[] output = TwoSum.twoSum(nums, 6);
        System.out.println("Arrays.toString(output) = " + Arrays.toString(output));

    }

    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> cache = new HashMap();
        for (int index = 0; index < nums.length; index++) {
            int key = target - nums[index];
            if(cache.containsKey(key)){
                return new int[] {cache.get(key), index};
            } else {
                cache.put(nums[index], index);
            }
        }
        return new int[]{};
    }
}
