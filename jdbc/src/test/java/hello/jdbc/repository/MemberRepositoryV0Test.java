package hello.jdbc.repository;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import hello.jdbc.domain.Member;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class MemberRepositoryV0Test {

  MemberRepositoryV0 repository = new MemberRepositoryV0();

  @Test
  void crud() throws SQLException {
    Member member = new Member("memberV5", 10000);
    repository.save(member);

    Member findMember = repository.findById(member.getMemberId());
    log.info("findMember: {}", findMember);
    log.info("member == findMember: {}", member==findMember);
    log.info("member equals findMember: {}", member.equals(findMember));
    assertThat(findMember).isEqualTo(member);

    repository.update(member.getMemberId(),20000);
    Member updateMember = repository.findById(member.getMemberId());
    assertThat(updateMember.getMoney()).isEqualTo(20000);

    repository.delete(member.getMemberId());
    assertThatThrownBy(()->repository.findById(member.getMemberId())).isInstanceOf(
        NoSuchElementException.class);
  }
}