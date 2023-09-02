package com.yt.yya.string;

public class N5_longestPalindrome {
    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i+1);

            result = result.length() > s1.length() ? result : s1;
            result = result.length() > s2.length() ? result : s2;
        }

        return result;
    }

    public String palindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}
