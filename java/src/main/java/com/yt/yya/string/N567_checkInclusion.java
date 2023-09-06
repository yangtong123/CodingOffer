package com.yt.yya.string;

import java.util.Arrays;

public class N567_checkInclusion {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }

        int[] s1Cnt = new int[26];
        int[] s2Cnt = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Cnt[s1.charAt(i) - 'a']++;
            s2Cnt[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(s1Cnt, s2Cnt)) {
            return true;
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            s2Cnt[s2.charAt(i) - 'a']--;
            s2Cnt[s2.charAt(i + s1.length())  - 'a']++;
            if (Arrays.equals(s1Cnt, s2Cnt)) {
                return true;
            }
        }

        return false;
    }
}
