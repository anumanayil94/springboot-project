package com.codingproject.study.questions;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums1 = {3, 2, 3};
        int[] nums2 = {1,1,3,3,4,4,4,4,5,5};
        int result1 = majorityElement(nums1);
        int result2 = majorityElement(nums2);
        System.out.println("Majority Element: " + result1);
        System.out.println("Majority Element: " + result2);
    }

    private static int majorityElement(int[] nums) {
        int val = 0, count = 0;
        for(int i= 0; i< nums.length; i++) {
            if(count == 0) {
                val = nums[i];
            }
            if(val == nums [i]) {
                count++;
            } else {
                count--;
            }
        }
        return val;
    }

}
