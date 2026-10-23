package org.example;

import java.util.HashSet;
import java.util.Set;

public class Main {

    static void main(String[] args) {
        String frase = "o rato roeu a roupa do reis de roma";
        char[] chars = frase.replaceAll("\\s", "").toCharArray();

        Set<Character> setChars = new HashSet<>();
        Set<Character> repetidos = new HashSet<>();

        for (char c : chars) {
            if (!setChars.add(c)) {
                repetidos.add(c);
            }
        }

        setChars.forEach(System.out::println);

        System.out.println("\nRepetidos:");
        repetidos.forEach(System.out::println);
        
        System.out.println("\nChars unicos:");
        setChars.removeAll(repetidos);
        setChars.forEach(System.out::println);

    }
}
