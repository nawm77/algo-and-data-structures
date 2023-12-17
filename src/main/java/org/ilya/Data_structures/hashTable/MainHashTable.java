package org.ilya.Data_structures.hashTable;

public class MainHashTable {
    public static void main(String[] args) {
        HashTable<String, Integer> table = new HashTable<>();
        table.add("Q", 1);
        System.out.println(table.iterator().next());
    }
}
