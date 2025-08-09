package pap2025.logica;

import pap2025.datatypes.DTDimenciones;
import pap2025.datatypes.DTFecha;

/**
 * Clase ArtEspeciales que hereda de DonacionMaterial
 */
public class ArtEspeciales extends DonacionMaterial {
    private String descripcion;
    private double peso;
    private DTDimenciones dimenciones;
    
    public ArtEspeciales(int id, DTFecha fechaIngreso, String descripcion, double peso, DTDimenciones dimenciones) {
        super(id, fechaIngreso);
        this.descripcion = descripcion;
        this.peso = peso;
        this.dimenciones = dimenciones;
    }
    
    // Getters
    public String getDescripcion() {
        return descripcion;
    }
    
    public double getPeso() {
        return peso;
    }
    
    public DTDimenciones getDimenciones() {
        return dimenciones;
    }
    
    // Setters
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    public void setDimenciones(DTDimenciones dimenciones) {
        this.dimenciones = dimenciones;
    }
    
    @Override
    public String toString() {
        return "ArtEspeciales{" +
                "id=" + id +
                ", fechaIngreso=" + fechaIngreso +
                ", descripcion='" + descripcion + '\'' +
                ", peso=" + peso +
                ", dimenciones=" + dimenciones +
                '}';
    }
}
