package me.potato.sec01;

import java.util.List;

public class FP01Structured {
    public static void main(String[] args) {
        printAllNumbersInListStructured(List.of(12, 9, 13, 4, 6, 2, 4, 12, 15));
    }

    private static void printAllNumbersInListStructured(List<Integer> integers) {
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
