package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
    
        EntityTransaction tx = em.getTransaction();
        tx.begin();
    
        try {
//            Member member = new Member(1L, "a", 1);
//            em.persist(member);
    
            Member member1 = em.find(Member.class, 1L);
            member1.setUsername("aaa");
    
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        
        emf.close();
    }
}
