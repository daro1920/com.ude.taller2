package gui.desktop.vista;

import gui.desktop.control.ControladorReasignarExcursion;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReasignarExcursion {
	
	private ControladorReasignarExcursion controlador;
	private boolean inicioFallido;

	private JFrame frame;
	private JTextField textFieldCodigoExcursion;

	/**
	 * Create the application.
	 */
	public ReasignarExcursion() {
		initialize();
		inicioFallido = false;
		controlador = new ControladorReasignarExcursion(this);
	}
	
    // #########################################################################
    // # METODOS PUBLICOS                                                      #
    // #########################################################################

	public void notificarReasignacionExitosa() {
		JOptionPane.showMessageDialog(frame,
	            "Excursión reasignada con éxito.",
	            "Reasignación exitosa",
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

	public void actuarAnteErrorNoExisteExcursion() {
		JOptionPane.showMessageDialog(frame,
                "No existe una excursión con el código dado.",
                "Excursión inexistente",
                JOptionPane.ERROR_MESSAGE);
	}

	public void actuarAnteErrorNoHayBusesDisponibles() {
		JOptionPane.showMessageDialog(frame,
                "No hay buses disponibles para la excursión dada.",
                "Sin buses disponibles",
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
		frame.setTitle("Reasignar Excursi\u00F3n");
		frame.setBounds(100, 100, 350, 130);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnReasignar = new JButton("Reasignar");
		btnReasignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnReasignarActionPerformed(e);
			}
		});
		btnReasignar.setBounds(12, 57, 97, 25);
		frame.getContentPane().add(btnReasignar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelarActionPerformed(e);
			}
		});
		btnCancelar.setBounds(235, 57, 97, 25);
		frame.getContentPane().add(btnCancelar);
		
		JLabel lblCodigoExcursion = new JLabel("C\u00F3digo Excursi\u00F3n");
		lblCodigoExcursion.setBounds(12, 13, 97, 16);
		frame.getContentPane().add(lblCodigoExcursion);
		
		textFieldCodigoExcursion = new JTextField();
		textFieldCodigoExcursion.setBounds(121, 10, 211, 22);
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

	protected void btnReasignarActionPerformed(ActionEvent e) {
		String codigo = textFieldCodigoExcursion.getText();
		controlador.reasignarExcursion(codigo);
	}

	private void btnCancelarActionPerformed(ActionEvent e) {
    	frame.dispose();
	}

}
