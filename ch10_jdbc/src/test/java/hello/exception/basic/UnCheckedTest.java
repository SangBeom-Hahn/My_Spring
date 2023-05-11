package hello.exception.basic;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class UnCheckedTest {
    @Test
    void unchecked_catch() {
        Service service = new Service();
        service.callCatch();
    }

    @Test
    void unchecked_throw() {
        Service service = new Service();
        service.callThrow();
    }

    static class MyUncheckedException extends RuntimeException {
        public MyUncheckedException(String message) {
            super(message);
        }
    }

    static class Service {
        Repository repository = new Repository();
        void callCatch() {
            try {
                repository.call();
            } catch (MyUncheckedException e) {
                System.out.println(e);
            }
        }

        void callThrow() {
            repository.call();
        }
    }
    static class Repository {
        public void call() {
            throw new MyUncheckedException("ex");
        }
    }
}
