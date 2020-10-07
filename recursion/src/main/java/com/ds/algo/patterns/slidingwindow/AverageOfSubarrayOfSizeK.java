package com.ds.algo.patterns.slidingwindow;

import java.util.Arrays;

public class AverageOfSubarrayOfSizeK {

    public static double[] findAverages(int K, int[] arr) {
        double[] result = new double[arr.length-K+1];
        for(int i =0 ; i <= arr.length - K ; i++) {
            double sum= 0 ;
            for(int j=i ;j < i + K; j ++){
                sum = sum + arr[j];
            }
            result[i] = sum/K;
        }
        return result;
    }


    public static double[] findAveragesOptimized(int K, int[] arr) {
        double[] result = new double[arr.length-K+1];
        double windowSum = 0;
        int j= 0;
        for(int i =0 ; i < arr.length ; i++) {
            windowSum = windowSum + arr[i];
            if(i>=K-1){
                result[j] = windowSum/K;
                windowSum = windowSum -arr[j];
                j++;
            }


        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr =  {1, 3, 2, 6, -1, 4, 1, 8, 2};

        double[] averages = AverageOfSubarrayOfSizeK.findAverages(5, arr);
        double[] averagesOptimized = AverageOfSubarrayOfSizeK.findAveragesOptimized(5, arr);
        System.out.println("averages = " + Arrays.toString(averages));
        System.out.println("Optimized averages = " + Arrays.toString(averagesOptimized));
    }
}
