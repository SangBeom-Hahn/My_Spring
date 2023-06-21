package stream;

import java.util.Optional;
import java.util.stream.Stream;

public class Stream5 {
    public static void main(String[] args) {

        String[] strArr = {"in", "ja", "la", "St"};
        Stream<String> stringStream = Stream.of(strArr);
        System.out.println(stringStream.noneMatch(s -> s.length() == 0));

        Optional<String> first = Stream.of(strArr).filter(s -> s.charAt(0) == 'l')
                .findFirst();
        System.out.println(first.get());
        Integer cnt = Stream.generate(() -> 1)
                .limit(5)
                .reduce(0, (a, b) -> a + 1);
        System.out.println(cnt);

        Integer sum = Stream.generate(() -> 2)
                .limit(5)
                .reduce(0, (a, b) -> a + b);
        System.out.println(sum);
    }
}
