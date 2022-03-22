package com.perlera.BD;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionMysql {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/clase?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String userBd = "perlera";
        String passBd = "12345678";

        return DriverManager.getConnection(url, userBd, passBd);
    }
}
