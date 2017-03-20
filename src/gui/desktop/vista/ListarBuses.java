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
		frame.setTitle("Listar Buses");
		frame.setBounds(100, 100, 581, 223);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblListaDeBuses = new JLabel("Listado de Buses: ");
		lblListaDeBuses.setBounds(12, 13, 122, 16);
		lblListaDeBuses.setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().add(lblListaDeBuses);
		
		JButton btnListar = new JButton("Listar Buses");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnListar.setBounds(12, 123, 137, 25);
		btnListar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnListar.setForeground(new Color(0, 0, 128));
		frame.getContentPane().add(btnListar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(418, 123, 118, 25);
		btnCancelar.setForeground(new Color(0, 0, 128));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(btnCancelar);
		
		JList list = new JList();
		list.setBounds(133, 12, 403, 33);
		frame.getContentPane().add(list);
		
		JButton btnListarExcursiones = new JButton("Listar Excursiones ");
		btnListarExcursiones.setForeground(new Color(0, 0, 128));
		btnListarExcursiones.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnListarExcursiones.setBounds(208, 123, 167, 25);
		frame.getContentPane().add(btnListarExcursiones);
	}

	/* Indico si deseo que la ventana sea visible o no */
	public void setVisible (boolean visible) {
		frame.setVisible(visible);
	}

}
