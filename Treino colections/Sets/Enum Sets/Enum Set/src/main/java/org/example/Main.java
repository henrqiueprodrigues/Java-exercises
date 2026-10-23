package org.example;

import java.util.EnumSet;
import java.util.Set;

enum notebook {TECNOLOGIA, COMPUTADOR, ELETRÔNICO}

enum Produto {JAVA, BACKEND, PROGRAMACAO, FRONTEND, SPRING}

public class Main {
    public static void main(String[] args) {

        //Cria set vazio
        EnumSet<notebook> notebooks = EnumSet.noneOf(notebook.class);
        notebooks.add(notebook.TECNOLOGIA);
        notebooks.add(notebook.COMPUTADOR);
        notebooks.add(notebook.ELETRÔNICO);
        printSet(notebooks);

        //Cria set com todos os valores
        EnumSet<notebook> notebooks2 = EnumSet.allOf(notebook.class);
        System.out.println("\nEquals?\n" + notebooks.equals(notebooks2));
        System.out.println("Notebook2:");

        notebooks.remove(notebook.TECNOLOGIA);
        System.out.println("\nRemove tecnologia:");
        printSet(notebooks);

        System.out.println("\nContains computador?\n" + notebooks.contains(notebook.COMPUTADOR));

        EnumSet<Produto> produtoA = EnumSet.of(Produto.JAVA, Produto.BACKEND, Produto.PROGRAMACAO);
        EnumSet<Produto> produtoB = EnumSet.of(Produto.JAVA, Produto.FRONTEND, Produto.PROGRAMACAO);
        EnumSet<Produto> produtoC = EnumSet.of(Produto.JAVA, Produto.BACKEND, Produto.SPRING);

        System.out.println("\nTags iguais A e B:");
        EnumSet<Produto> tagsIguaisA_B =  EnumSet.copyOf(produtoA);
        tagsIguaisA_B.retainAll(produtoB);
        printSet(tagsIguaisA_B);

        System.out.println("\nTags exclusivas de A:");
        EnumSet<Produto> tagsExclusivasA = EnumSet.copyOf(produtoA);
        tagsExclusivasA.removeAll(produtoB);
        printSet(tagsExclusivasA);
    }

    public static void printSet(Set<?> set){
        for(Object item : set){
            System.out.println(item);
        }
    }
}
