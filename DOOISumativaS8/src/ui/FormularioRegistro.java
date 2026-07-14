package ui;

import data.GestorEntidades;
import model.*;

import javax.swing.*;
import java.awt.*;

/**
 * Clase FormularioRegistro que representa la Interfaz Gráfica del Usuario GUI.
 * Permite registrar empresas o personas (clientes, trabajadores o proveedores) mediante un formulario
 * y visualizar el listado de personas registradas.
 */

public class FormularioRegistro extends JFrame {

    //Gestor que almacena y administra a las personas registradas.
    private final GestorEntidades gestorEntidades = new GestorEntidades();

    //Componentes del formulario.
    private JTextField txtNombre;
    private JTextField txtRut;
    private JTextField txtDatoEspecifico;
    private JLabel lblDatoEspecifico; //Etiqueta con texto cambiable según el tipo de persona.
    private JComboBox<String> comboPersonas; //Combo que permite seleccionar tipo de persona de forma dinámica.
    private JTextArea areaPersonas; //Área donde se muestra el listado de personas registradas.

    //Constructor de la ventana de la interfaz.
    public FormularioRegistro() {
        super("Sistema de registro LlanquihueTour");

        //Configuración de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(950, 700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        add(crearPanelLista(), BorderLayout.CENTER);
        add(crearPanelSuperior(), BorderLayout.NORTH);

        actualizarListado();
        setVisible(true);
    }

    //Construcción de la interfaz
    private JPanel crearPanelSuperior() {
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.Y_AXIS));
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(5, 15, 10, 15));

        JLabel titulo = new JLabel("Sistema de Registro LlanquihueTour");
        titulo.setFont(new Font("Century gothic", Font.BOLD, 18));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitulo = new JLabel("Datos de la Entidad");
        subtitulo.setFont(new Font("Century gothic", Font.ITALIC, 12));
        subtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel panelFormulario = crearPanelFormulario();
        panelFormulario.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel panelBotones = crearPanelBotones();
        panelBotones.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel listado = new JLabel("Entidades Registradas");
        listado.setFont(new Font("Century gothic", Font.ITALIC, 14));
        listado.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelSuperior.add(titulo);
        panelSuperior.add(Box.createVerticalStrut(15));
        panelSuperior.add(subtitulo);
        panelSuperior.add(Box.createVerticalStrut(5));
        panelSuperior.add(panelFormulario);
        panelSuperior.add(Box.createVerticalStrut(10));
        panelSuperior.add(panelBotones);
        panelSuperior.add(listado);

        return panelSuperior;
    }

    /**
     * Método que crea el panel del formulario
     * @return el panel que contiene los elementos del formulario.
     */
    private JPanel crearPanelFormulario() {
        JPanel panelFormulario = new JPanel(new GridLayout());
        panelFormulario.setBorder(BorderFactory.createEtchedBorder());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        comboPersonas = new JComboBox<>(new String[]{"Cliente", "Trabajador", "Proveedor"});
        txtNombre = new JTextField();
        txtRut = new JTextField();
        txtDatoEspecifico = new JTextField();
        lblDatoEspecifico = new JLabel();

        gbc.gridx = 0;
        gbc.gridy = 0;
        panelFormulario.add(new JLabel("Tipo de persona: "), gbc);

        gbc.gridx = 1;
        panelFormulario.add(comboPersonas, gbc);

        gbc.gridx = 2;
        panelFormulario.add(new JLabel("Nombre: "), gbc);

        gbc.gridx = 3;
        panelFormulario.add(txtNombre, gbc);

        gbc.gridx = 4;
        panelFormulario.add(new JLabel("Rut"), gbc);

        gbc.gridx = 5;
        panelFormulario.add(txtRut, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panelFormulario.add(lblDatoEspecifico, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 5;
        panelFormulario.add(txtDatoEspecifico, gbc);
        gbc.gridwidth = 1;

        //Al cambiar tipo de persona, se actualiza la etiqueta del dato específico.
        comboPersonas.addActionListener(e -> actualizarListado());
        actualizarDatos();

        return panelFormulario;
    }

    //Método que permite actualizar el dato específico de la persona según su tipo.
    private void actualizarListado() {
        String tipo =(String) comboPersonas.getSelectedItem();
        if (tipo == null) {
            return;
        }
        if (tipo.equals("Cliente")) {
            lblDatoEspecifico.setText("Nacionalidad: ");
        } else if (tipo.equals("Trabajador")) {
            lblDatoEspecifico.setText("Sección: ");
        } else if(tipo.equals("Proveedor")) {
            lblDatoEspecifico.setText("Giro Empresarial: ");
        }
    }

    /**
     * Método que crea el panel de botones.
     * El panel está compuesto por cuatro botones: Agregar, mostrar, limpiar y salir.
     * @return panel con botones.
     */
    private JPanel crearPanelBotones() {
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 5));

        JButton btnAgregar = new JButton("Agregar entidad");
        JButton btnMostrar = new JButton("Mostrar entidad");
        JButton btnLimpiar = new JButton("Limpiar datos");
        JButton btnSalir = new JButton("Salir");

        btnAgregar.addActionListener(e -> agregarPersona());
        btnMostrar.addActionListener(e -> actualizarDatos());
        btnLimpiar.addActionListener(e -> limpiarDatos());
        btnSalir.addActionListener(e -> System.exit(0));

        panelBotones.add(btnAgregar);
        panelBotones.add(btnMostrar);
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnSalir);

        return panelBotones;
    }

    /** Método que crea el panel donde se mostrará la información registrada al usuario.
     * @return Panel para muestra de texto.
     */
    private JScrollPane crearPanelLista() {
        areaPersonas = new JTextArea();
        areaPersonas.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaPersonas);
        scroll.setBorder(BorderFactory.createEmptyBorder(0,15,15,15));
        return scroll;
    }

    /**
     * Método que permite agregar personas a la lista de registro según su tipo y dato específico.
     */
    private void agregarPersona() {
        String nombre = txtNombre.getText().trim();
        String rutTexto = txtRut.getText().trim();
        String datoEspecifico = txtDatoEspecifico.getText().trim();
        String tipoPersona = (String) comboPersonas.getSelectedItem();

        if (nombre.isBlank() || rutTexto.isBlank() || datoEspecifico.isBlank()) {
            JOptionPane.showMessageDialog(this,
                    "Formulario incompleto.",
                        "Error",
                             JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            Entidad nuevaEntidad;

            if(tipoPersona.equals("Cliente")) {
                nuevaEntidad = new Cliente(nombre, new Rut(rutTexto), datoEspecifico);
            } else if (tipoPersona.equals("Trabajador")) {
                nuevaEntidad = new Trabajador(nombre, new Rut(rutTexto), datoEspecifico);
            } else if (tipoPersona.equals("Proveedor")){
                nuevaEntidad = new Proveedor(nombre, new Rut(rutTexto), datoEspecifico);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Error: Tipo de persona no reconocido.",
                            "Error",
                                 JOptionPane.ERROR_MESSAGE);
                return;
            }

            gestorEntidades.agregarPersona(nuevaEntidad);
            JOptionPane.showMessageDialog(this, nuevaEntidad.mostrarResumen());
            limpiarDatos();
            actualizarListado();

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Error de validación",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

   //Método que permite limpiar los datos de la pantalla.
    private void limpiarDatos() {
        txtNombre.setText("");
        txtRut.setText("");
        txtDatoEspecifico.setText("");
        areaPersonas.setText("");
    }

    //Método que permite actualizar y mostrar los datos en la pantalla.
    private void actualizarDatos() {
        areaPersonas.setText(gestorEntidades.mostrarResumenPersonas());
    }
}

