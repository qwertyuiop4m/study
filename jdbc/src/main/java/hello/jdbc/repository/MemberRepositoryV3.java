package hello.jdbc.repository;
/*
* JDBC - ConnectionPram
* */

import hello.jdbc.domain.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.NoSuchElementException;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.JdbcUtils;

/*
*트랜잭션 - 트랜잭션 매니저
* DataSourceUtils.getConnection()
* DataSourceUtils.releaseConnection()
 */
@Slf4j
public class MemberRepositoryV3 {

  private final DataSource dataSource;

  public MemberRepositoryV3(DataSource dataSource) {
    this.dataSource = dataSource;
  }

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

  public void update(String memberId, int money) throws SQLException {
    String sql="update member set money=? where member_id=?";

    Connection con=null;
    PreparedStatement ps=null;

    try{
      con = getConnection();
      ps = con.prepareStatement(sql);
      ps.setInt(1, money);
      ps.setString(2,memberId);
      int resultSize = ps.executeUpdate();
      log.info("resultSize={}",resultSize);

    } catch (SQLException e) {
      log.info("db error",e);
      throw e;
    }finally {
      close(con,ps,null);
    }
  }


  public void delete(String memeberId) throws SQLException {
    String sql="delete from member where member_id=?";

    Connection con=null;
    PreparedStatement ps=null;
    try{
      con = getConnection();
      ps = con.prepareStatement(sql);
      ps.setString(1, memeberId);
      ps.executeUpdate();
    }catch (SQLException e){
      log.error("db error",e);
      throw e;
    }
    finally {
      close(con,ps,null);
    }
  }

  private void close(Connection con, Statement stmt, ResultSet rs) {

    JdbcUtils.closeResultSet(rs);
    JdbcUtils.closeStatement(stmt);
    // 트랜잭션 동기화를 사용하려면 DataSourcesUtils를 사용
    DataSourceUtils.releaseConnection(con,dataSource);
  }


  private Connection getConnection() throws SQLException {
    // 트랜잭션 동기화를 사용하려면 DataSourcesUtils를 사용
    Connection con = DataSourceUtils.getConnection(dataSource);
    log.info("get connection={},class={}",con,dataSource.getClass());
    return con;
  }
}
