package test;


import dao.CatDAO;
import model.Cat;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;


public class testCat {
    public static void main(String[] args) {
        CatDAO cat_DAO = new CatDAO();
//        Cat cat = new Cat(5,"Kitty", new Date(2024-1900, 8,30), false);
//        cat_DAO.update(cat);

//        Transient
        Cat cat1 = new Cat();
        cat1.setId(1);

        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();

                // Persistent
                cat1 = session.get(Cat.class, 10);

                tr.commit();
                session.close();
            }
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        System.out.println(cat1);
    }
}
