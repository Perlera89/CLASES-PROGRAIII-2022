package Entidades;

public class Nota extends Estudiante {
    int idNota;
    String nota;

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public Nota(){
        
    }
    
    public Nota(int idEstudiante, int idMateria, String nota){
        this.idEstudiante = idEstudiante;
        this.idMateria = idMateria;
        this.nota = nota;
    }
}
