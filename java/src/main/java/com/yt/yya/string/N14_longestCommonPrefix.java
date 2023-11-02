package com.yt.yya.string;

public class N14_longestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);

            if ("".equals(prefix)) {
                return "";
            }
        }

        return prefix;
    }

    private String longestCommonPrefix(String str1, String str2) {
        int minLen = Math.min(str1.length(), str2.length());

        int count = 0;
        for (int i = 0; i < minLen; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            }

            count++;
        }

        return str1.substring(0, count);
    }

}
