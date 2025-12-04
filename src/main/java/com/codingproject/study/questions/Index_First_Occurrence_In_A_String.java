package com.codingproject.study.questions;

public class Index_First_Occurrence_In_A_String {
    /**
     * Returns the index of the first occurrence of needle in haystack, or -1 if not found.
     * Optimal: O(n*m) time in worst case, O(1) extra space.
     */
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        int hLen = haystack.length();
        int nLen = needle.length();

        for (int i = 0; i <= hLen - nLen; i++) {
            int j = 0;
            while (j < nLen && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == nLen) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Index_First_Occurrence_In_A_String solver = new Index_First_Occurrence_In_A_String();
        String[][] tests = new String[][]{
            {"hello", "ll"},      // expected 2
            {"aaaaa", "bba"},     // expected -1
            {"", ""},             // expected 0
            {"a", "a"},           // expected 0
            {"abc", "c"},         // expected 2
            {"mississippi", "issip"} // expected 4
        };

        for (String[] t : tests) {
            int res = solver.strStr(t[0], t[1]);
            System.out.println("\"" + t[0] + "\", \"" + t[1] + "\" -> " + res);
        }
    }
}
