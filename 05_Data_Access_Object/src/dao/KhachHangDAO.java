package dao;

import database.JDBCUtil;
import model.KhachHang;

import java.sql.*;
import java.util.ArrayList;

public class KhachHangDAO implements DAOIterface<KhachHang>{
    public static KhachHangDAO getInstance(){
        return new KhachHangDAO();
    };

    @Override
    public int insert(KhachHang khachHang) {
        return 0;
    }

    @Override
    public int update(KhachHang khachHang) {
        return 0;
    }

    @Override
    public int delete(KhachHang khachHang) {
        return 0;
    }

    @Override
    public ArrayList<KhachHang> sellectAll() {
        ArrayList<KhachHang> result = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnecion();
            Statement st = con.createStatement();
            String sql = "select * from khachhang";
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt("id");
                String hoVaTen = rs.getString("hoVaTen");
                Date ngaySinh = rs.getDate("ngaySinh");
                String diaChi = rs.getString("diaChi");
                KhachHang kh = new KhachHang(id, hoVaTen, ngaySinh, diaChi);
                result.add(kh);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public KhachHang selectById(KhachHang khachHang) {
        return null;
    }

    @Override
    public ArrayList<KhachHang> selectByCondition(String condition) {
        return null;
    }
}
