package com.yt.yya.string;

import java.util.ArrayList;
import java.util.List;

public class N68_fullJustify {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> aaa = new ArrayList<>();
        List<String> bbb = new ArrayList<>();

        int len = 0;
        for (int i = 0; i < words.length; i++) {
            int blankLen = bbb.size();
            int wordLen = words[i].length();
            if (len + blankLen + wordLen <= maxWidth) {
                bbb.add(words[i]);
                len += words[i].length();
            } else {
                aaa.add(bbb);
                bbb = new ArrayList<>();
                len = 0;
                i = i - 1;
            }

            if (i == words.length - 1 && !bbb.isEmpty()) {
                aaa.add(bbb);
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < aaa.size(); i++) {
            List<String> list = aaa.get(i);
            int numWords = list.size();

            if (i == aaa.size() - 1 || numWords == 1) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < list.size(); j++) {
                    sb.append(list.get(j));
                    if (j != list.size() - 1) {
                        sb.append(" ");
                    }
                }

                fillSpaces(sb, maxWidth - sb.length());

                result.add(sb.toString());
                continue;
            }

            int wordLen = 0;
            for (String s : list) {
                wordLen += s.length();
            }

            int numSpaces = maxWidth - wordLen;
            int avgSpaces = numSpaces / (numWords - 1);
            int extraSpaces = numSpaces % (numWords - 1);

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < list.size(); j++) {
                sb.append(list.get(j));

                if (j == list.size() - 1) {
                    continue;
                }

                if (j < extraSpaces) {
                    fillSpaces(sb, avgSpaces + 1);
                } else {
                    fillSpaces(sb, avgSpaces);
                }
            }

            result.add(sb.toString());
        }

        return result;
    }

    private void fillSpaces(StringBuilder sb, int numSpaces) {
        for (int i = 0; i < numSpaces; i++) {
            sb.append(" ");
        }
    }

    public static void main(String[] args) {
        N68_fullJustify obj = new N68_fullJustify();
//        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        String[] words = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        obj.fullJustify(words, 20);
    }
}
