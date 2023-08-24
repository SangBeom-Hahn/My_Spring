package hellojpa;

import hellojpa.domain.*;
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
            Parent parent = new Parent();
            Child child1 = new Child();
            Child child2 = new Child();
            
            parent.addChild(child1);
            parent.addChild(child2);
            
            em.persist(parent);
            
            em.flush();
            em.clear();
    
            Parent parent1 = em.find(Parent.class, parent.getId());
            em.remove(parent1);
    
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
