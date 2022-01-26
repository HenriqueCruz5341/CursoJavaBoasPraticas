package com.henrique.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // LIST
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.forEach(System.out::println);
        list.removeIf(n -> n % 2 == 0);
        list.forEach(System.out::println);
        list.replaceAll(n -> n * 2);
        list.forEach(System.out::println);

        // HASHMAP
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "Henrique");
        map.put(1, "Gosta");
        map.put(2, "De");
        map.put(3, "Empadão");

        map.forEach((k, v) -> System.out.println(k + ": " + v));
        map.compute(1, (k, v) -> v + " muito"); // passando uma chave inexistente, ele cria com null
        map.forEach((k, v) -> System.out.println(k + ": " + v));
        map.merge(3, "!", (v1, v2) -> v1 + v2); // passando uma chave inexistente, ele cria
        map.forEach((k, v) -> System.out.println(k + ": " + v));
        map.replaceAll((k, v) -> v.toUpperCase());
        map.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
