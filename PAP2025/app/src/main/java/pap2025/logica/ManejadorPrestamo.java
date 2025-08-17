package pap2025.logica;

import java.util.ArrayList;
import java.util.List;

/**
 * Manejador de Préstamos que solo gestiona el almacenamiento de la lista
 * Implementa el patrón Singleton
 * Toda la lógica de negocio está en ControladorFachada
 */
public class ManejadorPrestamo {
    
    private static ManejadorPrestamo instancia;
    private List<Prestamo> listaPrestamos;
    
    // Constructor privado para Singleton
    private ManejadorPrestamo() {
        this.listaPrestamos = new ArrayList<>();
    }
    
    // Método para obtener la instancia única (Singleton)
    public static ManejadorPrestamo getInstancia() {
        if (instancia == null) {
            instancia = new ManejadorPrestamo();
        }
        return instancia;
    }
    
    /**
     * Obtiene la lista de préstamos (referencia directa)
     * @return Lista de préstamos
     */
    public List<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }
}
