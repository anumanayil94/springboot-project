package com.codingproject.study.questions;

import java.util.*;

public class RandomizedSet {

    List<Integer> list;
    Map<Integer, Integer> map;
    Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    // Example runner moved inside the class to avoid static-context issues
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        boolean param1 = randomizedSet.insert(1);
        boolean param2 = randomizedSet.remove(2);
        // ensure there's at least one element for getRandom()
        randomizedSet.insert(2);
        int param3 = randomizedSet.getRandom();
        System.out.println(param1); // true
        System.out.println(param2); // false
        System.out.println(param3); // 2 (or 1)
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = map.get(val);
        int lastVal = list.get(list.size() - 1);
        list.set(index, lastVal);
        map.put(lastVal, index);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        if (list.isEmpty()) {
            throw new NoSuchElementException("RandomizedSet is empty");
        }
        return list.get(random.nextInt(list.size()));
    }

}
