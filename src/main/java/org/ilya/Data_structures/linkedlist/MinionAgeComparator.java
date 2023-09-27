package org.ilya.Data_structures.linkedlist;

import java.util.Comparator;

public class MinionAgeComparator implements Comparator<Minion> {

    @Override
    public int compare(Minion minion1, Minion minion2) {
        return Integer.compare(minion1.getAge(), minion2.getAge());
    }
}