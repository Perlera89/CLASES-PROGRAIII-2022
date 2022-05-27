package Entidades;

public class Materia {
    
    int idMateria;
    String nombreMateria;

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }
    
    public Materia(){
        
    }

    public Materia(int idMateria, String nombreMateria) {
        this.idMateria = idMateria;
        this.nombreMateria = nombreMateria;
    }
    
    
}
