package pap2025.logica;

import pap2025.datatypes.DTDimensiones;
import pap2025.datatypes.DTFecha;

/**
 * Clase ArtEspeciales que hereda de Material
 */
public class ArtEspeciales extends Material {
    private String descripcion;
    private double peso;
    private DTDimensiones dimensiones;
    
    public ArtEspeciales(int id, DTFecha fechaIngreso, String descripcion, double peso, DTDimensiones dimensiones) {
        super(id, fechaIngreso);
        this.descripcion = descripcion;
        this.peso = peso;
        this.dimensiones = dimensiones;
    }
    
    // Getters
    public String getDescripcion() {
        return descripcion;
    }
    
    public double getPeso() {
        return peso;
    }
    
    public DTDimensiones getDimensiones() {
        return dimensiones;
    }
    
    // Setters
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    public void setDimensiones(DTDimensiones dimensiones) {
        this.dimensiones = dimensiones;
    }
    
    @Override
    public String toString() {
        return "ArtEspeciales{" +
                "id=" + getId() +
                ", fechaIngreso=" + getFechaIngreso() +
                ", descripcion='" + descripcion + '\'' +
                ", peso=" + peso +
                ", dimensiones=" + dimensiones +
                '}';
    }
}
