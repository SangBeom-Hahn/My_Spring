package string_adv;

import java.util.Arrays;
import java.util.List;

public class join {
    public static void main(String[] args) {
        List<String> list = List.of("dog", "cat", "bear");
        String joinList = String.join("_", list);
        
        Integer i = 1;
        int i2 = 1;

        String s = "1";

        int i3 = Integer.parseInt(s);
        Integer integer = Integer.valueOf(s);

        Double aDouble = Double.valueOf(i);

        String s1 = String.valueOf(i);

        StringBuilder sb = new StringBuilder();
        sb.append(555).append(true);

        sb.insert(3, "abc");
        sb.setCharAt(3, 'h');
        System.out.println(sb);
    }
}
