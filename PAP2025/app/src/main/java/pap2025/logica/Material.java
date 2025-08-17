package pap2025.logica;

import pap2025.datatypes.DTFecha;

/**
 * Clase base Material
 */
public class Material {
    protected int id;
    protected DTFecha fechaIngreso;
    
    public Material(int id, DTFecha fechaIngreso) {
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
        return "Material{" +
                "id=" + id +
                ", fechaIngreso=" + fechaIngreso +
                '}';
    }
}
