package dao;

import database.JDBCUtil;
import model.User;
import model.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO implements DAOIterface<User> {
    public static UserDAO getInstance(){
        return new UserDAO();
    };

    @Override
    public int insert(User u) {
        int ketQua=0;
        try {
//        Buoc1: tao ket noi den CSDL
            Connection conn = JDBCUtil.getConnecion();

//        Buoc 2: tao ra doi tuong statement
            String sql = "insert into user values(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getHoVaTen());

//        Buoc3: thuc thi cau lenh SQL
            ketQua = ps.executeUpdate();

//            Buoc4:
            System.out.println("Ban da thuc thi: "+sql);
            System.out.println("Co "+ ketQua +" dong bi thay doi!");

            //            Buoc 5:
            JDBCUtil.closeConnection(conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return ketQua;
    }

    @Override
    public int update(User u) {
        int ketQua=0;
        try {
//        Buoc1: tao ket noi den CSDL
            Connection conn = JDBCUtil.getConnecion();

//        Buoc 2: tao ra doi tuong statement
            String sql = "update user set password =?, hoVaTen=? where userName = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, u.getPassword());
            ps.setString(2, u.getHoVaTen());
            ps.setString(3, u.getUsername());

//        Buoc3: thuc thi cau lenh SQL
            ketQua = ps.executeUpdate();

//            Buoc4:
            System.out.println("Ban da thuc thi: "+sql);
            System.out.println("Co "+ ketQua +" dong bi thay doi!");

            //            Buoc 5:
            JDBCUtil.closeConnection(conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return ketQua;
    }

    @Override
    public int delete(User u) {
        int ketQua=0;
        try {
//        Buoc1: tao ket noi den CSDL
            Connection conn = JDBCUtil.getConnecion();

//        Buoc 2: tao ra doi tuong statement
            String sql = "delete from user where userName = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, u.getUsername());

//        Buoc3: thuc thi cau lenh SQL
            ketQua = ps.executeUpdate();

//            Buoc4:
            System.out.println("Ban da thuc thi: "+sql);
            System.out.println("Co "+ ketQua +" dong bi thay doi!");

            //            Buoc 5:
            JDBCUtil.closeConnection(conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return ketQua;
    }

    @Override
    public ArrayList<User> sellectAll() {
        ArrayList<User> ketQua = new ArrayList<User>();
        try {
//        Buoc1: tao ket noi den CSDL
            Connection conn = JDBCUtil.getConnecion();

//        Buoc 2: tao ra doi tuong statement
            String sql = "select * from user";
            PreparedStatement ps = conn.prepareStatement(sql);

//        Buoc3: thuc thi cau lenh SQL
            ResultSet rs = ps.executeQuery();

//            Buoc4:
            while (rs.next()){
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String hoVaTen = rs.getString("hoVaTen");
                User user = new User(userName, password, hoVaTen);
                ketQua.add(user);
            }

            //            Buoc 5:
            JDBCUtil.closeConnection(conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    @Override
    public User selectById(User user) {
        User ketQua= null;
        try {
//        Buoc1: tao ket noi den CSDL
            Connection conn = JDBCUtil.getConnecion();

//        Buoc 2: tao ra doi tuong statement
            String sql = "select * from user where userName = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());

//        Buoc3: thuc thi cau lenh SQL
            ResultSet rs = ps.executeQuery();

//            Buoc4:
            while (rs.next()){
                String username = rs.getString("userName");
                String password = rs.getString("password");
                String hoVaTen = rs.getString("hoVaTen");
                ketQua = new User(username, password, hoVaTen);
            }

//            Buoc 5:
            JDBCUtil.closeConnection(conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return ketQua;
    }

    @Override
    public ArrayList<User> selectByCondition(String condition) {
        ArrayList<User> ketQua = new ArrayList<>();
        try {
//        Buoc1: tao ket noi den CSDL
            Connection conn = JDBCUtil.getConnecion();

//        Buoc 2: tao ra doi tuong statement
            Statement st = conn.createStatement();

//        Buoc3: thuc thi cau lenh SQL
            String sql = "select * from user where "+condition;
            ResultSet rs = st.executeQuery(sql);

//            Buoc4:
            while (rs.next()){
                String username = rs.getString("userName");
                String password = rs.getString("password");
                String hoVaTen = rs.getString("hoVaTen");
                User user = new User(username, password, hoVaTen);
                ketQua.add(user);
            }

            //            Buoc 5:
            JDBCUtil.closeConnection(conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }
}
