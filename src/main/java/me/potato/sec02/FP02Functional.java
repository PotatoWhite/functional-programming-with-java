package me.potato.sec02;

import java.util.List;
import java.util.function.BinaryOperator;

public class FP02Functional {
    public static void main(String[] args) {
        var numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        int sum     = addListFunctional(numbers);
        System.out.println(sum);

        var doubleNumbers   = squaredList(numbers);
        var evenNumbersOnly = numbers.stream().filter(x -> x % 2 == 0).toList();
        var oddNumbersOnly  = numbers.stream().filter(x -> x % 2 != 0).toList();
        var distinctNumbers = numbers.stream().distinct().toList();
    }

    private static List<Integer> squaredList(List<Integer> numbers) {
        return numbers.stream().map(x -> x * x).toList();
    }

    private static int addListFunctional(List<Integer> numbers) {
        BinaryOperator<Integer> accumulator = (aggregate, nextNumber) -> {
            System.out.println(aggregate + " " + nextNumber);
            return Integer.sum(aggregate, nextNumber);
        };

        return numbers.stream().reduce(0, accumulator);
    }
}