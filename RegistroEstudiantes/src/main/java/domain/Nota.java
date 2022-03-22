package domain;

public class Nota extends Estudiante{
    private int idNota;
    private String nota;
    
    public Nota(){
        
    }
    
    public Nota(int idNota, String nota){
        this.idNota = idNota;
        this.nota = nota;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }
    
}
