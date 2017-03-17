package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal window = new MenuPrincipal();
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
	public MenuPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(224, 255, 255));
		frame.setBounds(100, 100, 767, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnRegistrarExcursion = new JMenu("Registrar Excursion");
		mnRegistrarExcursion.setBackground(new Color(135, 206, 250));
		mnRegistrarExcursion.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnRegistrarExcursion.setForeground(new Color(0, 0, 128));
		menuBar.add(mnRegistrarExcursion);
		
		JMenu mnRegistrarBus = new JMenu("Registrar Bus");
		mnRegistrarBus.setForeground(new Color(0, 0, 128));
		mnRegistrarBus.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnRegistrarBus);
		
		JMenu mnVenderBoleto = new JMenu("Vender Boleto");
		mnVenderBoleto.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnVenderBoleto.setForeground(new Color(0, 0, 128));
		menuBar.add(mnVenderBoleto);
		
		JMenu mnListarBuses = new JMenu("Listar Buses");
		mnListarBuses.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnListarBuses.setForeground(new Color(0, 0, 128));
		menuBar.add(mnListarBuses);
		
		JMenu mnListarExcursionesHacia = new JMenu("Listar Excursiones Hacia Destino");
		mnListarExcursionesHacia.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnListarExcursionesHacia.setForeground(new Color(0, 0, 128));
		menuBar.add(mnListarExcursionesHacia);
		
		JMenu mnListarExcursionesEntre = new JMenu("Listar Excursiones entre Precios");
		mnListarExcursionesEntre.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnListarExcursionesEntre.setForeground(new Color(0, 0, 128));
		menuBar.add(mnListarExcursionesEntre);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(460, 130, 180, 45);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().setLayout(null);
		btnSalir.setBackground(new Color(192, 192, 192));
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalir.setForeground(new Color(220, 20, 60));
		frame.getContentPane().add(btnSalir);
	}

}
