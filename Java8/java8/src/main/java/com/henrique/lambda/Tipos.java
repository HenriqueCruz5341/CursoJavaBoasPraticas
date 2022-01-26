package com.henrique.lambda;

import java.util.stream.IntStream;

public class Tipos {
    public static void main(String[] args) {
        // PARÊNTESES
        IntStream.range(0, 5).filter((n) -> n % 2 == 0).forEach(System.out::println);

        IntStream.range(0, 5).filter((int n) -> n % 2 == 0).forEach(System.out::println);

        IntStream.range(0, 5).reduce((n1, n2) -> n1 + n2).ifPresent(System.out::println);

        Runnable r = () -> System.out.println("Hello World");
        r.run();

        // CHAVES
        IntStream.range(0, 5).filter((n) -> {
            System.out.println("Executando o filtro");
            return n % 2 == 0;
        }).forEach(n -> System.out.println(n));
    }
}
