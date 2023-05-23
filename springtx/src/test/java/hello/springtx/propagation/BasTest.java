package hello.springtx.propagation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

@Slf4j
@SpringBootTest
public class BasTest {
    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Test
    void commit() {
        TransactionStatus st = platformTransactionManager.getTransaction(new DefaultTransactionAttribute());
        platformTransactionManager.commit(st);
    }

    @Test
    void roll() {
        TransactionStatus st = platformTransactionManager.getTransaction(new DefaultTransactionAttribute());
        platformTransactionManager.rollback(st);
    }

    @Test
    void double_commit_roll() {
        TransactionStatus st = platformTransactionManager.getTransaction(new DefaultTransactionAttribute());
        platformTransactionManager.commit(st);

        TransactionStatus st2 = platformTransactionManager.getTransaction(new DefaultTransactionAttribute());
        platformTransactionManager.rollback(st2);
    }

    @Test
    void inner_commit() {
        TransactionStatus outer = platformTransactionManager.getTransaction(new DefaultTransactionAttribute());
        TransactionStatus inner = platformTransactionManager.getTransaction(new DefaultTransactionAttribute());

        platformTransactionManager.commit(inner);
        platformTransactionManager.commit(outer);
    }

    @Test
    void outer_rollback() {
        TransactionStatus outer = platformTransactionManager.getTransaction(new DefaultTransactionAttribute());
        TransactionStatus inner = platformTransactionManager.getTransaction(new DefaultTransactionAttribute());

        platformTransactionManager.commit(inner);
        platformTransactionManager.rollback(outer);
    }

    @Test
    void inner_rollback() {
        TransactionStatus outer = platformTransactionManager.getTransaction(new DefaultTransactionAttribute());
        TransactionStatus inner = platformTransactionManager.getTransaction(new DefaultTransactionAttribute());

        platformTransactionManager.rollback(inner);
        platformTransactionManager.commit(outer);
    }

    @Test
    void inner_rollback_new() {
        TransactionStatus outer = platformTransactionManager.getTransaction(new DefaultTransactionAttribute());

        DefaultTransactionAttribute defaultTransactionAttribute = new DefaultTransactionAttribute();
        defaultTransactionAttribute.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        TransactionStatus inner = platformTransactionManager.getTransaction(defaultTransactionAttribute);

        platformTransactionManager.rollback(inner);
        platformTransactionManager.commit(outer);
    }
}
