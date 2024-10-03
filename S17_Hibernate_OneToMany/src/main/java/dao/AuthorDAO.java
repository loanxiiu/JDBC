package dao;

import java.util.Collections;
import java.util.List;

public class AuthorDAO implements DAOInterface{
    @Override
    public List getAll() {
        return Collections.emptyList();
    }

    @Override
    public Object selectById(Object o) {
        return null;
    }

    @Override
    public boolean insert(Object o) {
        return false;
    }

    @Override
    public boolean update(Object o) {
        return false;
    }

    @Override
    public boolean delete(Object o) {
        return false;
    }
}
