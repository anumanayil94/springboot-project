package com.codingproject.study.questions;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = 3;
        int[] result = mergeSortedArray(nums1, nums2, m, n);
        System.out.println(Arrays.toString(result));

    }

    private static int[] mergeSortedArray(int[] nums1, int[] nums2, int m, int n) {
        int p =m+n-1, p1=m-1, p2=n-1;
        while(p1 >= 0 && p2>= 0) {
            if(nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p--;
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p--;
                p2--;
            }
        }
        while(p2>=0) {
            nums1[p] = nums2[p2];
            p--;
            p2--;
        }
        return nums1;
    }
}
