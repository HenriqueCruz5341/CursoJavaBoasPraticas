package com.henrique.optional;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // String s = "Hello World";
        String s = "1";
        Optional<Integer> numero = converteEmNumero(s);
        numero.ifPresent(n -> System.out.println(n));

        Integer orElse = converteEmNumero(s).orElse(2);
        System.out.println(orElse);

        Integer orElseGet = converteEmNumero(s).orElseGet(() -> funcaoPesada());
        System.out.println(orElseGet);

        Integer orElseThrow = converteEmNumero(s).orElseThrow(() -> new RuntimeException("Erro"));
        System.out.println(orElseThrow);

        Stream.of(1, 2, 3).findFirst().ifPresent(System.out::println);

        int optionalInt = converteEmNumero2(s).orElseThrow(() -> new RuntimeException("Erro"));
        System.out.println(optionalInt);
    }

    public static Optional<Integer> converteEmNumero(String numeroString) {
        try {
            return Optional.of(Integer.valueOf(numeroString));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public static OptionalInt converteEmNumero2(String numeroString) {
        try {
            return OptionalInt.of(Integer.valueOf(numeroString));
        } catch (NumberFormatException e) {
            return OptionalInt.empty();
        }
    }

    public static Integer funcaoPesada() {
        return 2 + 2;
    }
}
