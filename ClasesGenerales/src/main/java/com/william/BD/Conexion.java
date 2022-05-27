package com.william.BD;
import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
    
    private static Connection ConnectionBD= null;
    public Connection getConecction (){
        try {
            String url = "jdbc:mysql://localhost:3306/clase";
            String user = "perlera";
            String password = "12345678";
            
            ConnectionBD = DriverManager.getConnection(url,user,password);
            System.out.println("Conexion exitosa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error "+e.toString());
        }
        
    return ConnectionBD;
    }
    
}
