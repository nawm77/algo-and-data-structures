package org.ilya.Data_structures.heap;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxHeap<E extends Comparable<E>> implements Heap<E> {
    private final List<E> elements;

    public MaxHeap() {
        elements = new ArrayList<>();
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public void add(E element) {
        elements.add(element);
        heapifyUp(size() - 1);
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (elements.get(index).compareTo(elements.get(parentIndex)) <= 0) {
                break;
            }
            Collections.swap(elements, index, parentIndex);
            index = parentIndex;
        }
    }

    @Override
    public void updatePriority(E oldElement, E newElement) {
        int oldIndex = elements.indexOf(oldElement);
        if (oldIndex != -1) {
            elements.remove(oldIndex);
            heapifyDown(oldIndex);
            elements.add(newElement);
            heapifyUp(size() - 1);
        } else {
            throw new IllegalArgumentException(MessageFormat.format("No such element {0}", oldElement));
        }
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return elements.get(0);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    private void heapifyDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int largest = index;
        if (leftChildIndex < size() && elements.get(leftChildIndex).compareTo(elements.get(largest)) > 0) {
            largest = leftChildIndex;
        }
        if (rightChildIndex < size() && elements.get(rightChildIndex).compareTo(elements.get(largest)) > 0) {
            largest = rightChildIndex;
        }
        if (largest != index) {
            Collections.swap(elements, index, largest);
            heapifyDown(largest);
        }
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E root = elements.get(0);
        E lastElement = elements.remove(size() - 1);
        if (!isEmpty()) {
            elements.set(0, lastElement);
            heapifyDown(0);
        }
        return root;
    }

    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        maxHeap.add(3);
        maxHeap.add(7);
        maxHeap.add(1);
        maxHeap.add(2);
        maxHeap.add(4);
        maxHeap.add(5);
        maxHeap.add(6);
        System.out.println("Max Element (Peek): " + maxHeap.peek());
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
        while (!maxHeap.isEmpty()) {
            System.out.println("Extracted Max Element: " + maxHeap.poll());
        }
    }
}
