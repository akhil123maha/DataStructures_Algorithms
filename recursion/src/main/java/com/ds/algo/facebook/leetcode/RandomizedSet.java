package com.ds.algo.facebook.leetcode;

import java.util.*;

public class RandomizedSet {

    private Map<Integer, Integer> map;
    private List<Integer> list;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        list.add(val);
        map.put(val, list.size()-1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        Integer index = map.get(val);
        Integer lastElement = list.get(list.size() - 1);
        list.set(index, lastElement);
        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        int randomIndex = random.nextInt(list.size() - 1);
        return list.get(randomIndex);
    }

    public int search(int val) {
        if(map.containsKey(val)){
            return map.get(val);
        }
        return -1;
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        boolean insert = randomizedSet.insert(1);
        System.out.println("insert = " + insert);
        boolean insert1 = randomizedSet.insert(2);
        System.out.println("insert1 = " + insert1);
        boolean insert2 = randomizedSet.insert(1);
        System.out.println("insert2 = " + insert2);
        boolean insert3 = randomizedSet.insert(3);
        System.out.println("insert3 = " + insert3);
        boolean insert4 = randomizedSet.insert(6);
        System.out.println("insert4 = " + insert4);
        int search = randomizedSet.search(6);
        System.out.println("search = " + search);
        int search1 = randomizedSet.search(1);
        System.out.println("search1 = " + search1);
        boolean remove = randomizedSet.remove(1);
        System.out.println("remove = " + remove);
        int search2 = randomizedSet.search(1);
        System.out.println("search2 = " + search2);
        int random = randomizedSet.getRandom();
        System.out.println("random = " + random);
    }
}
