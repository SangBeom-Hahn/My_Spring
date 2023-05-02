package hello.jdbc.connection;

import hello.jdbc.domain.Member;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

class DBConnectionUtilTest {

    @Test
    void getConnection() {
        Connection connection = DBConnectionUtil.getConnection();
        assertThat(connection).isNotNull();

        Member member = new Member();
        Member member2 = new Member();
//        System.out.println(Objects.hash(member.getMemberId()));
//        System.out.println(Objects.hash(member.getMoney()));

        System.out.println(member2.hashCode());
        System.out.println(member.hashCode());
    }
}