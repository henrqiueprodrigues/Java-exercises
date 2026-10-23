package org.example.CharsInString;

import java.util.HashMap;
import java.util.Map;

public class Main2 {

    static void main(String[] args) {
        String frase = "O rato roeu a roupa do rei de roma";
        char[] characters = frase.replaceAll("\\s","").toCharArray();
        Map<Character, Integer> mapa = new HashMap<>();

        for (Character chars : characters) {
            if (mapa.containsKey(chars)) {
                mapa.put(chars, mapa.get(chars) + 1);
            } else {
                mapa.put(chars, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : mapa.entrySet()) {
            System.out.println("Letra: " + entry.getKey() + " Frequencia: " + entry.getValue());
        }

    }
}