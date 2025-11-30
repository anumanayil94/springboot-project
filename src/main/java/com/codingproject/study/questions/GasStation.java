package com.codingproject.study.questions;

/**
 * LeetCode 134. Gas Station
 * Given two integer arrays gas and cost, return the starting gas station's index if you can travel around
 * the circuit once in the clockwise direction, otherwise return -1.
 *
 * Greedy solution: If total gas < total cost -> impossible. Otherwise, the valid start is found by
 * scanning once and resetting the candidate start whenever current tank becomes negative.
 *
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class GasStation {

    /**
     * Returns the start index or -1 if impossible.
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length != cost.length) return -1;
        int n = gas.length;
        int total = 0;      // total gas - cost across all stations
        int tank = 0;       // current tank from candidate start
        int start = 0;      // candidate start index

        for (int i = 0; i < n; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            tank += diff;
            // If tank drops below 0, we cannot start from previous candidate
            if (tank < 0) {
                start = i + 1; // choose next station as candidate
                tank = 0;      // reset current tank
            }
        }

        return total >= 0 ? (start % n) : -1;
    }

    // Simple runner with example test cases
    public static void main(String[] args) {
        GasStation solver = new GasStation();

        int[] gas1 = {1, 2, 3, 4, 5};
        int[] cost1 = {3, 4, 5, 1, 2};
        int res1 = solver.canCompleteCircuit(gas1, cost1);
        System.out.println("Expected 3, got: " + res1);

        int[] gas2 = {2, 3, 4};
        int[] cost2 = {3, 4, 3};
        int res2 = solver.canCompleteCircuit(gas2, cost2);
        System.out.println("Expected -1, got: " + res2);

        int[] gas3 = {5, 1, 2, 3, 4};
        int[] cost3 = {4, 4, 1, 5, 1};
        int res3 = solver.canCompleteCircuit(gas3, cost3);
        System.out.println("Custom case, got: " + res3);
    }
}
