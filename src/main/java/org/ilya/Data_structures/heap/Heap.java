package org.ilya.Data_structures.heap;

public interface Heap<E extends Comparable<E>> {
    int size();

    void add(E element);

    E peek();

    E poll();
    void updatePriority(E element1, E element2);
}