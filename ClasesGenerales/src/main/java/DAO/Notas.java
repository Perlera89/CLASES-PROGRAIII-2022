package DAO;

import static DAO.Estudiantes.SELECT;
import Entidades.Estudiante;
import Entidades.Nota;
import com.perlera.BD.ConnectionMysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Notas {
    public ArrayList<Nota> seleccionar(){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Nota nota = null;
        ArrayList<Nota> notas = new ArrayList<>();
        
        try{
            con = ConnectionMysql.getConnection();
            stmt = con.prepareStatement(SELECT);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                String nota = rs.get

                nota = new Nota(idEstudiante, nombre, apellido);

                notas.add(nota);
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return estudiantes;
    }
}
