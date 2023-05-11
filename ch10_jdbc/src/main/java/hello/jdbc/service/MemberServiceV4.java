package hello.jdbc.service;

import hello.jdbc.domain.Member;
import hello.jdbc.repository.MemberRepository;
import hello.jdbc.repository.MemberRepositoryV3;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

/**
 * @Transactional AOP
 */

@Slf4j
public class MemberServiceV4 {
    private final MemberRepository memberRepository;

    public MemberServiceV4(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Transactional
    public void accountTransfer(String fromMemberId, String toMemberId, int money) {
        bizLogic(toMemberId, money, fromMemberId);
    }

    private void bizLogic(String toMemberId, int money, String fromMemberId) {
        Member findMember = memberRepository.findById(fromMemberId);
        Member toMember = memberRepository.findById(toMemberId);

        try {
            memberRepository.update(fromMemberId, findMember.getMoney() - money);
        } catch (BadSqlGrammarException e) {

        }

        validation(toMember);
        memberRepository.update(toMemberId, findMember.getMoney() + money);
    }

    private static void validation(Member toMember) {
        if (toMember.getMemberId().equals("ex")) {
            throw new IllegalStateException("이체중 예외 발생");
        }
    }
}
