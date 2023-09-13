package org.ilya.Data_structures;

import java.util.NoSuchElementException;
import java.util.Objects;

public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> last;
    private int size = 0;

    public void addFirst(T t) {
        size++;
        if (head == null) {
            head = new Node<>(t);
            last = head;
        } else {
            Node<T> currentNode = new Node<>(t);
            currentNode.next = head;
            head.previous = currentNode;
            head = currentNode;
        }
    }

    public void addLast(T t) {
        size++;
        if (head == null) {
            head = new Node<>(t);
            last = head;
            return;
        }
        Node<T> currentNode = new Node<>(t);
        last.next = currentNode;
        currentNode.previous = last;
        last = currentNode;
    }

    public int getId(T t) {
        if (head == null) {
            return -1;
        }
        if (head.value == t) {
            return 0;
        }
        Node<T> currentNode = head;
        int id = 0;
        while (currentNode.next != null) {
            id++;
            if (currentNode.next.value == t) {
                return id;
            }
            currentNode = currentNode.next;
        }
        return -1;
    }

    public void remove(T t) {
        if (head == null) {
            throw new NoSuchElementException("No such element: " + t);
        } else if (head.value == t) {
            head = head.next;
            head.previous = null;
        } else {
            Node<T> currentNode = head;
            while (currentNode.next != null) {
                if (currentNode.next.value == t) {
                    currentNode = currentNode.next;
                    currentNode.next = currentNode.next.next;
                    currentNode.previous = currentNode.previous.previous;
                    return;
                }
                currentNode = currentNode.next;
            }
        }
    }

    public void add(T t) {
        if (contains(t)) {
            Node<T> currentNode = getNode(t);
            currentNode.value = t;
        } else {
            addLast(t);
        }
    }

    public Node<T> getNode(T t) {
        if (head.value == t) {
            return head;
        }
        if (head.previous == t){
            return head.previous;
        }
        if (!contains(t)) {
            throw new NoSuchElementException("No such element " + t);
        } else {
            Node<T> currentNode = head;
            while (currentNode.next != null){
                if(currentNode.next.value == t){
                    return currentNode.next;
                }
                currentNode = currentNode.next;
            }
        }
        throw new NoSuchElementException("No such element " + t);
    }

    public int size() {
        return this.size;
    }

    public T findById(int id) {
        int i = 0;
        Node<T> currentNode = head;
        if (id == 0) {
            return head.value;
        } else if (id == size - 1) {
            return last.value;
        } else if (id < 0 || id >= size) {
            throw new IllegalArgumentException("ID must be between " + 0 + " and " + (size - 1));
        } else {
            while (currentNode.next != null) {
                i++;
                if (i == id) {
                    return currentNode.next.value;
                }
                currentNode = currentNode.next;
            }
        }
        return null;
    }

    public void editExisting(T t, T e) {
        if (head.value == t) {
            head.value = e;
            return;
        }
        if(!contains(t)){
            throw new IllegalArgumentException("No such element " + t);
        }
        Node<T> currentNode = head;
        while (currentNode.next != null) {
            if (currentNode.next.value == t) {
                currentNode.next.value = e;
                return;
            }
            currentNode = currentNode.next;
        }
    }

    public void add(int id, T t) {
        Node<T> currentNode = new Node<>(t);
        if (id == 0) {
            head.previous = currentNode;
            currentNode.next = head;
            head = currentNode;
            return;
        }
        if (id == size - 1) {
            last.next = currentNode;
            currentNode.previous = last;
            last = currentNode;
            return;
        }
        currentNode = head;
        int i = 0;
        if (!contains(t)) {
            Node<T> node = new Node<>(t);
            while (currentNode.next != null) {
                i++;
                if (i == id) {
                    Node<T> temp = currentNode.next;
                    temp.next = node;
                    node.previous = temp;
                    node.next = temp.next.next;
                    temp.next.next.previous = node;
                }
            }
        }
    }

    public void setById(int id, T t) {
        if (id < 0 || id > (size - 1)) {
            throw new IllegalArgumentException("Invalid id value");
        }
        if(contains(t)){
            if(findById(id) == t || findById(id).equals(t)) {
                editExisting(findById(id), t);
            } else {
                int i = 0;
                Node<T> currentNode = head;
                while (currentNode.next != null) {
                    i++;
                    if (i == id) {
                        currentNode.next = currentNode.next.next;

                    }
                }
            }
        }
    }

    public boolean contains(T t) {
        Node<T> currentNode = head;
        if (currentNode.value == t) {
            return true;
        }
        if (currentNode == null) {
            return false;
        }
        while (currentNode.next != null) {
            if (currentNode.next.value == t) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    @Override
    public String toString() {
        if (head == null || this.size == 0) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            Node<T> currentNode = head;
            while (currentNode.next != null) {
                sb.append(currentNode.value);
                sb.append(", ");
                currentNode = currentNode.next;
            }
            sb.append(currentNode.value);
            sb.append("]");
            return sb.toString();
        }
    }

    public static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> previous;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", prev=" + previous + "}";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(value, node.value) && Objects.equals(next, node.next) && Objects.equals(previous, node.previous);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, next, previous);
        }
    }
}
