package org.example;

import java.util.*;

public class Main {
    private static final Map<String ,String> mapTelefones = new HashMap<String ,String>();

    static void main(String[] args) {

        mapTelefones.put("Joao","123456");
        mapTelefones.put("Maria","654321");
        mapTelefones.put("Juan","123654");
        printMap(mapTelefones);

        System.out.println("\nRemove Joao:");
        mapTelefones.remove("Joao");
        printMap(mapTelefones);

        System.out.println("\nBuscar teelfone Maria:\n" + buscarTelefone("Maria"));

        System.out.println("\nTrocar numero Maria");
        mapTelefones.put("Maria","1234567890");
        printMap(mapTelefones);

        System.out.println("\nMapa contem Maria?\n" + mapTelefones.containsKey("Maria"));

        System.out.println("\nMapa contem numero 123456?\n" + mapTelefones.containsValue("123456"));

        System.out.println("\nBusca parcial usando for:");
        buscaPorNomeParcialFor("Ma");

        System.out.println("\nBusca parcial usando for:");
        buscaPorNomeParcialFor("Ma");

        System.out.println("\nBusca parcial usando stream:");
        mapTelefones.put("Ana","0987654321");
        buscaPorNomeParcialStream("an");

        System.out.println("\nMapa usando for:");
        createMapByStringFor("java é muito bom e java é muito poderoso");

        System.out.println("\nMapa usando stream:");
        createMapByStringStream("java é muito bom e java é muito poderoso");
    }

    public static void printMap(Map<?,?> map) {
        for (Map.Entry<?,?> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }

    public static String buscarTelefone(String nome) {
        return  mapTelefones.get(nome);
    }

    public static void buscaPorNomeParcialFor(String nomeParcial) {

        for (Map.Entry<String,String> entry : mapTelefones.entrySet()) {
            if (entry.getKey().toLowerCase(Locale.ROOT).contains(nomeParcial.toLowerCase(Locale.ROOT))) {
                System.out.println(entry.getKey() + " => " + entry.getValue());
            }
        }
    }

    public static void buscaPorNomeParcialStream(String nomeParcial) {
        mapTelefones.entrySet().stream().filter(entry -> entry.getKey().toLowerCase(Locale.ROOT).contains(nomeParcial.toLowerCase(Locale.ROOT))).forEach(entry -> System.out.println(entry.getKey() + " => " + entry.getValue()));
    }

    public static void createMapByStringFor(String string) {
        Map<String, Integer> map = new HashMap<>();
        String[] parts = string.split(" ");
        for (String part : parts) {
            if(map.containsKey(part)) {
                map.put(part, map.get(part) + 1);
            }
            else {
                map.put(part, 1);
            }
        }
        System.out.println("Frequência das palavras:");
        printMap(map);
    }

    public static void createMapByStringStream(String string) {
        Map<String, Integer> map = new HashMap<>();
        String[] parts = string.split(" ");
        Arrays.stream(parts).toList().forEach(part -> map.put(part, map.getOrDefault(part, 0) + 1));
        System.out.println("Frequência das palavras:");
        printMap(map);
    }
}
