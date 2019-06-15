package member;

import java.sql.Connection;
import java.sql.DriverManager;

public class CommonDao {
    Connection con;
    // String url = "jdbc:mysql://localhost:3306/my_site?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    String url = "jdbc:mysql://localhost:3306/my_site";
    String user = "jsp_user";
    String pass = "비밀번호";

    public Connection openConnection() {
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public void closeConnection() {
        try {
            if (con != null)
                con.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con = null;
        }
    }
}
