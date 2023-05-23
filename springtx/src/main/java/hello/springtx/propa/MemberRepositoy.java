package hello.springtx.propa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepositoy {
    private final EntityManager em;
    @Transactional
    public void save(Member member) {
        em.persist(member);
    }

    public Optional<Member> find(String username) {
        return em.createQuery("select m from Member m where m.username = :username")
                .setParameter("username", username)
                .getResultList().stream().findAny();
    }
}
