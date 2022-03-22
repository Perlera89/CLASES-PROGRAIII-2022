package data;

import domain.Estudiante;
import domain.Nota;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import viewModel.NotaVM;

public class NotaDao {
    public ArrayList<NotaVM> seleccionar(){
        Connection conexion = null;
        CallableStatement statement = null;
        ResultSet result = null;
        NotaVM nota = null;
        ArrayList<NotaVM> notas = new ArrayList<>();

        try{
            conexion = Conexion.getConnection();
            statement = conexion.prepareCall("call sp_read_mostrar_notas();");
            result = statement.executeQuery();

            while(result.next()){
                String nombre = result.getString("nombre");
                String materia = result.getString("nombre_materia");
                String _nota = result.getString("nota");
                

                nota = new NotaVM(nombre, materia, _nota);

                notas.add(nota);
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
        
        return notas;
    }
}
