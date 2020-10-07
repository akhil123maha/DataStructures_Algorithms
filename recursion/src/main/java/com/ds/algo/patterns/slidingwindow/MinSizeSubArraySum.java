package com.ds.algo.patterns.slidingwindow;

public class MinSizeSubArraySum {

    //[2, 1, 5, 2, 3, 2], S=7
    public static int findMinSubArray(int S, int[] arr) {
        int windowSum = 0;
        int minLength = Integer.MAX_VALUE;
        int j=0;
        for (int i = 0; i < arr.length; i++) {
            windowSum = windowSum + arr[i];
            while (windowSum > S){
                minLength = Math.min(minLength, i-j+1);
                windowSum = windowSum - arr[j];
                j++;
            }
        }
        return minLength;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 2, 3, 2};
        int sum = 7;
        int minSubArray = MinSizeSubArraySum.findMinSubArray(sum, arr);
        System.out.println("minSubArray = " + minSubArray);
    }
}
