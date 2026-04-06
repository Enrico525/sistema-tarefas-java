package javaapplication4;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    private static final String URL = "jdbc:mysql://localhost:3306/NEW";
    private static final String USER = "root";
    private static final String PASSWORD = "Enrico@2008";

    public static Connection conectar() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    static Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}