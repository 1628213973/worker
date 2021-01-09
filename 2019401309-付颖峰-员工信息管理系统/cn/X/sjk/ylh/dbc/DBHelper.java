package cn.X.sjk.ylh.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

;


//b3

//
 public class DBHelper {
    public static final String url = "jdbc:mysql://localhost:3306/fyf";
    public static final String name = "org.gjt.mm.mysql.Driver";
    public static final String user = "root";
    public static final String password = "root";



    public Connection conn = null;
    public PreparedStatement pst = null;

    public DBHelper(String sql) {
        try {
            Class.forName(name);
            conn = DriverManager.getConnection(url, user, password);
            pst = conn.prepareStatement(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            this.conn.close();
            this.pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

