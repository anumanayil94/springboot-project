package com.codingproject.study.questions;

public class LengthOfLastWord {
    /**
     * Returns the length of the last word in the string.
     * Optimal: O(n) time, O(1) extra space.
     */
    public int lengthOfLastWord(String s) {
        int count = 0;
        boolean wordFound = false;
        for(int i= s.length()-1; i>= 0; i--) {
            if(s.charAt(i)!= ' ') {
                count++;
                wordFound = true;
            }
            else if(s.charAt(i) == ' ' && wordFound) {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LengthOfLastWord solver = new LengthOfLastWord();
        String[] tests = new String[]{
            "Hello World",          // expected 5
            "   fly me   to   the moon  ", // expected 4
            "luffy is still joyboy", // expected 6
            "a",                    // expected 1
            "a ",                   // expected 1
            " ",                    // expected 0
            ""                      // expected 0
        };

        for (String t : tests) {
            int res = solver.lengthOfLastWord(t);
            System.out.println("\"" + t + "\" -> " + res);
        }
    }
}
