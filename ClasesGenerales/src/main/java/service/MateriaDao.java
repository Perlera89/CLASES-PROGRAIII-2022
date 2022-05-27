package service;

import Entidades.Estudiante;
import Entidades.Materia;
import Entidades.Nota;
import ViewModel.NotaVM;
import com.william.BD.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MateriaDao {

    Conexion con = new Conexion();
    Connection conexion = con.getConecction();

    public ArrayList<Materia> listarMaterias() {
        ArrayList<Materia> listado = null;

        try {
            listado = new ArrayList<>();

            CallableStatement cb = conexion.prepareCall("{call sp_s_materias()}");
            ResultSet resultado = cb.executeQuery();

            while (resultado.next()) {
                //Llamar a el objeto de entidades.
                Materia materia = new Materia();
                materia.setIdMateria(resultado.getInt("idMateria"));
                materia.setNombreMateria(resultado.getString("nombre_materia"));

                listado.add(materia);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return listado;

    }

}
