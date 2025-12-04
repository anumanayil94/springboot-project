package com.codingproject.study.questions;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int area = 0;
        int i = 0, j = height.length-1;
        while(i < j) {
            int container_height = Math.min(height[i], height[j]);
            int width = j-i;
            int currentArea = container_height * width;
            area = Math.max(area, currentArea);
            if(height[i] < height[j]) {
                i++;
            } else {
                j--;
            }

        }
        return area;
    }

    public static void main(String[] args) {
        ContainerWithMostWater solver = new ContainerWithMostWater();
        int[][] tests = new int[][]{
            {1,8,6,2,5,4,8,3,7},
                {0,9}// expected 49

        };

        for (int[] t : tests) {
            int res = solver.maxArea(t);
//            System.out.print("Heights: [");
//            for (int h : t) {
//                System.out.print(h + " ");
//            }
            System.out.println("] -> Max Area: " + res);
        }
    }
}
