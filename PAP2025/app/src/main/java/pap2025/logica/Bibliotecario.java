package pap2025;

/**
 * Clase Bibliotecario que hereda de Usuario
 */
public class Bibliotecario extends Usuario {
    private int nroEmpleado;
    
    public Bibliotecario(String nombre, String email, int nroEmpleado) {
        super(nombre, email);
        this.nroEmpleado = nroEmpleado;
    }
    
    // Getter
    public int getNroEmpleado() {
        return nroEmpleado;
    }
    
    // Setter
    public void setNroEmpleado(int nroEmpleado) {
        this.nroEmpleado = nroEmpleado;
    }
    
    @Override
    public String toString() {
        return "Bibliotecario{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", nroEmpleado=" + nroEmpleado +
                '}';
    }
}
