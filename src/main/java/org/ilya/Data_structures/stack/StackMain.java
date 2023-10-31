package org.ilya.Data_structures.stack;

public class StackMain {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        for(int i : stack){
            System.out.println(i);
        }
        System.out.println(stack.iterator().hasNext());
        System.out.println(stack.iterator().next());
        System.out.println("Stack size: " + stack.size());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Stack size after pops: " + stack.size());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Search: " + stack.search(1));
    }
}