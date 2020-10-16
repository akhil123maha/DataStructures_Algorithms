package com.ds.algo.facebook.leetcode;

public class VersionControl {

    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        return firstBadVersionHelper(low, high);
    }

    private int firstBadVersionHelper(int low, int high) {
        while (low < high){
            int mid = (low + high)/2;
            if(isBadVersion(mid)){
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    // Dummy Implimentation
    private boolean isBadVersion(int mid) {
        return false;
    }



}
