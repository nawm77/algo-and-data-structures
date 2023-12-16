package org.ilya.Data_structures.priorityQueue;

public interface AbstractQueue<E extends Comparable<E>> {
    int size();

    void add(E element);

    E peek();

    E poll();
    void updatePriority(E element1, E element2);
}
