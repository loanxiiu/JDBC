package test;

import model.CuocHop;
import model.GiaoVien;
import model.NhanVien;
import model.SinhVien;
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

                GiaoVien gv = new GiaoVien("gv1", "NT Loan", new Date(100,1,30),"Hibernate");
                SinhVien sv = new SinhVien("sv1", "Tung",new Date(1997-1900, 4,2), 8.5);
                session.save(gv);
                session.save(sv);

                tr.commit();
                session.close();
            }
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}
