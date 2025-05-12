package hello.jdbc.repository;


import static hello.jdbc.connection.ConnectionConst.PASSWORD;
import static hello.jdbc.connection.ConnectionConst.URL;
import static hello.jdbc.connection.ConnectionConst.USERNAME;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.zaxxer.hikari.HikariDataSource;
import hello.jdbc.domain.Member;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Slf4j
class MemberRepositoryV1Test {

  MemberRepositoryV1 repository;

  @BeforeEach
  void beforeEach() {
    //기본 DriverManager - 항상 새로운 커넥션 획득
    //커넥션 풀링: HikariProxyConnection -> JdbcConnection
    //DriverManagerDataSource dataSource = new DriverManagerDataSource(URL,USERNAME,PASSWORD);
    HikariDataSource dataSource = new HikariDataSource();
    dataSource.setJdbcUrl(URL);
    dataSource.setUsername(USERNAME);
    dataSource.setPassword(PASSWORD);
    repository = new MemberRepositoryV1(dataSource);
  }

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