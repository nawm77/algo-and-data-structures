package org.ilya.Data_structures;

public class Stack<T> {
    private int initialCapacity = 10;
    private T[] array;
    private int size = 0;

    public Stack() {
        this.array = (T[]) new Object[this.initialCapacity];
    }

    public Stack(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        this.array = (T[]) new Object[this.initialCapacity];
    }

    public boolean isEmpty(){
        return this.size == 0;
    }
}
