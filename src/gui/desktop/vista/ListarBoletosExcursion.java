package gui.desktop.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Color;

public class ListarBoletosExcursion {

	private JFrame frmListarBoletosVendidos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarBoletosExcursion window = new ListarBoletosExcursion();
					window.frmListarBoletosVendidos.setVisible(true);
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
	private void initialize() {
		frmListarBoletosVendidos = new JFrame();
		frmListarBoletosVendidos.setTitle("Listar Boletos Vendidos para una Excursion");
		frmListarBoletosVendidos.setBounds(100, 100, 646, 199);
		frmListarBoletosVendidos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmListarBoletosVendidos.getContentPane().setLayout(null);
		
		JLabel lblSeleccionarExcursin = new JLabel("Seleccionar Excursi\u00F3n:");
		lblSeleccionarExcursin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSeleccionarExcursin.setBounds(12, 13, 151, 16);
		frmListarBoletosVendidos.getContentPane().add(lblSeleccionarExcursin);
		
		JList list = new JList();
		list.setBounds(157, 12, 459, 25);
		frmListarBoletosVendidos.getContentPane().add(list);
		
		JButton btnVerBoletosVendidos = new JButton("Ver Boletos Vendidos");
		btnVerBoletosVendidos.setForeground(new Color(0, 0, 128));
		btnVerBoletosVendidos.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnVerBoletosVendidos.setBounds(48, 94, 185, 25);
		frmListarBoletosVendidos.getContentPane().add(btnVerBoletosVendidos);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(0, 0, 128));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelar.setBounds(369, 94, 185, 25);
		frmListarBoletosVendidos.getContentPane().add(btnCancelar);
	}
}
