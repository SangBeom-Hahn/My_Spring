package stream;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> intStream = list.stream();
        intStream.forEach(System.out::println);

        intStream = list.stream();
        intStream.forEach(System.out::println); // 스트림 닫힘

        Map<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Stream<Map.Entry<String, Integer>> entryStream = entries.stream();
        entryStream.forEach(System.out::println);

//        String[] strArr = {"a", "b", "c"};
//        Stream<String> strStream = Stream.of(strArr); // 가변인자
//        Stream<String> stream = Arrays.stream(strArr);
//
//        // 기본형 배열
//        int[] intArr = {1, 2, 3, 4, 5};
//        IntStream intArr1 = IntStream.of(intArr);
//        IntStream intBasicStream = Arrays.stream(intArr);
//
//        Stream<Integer> intIntegerStream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5});
//        intBasicStream.sum();
//        intBasicStream.average();
//
//        intIntegerStream.sum();

//        IntStream intStream = new Random().ints();
//        intStream
//                .limit(5)
//                .forEach(System.out::println);

//        Stream<Integer> intStream = Stream.iterate(0, n -> n + 2);
//        intStream.forEach(System.out::println);
//
//        intStream.limit(5).forEach(System.out::println);
//
//        Stream<Integer> generateStream = Stream.generate(() -> 1);
//        generateStream.limit(5).forEach(System.out::println);
    }
}