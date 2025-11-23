package com.codingproject.study.questions;

public class H_Index {


    public static void main(String[] args) {
        int[] citations1 = {3, 0, 6, 1, 5};
        int[] citations2 = {1, 3, 1, 4, 2, 5};
        int hIndex1 = hIndex(citations1);
        int hIndex2 = hIndex(citations2);
        System.out.println("H-Index: " + hIndex1);
        System.out.println("H-Index: " + hIndex2);
    }

    private static int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1];
        for (int c : citations) {
            if (c >= n) {
                count[n]++;
            } else {
                count[c]++;
            }
        }
        int total = 0;
        for (int i = n; i >= 0; i--) {
            total += count[i];
            if (total >= i) {
                return i;
            }
        }
        return 0;
    }
}
