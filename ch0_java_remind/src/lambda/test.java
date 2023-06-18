package lambda;

import lambda.functional_interface.Myfunctional;

import java.io.FilenameFilter;
import java.util.Comparator;
import java.util.function.Predicate;

public class test {
    public static void main(String[] args) {
        Predicate<String> isEmptyStr = s -> s.length() == 0;
        String s = "";

        if (isEmptyStr.test(s)) {
            System.out.println("empty");
        }
    }
}
