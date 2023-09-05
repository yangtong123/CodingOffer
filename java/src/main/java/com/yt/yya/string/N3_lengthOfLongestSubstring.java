package com.yt.yya.string;

import java.util.HashMap;
import java.util.Map;

public class N3_lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        int len = s.length();
        int result = 0;
        while (right < len) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            right++;

            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.getOrDefault(d, 0) - 1);
            }

            result = Math.max(result, (right - left));
        }

        return result;
    }
}
