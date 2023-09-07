package com.yt.yya.array;

import java.util.*;

public class N380_RandomizedSet {
    class RandomizedSet {
        Map<Integer, Integer> map;
        ArrayList<Integer> list;
        Random random;

        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }

            int size = list.size();
            map.put(val, size);
            list.add(val);

            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }

            int index = map.get(val);
            int last = list.get(list.size() - 1);
            list.set(index, last);
            map.put(last, index);

            map.remove(val);
            list.remove(list.size() -  1);
            return true;
        }

        public int getRandom() {
            int index = random.nextInt(list.size());
            return list.get(index);
        }
    }
}
