package gui.desktop.vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

public class ListarExcursionesHacia {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarExcursionesHacia window = new ListarExcursionesHacia();
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
	public ListarExcursionesHacia() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Listado de Excursiones hacia Destino");
		frame.setBounds(100, 100, 787, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblIngreseElDestino = new JLabel("Ingrese el Destino:");
		lblIngreseElDestino.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIngreseElDestino.setBounds(12, 31, 135, 16);
		frame.getContentPane().add(lblIngreseElDestino);
		
		textField = new JTextField();
		textField.setBounds(145, 28, 155, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblListadoDeExcursiones = new JLabel("Listado de excursiones:");
		lblListadoDeExcursiones.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblListadoDeExcursiones.setBounds(12, 74, 155, 16);
		frame.getContentPane().add(lblListadoDeExcursiones);
		
		JList list = new JList();
		list.setBounds(179, 73, 566, 45);
		frame.getContentPane().add(list);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setForeground(new Color(0, 0, 128));
		btnListar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnListar.setBounds(50, 184, 97, 25);
		frame.getContentPane().add(btnListar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(0, 0, 128));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelar.setBounds(535, 184, 97, 25);
		frame.getContentPane().add(btnCancelar);
	}

	/* Indico si deseo que la ventana sea visible o no */
	public void setVisible (boolean visible) {
		frame.setVisible(visible);
	}

}
