package pap2025;

/**
 * Clase Libro que hereda de DonacionMaterial
 */
public class Libro extends DonacionMaterial {
    private String titulo;
    private int cantPaginas;
    
    public Libro(int id, DTFecha fechaIngreso, String titulo, int cantPaginas) {
        super(id, fechaIngreso);
        this.titulo = titulo;
        this.cantPaginas = cantPaginas;
    }
    
    // Getters
    public String getTitulo() {
        return titulo;
    }
    
    public int getCantPaginas() {
        return cantPaginas;
    }
    
    // Setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public void setCantPaginas(int cantPaginas) {
        this.cantPaginas = cantPaginas;
    }
    
    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", fechaIngreso=" + fechaIngreso +
                ", titulo='" + titulo + '\'' +
                ", cantPaginas=" + cantPaginas +
                '}';
    }
}
