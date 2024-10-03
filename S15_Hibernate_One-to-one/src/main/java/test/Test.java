package test;

import model.Person;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.sql.Date;

public class Test {
    public static void main(String[] args) {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();

//                Person p1 = new Person("Loan", new Date(System.currentTimeMillis()), null);
//                session.save(p1);

//                Person p1 = session.find(Person.class, 31L);
//                Person p2 = new Person("Tung", new Date(System.currentTimeMillis()), p1);
//                session.saveOrUpdate(p2);

                Person p1 = session.find(Person.class, 31L);
                Person p2 = session.find(Person.class, 32L);

                p1.setSpouse(p2);
                p2.setSpouse(p1);
                session.saveOrUpdate(p1);
                session.saveOrUpdate(p2);

                tr.commit();
                session.close();
            }
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}
