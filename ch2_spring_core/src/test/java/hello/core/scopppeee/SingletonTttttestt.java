package hello.core.scopppeee;

import org.junit.jupiter.api.Test;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SingletonTttttestt {
    @Test
    void singletonTest() {

    }

    static class SingletonBean {
        @PostConstruct
        public void init() {
            System.out.println("init");
        }

        @PreDestroy
        public void close() {
            System.out.println("close");
        }
    }
}
