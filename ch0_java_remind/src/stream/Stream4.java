package stream;

import java.io.File;
import java.text.FieldPosition;
import java.util.Arrays;
import java.util.stream.Stream;

public class Stream4 {
    public static void main(String[] args) {
        System.out.println("a.java".indexOf('.')); // .의 인덱스를 출력
        System.out.println("java".indexOf('.')); // .이 없으면 -1을 출력
        System.out.println("java".substring(2)); // 해당 인덱스부터 끝까지 출력

        File[] files = {
                new File("a.java"),
                new File("b.txt")
        };

        Stream<File> fileStream = Stream.of(files);


        fileStream.map(File::getName)
                .filter(s -> s.indexOf('.') != -1)
                .map(s -> s.substring(s.indexOf('.') + 1))
                .distinct()
                .forEach(System.out::println);

        Stream<String> stream = Stream.of(
                "hi hello",
                "good bye"
        );

//        Stream<String> strStream = stream.flatMap(Arrays::stream);
    }
}
