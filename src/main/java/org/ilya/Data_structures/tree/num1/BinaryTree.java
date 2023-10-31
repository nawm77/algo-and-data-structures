//package org.ilya.Data_structures.tree.num1;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.function.Consumer;
//
//public class BinaryTree<E> implements AbstractBinaryTree<E> {
//    public E key;
//    public AbstractBinaryTree<E> left;
//    public AbstractBinaryTree<E> right;
//
//    public BinaryTree() {
//    }
//
//    public BinaryTree(E key) {
//        this.key = key;
//        this.left = null;
//        this.right = null;
//    }
//
//    @Override
//    public E getKey() {
//        return key;
//    }
//
//    @Override
//    public AbstractBinaryTree<E> getLeft() {
//        return left;
//    }
//
//    @Override
//    public AbstractBinaryTree<E> getRight() {
//        return right;
//    }
//
//    @Override
//    public void setKey(E key) {
//        this.key = key;
//    }
//
//    @Override
//    public String asIndentedPreOrder(int indent) {
//        StringBuilder treeString = new StringBuilder();
//        treeString.append("  ".repeat(indent));
//        treeString.append(key.toString());
//        treeString.append("\n");
//
//        if (left != null) {
//            treeString.append(left.asIndentedPreOrder(indent + 1));
//        }
//        if (right != null) {
//            treeString.append(right.asIndentedPreOrder(indent + 1));
//        }
//
//        return treeString.toString();
//    }
//
//    @Override
//    public List<AbstractBinaryTree<E>> preOrder() {
//        List<AbstractBinaryTree<E>> result = new ArrayList<>();
//        result.add(this);
//        if (left != null) {
//            result.addAll(left.preOrder());
//        }
//        if (right != null) {
//            result.addAll(right.preOrder());
//        }
//        return result;
//    }
//
//    @Override
//    public List<AbstractBinaryTree<E>> inOrder() {
//        List<AbstractBinaryTree<E>> result = new ArrayList<>();
//        if (left != null) {
//            result.addAll(left.inOrder());
//        }
//        result.add(this);
//        if (right != null) {
//            result.addAll(right.inOrder());
//        }
//        return result;
//    }
//
//    @Override
//    public List<AbstractBinaryTree<E>> postOrder() {
//        List<AbstractBinaryTree<E>> result = new ArrayList<>();
//        if (left != null) {
//            result.addAll(left.postOrder());
//        }
//        if (right != null) {
//            result.addAll(right.postOrder());
//        }
//        result.add(this);
//        return result;
//    }
//
//    @Override
//    public void forEachInOrder(Consumer<E> consumer) {
//        if (left != null) {
//            left.forEachInOrder(consumer);
//        }
//        consumer.accept(key);
//        if (right != null) {
//            right.forEachInOrder(consumer);
//        }
//    }
//
//    @Override
//    public BinaryTree<E> add(E value) {
//        if (key == null) {
//            key = value;
//            return this;
//        } else if(left == null){
//            left = new BinaryTree<E>(value);
//            return this;
//        } else if (right == null) {
//            right = new BinaryTree<E>(value);
//            return this;
//        } else if (value instanceof Comparable) {
//            @SuppressWarnings("unchecked")
//            Comparable<E> comparableValue = (Comparable<E>) value;
//            int comparison = comparableValue.compareTo(key);
//            if (comparison < 0) {
//                if (left == null) {
//                    left = new BinaryTree<>(value);
//                } else {
//                    left.add(value);
//                }
//            } else if (comparison > 0) {
//                if (right == null) {
//                    right = new BinaryTree<>(value);
//                } else {
//                    right.add(value);
//                }
//            }
//        } else {
//            throw new IllegalArgumentException("Objects are not comparable");
//        }
//        return this;
//    }
//
//    @Override
//    public String toString() {
//        getTreeVisualization()
//    }
//    private String getTreeVisualization(int depth, char branchChar) {
//        StringBuilder treeString = new StringBuilder();
//        if (left != null) {
//            treeString.append(left.getTreeVisualization(depth + 1, '│'));
//        }
//        treeString.append("  ".repeat(depth));
//        treeString.append(branchChar);
//        treeString.append(key.toString());
//        treeString.append("\n");
//        if (right != null) {
//            treeString.append(right.getTreeVisualization(depth + 1, '│'));
//        }
//        return treeString.toString();
//    }
//}


package org.ilya.Data_structures.tree.num1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BinaryTree<E> implements AbstractBinaryTree<E> {
    public E key;
    public AbstractBinaryTree<E> left;
    public AbstractBinaryTree<E> right;

    public BinaryTree(E key){
        setKey(key);
    }

    public BinaryTree(E key, AbstractBinaryTree<E> left, AbstractBinaryTree<E> right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    @Override
    public E getKey() {
        return key;
    }

    @Override
    public AbstractBinaryTree<E> getLeft() {
        return left;
    }

    @Override
    public AbstractBinaryTree<E> getRight() {
        return right;
    }

    @Override
    public void setKey(E key) {
        if(key != null) {
            this.key = key;
        }
    }

    @Override
    public String asIndentedPreOrder(int indent) {
        StringBuilder treeString = new StringBuilder();
        treeString.append("  ".repeat(indent));
        treeString.append(key.toString());
        treeString.append("\n");

        if (left != null) {
            treeString.append(left.asIndentedPreOrder(indent + 1));
        }
        if (right != null) {
            treeString.append(right.asIndentedPreOrder(indent + 1));
        }

        return treeString.toString();
    }

    @Override
    public List<AbstractBinaryTree<E>> preOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        result.add(this);
        if (left != null) {
            result.addAll(left.preOrder());
        }
        if (right != null) {
            result.addAll(right.preOrder());
        }
        return result;
    }

    @Override
    public List<AbstractBinaryTree<E>> inOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        if (left != null) {
            result.addAll(left.inOrder());
        }
        result.add(this);
        if (right != null) {
            result.addAll(right.inOrder());
        }
        return result;
    }

    @Override
    public List<AbstractBinaryTree<E>> postOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        if (left != null) {
            result.addAll(left.postOrder());
        }
        if (right != null) {
            result.addAll(right.postOrder());
        }
        result.add(this);
        return result;
    }

    @Override
    public void forEachInOrder(Consumer<E> consumer) {
        if (left != null) {
            left.forEachInOrder(consumer);
        }
        consumer.accept(key);
        if (right != null) {
            right.forEachInOrder(consumer);
        }
    }

    @Override
    public String toString() {
        return this.getKey().toString();
    }
    @Override
    public void printTree(AbstractBinaryTree<E> root) {
        List<List<String>> lines = new ArrayList<>();
        List<AbstractBinaryTree<E>> level = new ArrayList<>();
        List<AbstractBinaryTree<E>> next = new ArrayList<>();
        level.add(root);
        int nn = 1;
        int widest = 0;
        while (nn != 0) {
            List<String> line = new ArrayList<>();
            nn = 0;
            for (AbstractBinaryTree<E> n : level) {
                if (n == null) {
                    line.add(null);

                    next.add(null);
                    next.add(null);
                } else {
                    String aa = n.getKey().toString();
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();
                    next.add(n.getLeft());
                    next.add(n.getRight());
                    if (n.getLeft() != null) nn++;
                    if (n.getRight() != null) nn++;
                }
            }
            if (widest % 2 == 1) widest++;
            lines.add(line);
            List<AbstractBinaryTree<E>> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }
        int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
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
            for (String f : line) {
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
}
