package com.yt.yya.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class N6_convert {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> list = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }

        boolean down = false;
        int currentRow = 0;
        for (char c : s.toCharArray()) {
            list.get(currentRow).append(c);
            if (currentRow == 0 || currentRow == numRows - 1) {
                down = !down;
            }

            currentRow += down ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();

        for (StringBuilder stringBuilder : list) {
            result.append(stringBuilder);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "AB";

        N6_convert obj = new N6_convert();
        String convert = obj.convert(s, 1);

//        assert convert.equals("PINALSIGYAHRPI");
    }
}
