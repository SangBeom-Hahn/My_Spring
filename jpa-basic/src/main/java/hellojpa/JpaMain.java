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
    
            Member member = new Member();
            Member member2 = new Member(16L, "B");
            member.setName("A");
            member.setId(150L);
    
            Member member1 = em.find(Member.class, 150L);
            member1.setName("zzzz");
            System.out.println("=== after === ");
//
//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L);
//            System.out.println(findMember1 == findMember2);
            
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());
    
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        
        emf.close();
    }
}
