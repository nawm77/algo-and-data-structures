package org.ilya;


import org.ilya.Data_structures.linkedlist.DoublyLinkedList;
import org.ilya.Data_structures.linkedlist.Minion;
import org.ilya.Data_structures.linkedlist.MinionAgeComparator;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Minion> list = new DoublyLinkedList<>();
        Minion tom = new Minion(12, "Tom", 1.74f);
        list.addFirst(tom);
        list.addLast(new Minion(13, "Nick", 1.7f));
        Minion john = new Minion(14, "John", 1.4f);
        list.addLast(john);
        list.addLast(new Minion(15, "Carl", 1.24f));
        list.addLast(new Minion(16, "Jack", 1.16f));
        Minion min = new Minion(11, "Minik", 0.76f);
        list.addLast(min);
//        System.out.println(list);
        System.out.println(list.getId(min));
        list.remove(tom);
//        System.out.println(list);
        System.out.println(list.getId(min));
        list.editExisting(john, new Minion(50, "Mike", 2.22f));
//        System.out.println(list);
        try {
            list.editExisting(new Minion(1, "M", 2.23f), new Minion(50, "Mike", 2.22f));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        for(Minion i : list){
            System.out.println(i);
        }
        MinionAgeComparator minionAgeComparator = new MinionAgeComparator();
        System.out.println(minionAgeComparator.compare(john, min));
    }
}