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
public class TxLevelTest {

    @Autowired LevelService levelService;

    @Test
    void orderTest() {
        levelService.write();
        levelService.read();
    }

    @TestConfiguration
    static class TxLevelTestConfig{
        @Bean
        LevelService levelService() {
            return new LevelService();
        }
    }


    @Transactional(readOnly = true)
    static class LevelService{
        @Transactional(readOnly = false)
        public void write() {
            log.info("call write");
            println();
        }

        public void read() {
            log.info("call read");
            println();
        }

        public void println() {
            boolean ac = TransactionSynchronizationManager.isActualTransactionActive();
            log.info("tx active = {}", ac);

            boolean readOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly();
            log.info("tx readonly = {}", readOnly);
        }
    }
}
