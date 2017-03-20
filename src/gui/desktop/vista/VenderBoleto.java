package gui.desktop.vista;

import gui.desktop.control.ControladorRegistrarBus;
import gui.desktop.control.ControladorVenderBoleto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.List;
import java.awt.TextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import java.awt.Color;
import javax.swing.JSpinner;

public class VenderBoleto {
	
	private ControladorVenderBoleto controlador;
	private boolean inicioFallido;

	private JFrame frame;
	private JTextField textProcedencia;
	private JTextField textCelular;
	private JTextField textNroExcursion;
	private JSpinner spinnerEdadPasajero;
	private JSpinner spinnerDescuento;
	private JSpinner spinnerBoleto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VenderBoleto window = new VenderBoleto();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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

	public void actuarAnteNoHayAsientosDisponibles() {
		JOptionPane.showMessageDialog(frame,
                "No hay asientos disponibles para la excursio seleccionada.",
                "Capacidad insuficiente",
                JOptionPane.ERROR_MESSAGE);
	}

	public void actuarAnteNoExisteExcursion() {
		JOptionPane.showMessageDialog(frame,
                "No existe una excursion con ese codigo.",
                "Codigo excursion invalido",
                JOptionPane.ERROR_MESSAGE);
	}
	
    // #########################################################################
    // # INITIALIZE Y SET VISIBLE                                              #
    // #########################################################################

	/**
	 * Create the application.
	 */
	public VenderBoleto() {
		initialize();
		inicioFallido = false;
		this.controlador = new ControladorVenderBoleto(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.setBounds(100, 100, 453, 330);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edad Pasajero:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(12, 13, 120, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblProcedencia = new JLabel("Procedencia*:");
		lblProcedencia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblProcedencia.setBounds(12, 42, 120, 16);
		frame.getContentPane().add(lblProcedencia);
		
		JLabel lblCelular = new JLabel("Celular*:");
		lblCelular.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCelular.setBounds(12, 71, 85, 16);
		frame.getContentPane().add(lblCelular);
		
		JLabel lblExcursion = new JLabel("Excursion*:");
		lblExcursion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblExcursion.setBounds(12, 100, 93, 16);
		frame.getContentPane().add(lblExcursion);
		
		JLabel lblPrecio = new JLabel("Descuento:");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrecio.setBounds(12, 193, 85, 16);
		frame.getContentPane().add(lblPrecio);
		
		JLabel lblNroBoleto = new JLabel("Nro. Boleto:");
		lblNroBoleto.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNroBoleto.setBounds(12, 149, 76, 16);
		frame.getContentPane().add(lblNroBoleto);
		
		textProcedencia = new JTextField();
		textProcedencia.setBounds(127, 40, 116, 22);
		frame.getContentPane().add(textProcedencia);
		textProcedencia.setColumns(10);
		
		textCelular = new JTextField();
		textCelular.setBounds(127, 69, 116, 22);
		frame.getContentPane().add(textCelular);
		textCelular.setColumns(10);
		
		JButton btnNewButton = new JButton("Vender");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRegistrarActionPerformed(e);
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(50, 236, 125, 34);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelarActionPerformed(e);
			}
		});
		btnCancelar.setForeground(new Color(0, 0, 128));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelar.setBounds(258, 236, 125, 34);
		frame.getContentPane().add(btnCancelar);
		
		textNroExcursion = new JTextField();
		textNroExcursion.setColumns(10);
		textNroExcursion.setBounds(127, 98, 116, 22);
		frame.getContentPane().add(textNroExcursion);
		
		spinnerEdadPasajero = new JSpinner();
		spinnerEdadPasajero.setBounds(127, 11, 48, 22);
		frame.getContentPane().add(spinnerEdadPasajero);
		
		spinnerBoleto = new JSpinner();
		spinnerBoleto.setBounds(127, 147, 48, 22);
		frame.getContentPane().add(spinnerBoleto);
		
		spinnerDescuento = new JSpinner();
		spinnerDescuento.setBounds(127, 191, 48, 22);
		frame.getContentPane().add(spinnerDescuento);
	}
	
	private void btnCancelarActionPerformed(ActionEvent e) {
    	frame.dispose();
	}
	
	private void btnRegistrarActionPerformed(ActionEvent e) {
		if(camposObligatoriosCompletados()) {
			
			int edad = (Integer)spinnerEdadPasajero.getValue();
			String procedencia = textProcedencia.getText();
			String celular = textCelular.getText();
			String nroExcursion = textNroExcursion.getText();
			int descuento = (Integer) spinnerDescuento.getValue();
			int nroBoleto = (Integer) spinnerBoleto.getValue();
			
			controlador.venderBoleto(edad,procedencia,celular,nroExcursion,descuento,nroBoleto);
		} else {
			JOptionPane.showMessageDialog(frame,
                    "Los campos marcados con asterisco (*) son obligatorios.",
                    "Faltan campos obligatorios",
                    JOptionPane.ERROR_MESSAGE);
		}
	}

	/* Indico si deseo que la ventana sea visible o no */
	public void setVisible (boolean visible) {
		frame.setVisible(visible);
	}
	
	// #########################################################################
    // # METODOS AUXILIARES                                                    #
    // #########################################################################
	
    private boolean camposObligatoriosCompletados() {
    	boolean nroExcursion = !textNroExcursion.getText().trim().isEmpty();
		boolean procedencia = !textProcedencia.getText().trim().isEmpty();
		boolean celular = !textCelular.getText().trim().isEmpty();
		// No es posible dejar vacio el spinner, por lo que no se verifica
		return procedencia && celular;
	}
}
