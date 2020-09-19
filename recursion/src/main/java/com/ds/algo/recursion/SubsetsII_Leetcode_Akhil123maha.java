package com.ds.algo.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII_Leetcode_Akhil123maha {

    public static void main(String[] args) {

        SubsetsII_Leetcode_Akhil123maha soa= new SubsetsII_Leetcode_Akhil123maha();
        int[] nums= {2, 1, 2};
        Arrays.sort(nums);
        List<List<Integer>> subsets = soa.subsets(nums);
        for (List<Integer> subset: subsets) {
            System.out.println(subset);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        subsetsHelper(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void subsetsHelper(List<List<Integer>> list , List<Integer> resultList, int [] nums, int start){
        list.add(new ArrayList<>(resultList));
        for(int i = start; i < nums.length; i++){
            if(i != start && nums[i] == nums[i - 1]) continue;
            resultList.add(nums[i]);
            subsetsHelper(list, resultList, nums, i + 1);
            resultList.remove(resultList.size() - 1);
        }
    }

}
