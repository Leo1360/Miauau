package br.com.capy.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;

    public static Connection getConnectionMySql() throws ClassNotFoundException, SQLException {
        driver = "com.mysql.cj.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/miauau";
        user = "root";
        password = "root";
        return getConnection();

    }

    public static Connection getConnectionOracle() throws ClassNotFoundException, SQLException {
        driver = "oracle.jdbc.driver.OracleDriver";
        url = "jdbc:oracle:thin:@localhost:1521:xe";
        user = "C##ESIII";
        password = "123456";
        return getConnection();

    }

    private static Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, user, password);

        return conn;

    }

}
