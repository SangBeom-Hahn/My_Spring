package hello.jdbc.domain;

import lombok.Data;

import java.util.Objects;

//@Data
public class Car {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public Car() {
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
