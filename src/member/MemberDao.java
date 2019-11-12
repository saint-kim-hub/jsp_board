package member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Timestamp;

public class MemberDao extends CommonDao {
    /*
     * 신규 회원정보 삽입
     */
    public int insertMember(MemberInfo member) {
        PreparedStatement pstmt = null;
        String query = "INSERT INTO USER (user_id, user_pass, user_name, user_phone, user_email) VALUES(?, HEX(AES_ENCRYPT(?, SHA2(\"bluesky\",512))),?,?,?)";
        int res = 0;
        openConnection();
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, member.getId());
            // AES_ENCRYPT("abc", SHA2("enc_key",512))
            pstmt.setString(2, member.getPass());
            pstmt.setString(3, member.getName());
            pstmt.setString(4, member.getPhone());
            pstmt.setString(5, member.getEmail());
//            Timestamp ts = new Timestamp(System.currentTimeMillis());
//            pstmt.setTimestamp(6, ts);
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
        String query = "DELETE FROM USER WHERE user_id=?";
        int res = 0;
        openConnection();
        try {
            pstmt = con.prepareStatement(query);
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
        String query = "UPDATE USER SET user_pass=?, user_name=?, user_phone=?, user_email=? WHERE user_id=?";
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
        String query = "SELECT * FROM USER WHERE user_id=? and user_pass=HEX(AES_ENCRYPT(?, SHA2(\"bluesky\",512)))";
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
        String query = "SELECT * FROM USER WHERE user_id=?";
        openConnection();
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            member.setId(rs.getString("user_id"));
//            member.setPass(rs.getString("user_pass"));
            member.setName(rs.getString("user_name"));
            member.setPhone(rs.getString("user_phone"));
            member.setEmail(rs.getString("user_email"));
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return member;
    }
}
