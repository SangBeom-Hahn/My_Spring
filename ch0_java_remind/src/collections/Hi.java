package collections;

import java.util.*;

public class Hi {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(List.of(new Person("A", 1), new Person("B", 2)));
        Set<Person> A = new TreeSet<>(people);
        System.out.println(A.toString());
    }
}

class Person {
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public Person() {
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
    
    @Override
    public String toString() {
        return "Person{" +
          "name='" + name + '\'' +
          ", age=" + age +
          '}';
    }
}
