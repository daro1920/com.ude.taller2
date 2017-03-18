package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Color;

public class ListarExcursionesHacia {

	private JFrame frmListadoDeExcursiones;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarExcursionesHacia window = new ListarExcursionesHacia();
					window.frmListadoDeExcursiones.setVisible(true);
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
		frmListadoDeExcursiones = new JFrame();
		frmListadoDeExcursiones.setTitle("Listado de Excursiones hacia Destino");
		frmListadoDeExcursiones.setBounds(100, 100, 787, 300);
		frmListadoDeExcursiones.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmListadoDeExcursiones.getContentPane().setLayout(null);
		
		JLabel lblIngreseElDestino = new JLabel("Ingrese el Destino:");
		lblIngreseElDestino.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIngreseElDestino.setBounds(12, 31, 135, 16);
		frmListadoDeExcursiones.getContentPane().add(lblIngreseElDestino);
		
		textField = new JTextField();
		textField.setBounds(145, 28, 155, 22);
		frmListadoDeExcursiones.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblListadoDeExcursiones = new JLabel("Listado de excursiones:");
		lblListadoDeExcursiones.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblListadoDeExcursiones.setBounds(12, 74, 155, 16);
		frmListadoDeExcursiones.getContentPane().add(lblListadoDeExcursiones);
		
		JList list = new JList();
		list.setBounds(179, 73, 566, 45);
		frmListadoDeExcursiones.getContentPane().add(list);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setForeground(new Color(0, 0, 128));
		btnListar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnListar.setBounds(50, 184, 97, 25);
		frmListadoDeExcursiones.getContentPane().add(btnListar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(0, 0, 128));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelar.setBounds(535, 184, 97, 25);
		frmListadoDeExcursiones.getContentPane().add(btnCancelar);
	}

}
