package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    public static Connection getConnecion(){
        Connection c = null;

        try {

//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Đăng ký MySQL Driver với DriverManager
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://localhost:3306/nhasach";
            String username = "root";
            String password = "12341234";

//            Tao ket noi
            c = DriverManager.getConnection(url, username, password);

        }
//        catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        catch (SQLException e) {
            e.printStackTrace();
        }

        return c;
    }

    public static void closeConnection(Connection c){
        try {
            if(c != null){
                c.close();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void printInfo(Connection c){
        try {
            if(c != null){
                System.out.println(c.getMetaData().toString());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
