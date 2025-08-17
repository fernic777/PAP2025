package pap2025.logica;

import pap2025.datatypes.DTFecha;

/**
 * Clase Lector que hereda de Usuario
 */
public class Lector extends Usuario {
    private String direccion;
    private DTFecha fechaRegistro;
    private EstadoL estadoL;
    private Zona zona;
    
    public Lector(String nombre, String email, String direccion, DTFecha fechaRegistro, EstadoL estadoL, Zona zona) {
        super(nombre, email);
        this.direccion = direccion;
        this.fechaRegistro = fechaRegistro;
        this.estadoL = estadoL;
        this.zona = zona;
    }
    
    // Getters
    public String getDireccion() {
        return direccion;
    }
    
    public DTFecha getFechaRegistro() {
        return fechaRegistro;
    }
    
    public EstadoL getEstadoL() {
        return estadoL;
    }
    
    public Zona getZona() {
        return zona;
    }
    
    // Setters
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public void setFechaRegistro(DTFecha fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    public void setEstadoL(EstadoL estadoL) {
        this.estadoL = estadoL;
    }   
    public void setZona(Zona zona) { 
        this.zona = zona;
    }
    
    @Override
    public String toString() {
        return "Lector{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                ", estadoL=" + estadoL +
                '}';
    }
}
