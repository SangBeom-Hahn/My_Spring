package hello.springtx.propagation;

import jdk.jfr.DataAmount;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Slf4j
@SpringBootTest
public class BasicTxTest {
    @Autowired
    private  PlatformTransactionManager txManager;

    @TestConfiguration
    static class config {
        @Bean
        public PlatformTransactionManager transactionManager(DataSource dataSource) {
            return new DataSourceTransactionManager(dataSource);
        }
    }

    @Test
    void commit() {
        TransactionStatus status = txManager.getTransaction(new DefaultTransactionAttribute());
        txManager.commit(status);
    }

    @Test
    void roll() {
        TransactionStatus status = txManager.getTransaction(new DefaultTransactionAttribute());
        txManager.rollback(status);
    }

    @Test
    void double_commit_rollback() {
        log.info("트랜잭션1 시작");
        TransactionStatus tx1 = txManager.getTransaction(new DefaultTransactionAttribute());
        log.info("트랜잭션1 커밋");
        txManager.commit(tx1);

        log.info("트랜잭션2 시작");
        TransactionStatus tx2 = txManager.getTransaction(new DefaultTransactionAttribute());
        log.info("트랜잭션2 롤백");
        txManager.commit(tx2);
    }

    @Test
    void inner_commit() {
        log.info("외부 트랜 시작");
        TransactionStatus outer = txManager.getTransaction(new DefaultTransactionAttribute());
        log.info("outer.isNes = {}", outer.isNewTransaction());

        log.info("내부 트랜 시작");
        TransactionStatus inner = txManager.getTransaction(new DefaultTransactionAttribute());
        log.info("inner.isNes = {}", inner.isNewTransaction());
        
        log.info("내부 트랜 커밋");
        txManager.commit(inner);

        log.info("외부 트랜 커밋");
        txManager.commit(outer);
    }

    @Test
    void outer_rollback() {
        log.info("외부 트랜 시작");
        TransactionStatus outer = txManager.getTransaction(new DefaultTransactionAttribute());
        log.info("outer.isNes = {}", outer.isNewTransaction());

        log.info("내부 트랜 시작");
        TransactionStatus inner = txManager.getTransaction(new DefaultTransactionAttribute());
        log.info("inner.isNes = {}", inner.isNewTransaction());

        log.info("내부 트랜 커밋");
        txManager.commit(inner);

        log.info("외부 트랜 커밋");
        txManager.rollback(outer);
    }

    @Test
    void inner_rollback() {
        log.info("외부 트랜 시작");
        TransactionStatus outer = txManager.getTransaction(new DefaultTransactionAttribute());
        log.info("outer.isNes = {}", outer.isNewTransaction());

        log.info("내부 트랜 시작");
        TransactionStatus inner = txManager.getTransaction(new DefaultTransactionAttribute());
        log.info("inner.isNes = {}", inner.isNewTransaction());

        log.info("내부 트랜 롤백");
        txManager.rollback(inner);

        log.info("외부 트랜 커밋");
        assertThatThrownBy(() -> txManager.commit(outer))
                .isInstanceOf(UnexpectedRollbackException.class);

    }

    @Test
    void inner_rollback_new() {
        log.info("외부 트랜 시작");
        TransactionStatus outer = txManager.getTransaction(new DefaultTransactionAttribute());
        log.info("outer.isNes = {}", outer.isNewTransaction());

        log.info("내부 트랜 시작");
        DefaultTransactionAttribute definition = new DefaultTransactionAttribute();
        definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        TransactionStatus inner = txManager.getTransaction(definition);
        log.info("inner.isNes = {}", inner.isNewTransaction());

        log.info("내부 트랜 롤백");
        txManager.rollback(inner);

        log.info("외부 트랜 커밋");
        txManager.commit(outer);
    }
}