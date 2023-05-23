package hello.springtx.propa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LogRepo {
    private final EntityManager em;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(Log logMessage) {
        em.persist(logMessage);

        if (logMessage.getMessage().contains("로그예외")) {
            throw new RuntimeException("예외 발생");
        }
    }

    public Optional<Log> find(String username) {
        return em.createQuery("select l from Log l where l.message = :username")
                .setParameter("username", username)
                .getResultList().stream().findAny();
    }
}
