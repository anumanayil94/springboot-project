package com.codingproject.study.questions;

public class ReverseWordsInAString {

    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int end = s.length()-1;
        while(end >= 0) {
            while(end >= 0 && s.charAt(end) == ' ') {
                end--;
            }
            if(end <0) {
                break;
            }
            int start = end;
            while(start>=0 && s.charAt(start) != ' ') {
                start--;
            }
            if(result.length() > 0 ) {
                result.append(' ');
            }
            result.append(s, start+1, end+1);
            end = start-1;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        ReverseWordsInAString solver = new ReverseWordsInAString();
        String[] tests = new String[]{

            "a good   example",        // expected "example good a"

        };

        for (String t : tests) {
            String res = solver.reverseWords(t);
            System.out.println("\"" + t + "\" -> \"" + res + "\"");
        }
    }
}
