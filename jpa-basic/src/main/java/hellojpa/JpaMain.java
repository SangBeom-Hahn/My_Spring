package hellojpa;

import javax.persistence.*;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
    
        EntityTransaction tx = em.getTransaction();
        tx.begin();
    
        try {
            Member member = new Member();
            em.persist(member);
    
            System.out.println(member.getId());
            System.out.println("=====");
    
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        
        emf.close();
    }
}
