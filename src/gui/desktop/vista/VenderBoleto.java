package gui.desktop.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.List;
import java.awt.TextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Color;

public class VenderBoleto {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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

	/**
	 * Create the application.
	 */
	public VenderBoleto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.setBounds(100, 100, 453, 330);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edad Pasajero:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(12, 13, 120, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblProcedencia = new JLabel("Procedencia:");
		lblProcedencia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblProcedencia.setBounds(12, 42, 93, 16);
		frame.getContentPane().add(lblProcedencia);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCelular.setBounds(12, 71, 56, 16);
		frame.getContentPane().add(lblCelular);
		
		JLabel lblExcursion = new JLabel("Excursion:");
		lblExcursion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblExcursion.setBounds(12, 100, 93, 16);
		frame.getContentPane().add(lblExcursion);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrecio.setBounds(12, 193, 56, 16);
		frame.getContentPane().add(lblPrecio);
		
		JLabel lblNroBoleto = new JLabel("Nro. Boleto:");
		lblNroBoleto.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNroBoleto.setBounds(12, 149, 76, 16);
		frame.getContentPane().add(lblNroBoleto);
		
		textField = new JTextField();
		textField.setBounds(117, 10, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(117, 39, 116, 22);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(117, 68, 116, 22);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		List list = new List();
		list.setBounds(108, 99, 314, 34);
		frame.getContentPane().add(list);
		
		TextField textField_3 = new TextField();
		textField_3.setBounds(108, 146, 50, 22);
		frame.getContentPane().add(textField_3);
		
		TextField textField_4 = new TextField();
		textField_4.setBounds(64, 193, 56, 24);
		frame.getContentPane().add(textField_4);
		
		JButton btnNewButton = new JButton("Vender");
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(50, 236, 125, 34);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(0, 0, 128));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelar.setBounds(258, 236, 125, 34);
		frame.getContentPane().add(btnCancelar);
	}
}
