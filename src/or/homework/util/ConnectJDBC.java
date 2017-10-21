package or.homework.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectJDBC {
    private static Connection conn;private static String DBURL = "jdbc:oracle://localhost:3306/java55";
    private static String DBUSER = "SYSTEM";
    private static String DBPASS= "Admin117";
    private static String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
    static {
        try {
            Class.forName(DBDRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn(){
        if(conn != null){
            return conn;
        }else{
            try {
                conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return conn;
        }
    }
}
