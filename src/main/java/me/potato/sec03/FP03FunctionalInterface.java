package me.potato.sec03;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class FP03FunctionalInterface {


    public static void main(String[] args) {
        var numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        Predicate<Integer> isEven = number -> number % 2 == 0;
        var isEven2 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer number) {
                return number % 2 == 0;
            }
        };
//
//
//        Function<Integer, Integer> square = number -> number * number;
//        var square2 = new Function<Integer, Integer>() {
//            @Override
//            public Integer apply(Integer number) {
//                return number * number;
//            }
//        };
//
//        Consumer<Integer> sysoutPrintln = System.out::println;
//        var sysoutPrintln2 = new Consumer<Integer>() {
//            @Override
//            public void accept(Integer number) {
//                System.out.println(number);
//            }
//        };


//        numbers
//                .stream()
//                .filter(isEven)
//                .filter(isEven2)
//                .map(square)
//                .map(square2)
//                .forEach(sysoutPrintln2);

//        BinaryOperator<Integer> sumBinaryOperator = Integer::sum;
        BinaryOperator<Integer> sumBinaryOperator = (integer, integer2) -> integer + integer2;

        int sum = numbers
                .stream()
                .reduce(0, sumBinaryOperator);
        System.out.println(sum);

    }
}
