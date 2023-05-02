package hello.jdbc.repo2;

import hello.jdbc.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepo2Test {

    MemberRepo2 memberRepo2 = new MemberRepo2();

    @Test
    void crud() {
        Member member = new Member("1", 10000);
        memberRepo2.save(member);

        Member findMember = memberRepo2.findById("1");
        assertThat(findMember).isEqualTo(member);

        memberRepo2.update("1", 20000);
        Member updateMember = memberRepo2.findById("1");
        assertThat(updateMember.getMoney()).isEqualTo(20000);
    }
}