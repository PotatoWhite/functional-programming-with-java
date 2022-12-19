package me.potato.sec04;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
    private String name;
    private String category;
    private int    reviewScore;
    private int    noOfStudents;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name         = name;
        this.category     = category;
        this.reviewScore  = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", reviewScore=" + reviewScore +
                ", noOfStudents=" + noOfStudents +
                '}';
    }
}

public class FP04CustomClass {
    public static void main(String[] args) {
        var courses = List.of(
                new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000),
                new Course("API", "Framework", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("Full Stack", "Full Stack", 91, 14000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("PCF", "Cloud", 91, 20000),
                new Course("Azure", "Cloud", 99, 21000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000)
        );

        Predicate<? super Course> reviewScoreGreaterThan95Predicated = course -> course.getReviewScore() > 95;
        Predicate<? super Course> reviewScoreGreaterThan90Predicated = course -> course.getReviewScore() > 90;

        var allMatch95  = courses.stream().allMatch(reviewScoreGreaterThan95Predicated);
        var allMatch90  = courses.stream().allMatch(reviewScoreGreaterThan90Predicated);
        var noneMatch95 = courses.stream().noneMatch(reviewScoreGreaterThan95Predicated);
        var noneMatch90 = courses.stream().noneMatch(reviewScoreGreaterThan90Predicated);

        System.out.println(allMatch95);
        System.out.println(allMatch90);
        System.out.println(noneMatch95);
        System.out.println(noneMatch90);

        var anyMatch95 = courses.stream().anyMatch(reviewScoreGreaterThan95Predicated);
        var anyMatch90 = courses.stream().anyMatch(reviewScoreGreaterThan90Predicated);

        System.out.println(anyMatch95);
        System.out.println(anyMatch90);

        Comparator<Course> comparingByNoOfStudents = Comparator.comparing(Course::getNoOfStudents);

        var asc  = courses.stream().sorted(comparingByNoOfStudents).toList();
        var desc = courses.stream().sorted(comparingByNoOfStudents.reversed()).toList();

        System.out.println(asc);
        System.out.println(desc);

        Comparator<Course> comparingByNoOfStudentsAndReviews = Comparator
                .comparing(Course::getNoOfStudents)
                .thenComparing(Course::getReviewScore);

        var asc2  = courses.stream().sorted(comparingByNoOfStudentsAndReviews).toList();
        var desc2 = courses.stream().sorted(comparingByNoOfStudentsAndReviews.reversed()).toList();

        System.out.println(asc2);
        System.out.println(desc2);

        var skip3 = courses.stream().sorted(comparingByNoOfStudentsAndReviews).skip(3).toList();
        System.out.println(skip3);

        var limit3 = courses.stream().sorted(comparingByNoOfStudentsAndReviews).limit(3).toList();
        System.out.println(limit3);

        var skip3AndLimit3 = courses.stream().sorted(comparingByNoOfStudentsAndReviews).skip(3).limit(3).toList();
        System.out.println(skip3AndLimit3);

        var takeWhile = courses.stream()
                .takeWhile(course -> course.getReviewScore() > 95)
                .toList();
        System.out.println(takeWhile);


        var max = courses.stream()
                .max(comparingByNoOfStudentsAndReviews);
        System.out.println(max);

        var min = courses.stream()
                .min(comparingByNoOfStudentsAndReviews);
        System.out.println(min);

        var less = courses.stream()
                .filter(course -> course.getReviewScore() < 90)
                .min(comparingByNoOfStudentsAndReviews)
                .orElse(new Course("Kubernetes", "Cloud", 91, 0));
        System.out.println(less);

        var findFirst = courses.stream()
                .filter(course -> course.getReviewScore() >= 95)
                .findFirst();
        System.out.println(findFirst);


        var findAny = courses.stream()
                .filter(course -> course.getReviewScore() >= 95)
                .findAny();
        System.out.println(findAny);

        var sum = courses.stream()
                .filter(course -> course.getReviewScore() >= 95)
                .mapToInt(Course::getNoOfStudents)
                .sum();
        System.out.println(sum);

        var count = courses.stream()
                .filter(course -> course.getReviewScore() >= 95)
                .mapToInt(Course::getNoOfStudents)
                .count();
        System.out.println(count);

        var average = courses.stream()
                .filter(course -> course.getReviewScore() >= 95)
                .mapToInt(Course::getNoOfStudents)
                .average();
        System.out.println(average);

        var groupByCategory = courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory, Collectors.counting()));
        System.out.println(groupByCategory);

        var groupByMaxReviewScore = courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory, Collectors.maxBy(Comparator.comparing(Course::getReviewScore))));
        System.out.println(groupByMaxReviewScore);

        var groupingByCategory = courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory, Collectors.mapping(Course::getName, Collectors.toList())));
        System.out.println(groupingByCategory);
    }
}
