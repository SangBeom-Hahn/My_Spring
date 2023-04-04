package statictest;

public class Student {
    private static int studentId = 10000;
    int studentNum;

    public Student(){
        studentNum = studentId++;
    }
}
