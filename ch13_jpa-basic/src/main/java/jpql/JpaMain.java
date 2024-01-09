package jpql;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Team teamA = new Team();
            teamA.setName("teamA");
            em.persist(teamA);

            Team teamB = new Team();
            teamB.setName("teamB");
            em.persist(teamB);

            Member member2 = new Member();
            member2.setName("member1");
            member2.setTeam(teamA);

            Member member3 = new Member();
            member3.setName("member2");
            member3.setTeam(teamB);

            Member member1 = new Member();
            member1.setName("member1");
            member1.setTeam(teamA);

            em.persist(member1);
            em.persist(member2);
            em.persist(member3);

            String query = "update Member m set m.age = 20";
            int cnt = em.createQuery(query)
                    .executeUpdate();
            em.clear();
            Member member = em.find(Member.class, member1.getId());
            System.out.println(member.getAge());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }
}
