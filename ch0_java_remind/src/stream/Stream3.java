package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class Stream3 {
    public static void main(String[] args) {
        Student[] students = {
                new Student("a", 100, 3),
                new Student("b", 300, 4)
        };

//        studentStream.sorted(Comparator.comparing((Student s) -> s.getBan()).reversed()
//                        .thenComparing(Comparator.naturalOrder()))
//                .forEach(System.out::println);

        System.out.println(Arrays.toString(students));
        Arrays.sort(students, (Student s1, Student s2) -> s1.totalScore < s2.totalScore ? 1 : -1);
        System.out.println(Arrays.toString(students));
    }
}

class Student{
    String name;
    int totalScore;
    int ban;
    int hak;
    boolean isMale;

    enum Level {HIGH, MID, LOW}

    public int getBan() {
        return ban;
    }

    public String getName() {
        return name;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int getHak() {
        return hak;
    }

    public boolean isMale() {
        return isMale;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d %d %s", name, ban, totalScore, hak, isMale ? "남" : "여");
    }


    public Student(String name, int totalScore, int ban) {
        this.name = name;
        this.totalScore = totalScore;
        this.ban = ban;
    }

    public Student(String name, int totalScore, int ban, int hak, boolean isMale) {
        this.name = name;
        this.totalScore = totalScore;
        this.ban = ban;
        this.hak = hak;
        this.isMale = isMale;
    }

//    @Override
//    public int compareTo(Student s) {
//        return s.totalScore - this.totalScore;
//    }
}
