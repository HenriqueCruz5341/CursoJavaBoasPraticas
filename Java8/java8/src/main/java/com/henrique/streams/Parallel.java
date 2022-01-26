package com.henrique.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Parallel {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        list.parallelStream();
        IntStream.range(0, 5).parallel();

        list.parallelStream().forEach(System.out::println);
        list.parallelStream().forEachOrdered(System.out::println);

        list.parallelStream().findAny().ifPresent(System.out::println);
        list.stream().findAny().ifPresent(System.out::println);

        list.parallelStream().unordered().skip(1).limit(2).forEach(System.out::println);

        Map<Integer, Boolean> map = list.parallelStream()
                .collect(Collectors.toConcurrentMap(n -> n, n -> n % 2 == 0)); // concurrent pode perder a ordem
        System.out.println(map);

        Map<Boolean, List<Integer>> map1 = list.parallelStream()
                .collect(Collectors.groupingByConcurrent(n -> n % 2 == 0)); // concurrent pode perder a ordem
        System.out.println(map1);
    }

}