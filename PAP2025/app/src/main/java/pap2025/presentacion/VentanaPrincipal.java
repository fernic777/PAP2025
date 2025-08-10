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
        
        menuUsuarios.add(menuItemRegistrarLector);
        
        // Menú Materiales
        JMenu menuMateriales = new JMenu("Materiales");
        // TODO: Agregar opciones de materiales
        
        // Menú Préstamos
        JMenu menuPrestamos = new JMenu("Préstamos");
        // TODO: Agregar opciones de préstamos
        
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
    
    public static void main(String[] args) {
        // Configurar look and feel del sistema
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeel());
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
