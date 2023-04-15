package hello.springmvc.basic;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class HelloData {
    String username;
    int age;
}
