package gui.desktop.vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

public class ListarExcursionesEntrePrecios {

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
					ListarExcursionesEntrePrecios window = new ListarExcursionesEntrePrecios();
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
	public ListarExcursionesEntrePrecios() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Listar Excursiones entre Precios");
		frame.setBounds(100, 100, 669, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPrecio = new JLabel("Precio 1:");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrecio.setBounds(12, 13, 73, 16);
		frame.getContentPane().add(lblPrecio);
		
		JLabel lblPrecio_1 = new JLabel("Precio 2:");
		lblPrecio_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrecio_1.setBounds(226, 13, 99, 16);
		frame.getContentPane().add(lblPrecio_1);
		
		textField = new JTextField();
		textField.setBounds(81, 10, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(295, 10, 116, 22);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblListadoDeExcursiones = new JLabel("Listado de Excursiones en el rango de precios ingresados:");
		lblListadoDeExcursiones.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblListadoDeExcursiones.setBounds(12, 57, 392, 16);
		frame.getContentPane().add(lblListadoDeExcursiones);
		
		JList list = new JList();
		list.setBounds(22, 86, 598, 37);
		frame.getContentPane().add(list);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setForeground(new Color(0, 0, 128));
		btnListar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnListar.setBounds(22, 169, 97, 25);
		frame.getContentPane().add(btnListar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancelar.setForeground(new Color(0, 0, 128));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelar.setBounds(523, 169, 97, 25);
		frame.getContentPane().add(btnCancelar);
	}

	/* Indico si deseo que la ventana sea visible o no */
	public void setVisible (boolean visible) {
		frame.setVisible(visible);
	}
}
