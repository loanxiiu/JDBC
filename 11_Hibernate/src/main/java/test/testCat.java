package test;


import model.Cat;
import model.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;


public class testCat {
    public static void main(String[] args) {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if(sessionFactory != null) {
                Session session = sessionFactory.openSession();
                try {
                    Transaction transaction = session.beginTransaction();
//                    Cat cat1 = new Cat();
//                    cat1.setName("Kitty");
//                    cat1.setId(3);
//                    cat1.setSex(false);
////                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
////                    Date date = (Date) sdf.parse("2023-01-01");
////                    cat1.setDateOfBirth(date);
//                    session.save(cat1);

                    Dog dog1 = new Dog();
                    dog1.setName("dog1");
                    dog1.setId(2);
                    session.save(dog1);
                    transaction.commit();
                } finally {
                    session.close();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
