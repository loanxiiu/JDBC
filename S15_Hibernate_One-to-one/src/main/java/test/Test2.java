package test;

import model.Person;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.sql.Date;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();

                String hql = "select p.id, p.name, p.spouse.id, p.spouse.name from Person p";
                List<Object[]> results = session.createQuery(hql).list();
                for(Object[] result : results){
                    String id = result[0]+"";
                    String name = result[1]+"";
                    String spouseId = result[2]+"";
                    String spouseName = result[3]+"";
                    System.out.println(id + ": " + name + " da dinh hon voi " + spouseId + ": " + spouseName);
                }

                tr.commit();
                session.close();
            }
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}
