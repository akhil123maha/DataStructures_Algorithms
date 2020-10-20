package com.ds.algo.facebook.leetcode;

public class MonotonicArray {

    public static void main(String[] args) {

        int[] array = {1,2,2,4,7};
        boolean monotonic = MonotonicArray.isMonotonic(array);
        System.out.println("monotonic = " + monotonic);
    }

    public static boolean isMonotonic(int[] A){
        boolean isMonotonicIncreasing = true;
        boolean isMonotonicDecreasing = true;
        for (int i = 0; i < A.length -1; i++) {
            if(A[i] > A[i+1])
                isMonotonicIncreasing = false;
            if(A[i] < A[i+1])
                isMonotonicDecreasing = false;
        }
        return isMonotonicDecreasing || isMonotonicIncreasing;
    }

}
