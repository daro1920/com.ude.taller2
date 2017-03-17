package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Color;

public class ListarBuses {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarBuses window = new ListarBuses();
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
	public ListarBuses() {
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
		
		JLabel lblListaDeBuses = new JLabel("Listado de Buses: ");
		lblListaDeBuses.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblListaDeBuses.setBounds(12, 13, 122, 16);
		frame.getContentPane().add(lblListaDeBuses);
		
		JList list = new JList();
		list.setBounds(12, 167, 408, -126);
		frame.getContentPane().add(list);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnListar.setForeground(new Color(0, 0, 128));
		btnListar.setBounds(56, 215, 97, 25);
		frame.getContentPane().add(btnListar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(0, 0, 128));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelar.setBounds(262, 216, 97, 25);
		frame.getContentPane().add(btnCancelar);
	}

}
