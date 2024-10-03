package test;

import model.Author;
import model.Book;
import model.Person;
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

//                Author author1 = new Author("01", "NT Loan", new Date(2004-1900,12,21));
//                Author author2 = new Author("02", "NT Tung", new Date(1997-1900,12,21));
//                Book book1 = new Book("b1", "Loan iu oi", 5000, author2);
//                Book book2 = new Book("b2", "Loan xinh iu", 5000, author1);
//
//                session.save(author1);
//                session.save(author2);
//                session.save(book1);
//                session.save(book2);

                Book b1= session.find(Book.class, "b1");
                System.out.println(b1);

                tr.commit();
                session.close();
            }
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}
