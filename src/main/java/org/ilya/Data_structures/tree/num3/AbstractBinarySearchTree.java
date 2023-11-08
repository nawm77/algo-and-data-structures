package org.ilya.Data_structures.tree.num3;

public interface AbstractBinarySearchTree <E extends Comparable<E>>{
    class Node<E> {
        public E value;
        public Node<E> leftChild;
        public Node<E> rightChild;

        public Node(E value) {
            this.value= value;
        }

        public Node(E value, Node<E>leftChild, Node<E>rightChild) {
            this.value= value;
            this.leftChild= leftChild;
            this.rightChild= rightChild;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", leftChild=" + leftChild +
                    ", rightChild=" + rightChild +
                    '}';
        }
    }
    void insert(E element);
    boolean contains(E element);
    AbstractBinarySearchTree<E>search(E element);
    Node<E>getRoot();
    Node<E>getLeft();
    Node<E>getRight();
    E getValue();
    void print(Node<E> root);
    void toLinkedListByHash(Node<E> root);
    void printList(Node<E> node);
    void toLinkedListSpiral(Node<E> root);
    Node<E> getMin(Node<E> root);
    Node<E> getMax(Node<E> root);
}

