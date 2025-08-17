package pap2025.logica;

/**
 * Clase padre Usuario
 */
public class Usuario {
    protected String nombre;
    protected String email;
    
    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }
    
    // Getters
    public String getNombre() {
        return nombre;
    }
    
    public String getEmail() {
        return email;
    }
    
    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
