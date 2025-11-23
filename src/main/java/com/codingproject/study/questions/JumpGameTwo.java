package com.codingproject.study.questions;

public class JumpGameTwo {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int result = jump(nums);
        System.out.println("Minimum jumps to reach the end: " + result);
    }

    private static int jump(int[] nums) {
        int jumps = 0, currentEnd = 0, farthest = 0;
        int destination = nums.length - 1;
        for(int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if(i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
            if(currentEnd >= destination) {
                break;
            }
        }
        return jumps;
    }
}
