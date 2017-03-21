package gui.desktop.vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

public class ListarBoletosExcursion {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarBoletosExcursion window = new ListarBoletosExcursion();
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
	public ListarBoletosExcursion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("rawtypes")
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Listar Boletos Vendidos para una Excursion");
		frame.setBounds(100, 100, 646, 199);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSeleccionarExcursin = new JLabel("Seleccionar Excursi\u00F3n:");
		lblSeleccionarExcursin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSeleccionarExcursin.setBounds(12, 13, 151, 16);
		frame.getContentPane().add(lblSeleccionarExcursin);
		
		JList list = new JList();
		list.setBounds(157, 12, 459, 25);
		frame.getContentPane().add(list);
		
		JButton btnVerBoletosVendidos = new JButton("Ver Boletos Vendidos");
		btnVerBoletosVendidos.setForeground(new Color(0, 0, 128));
		btnVerBoletosVendidos.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnVerBoletosVendidos.setBounds(48, 94, 185, 25);
		frame.getContentPane().add(btnVerBoletosVendidos);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(0, 0, 128));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelar.setBounds(369, 94, 185, 25);
		frame.getContentPane().add(btnCancelar);
	}

	/* Indico si deseo que la ventana sea visible o no */
	public void setVisible (boolean visible) {
		frame.setVisible(visible);
	}
	
}
