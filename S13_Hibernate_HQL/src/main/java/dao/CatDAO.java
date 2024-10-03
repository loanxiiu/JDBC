package dao;

import model.Cat;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CatDAO implements DAOInterface<Cat> {
    @Override
    public List<Cat> getAll() {
        List<Cat> list = new ArrayList<Cat>();
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                // Thuc thi cau lenh HQL
                String hql = "from Cat";
                Query query = session.createQuery(hql);
                list = query.getResultList();
                tr.commit();
                session.close();
            }
            else {
                return null;
            }
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Cat selectById(Cat cat) {
        List<Cat> list = new ArrayList<Cat>();
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                // Thuc thi cau lenh HQL
                String hql = "from Cat c where c.id = :id";
                Query query = session.createQuery(hql);
                query.setParameter("id", cat.getId());
                list = query.getResultList();
                tr.commit();
                session.close();
            }
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        if(list.size() > 0){
            return list.get(0);
        }
        else {
            return null;
        }
    }

    @Override
    public boolean insert(Cat cat) {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                // Thuc thi cau lenh HQL

                // Chi luu khi chua ton tai
                session.save(cat);

//                // Them moi khi chua ton tai, cap nhat du lieu khi da ton tai
//                session.saveOrUpdate(cat);

                tr.commit();
                session.close();
                return true;
            }
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean update(Cat cat) {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                // Thuc thi cau lenh HQL

//                // Chi luu khi chua ton tai
//                session.save(cat);

                // Them moi khi chua ton tai, cap nhat du lieu khi da ton tai
                session.saveOrUpdate(cat);

                tr.commit();
                session.close();
                return true;
            }
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean delete(Cat cat) {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                // Thuc thi cau lenh HQL

//                // Chi luu khi chua ton tai
//                session.save(cat);

                // Them moi khi chua ton tai, cap nhat du lieu khi da ton tai
                session.delete(cat);

                tr.commit();
                session.close();
                return true;
            }
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
