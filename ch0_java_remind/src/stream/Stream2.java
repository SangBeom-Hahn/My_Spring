package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream2 {
    public static void main(String[] args) {
//        IntStream intStream = IntStream.rangeClosed(1, 10);
//        intStream.skip(3).limit(5).forEach(System.out::print);

//        Stream<Integer> stream1 = Stream.of(1, 2, 3, 3, 5, 5, 7);
//        stream1.distinct().forEach(System.out::println);

//        IntStream stream2 = IntStream.rangeClosed(1, 10);
//        stream2.filter(i -> i % 2 == 0).forEach(System.out::println);
//        stream2.filter(i -> i % 3 != 0 && i % 2 != 0).forEach(System.out::println);
//        stream2.filter(i -> i % 2 != 0).filter(i -> i % 3 != 2).forEach(System.out::println);

        String[] str = {"cat", "dog", "lion", "tiger"};

        Arrays.sort(str);
        System.out.println(Arrays.toString(str));

        Arrays.sort(str, String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.toString(str));


    }

    class Desc implements Comparator{
        @Override
        public int compare(Object o1, Object o2) {
            Comparable o11 = (Comparable) o1;
            Comparable o21 = (Comparable) o2;
            return o11.compareTo(o21) * -1;
        }
    }
}
