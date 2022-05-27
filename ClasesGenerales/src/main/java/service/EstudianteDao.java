package service;

import Entidades.Estudiante;
import com.william.BD.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public  class EstudianteDao {

    Conexion con = new Conexion();
    Connection conexion = con.getConecction();

    public ArrayList<Estudiante> listarEstudiantes() {
        ArrayList<Estudiante> listado = null;

        try {
            listado = new ArrayList<>();

            CallableStatement cb = conexion.prepareCall("{call sp_s_estudiantes()}");
            ResultSet resultado = cb.executeQuery();

            while (resultado.next()) {
                //Llamar a el objeto de entidades.
                Estudiante estudiante = new Estudiante();
              
                estudiante.setIdEstudiante(resultado.getInt("idEstudiante"));
                estudiante.setNombre(resultado.getString("nombre"));
                estudiante.setApellido(resultado.getString("apellido"));
                estudiante.setFechaNacimiento(resultado.getDate("fechaNc"));
                listado.add(estudiante);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error", e.getMessage(), 1);
        }

        return listado;

    }
    
    public void agregarEstudiante(Estudiante estudiante){
        try {
            CallableStatement cb = conexion.prepareCall("{call sp_i_estudiante(?,?,?)}");
            cb.setString(1, estudiante.getNombre());
            cb.setString(2, estudiante.getApellido());
            cb.setDate(3, new java.sql.Date(estudiante.getFechaNacimiento().getTime()));
            
            cb.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error", e.getMessage(), 1);
        }
    } 
}
