package com.melchizedek.leet.code.grind.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyHashSet {

    private final List<Integer> list;

    public MyHashSet() {
        list = new ArrayList<>();
    }

    public void add(int key) {
        if (!list.contains(key)) {
            list.add(key);
        }
    }

    public void remove(int key) {
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == key) {
                it.remove();
                return;
            }
        }
    }

    public boolean contains(int key) {
        return list.contains(key);
    }
}
