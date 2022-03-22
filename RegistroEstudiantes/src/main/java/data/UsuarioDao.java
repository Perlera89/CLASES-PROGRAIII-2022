package data;

import domain.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import viewModel.NotaVM;

public class UsuarioDao {
    public Usuario seleccionarUsuario(String usuario){
        Connection conexion = null;
        CallableStatement statement = null;
        Usuario miUsuario = null;
        ResultSet result = null;

        try{
            conexion = Conexion.getConnection();
            statement = conexion.prepareCall("SELECT * FROM usuario WHERE usuario = '"+usuario+"'");
            result = statement.executeQuery();

            while(result.next()){
                int idUsuario = result.getInt("id_usuario");
                String nombreUsuario = result.getString("usuario");
                String clave = result.getString("clave");
                

                miUsuario = new Usuario(idUsuario, nombreUsuario, clave);
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
        
        return miUsuario;
    }
}
