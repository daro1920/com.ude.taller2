package gui.desktop.vista;

import gui.desktop.control.ControladorRecaudacionExcursion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RecaudacionExcursion {
	
	private ControladorRecaudacionExcursion controlador;
	private boolean inicioFallido;
	private boolean errorDeCarga;

	private JFrame frame;
	private JTextField textFieldRecaudacion;
	private JTextField textFieldCodigoExcursion;

	/**
	 * Create the application.
	 */
	public RecaudacionExcursion() {
		initialize();
		inicioFallido = false;
		controlador = new ControladorRecaudacionExcursion(this);
	}
	
    // #########################################################################
    // # METODOS PUBLICOS                                                      #
    // #########################################################################

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
		errorDeCarga = true;
		JOptionPane.showMessageDialog(frame,
                "No fue posible conectarse al servidor.\n"
                + "Intentelo más tarde",
                "Error de conexión",
                JOptionPane.ERROR_MESSAGE);
	}

	public void actuarAnteErrorNoExisteExcursion() {
		errorDeCarga = true;
		JOptionPane.showMessageDialog(frame,
                "No existe una excursión con el codigo dado.",
                "Excursión inexistente",
                JOptionPane.ERROR_MESSAGE);
	}

	// #########################################################################
    // # INITIALIZE Y SET VISIBLE                                              #
    // #########################################################################

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Recaudaci\u00F3n");
		frame.setBounds(100, 100, 300, 155);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnCalcularRecaudacion = new JButton("Calcular Recaudacion");
		btnCalcularRecaudacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCalcularRecaudacionActionPerformed(e);
			}
		});
		btnCalcularRecaudacion.setBounds(12, 82, 270, 25);
		frame.getContentPane().add(btnCalcularRecaudacion);
		
		JLabel lblRecaudacion = new JLabel("Recaudaci\u00F3n");
		lblRecaudacion.setBounds(12, 42, 97, 16);
		frame.getContentPane().add(lblRecaudacion);
		
		textFieldRecaudacion = new JTextField();
		textFieldRecaudacion.setEditable(false);
		textFieldRecaudacion.setBounds(121, 39, 161, 22);
		frame.getContentPane().add(textFieldRecaudacion);
		textFieldRecaudacion.setColumns(10);
		
		JLabel lblCodigoExcursion = new JLabel("C\u00F3digo Excursi\u00F3n");
		lblCodigoExcursion.setBounds(12, 13, 97, 16);
		frame.getContentPane().add(lblCodigoExcursion);
		
		textFieldCodigoExcursion = new JTextField();
		textFieldCodigoExcursion.setBounds(121, 10, 161, 22);
		frame.getContentPane().add(textFieldCodigoExcursion);
		textFieldCodigoExcursion.setColumns(10);
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

	protected void btnCalcularRecaudacionActionPerformed(ActionEvent e) {
		errorDeCarga = false;
		String codigo = textFieldCodigoExcursion.getText();
		BigDecimal recaudacion = controlador.recaudacionExcursion(codigo);
		if (errorDeCarga) {
			textFieldRecaudacion.setText("");
		} else {
			textFieldRecaudacion.setText(recaudacion.toPlainString());
		}
	}

}
