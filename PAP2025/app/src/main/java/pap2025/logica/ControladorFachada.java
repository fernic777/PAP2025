package pap2025.logica;

import pap2025.interfaz.IControladorFachada;
import pap2025.datatypes.DTFecha;

/**
 * Controlador Fachada que coordina todos los manejadores del sistema
 */
public class ControladorFachada implements IControladorFachada {
    
    private static ControladorFachada instancia;
    private ManejadorUsuario manejadorUsuario;
    private ManejadorMaterial manejadorMaterial;
    private ManejadorPrestamo manejadorPrestamo;
    
    // Constructor privado para Singleton
    private ControladorFachada() {
        this.manejadorUsuario = new ManejadorUsuario();
        this.manejadorMaterial = new ManejadorMaterial();
        this.manejadorPrestamo = new ManejadorPrestamo();
    }
    
    // Método para obtener la instancia única (Singleton)
    public static ControladorFachada getInstancia() {
        if (instancia == null) {
            instancia = new ControladorFachada();
        }
        return instancia;
    }
    
    // Getters para acceder a los manejadores
    @Override
    public ManejadorUsuario getManejadorUsuario() {
        return manejadorUsuario;
    }
    
    @Override
    public ManejadorMaterial getManejadorMaterial() {
        return manejadorMaterial;
    }
    
    @Override
    public ManejadorPrestamo getManejadorPrestamo() {
        return manejadorPrestamo;
    }
    
    // Métodos de gestión de lectores (movidos desde CtrlLector)
    @Override
    public boolean registrarLector(String nombre, String email, String direccion, DTFecha fechaRegistro, Zona zona) {
        // Validaciones básicas
        if (nombre == null || nombre.trim().isEmpty()) {
            return false;
        }
        if (email == null || email.trim().isEmpty() || !email.contains("@")) {
            return false;
        }
        if (direccion == null || direccion.trim().isEmpty()) {
            return false;
        }
        if (fechaRegistro == null) {
            return false;
        }
        if (zona == null) {
            return false;
        }
        
        // Verificar que no exista ya un lector con ese email
        if (existeLector(email)) {
            return false;
        }
        
        // Crear el lector con estado ACTIVO por defecto
        Lector lector = new Lector(nombre, email, direccion, fechaRegistro, EstadoL.ACTIVO, zona);
        
        // Guardar en persistencia - SIMULADO
        System.out.println("Lector registrado (simulado): " + lector.getNombre() + " - " + lector.getEmail());
        return true;
    }
    
    @Override
    public Lector obtenerLector(String email) {
        if (email == null || email.trim().isEmpty()) {
            return null;
        }
        
        // Buscar en persistencia - SIMULADO
        System.out.println("Buscando lector (simulado): " + email);
        
        // Por ahora simula que encuentra un lector si existe
        if (existeLector(email)) {
            // Aquí se implementaría la lógica real de búsqueda
            return new Lector("Lector Simulado", email, "Dirección Simulada", new DTFecha(1, 1, 2025), EstadoL.ACTIVO, Zona.BIBLOTECA_CENTRAL);
        }
        return null;
    }
    
    @Override
    public boolean existeLector(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        
        // Verificar en persistencia - SIMULADO
        System.out.println("Verificando existencia de lector (simulado): " + email);
        
        // Simula que algunos lectores existen
        return email.equals("lector@biblioteca.com") || email.equals("usuario@test.com");
    }
}
