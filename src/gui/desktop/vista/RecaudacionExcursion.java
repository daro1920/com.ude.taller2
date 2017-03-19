package gui.desktop.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;

public class RecaudacionExcursion {

	private JFrame frmRecaudacionExcursion;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecaudacionExcursion window = new RecaudacionExcursion();
					window.frmRecaudacionExcursion.setVisible(true);
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
		frmRecaudacionExcursion = new JFrame();
		frmRecaudacionExcursion.setTitle("Recaudacion Excursion");
		frmRecaudacionExcursion.setBounds(100, 100, 450, 243);
		frmRecaudacionExcursion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRecaudacionExcursion.getContentPane().setLayout(null);
		
		JLabel lblSeleccioneLaExcursion = new JLabel("Seleccione la excursion:");
		lblSeleccioneLaExcursion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSeleccioneLaExcursion.setBounds(12, 13, 172, 16);
		frmRecaudacionExcursion.getContentPane().add(lblSeleccioneLaExcursion);
		
		JList list = new JList();
		list.setBounds(22, 42, 398, 30);
		frmRecaudacionExcursion.getContentPane().add(list);
		
		JButton btnCalcularRecaudacion = new JButton("Calcular Recaudacion");
		btnCalcularRecaudacion.setForeground(new Color(0, 0, 128));
		btnCalcularRecaudacion.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCalcularRecaudacion.setBounds(22, 163, 172, 25);
		frmRecaudacionExcursion.getContentPane().add(btnCalcularRecaudacion);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(0, 0, 128));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelar.setBounds(248, 163, 172, 25);
		frmRecaudacionExcursion.getContentPane().add(btnCancelar);
		
		JLabel lblRecaudacion = new JLabel("Recaudacion:");
		lblRecaudacion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRecaudacion.setBounds(12, 96, 113, 16);
		frmRecaudacionExcursion.getContentPane().add(lblRecaudacion);
		
		textField = new JTextField();
		textField.setBounds(104, 96, 116, 22);
		frmRecaudacionExcursion.getContentPane().add(textField);
		textField.setColumns(10);
	}

}
