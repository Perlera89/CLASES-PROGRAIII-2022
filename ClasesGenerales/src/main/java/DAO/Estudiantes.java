package DAO;

import Entidades.*;
import com.perlera.BD.ConnectionMysql;
import java.sql.*;
import java.util.ArrayList;

public class Estudiantes {
    public static final String SELECT = "SELECT idEstudiante, nombre, apellido from Estudiante";
    
    public ArrayList<Estudiante> seleccionar(){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Estudiante estudiante = null;
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        
        try{
            con = ConnectionMysql.getConnection();
            stmt = con.prepareStatement(SELECT);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                int idEstudiante = rs.getInt("idEstudiante");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");

                estudiante = new Estudiante(idEstudiante, nombre, apellido);

                estudiantes.add(estudiante);
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return estudiantes;
    }
}
