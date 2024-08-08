package org.example.jpql;

import jakarta.persistence.*;

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

            Member member=new Member();
            member.setUsername("member1");
            member.setAge(10);
            em.persist(member);

            member.setTeam(team);

            
            em.flush();
            em.clear();


            String query="SELECT m FROM Member m LEFT JOIN Team t on m.username=t.name ";


            List<Member> result = em.createQuery(query, Member.class)
                    .getResultList();

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
