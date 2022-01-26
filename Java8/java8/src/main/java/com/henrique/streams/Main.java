package com.henrique.streams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Pessoa {
    public String nome;
    public int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        List<Integer> lista = List.of(1, 5, 8, 9, 1, 4, 7, 6, 6, 9, 9);

        // CRIAÇÃO
        // COLLECTIONS
        lista.stream().forEach(System.out::println);
        lista.parallelStream().forEach(System.out::println);

        // ARRAYS
        Integer[] array = { 1, 5, 8, 9, 1, 4, 7, 6, 6, 9, 9 };
        Arrays.stream(array).forEach(System.out::println);

        // Stream.Of
        Pessoa pessoa = new Pessoa("Henrique", 21);
        Stream.of(pessoa, lista, array, "Hello", 2).forEach(System.out::println);

        // IntStream.range
        IntStream.range(0, 6).forEach(System.out::println);

        // Stream.iterate
        Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);

        // BufferedReader.lines
        File file = new File("streams.txt");
        FileReader fileReader = new FileReader(file);
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            bufferedReader.lines().forEach(System.out::println);
        }

        // FILES
        Path p = Paths.get("");
        Files.list(p).forEach(System.out::println);

        // RANDOM
        new Random().ints().limit(5).forEach(System.out::println);

        // PATTERN
        String s = "Gosto muito de batata";
        Pattern pattern = Pattern.compile(" ");
        pattern.splitAsStream(s).forEach(System.out::println);

        // OPERADORES
        // INTERMEDIÁRIOS
        lista.stream().skip(2).filter(n -> n % 2 == 0).limit(5).distinct().forEach(n -> System.out.println(n));

        lista.stream().map(e -> e * 2).forEach(System.out::println);

        // FINAIS
        long count = lista.stream().filter(n -> n % 2 == 0).distinct().count();
        System.out.println("Count: " + count);

        Optional<Integer> min = lista.stream().min(Comparator.naturalOrder());
        System.out.println("Min: " + min.get());

        Optional<Integer> max = lista.stream().max(Comparator.naturalOrder());
        System.out.println("Max: " + max.get());

        List<Integer> novaLista = lista.stream().sorted().map(n -> n + 2).collect(Collectors.toList());
        System.out.println("Nova Lista: " + novaLista);

        Map<Boolean, List<Integer>> mapa = lista.stream().sorted(Comparator.reverseOrder()).map(n -> n + 2)
                .collect(Collectors.groupingBy(n -> n % 2 == 0));
        System.out.println("Mapa: " + mapa);

        String collect = lista.stream().map(n -> n + "").collect(Collectors.joining(", "));
        System.out.println("Collect: " + collect);
    }
}
