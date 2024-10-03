package test;

import database.JDBCUtil;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

public class TestJDBCUtil {
    public static void main(String[] args) {
        try {
//        Buoc 1: tao ket noi
            Connection connection = JDBCUtil.getConnecion();

//        Buoc 2: Tao ra doi tuong statement
            Statement st = connection.createStatement();

//        Buoc3: Thuc thi cau lenh sql
            String sql = "insert into Person(person_id, last_name, first_name, gender, dob, income) \n" +
                    "values\n" +
                    "(3, \"Luong\", \"Tu\", \"nu\", null, 2000.5),\n" +
                    "(4, \"Nguyen\", \"Huy\", \"nam\", null, 2000.5);";
            int check = st.executeUpdate(sql);

//            Buoc 4: xu li ket qua
            System.out.println("So dong thay doi "+check);
            if(check>0){
                System.out.println("Them du lieu thanh cong");
            }
            else{
                System.out.println("Them du lieu that bai");
            }

//        Buoc 5: ngat ket noi
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
