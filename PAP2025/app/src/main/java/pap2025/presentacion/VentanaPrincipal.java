package pap2025.presentacion;

import pap2025.fabrica.Fabrica;
import pap2025.interfaz.IControladorFachada;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
    
    private JDesktopPane desktopPane;
    private JMenuBar menuBar;
    private IControladorFachada controladorFachada;
    
    public VentanaPrincipal() {
        // Obtener instancias de la fábrica
        this.controladorFachada = Fabrica.getInstancia().getIControladorFachada();
        
        // Configuración de la ventana principal
        setTitle("Biblioteca Comunitaria - Lectores.uy");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Inicializar componentes
        initComponents();
        initLayout();
        initMenu();
        
        // Hacer visible
        setVisible(true);
    }
    
    private void initComponents() {
        desktopPane = new JDesktopPane();
        menuBar = new JMenuBar();
    }
    
    private void initLayout() {
        setLayout(new BorderLayout());
        add(desktopPane, BorderLayout.CENTER);
        setJMenuBar(menuBar);
    }
    
    private void initMenu() {
        // Menú Usuarios
        JMenu menuUsuarios = new JMenu("Usuarios");
        
        JMenuItem menuItemRegistrarLector = new JMenuItem("Registrar Nuevo Lector");
        menuItemRegistrarLector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirRegistrarLector();
            }
        });
        
        JMenuItem menuItemModificarEstado = new JMenuItem("Modificar Estado de Lector");
        menuItemModificarEstado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirModificarEstadoLector();
            }
        });
        
        JMenuItem menuItemCambiarZona = new JMenuItem("Cambiar Zona de Lector");
        menuItemCambiarZona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirCambiarZonaLector();
            }
        });
        
        JMenuItem menuItemRegistrarBibliotecario = new JMenuItem("Registrar Nuevo Bibliotecario");
        menuItemRegistrarBibliotecario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirRegistrarBibliotecario();
            }
        });
        
        menuUsuarios.add(menuItemRegistrarLector);
        menuUsuarios.addSeparator();
        menuUsuarios.add(menuItemModificarEstado);
        menuUsuarios.add(menuItemCambiarZona);
        menuUsuarios.addSeparator();
        menuUsuarios.add(menuItemRegistrarBibliotecario);
        
        // Menú Materiales
        JMenu menuMateriales = new JMenu("Materiales");
        
        JMenuItem menuItemRegistrarDonacion = new JMenuItem("Registrar Nueva Donación");
        menuItemRegistrarDonacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirRegistrarDonacion();
            }
        });
        
        JMenuItem menuItemConsultarDonaciones = new JMenuItem("Consultar Todas las Donaciones");
        menuItemConsultarDonaciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirConsultarDonaciones();
            }
        });
        
        menuMateriales.add(menuItemRegistrarDonacion);
        menuMateriales.addSeparator();
        menuMateriales.add(menuItemConsultarDonaciones);
        
        // Menú Préstamos
        JMenu menuPrestamos = new JMenu("Préstamos");
        
        JMenuItem menuItemGestionarPrestamos = new JMenuItem("Gestionar Préstamos");
        menuItemGestionarPrestamos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirGestionarPrestamos();
            }
        });
        
        JMenuItem menuItemActualizarEstadoPrestamo = new JMenuItem("Actualizar Estado de Préstamo");
        menuItemActualizarEstadoPrestamo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirActualizarEstadoPrestamo();
            }
        });
        
        menuPrestamos.add(menuItemGestionarPrestamos);
        menuPrestamos.addSeparator();
        menuPrestamos.add(menuItemActualizarEstadoPrestamo);
        
        // Agregar menús a la barra
        menuBar.add(menuUsuarios);
        menuBar.add(menuMateriales);
        menuBar.add(menuPrestamos);
    }
    
    private void abrirRegistrarLector() {
        // Verificar si ya hay una ventana abierta
        for (JInternalFrame frame : desktopPane.getAllFrames()) {
            if (frame instanceof RegistrarLector) {
                frame.toFront();
                return;
            }
        }
        
        // Crear nueva ventana de registro
        RegistrarLector registrarLector = new RegistrarLector(controladorFachada);
        desktopPane.add(registrarLector);
        registrarLector.setVisible(true);
        
        // Centrar en el desktop pane
        Dimension desktopSize = desktopPane.getSize();
        Dimension frameSize = registrarLector.getSize();
        registrarLector.setLocation(
            (desktopSize.width - frameSize.width) / 2,
            (desktopSize.height - frameSize.height) / 2
        );
    }
    
    private void abrirModificarEstadoLector() {
        // Verificar si ya hay una ventana abierta
        for (JInternalFrame frame : desktopPane.getAllFrames()) {
            if (frame instanceof ModificarEstadoLector) {
                frame.toFront();
                return;
            }
        }
        
        // Crear nueva ventana de modificación de estado
        ModificarEstadoLector modificarEstadoLector = new ModificarEstadoLector(controladorFachada);
        desktopPane.add(modificarEstadoLector);
        modificarEstadoLector.setVisible(true);
        
        // Centrar en el desktop pane
        Dimension desktopSize = desktopPane.getSize();
        Dimension frameSize = modificarEstadoLector.getSize();
        modificarEstadoLector.setLocation(
            (desktopSize.width - frameSize.width) / 2,
            (desktopSize.height - frameSize.height) / 2
        );
    }
    
    private void abrirCambiarZonaLector() {
        // Verificar si ya hay una ventana abierta
        for (JInternalFrame frame : desktopPane.getAllFrames()) {
            if (frame instanceof CambiarZonaLector) {
                frame.toFront();
                return;
            }
        }
        
        // Crear nueva ventana de cambio de zona
        CambiarZonaLector cambiarZonaLector = new CambiarZonaLector(controladorFachada);
        desktopPane.add(cambiarZonaLector);
        cambiarZonaLector.setVisible(true);
        
        // Centrar en el desktop pane
        Dimension desktopSize = desktopPane.getSize();
        Dimension frameSize = cambiarZonaLector.getSize();
        cambiarZonaLector.setLocation(
            (desktopSize.width - frameSize.width) / 2,
            (desktopSize.height - frameSize.height) / 2
        );
    }
    
    private void abrirRegistrarBibliotecario() {
        // Verificar si ya hay una ventana abierta
        for (JInternalFrame frame : desktopPane.getAllFrames()) {
            if (frame instanceof RegistrarBibliotecario) {
                frame.toFront();
                return;
            }
        }
        
        // Crear nueva ventana de registro de bibliotecario
        RegistrarBibliotecario registrarBibliotecario = new RegistrarBibliotecario(controladorFachada);
        desktopPane.add(registrarBibliotecario);
        registrarBibliotecario.setVisible(true);
        
        // Centrar en el desktop pane
        Dimension desktopSize = desktopPane.getSize();
        Dimension frameSize = registrarBibliotecario.getSize();
        registrarBibliotecario.setLocation(
            (desktopSize.width - frameSize.width) / 2,
            (desktopSize.height - frameSize.height) / 2
        );
    }
    
    private void abrirRegistrarDonacion() {
        // Verificar si ya hay una ventana abierta
        for (JInternalFrame frame : desktopPane.getAllFrames()) {
            if (frame instanceof RegistrarDonacion) {
                frame.toFront();
                return;
            }
        }
        
        // Crear nueva ventana de registro de donación
        RegistrarDonacion registrarDonacion = new RegistrarDonacion(controladorFachada);
        desktopPane.add(registrarDonacion);
        registrarDonacion.setVisible(true);
        
        // Centrar en el desktop pane
        Dimension desktopSize = desktopPane.getSize();
        Dimension frameSize = registrarDonacion.getSize();
        registrarDonacion.setLocation(
            (desktopSize.width - frameSize.width) / 2,
            (desktopSize.height - frameSize.height) / 2
        );
    }
    
    private void abrirConsultarDonaciones() {
        // Verificar si ya hay una ventana abierta
        for (JInternalFrame frame : desktopPane.getAllFrames()) {
            if (frame instanceof ConsultarDonaciones) {
                frame.toFront();
                return;
            }
        }
        
        // Crear nueva ventana de consulta de donaciones
        ConsultarDonaciones consultarDonaciones = new ConsultarDonaciones(controladorFachada);
        desktopPane.add(consultarDonaciones);
        consultarDonaciones.setVisible(true);
        
        // Centrar en el desktop pane
        Dimension desktopSize = desktopPane.getSize();
        Dimension frameSize = consultarDonaciones.getSize();
        consultarDonaciones.setLocation(
            (desktopSize.width - frameSize.width) / 2,
            (desktopSize.height - frameSize.height) / 2
        );
    }
    
    private void abrirGestionarPrestamos() {
        // Crear nueva ventana de gestión de préstamos (JFrame independiente)
        GestionarPrestamos gestionarPrestamos = new GestionarPrestamos(controladorFachada);
        gestionarPrestamos.setVisible(true);
        
        // Centrar en pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = gestionarPrestamos.getSize();
        gestionarPrestamos.setLocation(
            (screenSize.width - frameSize.width) / 2,
            (screenSize.height - frameSize.height) / 2
        );
    }
    
    private void abrirActualizarEstadoPrestamo() {
        // Crear nueva ventana de actualización de estado (JFrame independiente)
        ActualizarEstadoPrestamo actualizarEstadoPrestamo = new ActualizarEstadoPrestamo(controladorFachada);
        actualizarEstadoPrestamo.setVisible(true);
        
        // Centrar en pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = actualizarEstadoPrestamo.getSize();
        actualizarEstadoPrestamo.setLocation(
            (screenSize.width - frameSize.width) / 2,
            (screenSize.height - frameSize.height) / 2
        );
    }
    
    public static void main(String[] args) {
        // Configurar look and feel del sistema
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Crear y mostrar la ventana principal
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaPrincipal();
            }
        });
    }
}
