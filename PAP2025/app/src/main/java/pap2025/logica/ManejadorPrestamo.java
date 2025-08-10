package pap2025.logica;

import pap2025.datatypes.DTFecha;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manejador de Préstamos que permite crear, editar y obtener préstamos
 */
public class ManejadorPrestamo {
    
    private Map<String, Prestamo> prestamos;
    private int contadorPrestamos;
    
    public ManejadorPrestamo() {
        this.prestamos = new HashMap<>();
        this.contadorPrestamos = 0;
    }
    
    /**
     * Crea un nuevo préstamo
     * @param fechaSolicitada Fecha en que se solicita el préstamo
     * @param fechaDevolucion Fecha de devolución esperada
     * @param estadoP Estado del préstamo
     * @return ID del préstamo creado o null si falló
     */
    public String crearPrestamo(DTFecha fechaSolicitada, DTFecha fechaDevolucion, EstadoP estadoP) {
        if (fechaSolicitada == null) {
            return null;
        }
        if (fechaDevolucion == null) {
            return null;
        }
        if (estadoP == null) {
            return null;
        }
        
        // Generar ID único para el préstamo
        String idPrestamo = "PREST-" + (++contadorPrestamos);
        
        // Crear el préstamo
        Prestamo prestamo = new Prestamo(fechaSolicitada, fechaDevolucion, estadoP);
        prestamos.put(idPrestamo, prestamo);
        
        System.out.println("Préstamo creado: " + idPrestamo + " - Estado: " + estadoP);
        return idPrestamo;
    }
    
    /**
     * Obtiene un préstamo por su ID
     * @param idPrestamo ID del préstamo
     * @return Préstamo encontrado o null si no existe
     */
    public Prestamo obtenerPrestamo(String idPrestamo) {
        if (idPrestamo == null || idPrestamo.trim().isEmpty()) {
            return null;
        }
        return prestamos.get(idPrestamo);
    }
    
    /**
     * Verifica si existe un préstamo con el ID dado
     * @param idPrestamo ID a verificar
     * @return true si existe, false en caso contrario
     */
    public boolean existePrestamo(String idPrestamo) {
        if (idPrestamo == null || idPrestamo.trim().isEmpty()) {
            return false;
        }
        return prestamos.containsKey(idPrestamo);
    }
    
    /**
     * Edita un préstamo existente
     * @param idPrestamo ID del préstamo a editar
     * @param nuevaFechaDevolucion Nueva fecha de devolución
     * @return true si se editó exitosamente, false en caso contrario
     */
    public boolean editarPrestamo(String idPrestamo, DTFecha nuevaFechaDevolucion) {
        if (idPrestamo == null || idPrestamo.trim().isEmpty()) {
            return false;
        }
        if (nuevaFechaDevolucion == null) {
            return false;
        }
        
        // Verificar que el préstamo existe
        if (!prestamos.containsKey(idPrestamo)) {
            return false;
        }
        
        // Editar el préstamo
        Prestamo prestamo = prestamos.get(idPrestamo);
        prestamo.setFechaDevolucion(nuevaFechaDevolucion);
        
        System.out.println("Préstamo editado: " + idPrestamo + " - Nueva fecha devolución: " + nuevaFechaDevolucion);
        return true;
    }
    
    /**
     * Cambia el estado de un préstamo
     * @param idPrestamo ID del préstamo
     * @param nuevoEstado Nuevo estado del préstamo
     * @return true si se cambió exitosamente, false en caso contrario
     */
    public boolean cambiarEstadoPrestamo(String idPrestamo, EstadoP nuevoEstado) {
        if (idPrestamo == null || idPrestamo.trim().isEmpty()) {
            return false;
        }
        if (nuevoEstado == null) {
            return false;
        }
        
        // Verificar que el préstamo existe
        if (!prestamos.containsKey(idPrestamo)) {
            return false;
        }
        
        // Cambiar el estado del préstamo
        Prestamo prestamo = prestamos.get(idPrestamo);
        prestamo.setEstadoP(nuevoEstado);
        
        System.out.println("Estado del préstamo cambiado: " + idPrestamo + " - Nuevo estado: " + nuevoEstado);
        return true;
    }
    
    /**
     * Elimina un préstamo
     * @param idPrestamo ID del préstamo a eliminar
     * @return true si se eliminó exitosamente, false en caso contrario
     */
    public boolean eliminarPrestamo(String idPrestamo) {
        if (idPrestamo == null || idPrestamo.trim().isEmpty()) {
            return false;
        }
        
        // Verificar que el préstamo existe
        if (!prestamos.containsKey(idPrestamo)) {
            return false;
        }
        
        // Eliminar el préstamo
        Prestamo prestamoEliminado = prestamos.remove(idPrestamo);
        System.out.println("Préstamo eliminado: " + idPrestamo);
        return true;
    }
    
    /**
     * Obtiene todos los préstamos
     * @return Lista de todos los préstamos
     */
    public List<Prestamo> obtenerTodosLosPrestamos() {
        return new ArrayList<>(prestamos.values());
    }
    
    /**
     * Obtiene la cantidad total de préstamos
     * @return Número total de préstamos
     */
    public int obtenerCantidadPrestamos() {
        return prestamos.size();
    }
    
    /**
     * Obtiene préstamos por estado
     * @param estado Estado a filtrar
     * @return Lista de préstamos con el estado especificado
     */
    public List<Prestamo> obtenerPrestamosPorEstado(EstadoP estado) {
        List<Prestamo> resultados = new ArrayList<>();
        if (estado == null) {
            return resultados;
        }
        
        for (Prestamo prestamo : prestamos.values()) {
            if (prestamo.getEstadoP() == estado) {
                resultados.add(prestamo);
            }
        }
        
        return resultados;
    }
    
    /**
     * Obtiene préstamos por fecha de solicitud
     * @param fecha Fecha a filtrar
     * @return Lista de préstamos solicitados en esa fecha
     */
    public List<Prestamo> obtenerPrestamosPorFechaSolicitud(DTFecha fecha) {
        List<Prestamo> resultados = new ArrayList<>();
        if (fecha == null) {
            return resultados;
        }
        
        for (Prestamo prestamo : prestamos.values()) {
            if (prestamo.getFechaSolicitada().equals(fecha)) {
                resultados.add(prestamo);
            }
        }
        
        return resultados;
    }
}
