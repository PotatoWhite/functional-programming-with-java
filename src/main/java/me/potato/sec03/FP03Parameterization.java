package me.potato.sec03;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03Parameterization {

    public static void main(String[] args) {
        var numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        filterAndPredicate(numbers, x -> x % 2 == 0);
        filterAndPredicate(numbers, x -> x % 2 != 0);

        var squaredNumbers = mapAndCreateNewList(numbers, x -> x * x);
        var cubedNumbers   = mapAndCreateNewList(numbers, x -> x * x * x);
        var doubledNumbers = mapAndCreateNewList(numbers, x -> x * 2);
    }

    @NotNull
    private static List<Integer> mapAndCreateNewList(List<Integer> numbers, Function<Integer, Integer> mappingFunction) {
        return numbers.stream().map(mappingFunction).toList();
    }

    private static void filterAndPredicate(List<Integer> numbers, Predicate<Integer> predicate) {
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }
}
