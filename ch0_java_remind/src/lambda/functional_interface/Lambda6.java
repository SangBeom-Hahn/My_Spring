package lambda.functional_interface;

import java.util.*;

public class Lambda6 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Integer[] arr = new Integer[] {1, 2, 3, 4, 5};
        list.addAll(Arrays.asList(arr));

        list.forEach(i -> System.out.println(i + ", ")); // 소비자
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }


        list.removeIf(x -> x % 2 == 0); // 조건자
        list.replaceAll(i -> i * 10); // 단항 연산자

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");

        map.forEach((k, v) -> System.out.println(k + " " + v));


    }
}
