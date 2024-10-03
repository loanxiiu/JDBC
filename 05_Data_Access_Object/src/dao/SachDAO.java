package dao;

import database.JDBCUtil;
import model.Sach;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SachDAO implements DAOIterface<Sach> {
    public static SachDAO getInstance(){
        return new SachDAO();
    };

    @Override
    public int insert(Sach t) {
        int ketQua=0;
        try {
//        Buoc1: tao ket noi den CSDL
            Connection conn = JDBCUtil.getConnecion();

//        Buoc 2: tao ra doi tuong statement
            Statement st = conn.createStatement();

//        Buoc3: thuc thi cau lenh SQL
            String sql = "insert into sach(id, tenSach, giaBan, namXuatBan)" +
                    "value ('"+t.getId()+"' , '"+t.getTenSach()+"' , '"+t.getGiaBan()+"' , '"+t.getNamXuatBan()+"')";

            ketQua = st.executeUpdate(sql);

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
    public int update(Sach t) {
        int ketQua=0;
        try {
//        Buoc1: tao ket noi den CSDL
            Connection conn = JDBCUtil.getConnecion();

//        Buoc 2: tao ra doi tuong statement
            Statement st = conn.createStatement();

//        Buoc3: thuc thi cau lenh SQL
            String sql = "update sach set tenSach ='"+t.getTenSach()+"',giaBan ="+t.getGiaBan()+", namXuatBan="+t.getNamXuatBan()+" where id = '"+t.getId()+"\'";

            ketQua = st.executeUpdate(sql);

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
    public int delete(Sach t) {
        int ketQua=0;
        try {
//        Buoc1: tao ket noi den CSDL
            Connection conn = JDBCUtil.getConnecion();

//        Buoc 2: tao ra doi tuong statement
            Statement st = conn.createStatement();

//        Buoc3: thuc thi cau lenh SQL
            String sql = "delete from sach where id = '"+t.getId()+"'";

            ketQua = st.executeUpdate(sql);

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
    public ArrayList<Sach> sellectAll() {
        ArrayList<Sach> ketQua = new ArrayList<>();
        try {
//        Buoc1: tao ket noi den CSDL
            Connection conn = JDBCUtil.getConnecion();

//        Buoc 2: tao ra doi tuong statement
            Statement st = conn.createStatement();

//        Buoc3: thuc thi cau lenh SQL
            String sql = "select * from sach";
            ResultSet rs = st.executeQuery(sql);

//            Buoc4:
            while (rs.next()){
                String id = rs.getString("id");
                String tenSach = rs.getString("tenSach");
                float giaBan = rs.getFloat("giaBan");
                int namXuatBan = rs.getInt("namXuatBan");
                Sach sach = new Sach(id, tenSach, giaBan, namXuatBan);
                ketQua.add(sach);
            }

            //            Buoc 5:
            JDBCUtil.closeConnection(conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    @Override
    public Sach selectById(Sach sach) {
        Sach ketQua= null;
        try {
//        Buoc1: tao ket noi den CSDL
            Connection conn = JDBCUtil.getConnecion();

//        Buoc 2: tao ra doi tuong statement
            Statement st = conn.createStatement();

//        Buoc3: thuc thi cau lenh SQL
            String sql = "select * from sach where id = '"+sach.getId()+"'";

            ResultSet rs = st.executeQuery(sql);

//            Buoc4:
            while (rs.next()){
                String id = rs.getString("id");
                String tenSach = rs.getString("tenSach");
                float giaBan = rs.getFloat("giaBan");
                int namXuatBan = rs.getInt("namXuatBan");
                ketQua = new Sach(id, tenSach, giaBan, namXuatBan);
            }

//            Buoc 5:
            JDBCUtil.closeConnection(conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return ketQua;
    }

    @Override
    public ArrayList<Sach> selectByCondition(String condition) {
        ArrayList<Sach> ketQua = new ArrayList<>();
        try {
//        Buoc1: tao ket noi den CSDL
            Connection conn = JDBCUtil.getConnecion();

//        Buoc 2: tao ra doi tuong statement
            Statement st = conn.createStatement();

//        Buoc3: thuc thi cau lenh SQL
            String sql = "select * from sach where "+condition;
            ResultSet rs = st.executeQuery(sql);

//            Buoc4:
            while (rs.next()){
                String id = rs.getString("id");
                String tenSach = rs.getString("tenSach");
                float giaBan = rs.getFloat("giaBan");
                int namXuatBan = rs.getInt("namXuatBan");
                Sach sach = new Sach(id, tenSach, giaBan, namXuatBan);
                ketQua.add(sach);
            }

            //            Buoc 5:
            JDBCUtil.closeConnection(conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }
}
