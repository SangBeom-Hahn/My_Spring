package hellojpa;

import hellojpa.domain.Book;
import hellojpa.domain.Member;
import hellojpa.domain.Movie;
import hellojpa.domain.Team;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        try {
            Team team = new Team();
            team.setName("hi");
            em.persist(team);
            
            Member member = new Member();
            member.setName("hello1");
            member.setTeam(team);
            em.persist(member);
            
            em.flush();
            em.clear();
    
            Member findM = em.find(Member.class, member.getId());
            System.out.println("findM.getTeam().getClass() = " + findM.getTeam().getClass());
    
            System.out.println("===");
            findM.getTeam().getName();
            System.out.println("===");
            
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
