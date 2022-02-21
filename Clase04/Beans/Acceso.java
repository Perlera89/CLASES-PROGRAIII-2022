package Beans;

import Services.IEstudiante;
import Pojos.*;

public class Acceso implements IEstudiante{
    @Override
    public int acceso(Estudiante estudiante) {
        if(estudiante.getUsername().equals("Manuel") && estudiante.getPassword().equals("1234")){
            return 1;
        }

        else{
            return 0;
        }
    }

}
