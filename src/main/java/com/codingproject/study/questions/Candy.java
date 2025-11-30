package com.codingproject.study.questions;

import java.util.Arrays;

/**
 * LeetCode 135. Candy - two-pass greedy solution.
 */
public class Candy {
    /**
     * Returns the minimum number of candies to distribute according to ratings.
     *
     * Approach: Two-pass greedy.
     * - Left-to-right pass computes minimal candies satisfying left neighbor constraint.
     * - Right-to-left pass enforces right neighbor constraint and sums the max of both passes.
     */
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        int n = ratings.length;
        int[] left = new int[n];
        Arrays.fill(left, 1);

        // Left-to-right: ensure each child with higher rating than left neighbor gets more candies
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }

        // Right-to-left: enforce right neighbor constraint and sum up
        int result = 0;
        int rightRun = 1; // candies needed considering right neighbor
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                rightRun++;
            } else {
                rightRun = 1;
            }
            result += Math.max(left[i], rightRun);
        }

        return result;
    }

    // Added main for quick manual testing
    public static void main(String[] args) {
        Candy solver = new Candy();
        int[][] tests = new int[][]{
            {3, 2, 1},        // expected 5 -> [2,1,2]
            {1, 2, 2},        // expected 4 -> [1,2,1]
            {1, 3, 4, 5, 2},  // expected 11 -> [1,2,3,4,1]
            {2, 1},           // expected 3 -> [2,1]
            {1},              // expected 1
            {1,2,87,87,87,2,1} // varied
        };

        for (int[] t : tests) {
            int res = solver.candy(t);
            System.out.println(Arrays.toString(t) + " -> " + res);
        }
    }
}
