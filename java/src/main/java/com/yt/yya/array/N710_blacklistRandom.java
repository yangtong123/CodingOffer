package com.yt.yya.array;

import java.util.*;

public class N710_blacklistRandom {
    class Solution {
        Map<Integer, Integer> b2w;
        Random random;
        int bound;

        public Solution(int n, int[] blacklist) {
            b2w = new HashMap<>();
            random = new Random();
            int blackSize = blacklist.length;
            bound = n - blackSize;
            Set<Integer> set = new HashSet<>();
            for (int num : blacklist) {
                if (num >= bound) {
                    set.add(num);
                }
            }

            int w = bound;
            for (int b : blacklist) {
                if (b < bound) {
                    while (set.contains(w)) {
                        w++;
                    }
                    b2w.put(b, w);
                    w++;
                }
            }
        }

        public int pick() {
            int val = random.nextInt(bound);
            return b2w.getOrDefault(val, val);
        }
    }
}
