package test;

import dao.CatDAO;
import model.Cat;

import java.sql.Date;

public class testCat2 {
    public static void main(String[] args) {
        CatDAO cat_DAO = new CatDAO();
        Cat cat = new Cat(20,"Kitty", new Date(2024-1900, 8,30), false);
        cat_DAO.insert(cat);

//        Transient
//        Cat cat1 = new Cat();
//        cat1.setId(1);

//        try {
//            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//            if(sessionFactory != null){
//                Session session = sessionFactory.openSession();
//                Transaction tr = session.beginTransaction();
//
//                // Persistent
//                session.saveOrUpdate(cat);
//
//                tr.commit();
//                session.close();
//            }
//        } catch (HibernateException e) {
//            throw new RuntimeException(e);
//        }
        System.out.println(cat);
    }
}
