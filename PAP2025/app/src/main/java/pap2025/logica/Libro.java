package pap2025.logica;

import pap2025.datatypes.DTFecha;

/**
 * Clase Libro que hereda de Material
 */
public class Libro extends Material {
    private String titulo;
    private int cantPaginas;
    
    public Libro( String titulo, int cantPaginas) {
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
                ", titulo='" + titulo + '\'' +
                ", cantPaginas=" + cantPaginas +
                '}';
    }
}
