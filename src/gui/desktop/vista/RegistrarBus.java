package gui.desktop.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.List;
import javax.swing.JButton;
import java.awt.Color;

public class RegistrarBus {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarBus window = new RegistrarBus();
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
	public RegistrarBus() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMatricula.setBounds(12, 13, 78, 16);
		frame.getContentPane().add(lblMatricula);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMarca.setBounds(12, 51, 56, 16);
		frame.getContentPane().add(lblMarca);
		
		JLabel lblCapacidad = new JLabel("Capacidad:");
		lblCapacidad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCapacidad.setBounds(12, 90, 78, 16);
		frame.getContentPane().add(lblCapacidad);
		
		JLabel lblExcursionesAsignadas = new JLabel("Excursiones Asignadas:");
		lblExcursionesAsignadas.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblExcursionesAsignadas.setBounds(12, 135, 175, 16);
		frame.getContentPane().add(lblExcursionesAsignadas);
		
		textField = new JTextField();
		textField.setBounds(81, 10, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(71, 48, 116, 22);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(102, 87, 45, 22);
		frame.getContentPane().add(spinner);
		
		List list = new List();
		list.setBounds(168, 135, 254, 68);
		frame.getContentPane().add(list);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setForeground(new Color(0, 0, 128));
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegistrar.setBounds(46, 215, 101, 25);
		frame.getContentPane().add(btnRegistrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(0, 0, 128));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelar.setBounds(201, 216, 101, 25);
		frame.getContentPane().add(btnCancelar);
	}
}
