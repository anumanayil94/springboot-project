package com.codingproject.study.questions;

public class JumpGameOne {
    public static void main(String[] args) {
        int[] nums1 = {2,3,1,1,4};
        int[] nums2 = {3,2,1,0,4};
        System.out.println("Can jump (nums1): " + canJump(nums1));
        System.out.println("Can jump (nums2): " + canJump(nums2));
    }

    private static boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            if(i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
