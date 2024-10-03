package test;


import dao.CatDAO;
import model.Cat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;
import java.sql.Date;
import java.util.List;


public class testCat {
    public static void main(String[] args) {
        CatDAO cat_DAO = new CatDAO();
//        List<Cat> catList = cat_DAO.getAll();
//        for (Cat cat : catList) {
//            System.out.println(cat.toString());
//        }

//        Cat c = new Cat();
//        c.setId(1);
//        Cat c1 = cat_DAO.selectById(c);
//        System.out.println(c1);

        Cat c3 = new Cat(9,"Meo Mum", new Date(2005-1900,2,15),true);
        cat_DAO.delete(c3);
    }
}
