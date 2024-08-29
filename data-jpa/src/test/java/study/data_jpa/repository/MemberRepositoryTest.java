package study.data_jpa.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.data_jpa.dto.MemberDto;
import study.data_jpa.entity.Member;
import study.data_jpa.entity.Team;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;
    @Autowired TeamRepository teamRepository;
    
    @Test
    public void testMember(){
        Member member=new Member("userA");
        Member savedMember = memberRepository.save(member);

        Member findMember= memberRepository.findById(savedMember.getId()).get();

        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        assertThat(findMember).isEqualTo(member);
    }

    @Test
    public void basicCRUD(){
        Member member1 = new Member("member1");
        Member member2 = new Member("member2");
        memberRepository.save(member1);
        memberRepository.save(member2);

        Member findMember1 = memberRepository.findById(member1.getId()).get();
        Member findMember2 = memberRepository.findById(member2.getId()).get();


        assertThat(findMember1).isEqualTo(member1);
        assertThat(findMember2).isEqualTo(member2);

        List<Member> all = memberRepository.findAll();
        assertThat(all.size()).isEqualTo(2);

        long count = memberRepository.count();
        assertThat(count).isEqualTo(2);

        memberRepository.delete(member1);
        memberRepository.delete(member2);

        long deleteCount = memberRepository.count();
        assertThat(deleteCount).isEqualTo(0);
    }

    @Test
    public void findByUsernameAndAgeGreaterThen() {
        Member m1 = new Member("A", 10);
        Member m2 = new Member("A", 20);
        memberRepository.save(m1);
        memberRepository.save(m2);

        List<Member> result = memberRepository.findByUsernameAndAgeGreaterThan("A", 15);

        assertThat(result.get(0).getUsername()).isEqualTo("A");
        assertThat(result.get(0).getAge()).isEqualTo(20);
        assertThat(result.size()).isEqualTo(1);
    }

    @Test
    public void namedQuery(){
        Member m1 = new Member("A", 10);
        Member m2 = new Member("B", 20);
        memberRepository.save(m1);
        memberRepository.save(m2);

        List<Member> result = memberRepository.findByUsername("A");
        Member findMember=result.get(0);
        assertThat(findMember).isEqualTo(m1);
    }

    @Test
    public void testQuery(){
        Member m1 = new Member("A", 10);
        Member m2 = new Member("B", 20);
        memberRepository.save(m1);
        memberRepository.save(m2);

        List<Member> result = memberRepository.findUser("A",10);
        assertThat(result.get(0)).isEqualTo(m1);
    }

    @Test
    public void findUsernamList(){
        Member m1 = new Member("A", 10);
        Member m2 = new Member("B", 20);
        memberRepository.save(m1);
        memberRepository.save(m2);

        List<String > result = memberRepository.findUsernameList();
        for (String s : result) {
            System.out.println("s = " + s);
        }
    }

    @Test
    public void findMemberDto(){

        Team team=new Team("teamA");
        teamRepository.save(team);


        Member m1 = new Member("A", 10);
        m1.setTeam(team);
        memberRepository.save(m1);

        List<MemberDto> result = memberRepository.findMemberDto();
        for (MemberDto dto : result) {
            System.out.println("dto = " + dto);
        }
    }

    @Test
    public void findByNames(){
        Member m1 = new Member("A", 10);
        Member m2 = new Member("B", 20);
        memberRepository.save(m1);
        memberRepository.save(m2);

        List<Member > result = memberRepository.findByNames(Arrays.asList("A","B"));
        for (Member member : result) {
            System.out.println("member = " + member);
        }
    }

    @Test
    public void returnType(){
        Member m1 = new Member("A", 10);
        Member m2 = new Member("B", 20);
        memberRepository.save(m1);
        memberRepository.save(m2);

        List<Member> a = memberRepository.findListByUsername("A");
        Member a1 = memberRepository.findMemberByUsername("A");
        Optional<Member> a2 = memberRepository.findOptionalByUsername("A");
    }


}