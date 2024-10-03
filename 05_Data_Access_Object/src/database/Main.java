package database;

import java.sql.Connection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Connection con = JDBCUtil.getConnecion();
        System.out.println(con);

        JDBCUtil.printInfo(con);

        JDBCUtil.closeConnection(con);
    }
}