package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

public class DataManager {
    Connection con = null;
    //String url = "jdbc:mysql://localhost:3306/my_site?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    String url = "jdbc:mysql://localhost:3306/my_site";
    String user = "jsp_user";
    String pass = "qwer1234";

    private Connection openConnection() {
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    private void closeConnection() {
        try {
            if (con != null)
                con.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con = null;
        }
    }

    /*
     * 신규 회원정보 삽입
     */
    public int insertMember(MemberInfo member) {
        PreparedStatement pstmt = null;
        String query = "INSERT INTO member VALUES(?,?,?,?,?,?)";
        int res = 0;
        openConnection();
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, member.getId());
            pstmt.setString(2, member.getPass());
            pstmt.setString(3, member.getName());
            pstmt.setString(4, member.getPhone());
            pstmt.setString(5, member.getEmail());
            Timestamp ts = new Timestamp(System.currentTimeMillis());
            pstmt.setTimestamp(6, ts);
            res = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
    }
    
    /*
     * 기존 회원정보 삭제
     */
    public int removeMember(String id) {
        PreparedStatement pstmt = null;
        String query = "DELETE FROM member WHERE id=?";
        int res = 0;
        openConnection();
        try {
            pstmt = con.prepareCall(query);
            pstmt.setString(1, id);
            res = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
    }
    
    /*
     * 기존 회원정보 수정
     */
    public int updateMember(MemberInfo member) {
        PreparedStatement pstmt = null;
        String query = "UPDATE member SET pass=?, name=?, phone=?, email=? WHERE id=?";
        int res = 0;
        openConnection();
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, member.getPass());
            pstmt.setString(2, member.getName());
            pstmt.setString(3, member.getPhone());
            pstmt.setString(4, member.getEmail());
            pstmt.setString(5, member.getId());
            res = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
    }
    
    /*
     * 회원가입 여부 확인
     */
    public boolean isMember(String id, String pass) {
        PreparedStatement pstmt = null;
        String query = "SELECT * FROM member WHERE id=? and pass=?";
        boolean res = false;
        openConnection();
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            pstmt.setString(2, pass);
            ResultSet rs = pstmt.executeQuery();
            res = rs.next();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
    }
    
    /*
     * 기존 회원정보 확인
     */
    public MemberInfo getMember(String id) {
        PreparedStatement pstmt = null;
        MemberInfo member = new MemberInfo();
        String query = "SELECT * FROM member WHERE id=?";
        openConnection();
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            member.setId(rs.getString("id"));
            member.setPass(rs.getString("pass"));
            member.setName(rs.getString("name"));
            member.setPhone(rs.getString("phone"));
            member.setEmail(rs.getString("email"));
            member.setReg_date(rs.getTimestamp("reg_date"));
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return member;
    }
}
