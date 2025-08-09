package pap2025;

/**
 * Clase padre DonacionMaterial
 */
public class DonacionMaterial {
    protected int id;
    protected DTFecha fechaIngreso;
    
    public DonacionMaterial(int id, DTFecha fechaIngreso) {
        this.id = id;
        this.fechaIngreso = fechaIngreso;
    }
    
    // Getters
    public int getId() {
        return id;
    }
    
    public DTFecha getFechaIngreso() {
        return fechaIngreso;
    }
    
    // Setters
    public void setId(int id) {
        this.id = id;
    }
    
    public void setFechaIngreso(DTFecha fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
    @Override
    public String toString() {
        return "DonacionMaterial{" +
                "id=" + id +
                ", fechaIngreso=" + fechaIngreso +
                '}';
    }
}
