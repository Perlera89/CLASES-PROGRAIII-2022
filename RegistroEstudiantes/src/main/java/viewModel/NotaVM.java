package viewModel;

public class NotaVM {
    public String nombre;
    public String materia;
    public String nota;

    public NotaVM(String nombre, String materia, String nota) {
        this.nombre = nombre;
        this.materia = materia;
        this.nota = nota;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
}
