package lambda.functional_interface;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

class Met {
    private int a;
    private int b;

    public Met(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public Met(int a) {
        this.a = a;
    }

    static Integer method(String a) {
        return Integer.parseInt(a);
    }

    public Met() {
    }


}

public class Lambda7 {
    public static void main(String[] args) {
        Supplier<Met> s = () -> new Met();
        Supplier<Met> s2 = Met::new;
        Function<Integer, Met> s3 = Met::new;
        BiFunction<Integer, Integer, Met> s4 = Met::new;
        Function<Integer, int[]> arr = int[]::new;

        Met met = s.get();
        Met apply = s3.apply(1);
        Met apply1 = s4.apply(1, 2);
        int[] apply2 = arr.apply(100); // 길이
    }
}
