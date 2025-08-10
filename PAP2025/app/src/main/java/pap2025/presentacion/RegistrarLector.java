package pap2025.presentacion;

import pap2025.interfaz.IControladorFachada;
import pap2025.logica.Zona;
import pap2025.datatypes.DTFecha;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RegistrarLector extends JInternalFrame {
    
    private IControladorFachada controladorFachada;
    
    // Componentes de la interfaz
    private JTextField txtNombre;
    private JTextField txtEmail;
    private JTextField txtDireccion;
    private JTextField txtFechaRegistro;
    private JComboBox<Zona> cmbZona;
    private JButton btnAceptar;
    private JButton btnCancelar;
    
    public RegistrarLector(IControladorFachada controladorFachada) {
        this.controladorFachada = controladorFachada;
        
        // Configuración del frame
        setTitle("Registrar Nuevo Lector");
        setSize(400, 300);
        setClosable(true);
        setResizable(false);
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        
        // Inicializar componentes
        initComponents();
        initLayout();
        initEvents();
        
        // Centrar en pantalla (JInternalFrame no tiene setLocationRelativeTo)
        setLocation(100, 100);
    }
    
    private void initComponents() {
        txtNombre = new JTextField(20);
        txtEmail = new JTextField(20);
        txtDireccion = new JTextField(20);
        txtFechaRegistro = new JTextField(20);
        txtFechaRegistro.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        txtFechaRegistro.setEditable(false);
        
        cmbZona = new JComboBox<>(Zona.values());
        
        btnAceptar = new JButton("Aceptar");
        btnCancelar = new JButton("Cancelar");
    }
    
    private void initLayout() {
        setLayout(new BorderLayout());
        
        // Panel principal con GridBagLayout
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        // Nombre
        gbc.gridx = 0; gbc.gridy = 0;
        mainPanel.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1;
        mainPanel.add(txtNombre, gbc);
        
        // Email
        gbc.gridx = 0; gbc.gridy = 1;
        mainPanel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        mainPanel.add(txtEmail, gbc);
        
        // Dirección
        gbc.gridx = 0; gbc.gridy = 2;
        mainPanel.add(new JLabel("Dirección:"), gbc);
        gbc.gridx = 1;
        mainPanel.add(txtDireccion, gbc);
        
        // Fecha de Registro
        gbc.gridx = 0; gbc.gridy = 3;
        mainPanel.add(new JLabel("Fecha de Registro:"), gbc);
        gbc.gridx = 1;
        mainPanel.add(txtFechaRegistro, gbc);
        
        // Zona
        gbc.gridx = 0; gbc.gridy = 4;
        mainPanel.add(new JLabel("Zona:"), gbc);
        gbc.gridx = 1;
        mainPanel.add(cmbZona, gbc);
        
        // Panel de botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(btnAceptar);
        buttonPanel.add(btnCancelar);
        
        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private void initEvents() {
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarLector();
            }
        });
        
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    
    private void registrarLector() {
        // Obtener datos de los campos
        String nombre = txtNombre.getText().trim();
        String email = txtEmail.getText().trim();
        String direccion = txtDireccion.getText().trim();
        Zona zona = (Zona) cmbZona.getSelectedItem();
        
        // Validaciones básicas
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
            txtNombre.requestFocus();
            return;
        }
        
        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El email es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
            txtEmail.requestFocus();
            return;
        }
        
        if (!email.contains("@")) {
            JOptionPane.showMessageDialog(this, "El email debe contener @", "Error", JOptionPane.ERROR_MESSAGE);
            txtEmail.requestFocus();
            return;
        }
        
        if (direccion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La dirección es obligatoria", "Error", JOptionPane.ERROR_MESSAGE);
            txtDireccion.requestFocus();
            return;
        }
        
        // Crear fecha de registro (hoy)
        LocalDate hoy = LocalDate.now();
        DTFecha fechaRegistro = new DTFecha(hoy.getDayOfMonth(), hoy.getMonthValue(), hoy.getYear());
        
        try {
            // Intentar registrar el lector
            boolean exito = controladorFachada.registrarLector(nombre, email, direccion, fechaRegistro, zona);
            
            if (exito) {
                JOptionPane.showMessageDialog(this, 
                    "Lector registrado exitosamente", 
                    "Éxito", 
                    JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Error al registrar el lector. Verifique que el email no esté duplicado.", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, 
                "Error inesperado: " + ex.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    
    private void limpiarCampos() {
        txtNombre.setText("");
        txtEmail.setText("");
        txtDireccion.setText("");
        cmbZona.setSelectedIndex(0);
        txtNombre.requestFocus();
    }
}
