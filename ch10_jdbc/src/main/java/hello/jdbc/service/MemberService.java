package hello.jdbc.service;

import hello.jdbc.domain.Member;
import hello.jdbc.repository.MemberRepositoryV1;

import java.sql.SQLException;

public class MemberService {
    private final MemberRepositoryV1 memberRepositoryV1;

    public MemberService(MemberRepositoryV1 memberRepositoryV1) {
        this.memberRepositoryV1 = memberRepositoryV1;
    }

    public void accountTransfer(String fromMemberId, String toMemberId, int money) throws SQLException {
        // 시작
        Member findMember = memberRepositoryV1.findById(fromMemberId);
        Member toMember = memberRepositoryV1.findById(toMemberId);

        memberRepositoryV1.update(fromMemberId, findMember.getMoney() - money);
        validation(toMember);
        memberRepositoryV1.update(toMemberId, findMember.getMoney() + money);
        // 커밋, 롤백
    }

    private static void validation(Member toMember) {
        if (toMember.getMemberId().equals("ex")) {
            throw new IllegalStateException("이체중 예외 발생");
        }
    }
}
