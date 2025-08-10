package pap2025.interfaz;

import pap2025.logica.ManejadorUsuario;
import pap2025.logica.ManejadorMaterial;
import pap2025.logica.ManejadorPrestamo;
import pap2025.logica.Lector;
import pap2025.logica.Zona;
import pap2025.datatypes.DTFecha;

/**
 * Interfaz del Controlador Fachada que define los métodos para acceder a los manejadores
 */
public interface IControladorFachada {
    
    /**
     * Obtiene el manejador de usuarios
     * @return ManejadorUsuario para gestionar usuarios
     */
    public ManejadorUsuario getManejadorUsuario();
    
    /**
     * Obtiene el manejador de materiales
     * @return ManejadorMaterial para gestionar materiales
     */
    public ManejadorMaterial getManejadorMaterial();
    
    /**
     * Obtiene el manejador de préstamos
     * @return ManejadorPrestamo para gestionar préstamos
     */
    public ManejadorPrestamo getManejadorPrestamo();
    
    /**
     * Registra un nuevo lector en el sistema
     * @param nombre Nombre del lector
     * @param email Email del lector
     * @param direccion Dirección del lector
     * @param fechaRegistro Fecha de registro
     * @param zona Zona de la biblioteca
     * @return true si se registró exitosamente, false en caso contrario
     */
    public boolean registrarLector(String nombre, String email, String direccion, DTFecha fechaRegistro, Zona zona);
    
    /**
     * Obtiene un lector por su email
     * @param email Email del lector
     * @return Lector encontrado o null si no existe
     */
    public Lector obtenerLector(String email);
    
    /**
     * Verifica si existe un lector con el email dado
     * @param email Email a verificar
     * @return true si existe, false en caso contrario
     */
    public boolean existeLector(String email);
}
