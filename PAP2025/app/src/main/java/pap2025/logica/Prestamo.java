package pap2025.logica;

import pap2025.datatypes.DTFecha;

/**
 * Clase Prestamo que representa un préstamo de material
 */
public class Prestamo {
    private int id;
    private Material material;
    private Lector lector;
    private Bibliotecario bibliotecario;
    private DTFecha fechaSolicitada;
    private DTFecha fechaDevolucion;
    private EstadoP estadoP;
    
    public Prestamo(int id, Material material, Lector lector, Bibliotecario bibliotecario, 
                   DTFecha fechaSolicitada, DTFecha fechaDevolucion, EstadoP estadoP) {
        this.id = id;
        this.material = material;
        this.lector = lector;
        this.bibliotecario = bibliotecario;
        this.fechaSolicitada = fechaSolicitada;
        this.fechaDevolucion = fechaDevolucion;
        this.estadoP = estadoP;
    }
    
    // Getters
    public int getId() {
        return id;
    }
    
    public Material getMaterial() {
        return material;
    }
    
    public Lector getLector() {
        return lector;
    }
    
    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }
    
    public DTFecha getFechaSolicitada() {
        return fechaSolicitada;
    }
    
    public DTFecha getFechaDevolucion() {
        return fechaDevolucion;
    }
    
    public EstadoP getEstadoP() {
        return estadoP;
    }
    
    // Setters
    public void setId(int id) {
        this.id = id;
    }
    
    public void setMaterial(Material material) {
        this.material = material;
    }
    
    public void setLector(Lector lector) {
        this.lector = lector;
    }
    
    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }
    
    public void setFechaSolicitada(DTFecha fechaSolicitada) {
        this.fechaSolicitada = fechaSolicitada;
    }
    
    public void setFechaDevolucion(DTFecha fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    
    public void setEstadoP(EstadoP estadoP) {
        this.estadoP = estadoP;
    }
    
    @Override
    public String toString() {
        return "Prestamo{" +
                "id=" + id +
                ", material=" + (material instanceof Libro ? ((Libro) material).getTitulo() : 
                                 material instanceof ArtEspeciales ? ((ArtEspeciales) material).getDescripcion() : "Material") +
                ", lector=" + lector.getNombre() +
                ", bibliotecario=" + bibliotecario.getNombre() +
                ", fechaSolicitada=" + fechaSolicitada +
                ", fechaDevolucion=" + fechaDevolucion +
                ", estadoP=" + estadoP +
                '}';
    }
}
