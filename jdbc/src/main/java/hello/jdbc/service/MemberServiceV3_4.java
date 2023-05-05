package hello.jdbc.service;

import hello.jdbc.domain.Member;
import hello.jdbc.repository.MemberRepositoryV3;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Transactional AOP
 */

@Slf4j
public class MemberServiceV3_4 {
    private final MemberRepositoryV3 memberRepository;

    public MemberServiceV3_4(MemberRepositoryV3 memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Transactional
    public void accountTransfer(String fromMemberId, String toMemberId, int money) throws SQLException {
        bizLogic(toMemberId, money, fromMemberId);
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
