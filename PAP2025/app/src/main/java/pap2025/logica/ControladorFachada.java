package pap2025.logica;

import pap2025.interfaz.IControladorFachada;
import pap2025.datatypes.DTFecha;
import pap2025.datatypes.DTDimensiones;
import java.util.List;
import java.util.ArrayList;

/**
 * Controlador Fachada que coordina todos los manejadores del sistema
 * Contiene toda la lógica de negocio del sistema
 */
public class ControladorFachada implements IControladorFachada {
    
    private static ControladorFachada instancia;
    private ManejadorUsuario manejadorUsuario;
    private ManejadorMaterial manejadorMaterial;
    private ManejadorPrestamo manejadorPrestamo;
    
    // Constructor privado para Singleton
    private ControladorFachada() {
        this.manejadorUsuario = ManejadorUsuario.getInstancia();
        this.manejadorMaterial = ManejadorMaterial.getInstancia();
        this.manejadorPrestamo = ManejadorPrestamo.getInstancia();
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
    
    // ===== MÉTODOS DE GESTIÓN DE USUARIOS =====
    
    @Override
    public boolean crearUsuario(String nombre, String email) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return false;
        }
        if (email == null || email.trim().isEmpty() || !email.contains("@")) {
            return false;
        }
        
        // Verificar que no exista ya un usuario con ese email
        if (existeUsuario(email)) {
            return false;
        }
        
        // Crear el usuario
        Usuario usuario = new Usuario(nombre, email);
        manejadorUsuario.getListaUsuarios().add(usuario);
        
        System.out.println("Usuario creado: " + usuario.getNombre() + " - " + usuario.getEmail());
        return true;
    }
    
    @Override
    public Usuario obtenerUsuario(String email) {
        if (email == null || email.trim().isEmpty()) {
            return null;
        }
        
        for (Usuario usuario : manejadorUsuario.getListaUsuarios()) {
            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }
        return null;
    }
    
    @Override
    public boolean existeUsuario(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        
        for (Usuario usuario : manejadorUsuario.getListaUsuarios()) {
            if (usuario.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean editarUsuario(String email, String nuevoNombre) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        if (nuevoNombre == null || nuevoNombre.trim().isEmpty()) {
            return false;
        }
        
        for (Usuario usuario : manejadorUsuario.getListaUsuarios()) {
            if (usuario.getEmail().equals(email)) {
                String nombreAnterior = usuario.getNombre();
                usuario.setNombre(nuevoNombre);
                System.out.println("Usuario editado: " + email + " - Nombre anterior: " + nombreAnterior + " - Nuevo nombre: " + nuevoNombre);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean eliminarUsuario(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        
        for (int i = 0; i < manejadorUsuario.getListaUsuarios().size(); i++) {
            Usuario usuario = manejadorUsuario.getListaUsuarios().get(i);
            if (usuario.getEmail().equals(email)) {
                manejadorUsuario.getListaUsuarios().remove(i);
                System.out.println("Usuario eliminado: " + email);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int obtenerCantidadUsuarios() {
        return manejadorUsuario.getListaUsuarios().size();
    }
    
    @Override
    public List<Usuario> getListaUsuarios() {
        return manejadorUsuario.getListaUsuarios();
    }
    
    // ===== MÉTODOS DE GESTIÓN DE LECTORES =====
    
    @Override
    public boolean registrarLector(String nombre, String email, String direccion, DTFecha fechaRegistro, Zona zona) {
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
        
        // Verificar que no exista ya un usuario con ese email
        if (existeUsuario(email)) {
            return false;
        }
        
        // Crear el lector con estado ACTIVO por defecto
        Lector lector = new Lector(nombre, email, direccion, fechaRegistro, EstadoL.ACTIVO, zona);
        manejadorUsuario.getListaUsuarios().add(lector);
        
        System.out.println("Lector creado: " + lector.getNombre() + " - " + lector.getEmail() + " - Estado: " + lector.getEstadoL());
        return true;
    }
    
    @Override
    public Lector obtenerLector(String email) {
        if (email == null || email.trim().isEmpty()) {
            return null;
        }
        
        for (Usuario usuario : manejadorUsuario.getListaUsuarios()) {
            if (usuario instanceof Lector && usuario.getEmail().equals(email)) {
                return (Lector) usuario;
            }
        }
        return null;
    }
    
    @Override
    public boolean existeLector(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        
        for (Usuario usuario : manejadorUsuario.getListaUsuarios()) {
            if (usuario instanceof Lector && usuario.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean modificarEstadoLector(String email, EstadoL nuevoEstado) {
        if (email == null || email.trim().isEmpty()) {
            System.out.println("ERROR: Email no puede estar vacío.");
            return false;
        }
        
        if (nuevoEstado == null) {
            System.out.println("ERROR: El nuevo estado no puede ser null.");
            return false;
        }
        
        for (Usuario usuario : manejadorUsuario.getListaUsuarios()) {
            if (usuario instanceof Lector && usuario.getEmail().equals(email)) {
                Lector lector = (Lector) usuario;
                EstadoL estadoAnterior = lector.getEstadoL();
                lector.setEstadoL(nuevoEstado);
                
                System.out.println("Estado del lector modificado por ADMINISTRADOR:");
                System.out.println("  - Email: " + email);
                System.out.println("  - Estado anterior: " + estadoAnterior);
                System.out.println("  - Nuevo estado: " + nuevoEstado);
                return true;
            }
        }
        
        System.out.println("ERROR: No se encontró un lector con el email: " + email);
        return false;
    }
    
    @Override
    public boolean suspenderLector(String email) {
        return modificarEstadoLector(email, EstadoL.SUSPENDIDO);
    }
    
    @Override
    public boolean activarLector(String email) {
        return modificarEstadoLector(email, EstadoL.ACTIVO);
    }
    
    @Override
    public boolean lectorPuedePrestar(String email) {
        Lector lector = obtenerLector(email);
        if (lector == null) {
            return false;
        }
        return lector.getEstadoL() == EstadoL.ACTIVO;
    }
    
    @Override
    public boolean cambiarZonaLector(String email, Zona nuevaZona) {
        if (email == null || email.trim().isEmpty()) {
            System.out.println("ERROR: Email no puede estar vacío.");
            return false;
        }
        
        if (nuevaZona == null) {
            System.out.println("ERROR: La nueva zona no puede ser null.");
            return false;
        }
        
        for (Usuario usuario : manejadorUsuario.getListaUsuarios()) {
            if (usuario instanceof Lector && usuario.getEmail().equals(email)) {
                Lector lector = (Lector) usuario;
                Zona zonaAnterior = lector.getZona();
                lector.setZona(nuevaZona);
                
                System.out.println("Zona del lector modificada por ADMINISTRADOR:");
                System.out.println("  - Email: " + email);
                System.out.println("  - Zona anterior: " + zonaAnterior);
                System.out.println("  - Nueva zona: " + nuevaZona);
                return true;
            }
        }
        
        System.out.println("ERROR: No se encontró un lector con el email: " + email);
        return false;
    }
    
    @Override
    public List<Lector> obtenerTodosLosLectores() {
        List<Lector> lectores = new ArrayList<>();
        for (Usuario usuario : manejadorUsuario.getListaUsuarios()) {
            if (usuario instanceof Lector) {
                lectores.add((Lector) usuario);
            }
        }
        return lectores;
    }
    
    @Override
    public List<Lector> obtenerLectoresPorEstado(EstadoL estado) {
        List<Lector> resultados = new ArrayList<>();
        if (estado == null) {
            return resultados;
        }
        
        for (Usuario usuario : manejadorUsuario.getListaUsuarios()) {
            if (usuario instanceof Lector) {
                Lector lector = (Lector) usuario;
                if (lector.getEstadoL() == estado) {
                    resultados.add(lector);
                }
            }
        }
        
        return resultados;
    }
    
    @Override
    public List<Lector> obtenerLectoresSuspendidos() {
        return obtenerLectoresPorEstado(EstadoL.SUSPENDIDO);
    }
    
    @Override
    public List<Lector> obtenerLectoresActivos() {
        return obtenerLectoresPorEstado(EstadoL.ACTIVO);
    }
    
    @Override
    public int obtenerCantidadLectores() {
        int contador = 0;
        for (Usuario usuario : manejadorUsuario.getListaUsuarios()) {
            if (usuario instanceof Lector) {
                contador++;
            }
        }
        return contador;
    }
    
    @Override
    public int obtenerCantidadLectoresPorEstado(EstadoL estado) {
        if (estado == null) {
            return 0;
        }
        
        int contador = 0;
        for (Usuario usuario : manejadorUsuario.getListaUsuarios()) {
            if (usuario instanceof Lector) {
                Lector lector = (Lector) usuario;
                if (lector.getEstadoL() == estado) {
                    contador++;
                }
            }
        }
        return contador;
    }
    
    @Override
    public List<Lector> getListaLectores() {
        return obtenerTodosLosLectores();
    }
    
    // ===== MÉTODOS DE GESTIÓN DE BIBLIOTECARIOS =====
    
    @Override
    public boolean registrarBibliotecario(String nombre, String email, int nroEmpleado) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return false;
        }
        if (email == null || email.trim().isEmpty() || !email.contains("@")) {
            return false;
        }
        if (nroEmpleado <= 0) {
            return false;
        }
        
        // Verificar que no exista ya un usuario con ese email
        if (existeUsuario(email)) {
            return false;
        }
        
        // Verificar que no exista ya un bibliotecario con ese número de empleado
        if (existeBibliotecarioPorNroEmpleado(nroEmpleado)) {
            return false;
        }
        
        // Crear el bibliotecario
        Bibliotecario bibliotecario = new Bibliotecario(nombre, email, nroEmpleado);
        manejadorUsuario.getListaUsuarios().add(bibliotecario);
        
        System.out.println("Bibliotecario creado: " + bibliotecario.getNombre() + " - " + bibliotecario.getEmail() + " - Nro. Empleado: " + bibliotecario.getNroEmpleado());
        return true;
    }
    
    @Override
    public Bibliotecario obtenerBibliotecario(String email) {
        if (email == null || email.trim().isEmpty()) {
            return null;
        }
        
        for (Usuario usuario : manejadorUsuario.getListaUsuarios()) {
            if (usuario instanceof Bibliotecario && usuario.getEmail().equals(email)) {
                return (Bibliotecario) usuario;
            }
        }
        return null;
    }
    
    @Override
    public boolean existeBibliotecario(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        
        for (Usuario usuario : manejadorUsuario.getListaUsuarios()) {
            if (usuario instanceof Bibliotecario && usuario.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean existeBibliotecarioPorNroEmpleado(int nroEmpleado) {
        if (nroEmpleado <= 0) {
            return false;
        }
        
        for (Usuario usuario : manejadorUsuario.getListaUsuarios()) {
            if (usuario instanceof Bibliotecario) {
                Bibliotecario bibliotecario = (Bibliotecario) usuario;
                if (bibliotecario.getNroEmpleado() == nroEmpleado) {
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public List<Bibliotecario> obtenerTodosLosBibliotecarios() {
        List<Bibliotecario> bibliotecarios = new ArrayList<>();
        for (Usuario usuario : manejadorUsuario.getListaUsuarios()) {
            if (usuario instanceof Bibliotecario) {
                bibliotecarios.add((Bibliotecario) usuario);
            }
        }
        return bibliotecarios;
    }
    
    @Override
    public int obtenerCantidadBibliotecarios() {
        int contador = 0;
        for (Usuario usuario : manejadorUsuario.getListaUsuarios()) {
            if (usuario instanceof Bibliotecario) {
                contador++;
            }
        }
        return contador;
    }
    
    @Override
    public List<Bibliotecario> getListaBibliotecarios() {
        return obtenerTodosLosBibliotecarios();
    }
    
    // ===== MÉTODOS DE GESTIÓN DE MATERIALES =====
    
    @Override
    public Integer crearMaterial(DTFecha fechaIngreso) {
        if (fechaIngreso == null) {
            return null;
        }
        
        int id = obtenerSiguienteIdMaterial();
        Material material = new Material(id, fechaIngreso);
        manejadorMaterial.getListaMateriales().add(material);
        
        System.out.println("Material creado con ID: " + id + " - Fecha ingreso: " + fechaIngreso);
        return id;
    }
    
    @Override
    public Integer crearLibro(DTFecha fechaIngreso, String titulo, int cantPaginas) {
        if (fechaIngreso == null) {
            return null;
        }
        if (titulo == null || titulo.trim().isEmpty()) {
            return null;
        }
        if (cantPaginas <= 0) {
            return null;
        }
        
        int id = obtenerSiguienteIdMaterial();
        Libro libro = new Libro(id, fechaIngreso, titulo, cantPaginas);
        manejadorMaterial.getListaMateriales().add(libro);
        
        System.out.println("Libro creado con ID: " + id + " - Título: " + titulo + " - Páginas: " + cantPaginas);
        return id;
    }
    
    @Override
    public Integer crearArtEspecial(DTFecha fechaIngreso, String descripcion, double peso, DTDimensiones dimensiones) {
        if (fechaIngreso == null) {
            return null;
        }
        if (descripcion == null || descripcion.trim().isEmpty()) {
            return null;
        }
        if (peso <= 0) {
            return null;
        }
        if (dimensiones == null) {
            return null;
        }
        
        int id = obtenerSiguienteIdMaterial();
        ArtEspeciales artEspecial = new ArtEspeciales(id, fechaIngreso, descripcion, peso, dimensiones);
        manejadorMaterial.getListaMateriales().add(artEspecial);
        
        System.out.println("Artículo especial creado con ID: " + id + " - Descripción: " + descripcion + " - Peso: " + peso);
        return id;
    }
    
    @Override
    public Material obtenerMaterial(int id) {
        for (Material material : manejadorMaterial.getListaMateriales()) {
            if (material.getId() == id) {
                return material;
            }
        }
        return null;
    }
    
    @Override
    public boolean existeMaterial(int id) {
        for (Material material : manejadorMaterial.getListaMateriales()) {
            if (material.getId() == id) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean editarMaterial(int id, DTFecha nuevaFechaIngreso) {
        if (nuevaFechaIngreso == null) {
            return false;
        }
        
        for (Material material : manejadorMaterial.getListaMateriales()) {
            if (material.getId() == id) {
                material.setFechaIngreso(nuevaFechaIngreso);
                System.out.println("Material editado: " + id + " - Nueva fecha ingreso: " + nuevaFechaIngreso);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean eliminarMaterial(int id) {
        for (int i = 0; i < manejadorMaterial.getListaMateriales().size(); i++) {
            Material material = manejadorMaterial.getListaMateriales().get(i);
            if (material.getId() == id) {
                manejadorMaterial.getListaMateriales().remove(i);
                System.out.println("Material eliminado: " + id);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int obtenerSiguienteIdMaterial() {
        return manejadorMaterial.getListaMateriales().size() + 1;
    }
    
    @Override
    public int obtenerCantidadMateriales() {
        return manejadorMaterial.getListaMateriales().size();
    }
    
    @Override
    public List<Material> getListaMateriales() {
        return manejadorMaterial.getListaMateriales();
    }
    
    // ===== MÉTODOS DE GESTIÓN DE DONACIONES =====
    
    @Override
    public Integer registrarDonacionLibro(String titulo, int cantPaginas) {
        if (titulo == null || titulo.trim().isEmpty()) {
            return null;
        }
        if (cantPaginas <= 0) {
            return null;
        }
        
        // Obtener el siguiente ID disponible
        int siguienteId = obtenerSiguienteIdMaterial();
        
        // Crear fecha de ingreso actual
        DTFecha fechaIngreso = new DTFecha(
            java.time.LocalDate.now().getDayOfMonth(),
            java.time.LocalDate.now().getMonthValue(),
            java.time.LocalDate.now().getYear()
        );
        
        // Crear el libro
        Libro libro = new Libro(siguienteId, fechaIngreso, titulo, cantPaginas);
        manejadorMaterial.getListaMateriales().add(libro);
        
        System.out.println("Donación de libro registrada: " + titulo + " - " + cantPaginas + " páginas - ID: " + libro.getId());
        return libro.getId();
    }
    
    @Override
    public Integer registrarDonacionArtEspecial(String descripcion, double peso, DTDimensiones dimensiones) {
        if (descripcion == null || descripcion.trim().isEmpty()) {
            return null;
        }
        if (peso <= 0) {
            return null;
        }
        if (dimensiones == null) {
            return null;
        }
        
        // Obtener el siguiente ID disponible
        int siguienteId = obtenerSiguienteIdMaterial();
        
        // Crear fecha de ingreso actual
        DTFecha fechaIngreso = new DTFecha(
            java.time.LocalDate.now().getDayOfMonth(),
            java.time.LocalDate.now().getMonthValue(),
            java.time.LocalDate.now().getYear()
        );
        
        // Crear el artículo especial
        ArtEspeciales artEspecial = new ArtEspeciales(siguienteId, fechaIngreso, descripcion, peso, dimensiones);
        manejadorMaterial.getListaMateriales().add(artEspecial);
        
        System.out.println("Donación de artículo especial registrada: " + descripcion + " - " + peso + " kg - ID: " + artEspecial.getId());
        return artEspecial.getId();
    }
    
    @Override
    public List<Libro> obtenerTodosLosLibros() {
        List<Libro> libros = new ArrayList<>();
        for (Material material : manejadorMaterial.getListaMateriales()) {
            if (material instanceof Libro) {
                libros.add((Libro) material);
            }
        }
        return libros;
    }
    
    @Override
    public List<ArtEspeciales> obtenerTodosLosArtEspeciales() {
        List<ArtEspeciales> artEspeciales = new ArrayList<>();
        for (Material material : manejadorMaterial.getListaMateriales()) {
            if (material instanceof ArtEspeciales) {
                artEspeciales.add((ArtEspeciales) material);
            }
        }
        return artEspeciales;
    }
    
    @Override
    public int obtenerCantidadLibros() {
        int contador = 0;
        for (Material material : manejadorMaterial.getListaMateriales()) {
            if (material instanceof Libro) {
                contador++;
            }
        }
        return contador;
    }
    
    @Override
    public int obtenerCantidadArtEspeciales() {
        int contador = 0;
        for (Material material : manejadorMaterial.getListaMateriales()) {
            if (material instanceof ArtEspeciales) {
                contador++;
            }
        }
        return contador;
    }
    
    // ===== MÉTODOS DE CONSULTA DE DONACIONES =====
    
    @Override
    public List<Material> obtenerDonacionesEnRango(DTFecha fechaInicio, DTFecha fechaFin) {
        if (fechaInicio == null || fechaFin == null) {
            return new ArrayList<>();
        }
        
        List<Material> donacionesEnRango = new ArrayList<>();
        for (Material material : manejadorMaterial.getListaMateriales()) {
            if (material.getFechaIngreso() != null) {
                if (fechaEnRango(material.getFechaIngreso(), fechaInicio, fechaFin)) {
                    donacionesEnRango.add(material);
                }
            }
        }
        return donacionesEnRango;
    }
    
    @Override
    public List<Libro> obtenerDonacionesLibrosEnRango(DTFecha fechaInicio, DTFecha fechaFin) {
        if (fechaInicio == null || fechaFin == null) {
            return new ArrayList<>();
        }
        
        List<Libro> librosEnRango = new ArrayList<>();
        for (Material material : manejadorMaterial.getListaMateriales()) {
            if (material instanceof Libro && material.getFechaIngreso() != null) {
                if (fechaEnRango(material.getFechaIngreso(), fechaInicio, fechaFin)) {
                    librosEnRango.add((Libro) material);
                }
            }
        }
        return librosEnRango;
    }
    
    @Override
    public List<ArtEspeciales> obtenerDonacionesArtEspecialesEnRango(DTFecha fechaInicio, DTFecha fechaFin) {
        if (fechaInicio == null || fechaFin == null) {
            return new ArrayList<>();
        }
        
        List<ArtEspeciales> artEspecialesEnRango = new ArrayList<>();
        for (Material material : manejadorMaterial.getListaMateriales()) {
            if (material instanceof ArtEspeciales && material.getFechaIngreso() != null) {
                if (fechaEnRango(material.getFechaIngreso(), fechaInicio, fechaFin)) {
                    artEspecialesEnRango.add((ArtEspeciales) material);
                }
            }
        }
        return artEspecialesEnRango;
    }
    
    @Override
    public List<Material> obtenerTodasLasDonaciones() {
        return new ArrayList<>(manejadorMaterial.getListaMateriales());
    }
    
    @Override
    public List<Libro> obtenerTodasLasDonacionesLibros() {
        List<Libro> todosLosLibros = new ArrayList<>();
        for (Material material : manejadorMaterial.getListaMateriales()) {
            if (material instanceof Libro) {
                todosLosLibros.add((Libro) material);
            }
        }
        return todosLosLibros;
    }
    
    @Override
    public List<ArtEspeciales> obtenerTodasLasDonacionesArtEspeciales() {
        List<ArtEspeciales> todosLosArtEspeciales = new ArrayList<>();
        for (Material material : manejadorMaterial.getListaMateriales()) {
            if (material instanceof ArtEspeciales) {
                todosLosArtEspeciales.add((ArtEspeciales) material);
            }
        }
        return todosLosArtEspeciales;
    }
    
    /**
     * Método auxiliar para verificar si una fecha está en un rango
     * @param fecha Fecha a verificar
     * @param fechaInicio Fecha de inicio del rango
     * @param fechaFin Fecha de fin del rango
     * @return true si la fecha está en el rango, false en caso contrario
     */
    private boolean fechaEnRango(DTFecha fecha, DTFecha fechaInicio, DTFecha fechaFin) {
        if (fecha == null || fechaInicio == null || fechaFin == null) {
            return false;
        }
        
        // Convertir a días desde una fecha base para comparación
        int diasFecha = fecha.getAnio() * 365 + fecha.getMes() * 30 + fecha.getDia();
        int diasInicio = fechaInicio.getAnio() * 365 + fechaInicio.getMes() * 30 + fechaInicio.getDia();
        int diasFin = fechaFin.getAnio() * 365 + fechaFin.getMes() * 30 + fechaFin.getDia();
        
        return diasFecha >= diasInicio && diasFecha <= diasFin;
    }
    
    // ===== MÉTODOS DE GESTIÓN DE PRÉSTAMOS =====
    
    @Override
    public Integer crearPrestamo(Material material, Lector lector, Bibliotecario bibliotecario, DTFecha fechaDevolucion) {
        if (material == null || lector == null || bibliotecario == null || fechaDevolucion == null) {
            return null;
        }
        
        // Verificar que el lector esté activo
        if (lector.getEstadoL() != EstadoL.ACTIVO) {
            System.out.println("Error: El lector " + lector.getNombre() + " no puede realizar préstamos (Estado: " + lector.getEstadoL() + ")");
            return null;
        }
        
        // Verificar que el material esté disponible
        // (Aquí podrías agregar lógica adicional para verificar disponibilidad)
        
        int idPrestamo = obtenerSiguienteIdPrestamo();
        DTFecha fechaSolicitada = new DTFecha(java.time.LocalDate.now().getDayOfMonth(), 
                                             java.time.LocalDate.now().getMonthValue(), 
                                             java.time.LocalDate.now().getYear());
        
        Prestamo prestamo = new Prestamo(idPrestamo, material, lector, bibliotecario, 
                                        fechaSolicitada, fechaDevolucion, EstadoP.ENCURSO);
        manejadorPrestamo.getListaPrestamos().add(prestamo);
        
        System.out.println("✅ Préstamo creado exitosamente:");
        System.out.println("   📚 Material: " + (material instanceof Libro ? ((Libro) material).getTitulo() : 
                                                material instanceof ArtEspeciales ? ((ArtEspeciales) material).getDescripcion() : "Material ID: " + material.getId()));
        System.out.println("   👤 Lector: " + lector.getNombre() + " (" + lector.getEmail() + ")");
        System.out.println("   🏢 Bibliotecario: " + bibliotecario.getNombre() + " (Nro. Empleado: " + bibliotecario.getNroEmpleado() + ")");
        System.out.println("   📅 Fecha Solicitud: " + fechaSolicitada);
        System.out.println("   📅 Fecha Devolución: " + fechaDevolucion);
        System.out.println("   🆔 ID Préstamo: " + idPrestamo);
        
        return idPrestamo;
    }
    
    @Override
    public Prestamo obtenerPrestamo(int idPrestamo) {
        for (Prestamo prestamo : manejadorPrestamo.getListaPrestamos()) {
            if (prestamo.getId() == idPrestamo) {
                return prestamo;
            }
        }
        return null;
    }
    
    @Override
    public boolean existePrestamo(int idPrestamo) {
        return obtenerPrestamo(idPrestamo) != null;
    }
    
    @Override
    public boolean editarPrestamo(int idPrestamo, DTFecha nuevaFechaDevolucion) {
        if (nuevaFechaDevolucion == null) {
            return false;
        }
        
        Prestamo prestamo = obtenerPrestamo(idPrestamo);
        if (prestamo == null) {
            return false;
        }
        
        DTFecha fechaAnterior = prestamo.getFechaDevolucion();
        prestamo.setFechaDevolucion(nuevaFechaDevolucion);
        
        System.out.println("✅ Fecha de devolución del préstamo actualizada:");
        System.out.println("   🆔 ID Préstamo: " + idPrestamo);
        System.out.println("   📅 Fecha anterior: " + fechaAnterior);
        System.out.println("   📅 Nueva fecha: " + nuevaFechaDevolucion);
        
        return true;
    }
    
    @Override
    public boolean actualizarEstadoPrestamo(int idPrestamo, EstadoP nuevoEstado) {
        if (nuevoEstado == null) {
            return false;
        }
        
        Prestamo prestamo = obtenerPrestamo(idPrestamo);
        if (prestamo == null) {
            System.out.println("❌ Error: No se encontró el préstamo con ID: " + idPrestamo);
            return false;
        }
        
        EstadoP estadoAnterior = prestamo.getEstadoP();
        prestamo.setEstadoP(nuevoEstado);
        
        System.out.println("✅ Estado del préstamo actualizado exitosamente:");
        System.out.println("   🆔 ID Préstamo: " + idPrestamo);
        System.out.println("   📚 Material: " + (prestamo.getMaterial() instanceof Libro ? ((Libro) prestamo.getMaterial()).getTitulo() : 
                                                prestamo.getMaterial() instanceof ArtEspeciales ? ((ArtEspeciales) prestamo.getMaterial()).getDescripcion() : "Material ID: " + prestamo.getMaterial().getId()));
        System.out.println("   👤 Lector: " + prestamo.getLector().getNombre());
        System.out.println("   🔄 Estado anterior: " + estadoAnterior);
        System.out.println("   🔄 Nuevo estado: " + nuevoEstado);
        
        return true;
    }
    
    @Override
    public boolean eliminarPrestamo(int idPrestamo) {
        Prestamo prestamo = obtenerPrestamo(idPrestamo);
        if (prestamo == null) {
            return false;
        }
        
        boolean eliminado = manejadorPrestamo.getListaPrestamos().remove(prestamo);
        if (eliminado) {
            System.out.println("✅ Préstamo eliminado exitosamente:");
            System.out.println("   🆔 ID Préstamo: " + idPrestamo);
            System.out.println("   📚 Material: " + (prestamo.getMaterial() instanceof Libro ? ((Libro) prestamo.getMaterial()).getTitulo() : 
                                                prestamo.getMaterial() instanceof ArtEspeciales ? ((ArtEspeciales) prestamo.getMaterial()).getDescripcion() : "Material ID: " + prestamo.getMaterial().getId()));
        }
        
        return eliminado;
    }
    
    @Override
    public int obtenerSiguienteIdPrestamo() {
        return manejadorPrestamo.getListaPrestamos().size() + 1;
    }
    
    @Override
    public int obtenerCantidadPrestamos() {
        return manejadorPrestamo.getListaPrestamos().size();
    }
    
    @Override
    public List<Prestamo> getListaPrestamos() {
        return manejadorPrestamo.getListaPrestamos();
    }
    
    @Override
    public List<Prestamo> obtenerPrestamosPorLector(String emailLector) {
        List<Prestamo> prestamosLector = new ArrayList<>();
        for (Prestamo prestamo : manejadorPrestamo.getListaPrestamos()) {
            if (prestamo.getLector().getEmail().equals(emailLector)) {
                prestamosLector.add(prestamo);
            }
        }
        return prestamosLector;
    }
    
    @Override
    public List<Prestamo> obtenerPrestamosPorMaterial(int idMaterial) {
        List<Prestamo> prestamosMaterial = new ArrayList<>();
        for (Prestamo prestamo : manejadorPrestamo.getListaPrestamos()) {
            if (prestamo.getMaterial().getId() == idMaterial) {
                prestamosMaterial.add(prestamo);
            }
        }
        return prestamosMaterial;
    }
    
    @Override
    public List<Prestamo> obtenerPrestamosPorEstado(EstadoP estado) {
        List<Prestamo> prestamosEstado = new ArrayList<>();
        for (Prestamo prestamo : manejadorPrestamo.getListaPrestamos()) {
            if (prestamo.getEstadoP() == estado) {
                prestamosEstado.add(prestamo);
            }
        }
        return prestamosEstado;
    }
}
