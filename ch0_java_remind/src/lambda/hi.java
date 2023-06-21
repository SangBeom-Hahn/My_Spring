package lambda;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class hi {
    public static void main(String[] args) {
        Student[] students = {
                new Student("a", 7, 200),
                new Student("a", 7, 500),
                new Student("b", 8, 600)
        };

        String[] strArray = {"aac", "ac=7", "a", "ad33333"};

//        List<Integer> stuBans = Stream.of(students)
//                .map(Student::getBan)
//                .collect(toList());
//        Map<Integer, Student> studentMap = Stream.of(students)
//                .collect(toMap(student -> student.getBan(), student -> student));
//
//        Student[] studentArr = Stream.of(students).toArray(Student[]::new);
        Stream<Student> studentStream = Stream.of(students);
//        Long studentCnt = studentStream.collect(counting());
//        Integer totalScore = studentStream.collect(summingInt(Student::getTotalScore));

        Optional<Student> maxStudent = studentStream.collect(maxBy(Comparator.comparingInt(Student::getTotalScore)));
        System.out.println(maxStudent.get());

        IntStream intStream = new Random().ints();
        OptionalInt gob = intStream.reduce((int a, int b) -> a * b);

        Optional<Integer> groupGob = intStream.boxed().collect(reducing(((integer, integer2) -> integer * integer2)));
        String nameJoining = studentStream.map(Student::getName).collect(joining());

    }
}

@FunctionalInterface
interface Max {
    int max(int a, int b);
}

class MaxClass implements Max {
    @Override
    public int max(int a, int b) {
        return a > b ? a : b;
    }
}

class Student implements Comparable<Student>{
    String name;
    int ban;
    int totalScore;

    boolean isMale;

    public Student(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    public int getBan() {
        return ban;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public String getName() {
        return name;
    }

    public boolean isMale() {
        return isMale;
    }

    @Override
    public String toString() {
        return String.format("%s  %d  %d", name, ban, totalScore);
    }

    @Override
    public int compareTo(Student s) {
        return this.totalScore > s.totalScore ? 1 : -1;
    }
}

class Sort implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 > o2 ? 1 : -1;
    }
}