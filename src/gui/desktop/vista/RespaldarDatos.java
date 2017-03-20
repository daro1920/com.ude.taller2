package gui.desktop.vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;

public class RespaldarDatos {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RespaldarDatos window = new RespaldarDatos();
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
	public RespaldarDatos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Respaldar Datos");
		frame.setBounds(100, 100, 450, 134);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnRespaldarDatos = new JButton("Respaldar Datos");
		btnRespaldarDatos.setForeground(new Color(0, 0, 128));
		btnRespaldarDatos.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRespaldarDatos.setBounds(12, 45, 167, 25);
		frame.getContentPane().add(btnRespaldarDatos);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(0, 0, 128));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelar.setBounds(237, 45, 167, 25);
		frame.getContentPane().add(btnCancelar);
	}

	/* Indico si deseo que la ventana sea visible o no */
	public void setVisible (boolean visible) {
		frame.setVisible(visible);
	}

	public void actuarAnteErrorConexion() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("No implementado, aun");
	}

	public void actuarAnteErrorConfiguracion() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("No implementado, aun");
	}

	public void actuarAnteErrorPersistencia() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("No implementado, aun");
	}

}
