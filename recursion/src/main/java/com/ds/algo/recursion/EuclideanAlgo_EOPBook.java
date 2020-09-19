package com.ds.algo.recursion;


/***
 * GCD of x and y is GCD (y, y%x)
 */
public class EuclideanAlgo_EOPBook {

    public static void main(String[] args) {
        EuclideanAlgo_EOPBook gcdAlgoRecursion = new EuclideanAlgo_EOPBook();
        System.out.println(gcdAlgoRecursion.EuclideanGCD(36, 156));
    }

    public long EuclideanGCD(long x, long y){
        if(y == 0)
            return x;
        else
            return EuclideanGCD(y, x % y);
    }


}
