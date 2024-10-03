package test;

import dao.KhachHangDAO;
import model.KhachHang;

import java.util.ArrayList;

public class TestKhachHangDAO {
    public static void main(String[] args) {
        ArrayList<KhachHang> list = KhachHangDAO.getInstance().sellectAll();
        for (KhachHang khachHang : list) {
            System.out.println(khachHang.toString());
        }
    }
}
