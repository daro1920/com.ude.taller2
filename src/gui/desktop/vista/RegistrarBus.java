package gui.desktop.vista;

import gui.desktop.control.ControladorRegistrarBus;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class RegistrarBus {
	
	private ControladorRegistrarBus controlador;
	private boolean inicioFallido;

	private JFrame frame;
	private JTextField textFieldMatricula;
	private JTextField textFieldMarca;
	private JSpinner spinnerCapacidad;

	/**
	 * Create the application.
	 */
	public RegistrarBus() {
		initialize();
		inicioFallido = false;
		this.controlador = new ControladorRegistrarBus(this);
	}
	
    // #########################################################################
    // # METODOS PUBLICOS                                                      #
    // #########################################################################

	public void notificarRegistroExitoso() {
		JOptionPane.showMessageDialog(frame,
            "Bus registrado con exito.",
            "Registro exitoso",
            JOptionPane.INFORMATION_MESSAGE);
	}

	public void actuarAnteErrorConexionInicial() {
		inicioFallido = true;
		JOptionPane.showMessageDialog(frame,
                "No fue posible conectarse al servidor.",
                "Error de conexión",
                JOptionPane.ERROR_MESSAGE);
	}

	public void actuarAnteErrorConfiguracionInicial() {
		inicioFallido = true;
		JOptionPane.showMessageDialog(frame,
                "No fue posible cargar la configuración.",
                "Error de configuración",
                JOptionPane.ERROR_MESSAGE);
	}

	public void actuarAnteErrorConexionMetodo() {
		JOptionPane.showMessageDialog(frame,
                "No fue posible conectarse al servidor.\n"
                + "Intentelo más tarde",
                "Error de conexión",
                JOptionPane.ERROR_MESSAGE);
	}

	public void actuarAnteCapacidadInsuficiente() {
		JOptionPane.showMessageDialog(frame,
                "La capacidad debe ser mayor a cero.",
                "Capacidad insuficiente",
                JOptionPane.ERROR_MESSAGE);
	}

	public void actuarAnteBusYaExistente() {
		JOptionPane.showMessageDialog(frame,
                "Ya existe un bus con la misma matrícula.",
                "Bus ya existente",
                JOptionPane.ERROR_MESSAGE);
	}
	
    // #########################################################################
    // # INITIALIZE                                                            #
    // #########################################################################

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 350, 210);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMatricula = new JLabel("Matr\u00EDcula *");
		lblMatricula.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMatricula.setBounds(12, 13, 78, 16);
		frame.getContentPane().add(lblMatricula);
		
		JLabel lblMarca = new JLabel("Marca *");
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMarca.setBounds(12, 42, 56, 16);
		frame.getContentPane().add(lblMarca);
		
		JLabel lblCapacidad = new JLabel("Capacidad *");
		lblCapacidad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCapacidad.setBounds(12, 71, 78, 16);
		frame.getContentPane().add(lblCapacidad);
		
		textFieldMatricula = new JTextField();
		textFieldMatricula.setBounds(102, 10, 230, 22);
		frame.getContentPane().add(textFieldMatricula);
		textFieldMatricula.setColumns(10);
		
		textFieldMarca = new JTextField();
		textFieldMarca.setBounds(102, 39, 230, 22);
		frame.getContentPane().add(textFieldMarca);
		textFieldMarca.setColumns(10);
		
		spinnerCapacidad = new JSpinner();
		spinnerCapacidad.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinnerCapacidad.setBounds(102, 68, 48, 22);
		frame.getContentPane().add(spinnerCapacidad);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRegistrarActionPerformed(e);
			}
		});
		btnRegistrar.setForeground(new Color(0, 0, 128));
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegistrar.setBounds(12, 137, 101, 25);
		frame.getContentPane().add(btnRegistrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelarActionPerformed(e);
			}
		});
		btnCancelar.setForeground(new Color(0, 0, 128));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelar.setBounds(231, 137, 101, 25);
		frame.getContentPane().add(btnCancelar);
		
		JLabel lblObligatorios = new JLabel("(*) Campos obligatorios");
		lblObligatorios.setBounds(12, 100, 308, 16);
		frame.getContentPane().add(lblObligatorios);
	}

	/* Indico si deseo que la ventana sea visible o no */
	public void setVisible (boolean visible) {
		if (inicioFallido) {
			frame.dispose();
		} else {
			frame.setVisible(visible);
		}
	}

	// #########################################################################
    // # EVENT HANDLERS                                                        #
    // #########################################################################

	private void btnRegistrarActionPerformed(ActionEvent e) {
		if(camposObligatoriosCompletados()) {
			String matricula = textFieldMatricula.getText();
			String marca = textFieldMarca.getText();
			int capacidad = (Integer) spinnerCapacidad.getValue();
			controlador.registrarBus(matricula, marca, capacidad);
		} else {
			JOptionPane.showMessageDialog(frame,
                    "Los campos marcados con asterisco (*) son obligatorios.",
                    "Faltan campos obligatorios",
                    JOptionPane.ERROR_MESSAGE);
		}
	}

	private void btnCancelarActionPerformed(ActionEvent e) {
    	frame.dispose();
	}
	
    // #########################################################################
    // # METODOS AUXILIARES                                                    #
    // #########################################################################
	
    private boolean camposObligatoriosCompletados() {
		boolean matriculaCompletada = !textFieldMatricula.getText().trim().isEmpty();
		boolean marcaCompletada = !textFieldMarca.getText().trim().isEmpty();
		// No es posible dejar vacio el spinner, por lo que no se verifica
		return matriculaCompletada && marcaCompletada;
	}
}
