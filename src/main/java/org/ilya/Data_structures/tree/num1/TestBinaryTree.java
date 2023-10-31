package org.ilya.Data_structures.tree.num1;

public class TestBinaryTree {
    public static void main(String[] args) {
        AbstractBinaryTree<Integer> tree = new BinaryTree<>(1);
        AbstractBinaryTree<Integer> tree1 = new BinaryTree<>(3);
        AbstractBinaryTree<Integer> tree2 = new BinaryTree<>(2, tree, tree1);

        AbstractBinaryTree<Integer> tree3 = new BinaryTree<>(5);
        AbstractBinaryTree<Integer> tree4 = new BinaryTree<>(7);
        AbstractBinaryTree<Integer> tree5 = new BinaryTree<>(6, tree3, tree4);

        AbstractBinaryTree<Integer> mainTree = new BinaryTree<>(4, tree2, tree5);

        System.out.println("PreOrder: " + mainTree.preOrder());
        System.out.println("InOrder: " + mainTree.inOrder());
        System.out.println("PostOrder: " + mainTree.postOrder());

        System.out.println("Tree structure:");
        System.out.println(mainTree.asIndentedPreOrder(1));

        System.out.println("InOrder traversal:");
        mainTree.forEachInOrder(element -> System.out.print(element + " "));
        System.out.println();
        mainTree.printTree(mainTree);
    }
}
