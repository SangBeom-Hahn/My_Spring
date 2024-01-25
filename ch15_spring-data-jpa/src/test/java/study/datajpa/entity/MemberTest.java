package study.datajpa.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberTest {
    @PersistenceContext
    EntityManager em;

    @Test
    @DisplayName("")
    @Transactional()
    @Rollback(value = false)
    void test() {
        // given
        Team teamA = new Team("A");
        Team teamB = new Team("B");
        em.persist(teamA);
        em.persist(teamB);

        // when
        Member member1 = new Member("1", 10, teamA);
        Member member2 = new Member("2", 10, teamA);
        Member member3 = new Member("3", 10, teamB);
        Member member4 = new Member("4", 10, teamB);

        // then
        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);

        em.flush();
        em.clear();

        List<Member> members = em.createQuery("select m from Member m", Member.class)
                .getResultList();

        for (Member member : members) {
            System.out.println("member = " + member);
            System.out.println("member = " + member.getTeam());
        }
    }
}