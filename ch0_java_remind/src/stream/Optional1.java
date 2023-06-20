package stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Optional1 {
    public static void main(String[] args) {
        Stream.iterate(0, n -> n + 1).limit(100)
                .collect(toList());

//        intStream.forEach(System.out::println);
    }
}
