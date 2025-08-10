package pap2025.logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manejador de Usuarios que permite crear, editar y obtener usuarios
 */
public class ManejadorUsuario {
    
    private Map<String, Usuario> usuarios;
    
    public ManejadorUsuario() {
        this.usuarios = new HashMap<>();
    }
    
    /**
     * Crea un nuevo usuario
     * @param nombre Nombre del usuario
     * @param email Email del usuario
     * @return true si se creó exitosamente, false en caso contrario
     */
    public boolean crearUsuario(String nombre, String email) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return false;
        }
        if (email == null || email.trim().isEmpty() || !email.contains("@")) {
            return false;
        }
        
        // Verificar que no exista ya un usuario con ese email
        if (usuarios.containsKey(email)) {
            return false;
        }
        
        // Crear el usuario
        Usuario usuario = new Usuario(nombre, email);
        usuarios.put(email, usuario);
        
        System.out.println("Usuario creado: " + usuario.getNombre() + " - " + usuario.getEmail());
        return true;
    }
    
    /**
     * Obtiene un usuario por su email
     * @param email Email del usuario
     * @return Usuario encontrado o null si no existe
     */
    public Usuario obtenerUsuario(String email) {
        if (email == null || email.trim().isEmpty()) {
            return null;
        }
        return usuarios.get(email);
    }
    
    /**
     * Verifica si existe un usuario con el email dado
     * @param email Email a verificar
     * @return true si existe, false en caso contrario
     */
    public boolean existeUsuario(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return usuarios.containsKey(email);
    }
    
    /**
     * Edita un usuario existente
     * @param email Email del usuario a editar
     * @param nuevoNombre Nuevo nombre del usuario
     * @return true si se editó exitosamente, false en caso contrario
     */
    public boolean editarUsuario(String email, String nuevoNombre) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        if (nuevoNombre == null || nuevoNombre.trim().isEmpty()) {
            return false;
        }
        
        // Verificar que el usuario existe
        if (!usuarios.containsKey(email)) {
            return false;
        }
        
        // Editar el usuario
        Usuario usuario = usuarios.get(email);
        usuario.setNombre(nuevoNombre);
        
        System.out.println("Usuario editado: " + email + " - Nuevo nombre: " + nuevoNombre);
        return true;
    }
    
    /**
     * Elimina un usuario
     * @param email Email del usuario a eliminar
     * @return true si se eliminó exitosamente, false en caso contrario
     */
    public boolean eliminarUsuario(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        
        // Verificar que el usuario existe
        if (!usuarios.containsKey(email)) {
            return false;
        }
        
        // Eliminar el usuario
        Usuario usuarioEliminado = usuarios.remove(email);
        System.out.println("Usuario eliminado: " + usuarioEliminado.getNombre() + " - " + usuarioEliminado.getEmail());
        return true;
    }
    
    /**
     * Obtiene todos los usuarios
     * @return Lista de todos los usuarios
     */
    public List<Usuario> obtenerTodosLosUsuarios() {
        return new ArrayList<>(usuarios.values());
    }
    
    /**
     * Obtiene la cantidad total de usuarios
     * @return Número total de usuarios
     */
    public int obtenerCantidadUsuarios() {
        return usuarios.size();
    }
}
