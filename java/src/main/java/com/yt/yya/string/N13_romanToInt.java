package com.yt.yya.string;

import java.util.HashMap;
import java.util.Map;

public class N13_romanToInt {

    Map<Character, Integer> map = new HashMap<>();
    {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        int len = s.length();

        int res = 0;
        for (int i = 0; i < len; i++) {
            char left = s.charAt(i);

            int value = map.get(left);
            if (i < len - 1 && value < map.get(s.charAt(i+1))) {
                res -= value;
            } else {
                res += value;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String str = "IV";

        N13_romanToInt obj = new N13_romanToInt();
        System.out.println(obj.romanToInt(str));
    }
}
