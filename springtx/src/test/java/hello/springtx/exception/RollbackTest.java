package hello.springtx.exception;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@Slf4j
@SpringBootTest
public class RollbackTest {
    @Autowired
    RollBackService service;
    @Test
    void runtimeException() {
        assertThatThrownBy(() -> service.RuntimeEx())
                .isInstanceOf(RuntimeException.class);
    }
    @Test
    void checkedException() {
        assertThatThrownBy(() -> service.UnRuntimeEx())
                .isInstanceOf(MyEx.class);
    }
    @Test
    void rollbackFor() {
        assertThatThrownBy(() -> service.RollBackEx())
                .isInstanceOf(MyEx.class);
    }

    @TestConfiguration
    static class RollbackTestConfig {
        @Bean
        RollBackService rollbackService() {
            return new RollBackService();
        }
    }
    static class RollBackService {
        @Transactional
        void RuntimeEx() {
            log.info("call RuntimeEx");
            throw new RuntimeException();
        }

        @Transactional
        void UnRuntimeEx() throws MyEx {
            log.info("call UnRuntimeEx");
            throw new MyEx();
        }

        @Transactional(rollbackFor = Exception.class)
        void RollBackEx() throws MyEx {
            log.info("call CheckedEx");
            throw new MyEx();
        }
    }

    static class MyEx extends Exception {
    }

}
