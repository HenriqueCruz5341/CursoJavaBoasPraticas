package com.henrique.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;

public class Reduce {
    public static void main(String[] args) {
        String s = "Fui ontem na feira e não sabia o que comprar";
        List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> listaString = Arrays.asList(s.split(" "));
        List<Integer> listaVazia = Arrays.asList();

        // ASSOCIATIVO
        // SOMA
        Optional<Integer> resultado = lista.stream()
                .reduce((a, b) -> a + b);
        System.out.println(resultado.get());

        // MULTIPLICAÇÃO
        Optional<Integer> resultado2 = lista.stream()
                .reduce((a, b) -> a * b);
        System.out.println(resultado2.get());

        // CONCATENAÇÃO
        Optional<String> resultado3 = listaString.stream()
                .reduce((a, b) -> a + b);
        System.out.println(resultado3.get());

        // NÃO ASSOCIATIVO (NÃO USAR PARALELIZAÇÃO)
        // SUBTRAÇÃO
        Optional<Integer> resultado4 = lista.stream()
                .reduce((a, b) -> a - b);
        System.out.println(resultado4.get());

        // IDENTIDADE
        // SOMA
        Integer resultado5 = listaVazia.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println(resultado5);

        // MULTIPLICAÇÃO
        Integer resultado6 = lista.stream()
                .reduce(1, (a, b) -> a * b);
        System.out.println(resultado6);

        // CONCATENAÇÃO
        String resultado7 = listaString.stream()
                .reduce("", (a, b) -> a + b);
        System.out.println(resultado7);

        // MENOR VALOR
        double resultado8 = DoubleStream.of(1.5, 2.6, 3.7, 4.8, 5.9, 6.0)
                .reduce(Double.MAX_VALUE, (a, b) -> Math.min(a, b));
        System.out.println(resultado8);

        // COMBINADORES
        // SOMA
        Integer resultado9 = lista.stream().parallel()
                .reduce(0, (a, b) -> a + b, (a, b) -> a + b);
        System.out.println(resultado9);

        // MAP + COMBINER
        String resultado10 = lista.stream()
                .parallel()
                .reduce(
                        "",
                        (n1, n2) -> n1.toString().concat(n2.toString()),
                        (n1, n2) -> n1.concat(n2));
        System.out.println(resultado10);
    }
}
