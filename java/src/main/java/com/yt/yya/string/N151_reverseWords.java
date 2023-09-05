package com.yt.yya.string;

public class N151_reverseWords {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int left = n - 1, right = n;
        for (; left < right && left >= 0; left--) {
            char ch = s.charAt(left);
            if (ch == ' ') {
                if (left + 1 < right) {
                    sb.append(s, left + 1, right);
                    sb.append(' ');
                }

                right = left;
            }
        }

        if (left + 1 < right) {
            sb.append(s, left + 1, right);
        } else {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }
}
