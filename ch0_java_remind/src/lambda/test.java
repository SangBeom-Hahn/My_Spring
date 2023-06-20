package lambda;

import jdk.dynalink.Operation;
import lambda.functional_interface.Myfunctional;

import java.awt.*;
import java.awt.color.ProfileDataException;
import java.io.FilenameFilter;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Flow;
import java.util.function.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;


class MyFunc {
//    void run();
    private int a;
    private int b;

    public MyFunc() {
    }

    public MyFunc(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public MyFunc(int a) {
        this.a = a;
    }
}

@FunctionalInterface
interface MyMax {
    int max(int a, int b);
}

public class test {
//    static MyFunc myFunc() {
//        return () -> System.out.println("fi.run");
//    }

    static void makeRandomList(Supplier<Integer> s, List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(s.get());
        }
    }

    static void printEvenNum(Predicate<Integer> p, Consumer<Integer> c, List<Integer> list) {
        for (Integer integer : list) {
            if (p.test(integer)) {
                c.accept(integer);
            }
        }
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("1", "2");
        Stream<String> stream = strings.stream();
        stream.forEach(System.out::println);

        stream = strings.stream();
        stream.forEach(System.out::println);
        strings.forEach(System.out::println);

        Map<Object, Object> map = new HashMap<>();
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");

        Set<Map.Entry<Object, Object>> entries = map.entrySet();
        Stream<Map.Entry<Object, Object>> stream1 = entries.stream();
        stream1.forEach(System.out::println);

        Integer[] integer = {1, 2, 3};
        Stream<Integer> integer1 = Stream.of(integer);
        Stream<Integer> stream2 = Arrays.stream(integer);

        int[] i = {1, 2, 3};
        IntStream i1 = IntStream.of(i);
        IntStream stream3 = Arrays.stream(i);

        Double[] d = {1.2, 5.3};
        DoubleStream d2 = DoubleStream.of(1.2, 3.4);
        d2.forEach(System.out::println);

        IntStream ints = new Random().ints();
        ints
                .limit(5)
                .forEach(System.out::println);

//        Stream<Integer> iterate = Stream.iterate(0, n -> n * 2);
//        iterate.forEach(System.out::println);

        Stream<Integer> generate = Stream.generate(() -> 3);
        generate
                .skip(3)
                .limit(5)
                .forEach(System.out::println);

        IntStream intStream = IntStream.rangeClosed(1, 10);
//        intStream.filter(n -> n % 2 == 0 && n % 3 != 0).forEach(System.out::println);
        intStream.filter(n -> n % 2 == 0).filter(n -> n % 3 == 0).forEach(System.out::println);

    }
}

