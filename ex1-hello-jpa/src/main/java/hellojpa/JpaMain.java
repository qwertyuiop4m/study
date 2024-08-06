package hellojpa;

import jakarta.persistence.*;
import org.hibernate.boot.model.source.internal.hbm.XmlElementMetadata;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member=new Member();
            member.setName("member1");
            member.setHomeAddress(new Address("homeCity","street","100000"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");

            member.getAddressesHistory().add(new AddressEntity("old1","street","100000"));
            member.getAddressesHistory().add(new AddressEntity("old2","street","100000"));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("=============start==================");
            Member findMember = em.find(Member.class, member.getId());

            //homecity->newcity
                //findMember.getHomeAddress().setCity("newCity");
            Address a = findMember.getHomeAddress();
            findMember.setHomeAddress(new Address("newCity",a.getStreet(),a.getZipcode()));

            //치킨->한식
            findMember.getFavoriteFoods().remove("치킨");
            findMember.getFavoriteFoods().add("한식");


//            findMember.getAddressesHistory().remove(new AddressEntity("old1","street","100000"));
//            findMember.getAddressesHistory().add(new AddressEntity("newCity1","street","100000"));

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        
        emf.close();
    }
    
}
