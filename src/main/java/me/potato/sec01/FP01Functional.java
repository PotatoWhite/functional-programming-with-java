package me.potato.sec01;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP01Functional {
    public static void main(String[] args) {
        var numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        printAllNumbersInListFunctional(numbers);
        System.out.println("----------");
        printEvenNumbersInListFunctional(numbers);
        System.out.println("----------");
        printOddNumbersInListFunctional(numbers);
        System.out.println("----------");
        printSquaresOfEvenNumbersInListFunctional(numbers);
        System.out.println("----------");
        printCubesOfOddNumbersInListFunctional(numbers);

        var courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        System.out.println("----------");
        printAllCoursesInListFunctional(courses);
        System.out.println("----------");
        printSpringCoursesInListFunctional(courses);
        System.out.println("----------");
        printLengthOfAllCoursesInListFunctional(courses);
    }

    private static void printSpringCoursesInListFunctional(List<String> courses) {
        Predicate<String> startsWithSpring = course -> course.toLowerCase(Locale.ENGLISH).contains("spring");
        courses.stream().filter(startsWithSpring).forEach(System.out::println);
    }

    private static void printAllCoursesInListFunctional(List<String> courses) {
        courses.forEach(System.out::println);
    }

    private static void printLengthOfAllCoursesInListFunctional(List<String> courses) {
        Function<String, String> displayFormat = course -> course + " " + course.length();
        courses.stream().map(displayFormat).forEach(System.out::println);
    }

    private static void printOddNumbersInListFunctional(List<Integer> numbers) {
        Predicate<Integer> isOdd = x -> x % 2 != 0;
        numbers.stream().filter(isOdd).forEach(System.out::println);
    }

    private static void printAllNumbersInListFunctional(List<Integer> numbers) {
        numbers.forEach(System.out::println);
    }

    private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
        Predicate<Integer> isEven = x -> x % 2 == 0;
        numbers.stream().filter(isEven).forEach(System.out::println);
    }

    private static void printSquaresOfEvenNumbersInListFunctional(List<Integer> numbers) {
        Predicate<Integer>         isEven = x -> x % 2 == 0;
        Function<Integer, Integer> square = x -> x * x;
        numbers.stream().filter(isEven).map(square).forEach(System.out::println);
    }

    private static void printCubesOfOddNumbersInListFunctional(List<Integer> numbers) {
        Predicate<Integer>         isOdd = x -> x % 2 != 0;
        Function<Integer, Integer> cube  = x -> x * x * x;
        numbers.stream().filter(isOdd).map(cube).forEach(System.out::println);
    }

}


