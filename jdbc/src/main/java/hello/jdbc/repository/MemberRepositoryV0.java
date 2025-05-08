package hello.jdbc.repository;
/*
* JDBC - DriverManager 사용
* */

import hello.jdbc.connection.DBConnectionUtil;
import hello.jdbc.domain.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemberRepositoryV0 {

  public Member save(Member member) throws SQLException {
    String sql="insert into member(member_id,money) values(?,?)";

    Connection con=null;
    PreparedStatement ps=null;

    try {
      con = getConnection();
      ps = con.prepareStatement(sql);
      ps.setString(1, member.getMemberId());
      ps.setInt(2, member.getMoney());
      ps.executeUpdate();
      return member;
    } catch (SQLException e) {
      log.error("db error",e);
      throw e;
    }finally {
      close(con,ps,null);
    }
  }

  private void close(Connection con, Statement stmt, ResultSet rs) {
    if(rs!=null){
      try {
        rs.close();
      } catch (SQLException e) {
        log.error("error",e);
      }
    }

    if(stmt != null) {
      try {
        stmt.close();
      } catch (SQLException e) {
        log.error("error",e);
      }
    }
    if(con != null) {
      try {
        con.close();
      } catch (SQLException e) {
        log.error("error",e);
      }
    }
  }

  private Connection getConnection() {
    return DBConnectionUtil.getConnection();
  }
}
