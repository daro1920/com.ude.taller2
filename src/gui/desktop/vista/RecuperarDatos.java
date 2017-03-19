package gui.desktop.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class RecuperarDatos {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecuperarDatos window = new RecuperarDatos();
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
	public RecuperarDatos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
