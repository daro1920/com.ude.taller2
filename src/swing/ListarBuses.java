package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarBuses {

	private JFrame frmListarBuses;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarBuses window = new ListarBuses();
					window.frmListarBuses.setVisible(true);
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
		frmListarBuses = new JFrame();
		frmListarBuses.setTitle("Listar Buses");
		frmListarBuses.setBounds(100, 100, 581, 223);
		frmListarBuses.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmListarBuses.getContentPane().setLayout(null);
		
		JLabel lblListaDeBuses = new JLabel("Listado de Buses: ");
		lblListaDeBuses.setBounds(12, 13, 122, 16);
		lblListaDeBuses.setFont(new Font("Tahoma", Font.BOLD, 13));
		frmListarBuses.getContentPane().add(lblListaDeBuses);
		
		JButton btnListar = new JButton("Listar Buses");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnListar.setBounds(12, 123, 137, 25);
		btnListar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnListar.setForeground(new Color(0, 0, 128));
		frmListarBuses.getContentPane().add(btnListar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(418, 123, 118, 25);
		btnCancelar.setForeground(new Color(0, 0, 128));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		frmListarBuses.getContentPane().add(btnCancelar);
		
		JList list = new JList();
		list.setBounds(133, 12, 403, 33);
		frmListarBuses.getContentPane().add(list);
		
		JButton btnListarExcursiones = new JButton("Listar Excursiones ");
		btnListarExcursiones.setForeground(new Color(0, 0, 128));
		btnListarExcursiones.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnListarExcursiones.setBounds(208, 123, 167, 25);
		frmListarBuses.getContentPane().add(btnListarExcursiones);
	}

}
