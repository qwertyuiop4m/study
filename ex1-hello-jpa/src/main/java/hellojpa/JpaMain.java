package hellojpa;

import jakarta.persistence.*;
import org.hibernate.boot.model.source.internal.hbm.XmlElementMetadata;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member=new Member();
            member.setName("user1");
            member.setCreatedBy("kim");
            member.setCreatedDate(LocalDateTime.now());

            em.persist(member);

            em.flush();
            em.clear();

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        
        emf.close();
    }
}
