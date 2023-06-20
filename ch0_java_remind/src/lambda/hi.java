package lambda;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class hi {
    public static void main(String[] args) {
        Student[] students = {
                new Student("a", 7, 200),
                new Student("a", 7, 500),
                new Student("b", 8, 600)
        };
//
//        Stream<Student> stream = Stream.of(students);
//        stream.sorted(Comparator.comparing((Student student) -> student.getTotalScore()))
//                .forEach(System.out::println);


//        @Override
//        public int compareTo(Student s) {
//            return this.totalScore < s.totalScore ? 1 : -1;
//        }

        String[] strArray = {"aac", "ac=7", "a", "ad33333"};

        System.out.println(Arrays.toString(strArray));
//        Arrays.sort(strArray, Integer::compare);
        System.out.println(Arrays.toString(strArray));
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