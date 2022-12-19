package me.potato.sec03;

import java.util.List;
import java.util.Random;
import java.util.function.*;

public class FP03FunctionalInterface2 {


    public static void main(String[] args) {
        var numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        Predicate<Integer>         isEven            = number -> number % 2 == 0;
        Function<Integer, Integer> square            = number -> number * number;
        Function<Integer, String>  stringOutput      = String::valueOf;
        Consumer<Integer>          sysoutPrintln     = System.out::println;
        BinaryOperator<Integer>    sumBinaryOperator = Integer::sum;
        Supplier<Integer>          randomInteger     = () -> new Random().nextInt(1000);
        UnaryOperator<Integer>     unaryOperator     = x -> x * 3;

        BiPredicate<Integer, String> biPredicate = (number, str) -> {
            return number < 10 && str.length() > 5;
        };

        BiFunction<Integer, String, String> biFunction = (number, str) -> {
            return number + " " + str;
        };

        BiConsumer<Integer, String> biConsumer = (number, str) -> {
            System.out.println("BiConsumer " + number + " " + str);
        };
        biConsumer.accept(10, "Hello");

        IntBinaryOperator intBinaryOperator = (x, y) -> x + y;

        System.out.println(biFunction.apply(10, "potato"));
    }
}
