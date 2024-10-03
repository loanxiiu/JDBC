package test;

import model.ChiTietDonHang;
import model.DonHang;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.sql.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();

//                DonHang dh1 = new DonHang();
//                dh1.setTenKhachHang("NT Loan");
//                dh1.setNgayMua(new Date(2025-1900,1,21));
//                dh1.setTenKhachHang("Tung");
//
//                for(int i=0; i<10000; i++){
//                    ChiTietDonHang ctdh = new ChiTietDonHang();
//                    ctdh.setTenSanPham("Mi hao hao");
//                    ctdh.setSoLuong(5);
//                    ctdh.setGiaBan(5000);
//                    ctdh.setThanhTien(5*5000);
//                    ctdh.setDonHang(dh1);
//                    dh1.addCTDH(ctdh);
//                }
//
//                session.save(dh1);

//                long batDau = System.currentTimeMillis();
//                DonHang dh = session.load(DonHang.class, 1);
//                long ketThuc = System.currentTimeMillis();
//                System.out.println("Thoi gian thuc hien cau lenh la: "+(ketThuc-batDau)+" ms");
//                //System.out.println(dh);

                long batDau = System.currentTimeMillis();
                DonHang dh = session.load(DonHang.class, 1);
                long ketThuc = System.currentTimeMillis();
                System.out.println(dh.toString());
                List<ChiTietDonHang> ds = dh.getDanhSachChiTiet();
                for(ChiTietDonHang d : ds){
                    System.out.println(d.toString());
                }
                System.out.println("Thoi gian thuc hien cau lenh la: "+(ketThuc-batDau)+" ms");


                tr.commit();
                session.close();
            }
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}
