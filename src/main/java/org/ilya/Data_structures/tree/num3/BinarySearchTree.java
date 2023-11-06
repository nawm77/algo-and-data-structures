package org.ilya.Data_structures.tree.num3;

import java.util.*;

public class BinarySearchTree<E extends Comparable<E>> implements AbstractBinarySearchTree<E> {
    private Node<E> root;

    @Override
    public void insert(E element) {
        root = insertRec(root, element);
    }

    private Node<E> insertRec(Node<E> root, E element) {
        if (root == null) {
            return new Node<>(element);
        }
        if (element.compareTo(root.value) < 0) {
            root.leftChild = insertRec(root.leftChild, element);
        } else if (element.compareTo(root.value) > 0) {
            root.rightChild = insertRec(root.rightChild, element);
        }
        return root;
    }

    @Override
    public boolean contains(E element) {
        return search(element) != null;
    }

    @Override
    public AbstractBinarySearchTree<E> search(E element) {
        Node<E> node = searchRec(root, element);
        if (node == null) {
            return null;
        }
        BinarySearchTree<E> tree = new BinarySearchTree<>();
        tree.root = node;
        return tree;
    }

    private Node<E> searchRec(Node<E> root, E element) {
        if (root == null || root.value.equals(element)) {
            return root;
        }

        if (element.compareTo(root.value) < 0) {
            return searchRec(root.leftChild, element);
        } else {
            return searchRec(root.rightChild, element);
        }
    }

    @Override
    public Node<E> getRoot() {
        return root;
    }

    @Override
    public Node<E> getLeft() {
        return root != null ? root.leftChild : null;
    }

    @Override
    public Node<E> getRight() {
        return root != null ? root.rightChild : null;
    }

    @Override
    public E getValue() {
        return root != null ? root.value : null;
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                '}';
    }

    @Override
    public void toLinkedListByHash(Node<E> root) {
        Map<Integer, Deque<Node<E>>> map = new HashMap<>();
        preOrder(root, 0, map);
        Node<E> head = null;
        for (int i = map.size()-1; i >=0; i--) {
            for (Node<E> node : map.get(i)) {
                head = push(node, head);
            }
        }
    }

    @Override
    public void printDoublyLinkedList(Node<E> node) {
        while (node != null) {
            System.out.print(node.value + " —> ");
            node = node.rightChild;
        }
        System.out.println("null");
    }

    private Node<E> push(Node<E> node, Node<E> head) {
        if (head == null) {
            head = node;
            head.leftChild = null;
            head.rightChild = null;
            return head;
        }
        head.leftChild = node;
        node.rightChild = head;
        node.leftChild = null;
        head = node;
        return head;
    }

    private void preOrder(Node<E> node, Integer level, Map<Integer, Deque<Node<E>>> map) {
        if (node == null) {
            return;
        }
        map.putIfAbsent(level, new ArrayDeque<>());
        if (level % 2 == 0) {
            map.get(level).addFirst(node);
        } else {
            map.get(level).addLast(node);
        }
        preOrder(node.leftChild, level + 1, map);
        preOrder(node.rightChild, level + 1, map);
    }

    @Override
    public void print(Node<E> root) {
        List<List<String>> lines = new ArrayList<>();
        List<Node<E>> level = new ArrayList<>();
        List<Node<E>> next = new ArrayList<>();
        level.add(root);
        int nn = 1;
        int widest = 0;
        while (nn != 0) {
            List<String> line = new ArrayList<>();
            nn = 0;
            for (Node<E> n : level) {
                if (n == null) {
                    line.add(null);
                    next.add(null);
                    next.add(null);
                } else {
                    String aa = n.value.toString();
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();
                    next.add(n.leftChild);
                    next.add(n.rightChild);
                    if (n.leftChild != null) nn++;
                    if (n.rightChild != null) nn++;
                }
            }
            if (widest % 2 == 1) widest++;
            lines.add(line);
            List<Node<E>> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perpiece = lines.get(lines.size() - 1).size() * (widest + 2);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) - 1;
            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '┴' : '┘';
                        } else {
                            if (j < line.size() && line.get(j) != null) c = '└';
                        }
                    }
                    System.out.print(c);
                    if (line.get(j) == null) {
                        for (int k = 0; k < perpiece - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? " " : "─");
                        }
                        System.out.print(j % 2 == 0 ? "┌" : "┐");
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "─" : " ");
                        }
                    }
                }
                System.out.println();
            }
            for (int j = 0; j < line.size(); j++) {
                String f = line.get(j);
                if (f == null) f = "";
                int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);
                for (int k = 0; k < gap1; k++) {
                    System.out.print(" ");
                }
                System.out.print(f);
                for (int k = 0; k < gap2; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            perpiece /= 2;
        }
    }

    @Override
    public void toLinkedListSpiral(Node<E> root) {
        if (root == null) {
            return;
        }
        Deque<Node<E>> deque = new ArrayDeque<>();
        Stack<Node<E>> stack = new Stack<>();
        deque.addFirst(root);
        boolean isEven = true;
        while (!deque.isEmpty()) {
            int nodeCount = deque.size();
            if (isEven) {
                while (nodeCount > 0) {
                    Node<E> current = deque.pollFirst();
                    if (current.leftChild != null) {
                        deque.addLast(current.leftChild);
                    }
                    if (current.rightChild != null) {
                        deque.addLast(current.rightChild);
                    }
                    stack.push(current);
                    nodeCount--;
                }
            }
            else {
                while (nodeCount > 0) {
                    Node<E> current = deque.pollLast();
                    if (current.rightChild != null) {
                        deque.addFirst(current.rightChild);
                    }
                    if (current.leftChild != null) {
                        deque.addFirst(current.leftChild);
                    }
                    stack.push(current);
                    nodeCount--;
                }
            }
            isEven = !isEven;
        }
        Node<E> head = null;
        while(!stack.empty()) {
            head = push(stack.pop(), head);
        }
    }
}
