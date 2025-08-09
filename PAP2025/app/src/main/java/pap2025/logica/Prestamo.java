package pap2025;

/**
 * Clase Prestamo
 */
public class Prestamo {
    private DTFecha fechaSolicitada;
    private DTFecha fechaDevolucion;
    private EstadoP estadoP;
    
    public Prestamo(DTFecha fechaSolicitada, DTFecha fechaDevolucion, EstadoP estadoP) {
        this.fechaSolicitada = fechaSolicitada;
        this.fechaDevolucion = fechaDevolucion;
        this.estadoP = estadoP;
    }
    
    // Getters
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
                "fechaSolicitada=" + fechaSolicitada +
                ", fechaDevolucion=" + fechaDevolucion +
                ", estadoP=" + estadoP +
                '}';
    }
}
