package org.example.MaoMethods;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MethodMain {

    public static void main (String [] args){
        Map<Integer, String> mapa1 = new HashMap<>();
        mapa1.put(1, "Ana");
        mapa1.put(2, "Beatriz");
        mapa1.put(3, "Clara");
        mapa1.put(4, "Danilo");
        mapa1.put(5, "Eduardo");

        printMap(mapa1);
        printMapMethod(mapa1);
        System.out.println();

        Map<Integer, String> treeMap = new TreeMap<>(mapa1);
        System.out.println("\nTree map:");
        printMap(treeMap);

        System.out.println("\nMapa1 equals treeMap? -> " + mapa1.equals(treeMap));

        treeMap.clear();
        System.out.println("\nFoi esvaziado? -> " + treeMap.isEmpty());
    }

    public static void printMap(Map<?, ?> map) {
        System.out.println("map by iterating");
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            System.out.println("\nChave = " + entry.getKey() + "\nNome = " + entry.getValue());
        }
    }

    public static void printMapMethod(Map<?, ?> map) {
        System.out.println("\nMap by method");
        map.forEach((key, value) -> System.out.println("\nChave = " + key + "\nNome = " + value));
    }

    public static void printValues(Map<?, ?> map) {
        map.values().forEach(System.out::println);
        Collection<?> collection = map.values();
    }
}
