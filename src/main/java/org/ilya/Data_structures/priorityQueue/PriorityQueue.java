package org.ilya.Data_structures.priorityQueue;

import org.ilya.Data_structures.heap.Heap;
import org.ilya.Data_structures.heap.MaxHeap;

public class PriorityQueue<E extends Comparable<E>> implements AbstractQueue<E> {
    private final Heap<E> heap;

    public PriorityQueue() {
        heap = new MaxHeap<>();
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public void add(E element) {
        heap.add(element);
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return heap.peek();
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        return heap.poll();
    }

    @Override
    public void updatePriority(E element1, E element2){
        heap.updatePriority(element1, element2);
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    public static void main(String[] args) {
//        PriorityQueue<Minion> customPriorityQueue = new PriorityQueue<>();
//
//        customPriorityQueue.add(new Minion(14, "John", 1.4f));
//        customPriorityQueue.add(new Minion(13, "Nick", 1.7f));
//        customPriorityQueue.add(new Minion(12, "Tom", 1.74f));
//        customPriorityQueue.add(new Minion(12, "Mike", 1.75f));
//        customPriorityQueue.add(new Minion(12, "Alex", 1.76f));
//        customPriorityQueue.add(new Minion(12, "Jason", 1.77f));

        PriorityQueue<Integer> customPriorityQueue = new PriorityQueue<>();
        customPriorityQueue.add(2);
        customPriorityQueue.add(3);
        customPriorityQueue.add(4);
        customPriorityQueue.add(5);
        customPriorityQueue.add(6);
        customPriorityQueue.add(7);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        while (!customPriorityQueue.isEmpty()) {
            Integer elem = customPriorityQueue.poll();
            System.out.println(elem);
            queue.add(elem);
        }
        System.out.println("-------------");
        queue.updatePriority(7, 1);
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
