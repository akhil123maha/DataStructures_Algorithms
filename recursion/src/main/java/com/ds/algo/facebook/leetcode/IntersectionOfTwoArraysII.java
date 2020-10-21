package com.ds.algo.facebook.leetcode;

import java.util.*;

/***
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Note:
 *
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 *
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class IntersectionOfTwoArraysII {

    public static void main(String[] args) {

        int[] nums1 = {1,2,2,1}, nums2 = {2,2};
        int[] intersect = IntersectionOfTwoArraysII.intersect(nums1, nums2);
        System.out.println("Arrays.toString(intersect) = " + Arrays.toString(intersect));
    }

    public static int[] intersect(int[] nums1, int[] nums2){

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int[] output;
        if(nums1.length < nums2.length)
            output = new int[nums1.length];
        else
            output = new int[nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            if(frequencyMap.containsKey(nums1[i])){
                frequencyMap.put(nums1[i], frequencyMap.get(nums1[i]) + 1);
            } else
                frequencyMap.put(nums1[i], 1);
        }
        int j = 0;
        for (int i = 0; i < nums2.length; i++) {
            if(frequencyMap.containsKey(nums2[i]) && frequencyMap.get(nums2[i]) != 0){
                output[j++] = nums2[i];
                frequencyMap.put(nums2[i], frequencyMap.get(nums2[i]) - 1);
            }
        }
        return Arrays.copyOf(output, j);
    }

}
