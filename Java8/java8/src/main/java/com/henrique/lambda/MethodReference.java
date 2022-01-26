package com.henrique.lambda;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class MethodReference {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.stream().forEach(System.out::println); // <-- Method reference

        // MÉTODOS ESTÁTICOS
        list.stream().map(MethodReference::multipliquePorDois).forEach(System.out::println);

        // CONSTRUTORES
        list.stream().map(BigDecimal::new).forEach(System.out::println);

        // VÁRIAS INSTÂNCIAS
        list.stream().map(Integer::doubleValue).forEach(System.out::println);

        // ÚNICA INSTÂNCIA
        BigDecimal dois = new BigDecimal(2);
        list.stream().map(BigDecimal::new).map(dois::multiply).forEach(System.out::println);
    }

    private static Integer multipliquePorDois(Integer n) {
        return n * 2;
    }
}
