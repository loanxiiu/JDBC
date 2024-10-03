package test;

import model.ChiTietDonHang;
import model.DonHang;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.sql.Date;

public class Test {
    public static void main(String[] args) {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();

                DonHang dh1 = new DonHang();
                dh1.setTenKhachHang("NT Loan");
                dh1.setNgayMua(new Date(2025-1900,1,21));
                dh1.setTenKhachHang("Tung");

                ChiTietDonHang ctdh1 = new ChiTietDonHang();
                ctdh1.setTenSanPham("Mi hao hao");
                ctdh1.setSoLuong(5);
                ctdh1.setGiaBan(5000);
                ctdh1.setThanhTien(5*5000);

                ChiTietDonHang ctdh2 = new ChiTietDonHang();
                ctdh2.setTenSanPham("Sua vinamilk");
                ctdh2.setSoLuong(1);
                ctdh2.setGiaBan(30000);
                ctdh2.setThanhTien(1*30000);

                dh1.addCTDH(ctdh1);
                dh1.addCTDH(ctdh2);

                session.update(dh1);

//                DonHang dh = session.load(DonHang.class, 1);
//                session.remove(dh);

                tr.commit();
                session.close();
            }
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}
