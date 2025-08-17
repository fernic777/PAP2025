package pap2025.logica;

import java.util.ArrayList;
import java.util.List;

/**
 * Manejador de Materiales que solo gestiona el almacenamiento de la lista
 * Implementa el patrón Singleton
 * Toda la lógica de negocio está en ControladorFachada
 */
public class ManejadorMaterial {
    
    private static ManejadorMaterial instancia;
    private List<Material> listaMateriales;
    
    // Constructor privado para Singleton
    private ManejadorMaterial() {
        this.listaMateriales = new ArrayList<>();
    }
    
    // Método para obtener la instancia única (Singleton)
    public static ManejadorMaterial getInstancia() {
        if (instancia == null) {
            instancia = new ManejadorMaterial();
        }
        return instancia;
    }
    
    /**
     * Obtiene la lista de materiales (referencia directa)
     * @return Lista de materiales
     */
    public List<Material> getListaMateriales() {
        return listaMateriales;
    }
}
