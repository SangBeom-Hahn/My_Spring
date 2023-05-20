package hello.springtx.apply;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Slf4j
@SpringBootTest
public class InternalCallV1Test {
    @Autowired
    private CallService callService;

    @Test
    void internalCall() {
        callService.internal();
    }
    @Test
    void externalCall() {
        callService.external();
    }

    @TestConfiguration
    static class InternalCallV1Config {
        @Bean
        CallService callService() {
            return new CallService();
        }
    }

    static class CallService {
        public void external() {
            log.info("call external");
            println();
            internal();
        }
        @Transactional
        public void internal() {
            log.info("call internal");
            println();
        }

        public void println() {
            boolean ac = TransactionSynchronizationManager.isActualTransactionActive();
            log.info("tx active = {}", ac);
        }
    }
}
