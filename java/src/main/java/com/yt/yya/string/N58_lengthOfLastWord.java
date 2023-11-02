package com.yt.yya.string;

public class N58_lengthOfLastWord {

    public int lengthOfLastWord(String s) {
        String a = s.trim();

        String[] strs = a.split(" ");

        for (int i = strs.length - 1; i >= 0; i--) {
            if (strs[i] != null || "".equals(strs[i])) {
                return strs[i].length();
            }
        }

        return 0;
    }
}
