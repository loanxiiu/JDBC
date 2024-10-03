package test;

import model.CuocHop;
import model.NhanVien;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();

                NhanVien nv1 = new NhanVien("NV1", "NTLOAN", new Date(2004-1900, 21,12));
//                session.save(nv1);

                CuocHop ch1=new CuocHop();
                ch1.setTenCuocHop("Hop hoi dong quan tri cong ty");
                ch1.setThoiGian(new Date(2024-1900, 21,12));
                ch1.setDiaDiem("Phong hop 1");
                ch1.addNhanVien(nv1);

                session.save(ch1);

                tr.commit();
                session.close();
            }
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}
