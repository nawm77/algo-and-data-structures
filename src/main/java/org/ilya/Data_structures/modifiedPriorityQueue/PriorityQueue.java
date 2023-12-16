package org.ilya.Data_structures.modifiedPriorityQueue;

import org.ilya.Data_structures.priorityQueue.AbstractQueue;

public interface PriorityQueue<E extends Comparable<E>> extends AbstractQueue<E> {
    void changePriority(E element, int priority);
}
