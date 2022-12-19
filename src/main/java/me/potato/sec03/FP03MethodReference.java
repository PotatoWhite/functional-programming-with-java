package me.potato.sec03;

import java.util.List;
import java.util.function.Supplier;

public class FP03MethodReference {
    private static void print(String str) {
        System.out.println(str);
    }

    public static void main(String[] args) {
        var course = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        course.stream()
                .map(String::toUpperCase)
                .forEach(FP03MethodReference::print);

        Supplier<String> supplier = String::new;
    }
}
