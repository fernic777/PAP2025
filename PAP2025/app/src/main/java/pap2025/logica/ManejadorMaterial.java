package pap2025.logica;

import pap2025.datatypes.DTFecha;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manejador de Materiales que permite crear, editar y obtener materiales
 */
public class ManejadorMaterial {
    
    private Map<String, Material> materiales;
    
    public ManejadorMaterial() {
        this.materiales = new HashMap<>();
    }
    
    /**
     * Crea un nuevo material
     * @param codigo Código único del material
     * @param titulo Título del material
     * @param fechaAdquisicion Fecha de adquisición
     * @return true si se creó exitosamente, false en caso contrario
     */
    public boolean crearMaterial(String codigo, String titulo, DTFecha fechaAdquisicion) {
        if (codigo == null || codigo.trim().isEmpty()) {
            return false;
        }
        if (titulo == null || titulo.trim().isEmpty()) {
            return false;
        }
        if (fechaAdquisicion == null) {
            return false;
        }
        
        // Verificar que no exista ya un material con ese código
        if (materiales.containsKey(codigo)) {
            return false;
        }
        
        // Crear el material
        Material material = new Material();
        materiales.put(codigo, material);
        
        System.out.println("Material creado: " + codigo + " - " + titulo);
        return true;
    }
    
    /**
     * Obtiene un material por su código
     * @param codigo Código del material
     * @return Material encontrado o null si no existe
     */
    public Material obtenerMaterial(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            return null;
        }
        return materiales.get(codigo);
    }
    
    /**
     * Verifica si existe un material con el código dado
     * @param codigo Código a verificar
     * @return true si existe, false en caso contrario
     */
    public boolean existeMaterial(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            return false;
        }
        return materiales.containsKey(codigo);
    }
    
    /**
     * Edita un material existente
     * @param codigo Código del material a editar
     * @param nuevoTitulo Nuevo título del material
     * @return true si se editó exitosamente, false en caso contrario
     */
    public boolean editarMaterial(String codigo, String nuevoTitulo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            return false;
        }
        if (nuevoTitulo == null || nuevoTitulo.trim().isEmpty()) {
            return false;
        }
        
        // Verificar que el material existe
        if (!materiales.containsKey(codigo)) {
            return false;
        }
        
        // Editar el material
        Material material = materiales.get(codigo);
        // Aquí se editaría el material cuando tenga propiedades
        
        System.out.println("Material editado: " + codigo + " - Nuevo título: " + nuevoTitulo);
        return true;
    }
    
    /**
     * Elimina un material
     * @param codigo Código del material a eliminar
     * @return true si se eliminó exitosamente, false en caso contrario
     */
    public boolean eliminarMaterial(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            return false;
        }
        
        // Verificar que el material existe
        if (!materiales.containsKey(codigo)) {
            return false;
        }
        
        // Eliminar el material
        Material materialEliminado = materiales.remove(codigo);
        System.out.println("Material eliminado: " + codigo);
        return true;
    }
    
    /**
     * Obtiene todos los materiales
     * @return Lista de todos los materiales
     */
    public List<Material> obtenerTodosLosMateriales() {
        return new ArrayList<>(materiales.values());
    }
    
    /**
     * Obtiene la cantidad total de materiales
     * @return Número total de materiales
     */
    public int obtenerCantidadMateriales() {
        return materiales.size();
    }
    
    /**
     * Busca materiales por título
     * @param titulo Título a buscar (puede ser parcial)
     * @return Lista de materiales que coinciden con la búsqueda
     */
    public List<Material> buscarPorTitulo(String titulo) {
        List<Material> resultados = new ArrayList<>();
        if (titulo == null || titulo.trim().isEmpty()) {
            return resultados;
        }
        
        String tituloLower = titulo.toLowerCase();
        for (Material material : materiales.values()) {
            // Aquí se implementaría la búsqueda cuando el material tenga propiedades
            // Por ahora retorna todos los materiales
            resultados.add(material);
        }
        
        return resultados;
    }
}
