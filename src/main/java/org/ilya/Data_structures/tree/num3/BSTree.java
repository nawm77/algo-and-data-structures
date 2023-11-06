package org.ilya.Data_structures.tree.num3;

public class BSTree {
    public static void main(String[] args) {
        AbstractBinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(4);
        tree.insert(2);
        tree.insert(6);
        tree.insert(1);
        tree.insert(3);
        tree.insert(5);
        tree.insert(7);
        System.out.println(tree);
        System.out.println(tree.contains(4));
        System.out.println(tree.search(3));
        tree.print(tree.getRoot());
        tree.toLinkedListByHash(tree.getRoot());
        tree.printDoublyLinkedList(tree.getRoot());
        AbstractBinarySearchTree<Integer> tree1 = new BinarySearchTree<>();
        tree1.insert(4);
        tree1.insert(2);
        tree1.insert(6);
        tree1.insert(1);
        tree1.insert(3);
        tree1.insert(5);
        tree1.insert(7);
        tree1.toLinkedListSpiral(tree1.getRoot());
        tree1.printDoublyLinkedList(tree1.getRoot());
    }
}
