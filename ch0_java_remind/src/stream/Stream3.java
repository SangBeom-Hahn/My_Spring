package stream;

import java.util.Comparator;
import java.util.stream.Stream;

public class Stream3 {
    public static void main(String[] args) {
        Stream<Student> studentStream = Stream.of(
                new Student("a", 300, 3),
                new Student("a", 400, 3),
                new Student("b", 200, 1),
                new Student("b", 500, 1)
        );

        studentStream.sorted(Comparator.comparing((Student s) -> s.getBan()).reversed()
                        .thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);


    }
}

class Student implements Comparable<Student> {
    private String name;
    private int totalScore;
    private int ban;

    public int getBan() {
        return ban;
    }
    @Override
    public String toString() {
        return String.format("%s  %d  %d", name, ban, totalScore);
    }


    public Student(String name, int totalScore, int ban) {
        this.name = name;
        this.totalScore = totalScore;
        this.ban = ban;
    }

    @Override
    public int compareTo(Student s) {
        return s.totalScore - this.totalScore;
    }
}
