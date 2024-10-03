package test;

import dao.UserDAO;
import model.User;

public class TestUser {
    public static void main(String[] args) {
        User u1 = new User("u1", "12345", "loaniuoi");
//        UserDAO.getInstance().insert(u1);
        User u2 = new User("loaniuoi", "12346", "loaniuoi");
        User u3 = new User("x\' or 1=1 -- ", "", "");
        User list2 = UserDAO.getInstance().selectById(u3);
        System.out.println(list2);
    }
}
