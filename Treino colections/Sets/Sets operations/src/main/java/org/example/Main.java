package org.example;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        HashSet<String> set = new HashSet<>();
        set.add("1234567890");
        set.add("0987654321");
        set.add("11111111111");
        set.add("00000000000");

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("1234567890");
        linkedHashSet.add("0987654321");
        linkedHashSet.add("11111111111");
        linkedHashSet.add("00000000000");

        TreeSet<String> treeSet = new TreeSet<>(set);

        System.out.println("\nHASHSET:");
        printSet(set);

        System.out.println("\nLINKEDHASHSET:");
        printSet(linkedHashSet);

        System.out.println("\nTREESET:");
        printSet(treeSet);

        set.remove("11111111111");
        System.out.println("\nContains 1234567890?\n" + set.contains("1234567890"));
        System.out.println("Contains 11111111111?\n" + set.contains("11111111111"));
        System.out.println("QTD CPFs: " + set.size());
    }

    public static void printSet(Set<String> set) {
        for (String s : set) {
            System.out.println(s);
        }
    }
}
