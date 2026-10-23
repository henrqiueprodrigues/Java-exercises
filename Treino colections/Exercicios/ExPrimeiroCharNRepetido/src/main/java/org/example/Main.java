package org.example;


import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    static void main() {
        String palavra = "redividera";
        Map<Character, Long> mapa = new LinkedHashMap<>();
        mapa.
        for (Character c : palavra.toCharArray()) {
            mapa.put(c, mapa.getOrDefault(c, 0L) + 1);
        }

        System.out.println(mapa.entrySet().stream().filter(e -> e.getValue().equals(1L)).findFirst().orElse(null));
    }
}
