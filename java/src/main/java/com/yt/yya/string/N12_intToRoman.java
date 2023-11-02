package com.yt.yya.string;

import java.util.HashMap;
import java.util.Map;

public class N12_intToRoman {

    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] strings = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuilder resultSb = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String str = strings[i];

            while (num >= value) {
                num -= value;
                resultSb.append(str);
            }

            if (num == 0) {
                break;
            }
        }

        return resultSb.toString();
    }
}
