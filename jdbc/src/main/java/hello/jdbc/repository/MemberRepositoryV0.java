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
import java.util.NoSuchElementException;
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

  public Member findById(String memberId) throws SQLException {
    String sql="select * from member where member_id=?";

    Connection con=null;
    PreparedStatement ps=null;
    ResultSet rs=null;

    try{
      con = getConnection();
      ps = con.prepareStatement(sql);
      ps.setString(1, memberId);
      rs = ps.executeQuery();
      if(rs.next()){
        Member member = new Member();
        member.setMemberId(rs.getString("member_id"));
        member.setMoney(rs.getInt("money"));
        return member;
      }else {
        throw new NoSuchElementException("member not found memberId= "+memberId);
      }
    }catch (SQLException e){
      log.error("db error",e);
      throw e;
    }finally {
      close(con,ps,rs);
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
