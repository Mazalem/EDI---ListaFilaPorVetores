public class Processo {
    private int id;
    private String titulo;
    
    public Processo(String titulo) {
        this.id = 0;
        this.titulo = titulo;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}