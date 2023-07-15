package collections;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.time.LocalDateTime;
import java.util.Collections;

@Retention(RetentionPolicy.RUNTIME)
@interface TestInfo {
  int count() default 1;
  
  String s();
  
  String[] sArr() default "JUnit";
}

@TestInfo(s = "aaa")
public class Col {
  public static void main(String[] args) {
    Class<Col> cls = Col.class;
    TestInfo anno = cls.getAnnotation(TestInfo.class);
    System.out.println(anno.count());
    System.out.println(anno.s());
    
    for (String s : anno.sArr()) {
      System.out.println(s);
    }
  }
}
