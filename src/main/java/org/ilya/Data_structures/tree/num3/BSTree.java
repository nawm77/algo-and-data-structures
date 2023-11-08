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
        tree.print(tree.getRoot());
        System.out.println(tree.contains(4));
        System.out.println(tree.search(3));
        tree.print(tree.getRoot());
        tree.toLinkedListByHash(tree.getRoot());
        tree.printList(tree.getRoot());
        tree = new BinarySearchTree<>();
        tree.insert(4);
        tree.insert(2);
        tree.insert(6);
        tree.insert(1);
        tree.insert(3);
        tree.insert(5);
        tree.insert(7);
        tree.toLinkedListSpiral(tree.getRoot());
        tree.printList(tree.getRoot());
    }
}
