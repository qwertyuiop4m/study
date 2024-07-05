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
            Team team=new Team();
            team.setName("teamA");
           em.persist(team);

            Member member1=new Member();
            member1.setName("hello1");
            member1.setTeam(team);
            em.persist(member1);

            em.flush();
            em.clear();

            Member m = em.find(Member.class, member1.getId());

            System.out.println("m=" + m.getTeam().getClass());
            System.out.println("===========");
            m.getTeam().getName();
            System.out.println("===========");

            tx.commit();
        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
        
        emf.close();
    }
    
}
