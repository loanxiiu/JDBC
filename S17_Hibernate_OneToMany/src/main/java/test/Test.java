package test;

import model.Customer;
import model.My_Order;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();

                Customer c1 = new Customer("01", "NT Loan", "ntloan@gmail.com");
                My_Order o1 = new My_Order("sp1", "HaNoi", c1);
                My_Order o2 = new My_Order("sp2", "HaNoi", c1);
                My_Order o3 = new My_Order("sp3", "HaNoi", c1);
                My_Order o4 = new My_Order("sp4", "HaNoi", c1);
                My_Order o5 = new My_Order("sp5", "HaNoi", c1);

                List<My_Order> myOrders = new ArrayList<My_Order>();
                myOrders.add(o1);
                myOrders.add(o2);
                myOrders.add(o3);
                myOrders.add(o4);
                myOrders.add(o5);

                c1.setOrders(myOrders);

                session.saveOrUpdate(c1);
                session.saveOrUpdate(o1);
                session.saveOrUpdate(o2);
                session.saveOrUpdate(o3);
                session.saveOrUpdate(o4);
                session.saveOrUpdate(o5);

                Customer c2 = new Customer("02", "NT Tung", "ntloan@gmail.com");
                session.saveOrUpdate(c2);

                String hql = "from Customer c where size(c.myOrders) > 0";
                List<Customer> customers = session.createQuery(hql).list();
                for (Customer c : customers) {
                    System.out.println(c);
                }

                tr.commit();
                session.close();
            }
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}
