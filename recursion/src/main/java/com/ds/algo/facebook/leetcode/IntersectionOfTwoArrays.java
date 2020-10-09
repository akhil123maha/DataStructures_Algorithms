package com.ds.algo.facebook.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/***
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 *
 *
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Note:
 *
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class IntersectionOfTwoArrays {
    public static void main(String[] args) {

    }

    public static int[] intersection(int[] a, int[] b){
        Set<Integer> set = new HashSet<>();
        Set<Integer> outputSet = new HashSet<>();
        int[] output = new int[(a.length > b.length)? b.length : a.length];
        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
        }
        for (int i = 0; i < b.length; i++) {
            if(set.contains(b[i])){
                outputSet.add(b[i]);
            }
        }
        int j = 0;
        for (Integer element: outputSet) {
            output[j] = element;
            j++;
        }
        return Arrays.copyOf(output, j);
    }

}
