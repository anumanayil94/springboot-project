package com.codingproject.study.questions;

public class ValidPaliandrome {
    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]","");
        s = s.toLowerCase();
        int i = 0;
        int j = s.length()-1;
        while(i < s.length()/2) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "0P";
        boolean result = isPalindrome(s);
        System.out.println(result);
    }
}


