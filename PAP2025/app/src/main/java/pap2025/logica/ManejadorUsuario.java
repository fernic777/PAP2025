package pap2025.logica;

import java.util.ArrayList;
import java.util.List;

/**
 * Manejador de Usuarios que solo gestiona el almacenamiento de la lista
 * Implementa el patrón Singleton
 * Toda la lógica de negocio está en ControladorFachada
 */
public class ManejadorUsuario {
    
    private static ManejadorUsuario instancia;
    private List<Usuario> listaUsuarios;
    
    // Constructor privado para Singleton
    private ManejadorUsuario() {
        this.listaUsuarios = new ArrayList<>();
    }
    
    // Método para obtener la instancia única (Singleton)
    public static ManejadorUsuario getInstancia() {
        if (instancia == null) {
            instancia = new ManejadorUsuario();
        }
        return instancia;
    }
    
    /**
     * Obtiene la lista de usuarios (referencia directa)
     * @return Lista de usuarios
     */
    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
}
