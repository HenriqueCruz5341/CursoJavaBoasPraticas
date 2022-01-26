package com.henrique.lambda;

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

public final class Main {

    public static void main(String[] args) {

        // ########################################################
        // 1
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        }).run();

        new Thread(() -> System.out.println("Hello World!")).run();

        // ########################################################
        // 2
        JButton button = new JButton("Click me!");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hello World!");
            }
        });

        JButton button2 = new JButton("Click me!");
        button2.addActionListener(e -> System.out.println("Hello World!"));

        // ########################################################
        // 3
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        list.stream()
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer n) {
                        return n % 2 == 0;
                    }
                })
                .forEach(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer n) {
                        System.out.println(n);
                    }
                });

        List<Integer> list2 = Arrays.asList(1, 2, 3, 4);
        list2.stream()
                .filter(n -> n % 2 == 0)
                .forEach(n -> System.out.println(n));

    }
}
