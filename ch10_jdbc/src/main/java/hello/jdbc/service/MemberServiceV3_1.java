package hello.jdbc.service;

import hello.jdbc.domain.Member;
import hello.jdbc.repository.MemberRepositoryV3;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 트랜잭션 매니저
 */

@Slf4j
@RequiredArgsConstructor
public class MemberServiceV3_1 {
    private final MemberRepositoryV3 memberRepository;
    private final PlatformTransactionManager transactionManager;


    public void accountTransfer(String fromMemberId, String toMemberId, int money) throws SQLException {
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());

        try {
            // 시작
            bizLogic(toMemberId, money, fromMemberId);
            transactionManager.commit(status);
            // 커밋, 롤백
        } catch (IllegalStateException e) {
            transactionManager.rollback(status);
            throw new IllegalStateException(e);
        }
    }

    private void bizLogic(String toMemberId, int money, String fromMemberId) throws SQLException {
        Member findMember = memberRepository.findById(fromMemberId);
        Member toMember = memberRepository.findById(toMemberId);

        memberRepository.update(fromMemberId, findMember.getMoney() - money);
        validation(toMember);
        memberRepository.update(toMemberId, findMember.getMoney() + money);
    }

    private static void validation(Member toMember) {
        if (toMember.getMemberId().equals("ex")) {
            throw new IllegalStateException("이체중 예외 발생");
        }
    }
}
