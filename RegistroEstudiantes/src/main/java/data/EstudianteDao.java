package data;

import domain.*;
import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;

public class EstudianteDao {
    public static final String UPDATE = "UPDATE Estudiante SET nombre = ?, apellido = ? WHERE idEstudiante = ?";
    public static final String DELETE = "DELETE FROM Estudiante WHERE idEstudiante = ? ";

    public ArrayList<Estudiante> seleccionar(){
        Connection conexion = null;
        CallableStatement statement = null;
        ResultSet result = null;
        Estudiante estudiante = null;
        ArrayList<Estudiante> estudiantes = new ArrayList<>();

        try{
            conexion = Conexion.getConnection();
            statement = conexion.prepareCall("call sp_read_estudiantes()");
            result = statement.executeQuery();

            while(result.next()){
                int idEstudiante = result.getInt("idEstudiante");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");

                estudiante = new Estudiante(idEstudiante, nombre, apellido);

                estudiantes.add(estudiante);
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "No se ha podido cargar", "Error", 2);
        }

        finally{
            try{
                Conexion.close(result);
                Conexion.close(statement);
                Conexion.close(conexion);
            } catch(SQLException e){
                JOptionPane.showMessageDialog(null, "No se ha cerrado la conexión", "Error", 2);
            }
        }
        
        return estudiantes;
    }

    public void insertar(Estudiante estudiante){
        Connection conexion = null;
        CallableStatement consulta = null;
        try {
            conexion = Conexion.getConnection();
            consulta = conexion.prepareCall("call sp_insert_estudiante(?, ?)");

            consulta.setString(1, estudiante.getNombre());
            consulta.setString(2, estudiante.getApellido());
            consulta.executeUpdate();

            JOptionPane.showMessageDialog(null, "Estudiante agregado", "Error", 1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha podido insertar", "Error", 2);
        }

        finally{
            try {
                Conexion.close(consulta);
                Conexion.close(conexion);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "No se ha cerrado la conexión", "Error", 2);
            }
        }
    }

    public void actualizar(Estudiante estudiante){
        Connection conexion = null;
        PreparedStatement consulta = null;
        try {
            conexion = Conexion.getConnection();
            consulta = conexion.prepareStatement(UPDATE);
            consulta.setString(1, estudiante.getNombre());
            consulta.setString(2, estudiante.getApellido());
            consulta.setInt(3, estudiante.getIdEstudiante());
            consulta.executeUpdate();

            JOptionPane.showMessageDialog(null, "Estudiante actualizado", "Error", 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido actualizar " + ex.getMessage(), "Error", 2);
        }
        finally{
            try {
                Conexion.close(consulta);
                Conexion.close(conexion);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "No se ha cerrado la conexión", "Error", 2);
            }
        }
    }
    
     public void eliminar(Estudiante estudiante){
        Connection conexion = null;
        PreparedStatement consulta = null;
        try {
            conexion = Conexion.getConnection();
            consulta = conexion.prepareStatement(DELETE);
            consulta.setInt(1, estudiante.getIdEstudiante());
            consulta.executeUpdate();

            JOptionPane.showMessageDialog(null, "Estudiante eliminado", "Error", 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido eliminar", "Error", 2);
        }
        finally{
            try {
                Conexion.close(consulta);
                Conexion.close(conexion);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "No se ha cerrado la conexión", "Error", 2);
            }
        }
    }
}
