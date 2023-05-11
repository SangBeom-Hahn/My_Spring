package hello.jdbc.service;

import hello.jdbc.domain.Member;
import hello.jdbc.repository.MemberRepositoryV3;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 트랜잭션 탬플릿
 */

@Slf4j
public class MemberServiceV3_2 {
    private final MemberRepositoryV3 memberRepository;
//    private final PlatformTransactionManager transactionManager;
    private final TransactionTemplate txTemplate;

    public MemberServiceV3_2(MemberRepositoryV3 memberRepository, PlatformTransactionManager transactionManager) {
        this.memberRepository = memberRepository;
        this.txTemplate = new TransactionTemplate(transactionManager);
    }

    public void accountTransfer(String fromMemberId, String toMemberId, int money) throws SQLException {
        txTemplate.executeWithoutResult((status) -> {
            try {
                bizLogic(toMemberId, money, fromMemberId);
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        });
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
