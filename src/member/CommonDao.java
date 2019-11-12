package member;

import java.sql.Connection;
import java.sql.DriverManager;

public class CommonDao {
    private final String driverName="org.mariadb.jdbc.Driver";
    private final String url = "jdbc:mysql://DB서버-IP주소:3306/my_site";
    private final String db_id = "DB-아이디";
    private final String db_pw = "DB-비밀번호";

    protected Connection con = null;

    public Connection openConnection() {
        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url, db_id, db_pw);
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
