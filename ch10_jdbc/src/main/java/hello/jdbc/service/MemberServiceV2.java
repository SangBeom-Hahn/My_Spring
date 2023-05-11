package hello.jdbc.service;

import hello.jdbc.domain.Member;
import hello.jdbc.repository.MemberRepositoryV1;
import hello.jdbc.repository.MemberRepositoryV2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
@Slf4j
@RequiredArgsConstructor
public class MemberServiceV2 {
    private final MemberRepositoryV2 memberRepository;
    private final DataSource dataSource;


    public void accountTransfer(String fromMemberId, String toMemberId, int money) throws SQLException {
        Connection con = dataSource.getConnection();

        try {
            con.setAutoCommit(false);
            // 시작
            bizLogic(con, toMemberId, money, fromMemberId);
            con.commit();
            // 커밋, 롤백
        } catch (IllegalStateException e) {
            con.rollback();
            throw new IllegalStateException(e);
        } finally {
            release(con);
        }
    }

    private void bizLogic(Connection con, String toMemberId, int money, String fromMemberId) throws SQLException {
        Member findMember = memberRepository.findById(fromMemberId, con);
        Member toMember = memberRepository.findById(toMemberId, con);

        memberRepository.update(fromMemberId, findMember.getMoney() - money, con);
        validation(toMember);
        memberRepository.update(toMemberId, findMember.getMoney() + money, con);
    }

    private static void release(Connection con) {
        if (con != null) {
            try {
                con.setAutoCommit(true);
                con.close();
            } catch (Exception e) {
                log.error("error", e);
            }
        }
    }

    private static void validation(Member toMember) {
        if (toMember.getMemberId().equals("ex")) {
            throw new IllegalStateException("이체중 예외 발생");
        }
    }
}
