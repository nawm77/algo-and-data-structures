package org.ilya.Data_structures.stack;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayStack<T> implements Iterable<T>{
    private static final int DEFAULT_CAPACITY = 10;
    private T[] array;
    private int size;

    public ArrayStack() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public ArrayStack(int capacity) {
        array = (T[]) new Object[capacity];
        size = 0;
    }

    public void push(T item) {
        if (size == array.length) {
            resizeArray();
        }
        array[size++] = item;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T item = array[--size];
        array[size] = null;
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resizeArray() {
        int newCapacity = array.length * 2;
        T[] newArray = (T[]) new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {
        private int currentIndex = size - 1;

        @Override
        public boolean hasNext() {
            return currentIndex >= 0;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return array[currentIndex--];
        }
    }
}
