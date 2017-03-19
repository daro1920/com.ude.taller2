package gui.desktop.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class RespaldarDatos {

	private JFrame frmRespaldarDatos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RespaldarDatos window = new RespaldarDatos();
					window.frmRespaldarDatos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RespaldarDatos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRespaldarDatos = new JFrame();
		frmRespaldarDatos.setTitle("Respaldar Datos");
		frmRespaldarDatos.setBounds(100, 100, 450, 134);
		frmRespaldarDatos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRespaldarDatos.getContentPane().setLayout(null);
		
		JButton btnRespaldarDatos = new JButton("Respaldar Datos");
		btnRespaldarDatos.setForeground(new Color(0, 0, 128));
		btnRespaldarDatos.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRespaldarDatos.setBounds(12, 45, 167, 25);
		frmRespaldarDatos.getContentPane().add(btnRespaldarDatos);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(0, 0, 128));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelar.setBounds(237, 45, 167, 25);
		frmRespaldarDatos.getContentPane().add(btnCancelar);
	}

}
