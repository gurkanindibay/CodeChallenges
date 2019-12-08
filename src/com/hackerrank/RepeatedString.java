package com.hackerrank;

public class RepeatedString {

    static long repeatedString(String s, long n) {
        final String charToBeSearched = "a";
        if (n <= 0 || s.length() == 0 || !s.contains(charToBeSearched)) return 0;
        long charCount = s.chars().filter(ch -> ch == charToBeSearched.charAt(0)).count();
        long modValue = n % s.length();
        long multiplier = n / s.length();
        String remainderStringAfterMod = s.substring(0, (int) modValue);
        long charCountForRemainderString = remainderStringAfterMod.chars().filter(ch -> ch == charToBeSearched.charAt(0)).count();

        return multiplier * charCount + charCountForRemainderString;

    }

    public static void main(String[] args) {
        System.out.println(repeatedString("abc", 102));

    }
}
