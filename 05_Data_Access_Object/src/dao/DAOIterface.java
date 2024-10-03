package dao;

import java.util.ArrayList;

public interface DAOIterface<T> {
    public int insert(T t);
    public int update(T t);
    public int delete(T t);
    public ArrayList<T> sellectAll();
    public T selectById(T t);
    public ArrayList<T> selectByCondition(String condition);
}
