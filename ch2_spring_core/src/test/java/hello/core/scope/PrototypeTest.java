package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PrototypeTest {


    @Test
    void prototypeBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        System.out.println("find proto1");
        PrototypeBean PrototypeBean1 = ac.getBean(PrototypeBean.class);

        System.out.println("find proto2");
        PrototypeBean PrototypeBean2 = ac.getBean(PrototypeBean.class);

        System.out.println(PrototypeBean1);
        System.out.println(PrototypeBean2);

        ac.close();
    }
    @Scope("prototype")
    static class PrototypeBean {
        @PostConstruct
        public void init() {
            System.out.println("init");
        }

        @PreDestroy
        public void close() {
            System.out.println("destroy");
        }
    }
}
