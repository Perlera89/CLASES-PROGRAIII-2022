package service;

import Entidades.*;
import ViewModel.NotaVM;
import com.william.BD.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class NotaDao {

    Conexion con = new Conexion();
    Connection conexion = con.getConecction();

    public ArrayList<Nota> listarNotas() {
        ArrayList<Nota> listado = null;

        try {
            listado = new ArrayList<Nota>();

            CallableStatement cb = conexion.prepareCall("{call sp_seleccionar_estudiantes()}");
            ResultSet resultado = cb.executeQuery();

            while (resultado.next()) {
                //Llamar a el objeto de entidades.
                Nota es = new Nota();
                es.setNota(resultado.getString("nota"));
                es.setNombreMateria(resultado.getString("nombre_materia"));
                es.setNombre(resultado.getString("nombre"));

                listado.add(es);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return listado;

    }

    public ArrayList<NotaVM> listarNotasEstudiantes() {
        ArrayList<NotaVM> listado = null;

        try {
            listado = new ArrayList<NotaVM>();

            CallableStatement cb = conexion.prepareCall("{call sp_s_notas()}");
            ResultSet resultado = cb.executeQuery();

            while (resultado.next()) {
                //Llamar a el objeto de entidades.
                NotaVM es = new NotaVM();
                es.setNota(resultado.getString("nota"));
                es.setNombremateria(resultado.getString("nombre_materia"));
                es.setNombre(resultado.getString("nombre"));
                listado.add(es);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return listado;

    }
    
    public void agregarNota(Nota nota){
        try {
            CallableStatement cb = conexion.prepareCall("{call sp_i_nota(?,?,?)}");
            cb.setInt(1, nota.getIdEstudiante());
            cb.setInt(2, nota.getIdMateria());
            cb.setString(3, nota.getNota());
            
            cb.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    } 

}
