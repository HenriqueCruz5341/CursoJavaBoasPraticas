package com.henrique.streams;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Collect {
    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5, 6);

        // fornecedor - acumulação - combinação
        List<Integer> collect = lista.stream().collect(() -> new ArrayList<>(), (l, e) -> l.add(e),
                (l1, l2) -> l1.addAll(l2));
        System.out.println(collect);

        // toList
        List<Integer> collect2 = lista.stream().filter((n) -> n % 2 == 0).collect(Collectors.toList());
        System.out.println(collect2);

        Set<Integer> collect3 = lista.stream().limit(3).collect(Collectors.toSet());
        System.out.println(collect3);

        Deque<Integer> collect4 = lista.stream().skip(2).collect(Collectors.toCollection(() -> new ArrayDeque<>()));
        System.out.println(collect4);

        // joining
        String collect5 = lista.stream().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(collect5);

        // averaging
        Double collect6 = lista.stream().collect(Collectors.averagingInt(n -> n.intValue()));
        System.out.println(collect6);

        // summing
        Integer collect7 = lista.stream().collect(Collectors.summingInt(n -> n.intValue()));
        System.out.println(collect7);

        // summarizing
        IntSummaryStatistics summary = lista.stream().collect(Collectors.summarizingInt(n -> n.intValue()));
        System.out.println(summary.getAverage());
        System.out.println(summary.getCount());
        System.out.println(summary.getMax());
        System.out.println(summary.getMin());
        System.out.println(summary.getSum());

        // counting
        Long collect8 = lista.stream().collect(Collectors.counting());
        System.out.println(collect8);

        // max/min
        Optional<Integer> collect9 = lista.stream().collect(Collectors.maxBy(Comparator.naturalOrder()));
        collect9.ifPresent(System.out::println);

        // grouping
        Map<Integer, List<Integer>> collect10 = lista.stream().collect(Collectors.groupingBy(n -> n % 3));
        System.out.println(collect10);

        // partitioning
        Map<Boolean, List<Integer>> collect11 = lista.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(collect11);

        // mapping
        Map<Integer, Integer> collect12 = lista.stream().collect(Collectors.toMap(n -> n, n -> n * 2));
        System.out.println(collect12);
    }
}
