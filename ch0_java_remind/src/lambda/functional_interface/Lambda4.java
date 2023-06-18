package lambda.functional_interface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lambda4 {
    public static void main(String[] args) {
        Supplier<Integer> s = () -> (int) (Math.random() * 100) + 1;
        Consumer<Integer> c = integer -> System.out.println(integer);
        Predicate<Integer> p = integer -> integer % 2 == 0;

        List<Integer> list = new ArrayList<>();
        makeRandomList(s, list);
        System.out.println(list);
        printEvenNum(p, c, list);
    }

    static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
        for (T i : list) {
            if(p.test(i))
                c.accept(i);
        }
    }

    static <T> void makeRandomList(Supplier<T> s, List<T> list) {
        for (int i = 0; i < 10; i++) {
            list.add(s.get());
        }
    }
}
