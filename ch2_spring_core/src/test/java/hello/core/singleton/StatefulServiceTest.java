package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleTon() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1 = applicationContext.getBean(StatefulService.class);
        StatefulService statefulService2 = applicationContext.getBean(StatefulService.class);

        //Thread A : A사용자 10000원 주문
        int userAPrice = statefulService1.order("userA", 10000);

        //Thread B : B사용자 20000원 주문
        int userBPrice = statefulService2.order("userB", 20000);

//        int price = statefulService1.getPrice();
        System.out.println("price = " + userAPrice);
    }
}