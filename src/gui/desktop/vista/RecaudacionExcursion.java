package gui.desktop.vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

public class RecaudacionExcursion {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecaudacionExcursion window = new RecaudacionExcursion();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RecaudacionExcursion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Recaudacion Excursion");
		frame.setBounds(100, 100, 450, 243);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSeleccioneLaExcursion = new JLabel("Seleccione la excursion:");
		lblSeleccioneLaExcursion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSeleccioneLaExcursion.setBounds(12, 13, 172, 16);
		frame.getContentPane().add(lblSeleccioneLaExcursion);
		
		JList list = new JList();
		list.setBounds(22, 42, 398, 30);
		frame.getContentPane().add(list);
		
		JButton btnCalcularRecaudacion = new JButton("Calcular Recaudacion");
		btnCalcularRecaudacion.setForeground(new Color(0, 0, 128));
		btnCalcularRecaudacion.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCalcularRecaudacion.setBounds(22, 163, 172, 25);
		frame.getContentPane().add(btnCalcularRecaudacion);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(0, 0, 128));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelar.setBounds(248, 163, 172, 25);
		frame.getContentPane().add(btnCancelar);
		
		JLabel lblRecaudacion = new JLabel("Recaudacion:");
		lblRecaudacion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRecaudacion.setBounds(12, 96, 113, 16);
		frame.getContentPane().add(lblRecaudacion);
		
		textField = new JTextField();
		textField.setBounds(104, 96, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}

	/* Indico si deseo que la ventana sea visible o no */
	public void setVisible (boolean visible) {
		frame.setVisible(visible);
	}

	public void actuarAnteErrorConexion() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("No implementado, aun");
	}

	public void actuarAnteErrorConfiguracion() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("No implementado, aun");
	}

	public void actuarAnteErrorNoExisteExcursion() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("No implementado, aun");
	}

}
