package com.ds.algo.patterns.slidingwindow;

public class MaxSumSubArrayOfSizeK {

    public static int findMaxSumSubArray(int k, int[] arr) {
        int windowSum = 0;
        int maxSum = 0;
        int  j = 0;
        for (int i = 0; i < arr.length; i++) {
            windowSum = windowSum + arr[i];
            if(i>=k-1){
                if(maxSum < windowSum)
                    maxSum = windowSum;
                windowSum = windowSum - arr[j];
                j++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr =  {2, 1, 5, 1, 3, 2};
        int maxSumSubArray = MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, arr);
        System.out.println("maxSumSubArray = " + maxSumSubArray);
    }

}
