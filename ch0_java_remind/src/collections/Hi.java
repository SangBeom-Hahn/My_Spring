package collections;

import com.sun.source.tree.Tree;

import java.util.*;

public class Hi {
    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("1", 10);
        map.put("1", 20);
    
        System.out.println(map.containsKey("1"));
    }
}

class Person implements Comparable<Person>{
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
    
    @Override
    public int compareTo(Person o) {
        return this.age < o.age ? 1 : -1;
    }
}
