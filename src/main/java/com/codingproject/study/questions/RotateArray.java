package com.codingproject.study.questions;

import javax.sql.rowset.spi.SyncResolver;

public class RotateArray {
    public static void main(String args[]) {
        int[] nums = {1,2,3};
        int k = 4;
        rotateArray(nums, k);
        for(int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static void rotateArray(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    public static int[] reverse(int[] nums, int start, int end) {
        while(start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        return nums;
    }
}
