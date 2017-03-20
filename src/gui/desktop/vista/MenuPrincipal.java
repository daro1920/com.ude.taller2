package gui.desktop.vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmRespaldar = new JMenuItem("Respaldar");
		mntmRespaldar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmRespaldarActionPerformed(e);
			}
		});
		mnArchivo.add(mntmRespaldar);
		
		JMenuItem mntmRecuperar = new JMenuItem("Recuperar");
		mntmRecuperar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmRecuperarActionPerformed(e);
			}
		});
		mnArchivo.add(mntmRecuperar);
		
		JMenu mnAltas = new JMenu("Altas");
		menuBar.add(mnAltas);
		
		JMenuItem mntmRegistrarBus = new JMenuItem("Registrar Bus");
		mntmRegistrarBus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmRegistrarBusActionPerformed(e);
			}
		});
		mnAltas.add(mntmRegistrarBus);
		
		JMenuItem mntmResgistrarExcursion = new JMenuItem("Resgistrar Excursi\u00F3n");
		mntmResgistrarExcursion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmResgistrarExcursionActionPerformed(e);
			}
		});
		mnAltas.add(mntmResgistrarExcursion);
		
		JMenuItem mntmVenderBoleto = new JMenuItem("Vender Boleto");
		mntmVenderBoleto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmVenderBoletoActionPerformed(e);
			}
		});
		mnAltas.add(mntmVenderBoleto);
		
		JMenu mnModificaciones = new JMenu("Modificaciones");
		menuBar.add(mnModificaciones);
		
		JMenuItem mntmReasignarExcursion = new JMenuItem("Reasignar Excursi\u00F3n");
		mntmReasignarExcursion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmReasignarExcursionActionPerformed(e);
			}
		});
		mnModificaciones.add(mntmReasignarExcursion);
		
		JMenu mnListadosYConsultas = new JMenu("Listados y Consultas");
		menuBar.add(mnListadosYConsultas);
		
		JMenuItem mntmBuses = new JMenuItem("Buses");
		mntmBuses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmBusesActionPerformed(e);
			}
		});
		mnListadosYConsultas.add(mntmBuses);
		
		JMenuItem mntmRecaudacionExcursion = new JMenuItem("Recaudaci\u00F3n Excursi\u00F3n");
		mntmRecaudacionExcursion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmRecaudacionExcursionActionPerformed(e);
			}
		});
		mnListadosYConsultas.add(mntmRecaudacionExcursion);
		
		JMenuItem mntmBoletosExcursion = new JMenuItem("Boletos de una Excursi\u00F3n");
		mntmBoletosExcursion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmBoletosExcursionActionPerformed(e);
			}
		});
		mnListadosYConsultas.add(mntmBoletosExcursion);
		
		JMenuItem mntmExcursionesHaciaDestino = new JMenuItem("Excursiones hacia un Destino");
		mntmExcursionesHaciaDestino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmExcursionesHaciaDestinoActionPerformed(e);
			}
		});
		mnListadosYConsultas.add(mntmExcursionesHaciaDestino);
		
		JMenuItem mntmExcursionesEntrePrecios = new JMenuItem("Excursiones entre Precios");
		mntmExcursionesEntrePrecios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmExcursionesEntrePreciosActionPerformed(e);
			}
		});
		mnListadosYConsultas.add(mntmExcursionesEntrePrecios);
		frame.getContentPane().setLayout(null);
	}

	private void mntmRespaldarActionPerformed(ActionEvent e) {
		RespaldarDatos ventana = new RespaldarDatos();
		ventana.setVisible(true);
	}
	
	private void mntmRecuperarActionPerformed(ActionEvent e) {
		RecuperarDatos ventana = new RecuperarDatos();
		ventana.setVisible(true);
	}

	private void mntmRegistrarBusActionPerformed(ActionEvent e) {
		RegistrarBus ventana = new RegistrarBus();
		ventana.setVisible(true);
	}

	private void mntmResgistrarExcursionActionPerformed(ActionEvent e) {
		RegistrarExcursion ventana = new RegistrarExcursion();
		ventana.setVisible(true);
	}

	private void mntmVenderBoletoActionPerformed(ActionEvent e) {
		VenderBoleto ventana = new VenderBoleto();
		ventana.setVisible(true);
	}

	private void mntmReasignarExcursionActionPerformed(ActionEvent e) {
		ReasignarExcursion ventana = new ReasignarExcursion();
		ventana.setVisible(true);
	}

	private void mntmBusesActionPerformed(ActionEvent e) {
		ListarBuses ventana = new ListarBuses();
		ventana.setVisible(true);
	}

	private void mntmRecaudacionExcursionActionPerformed(ActionEvent e) {
		RecaudacionExcursion ventana = new RecaudacionExcursion();
		ventana.setVisible(true);
	}

	private void mntmBoletosExcursionActionPerformed(ActionEvent e) {
		ListarBoletosExcursion ventana = new ListarBoletosExcursion();
		ventana.setVisible(true);
	}

	private void mntmExcursionesHaciaDestinoActionPerformed(ActionEvent e) {
		ListarExcursionesHacia ventana = new ListarExcursionesHacia();
		ventana.setVisible(true);
	}

	private void mntmExcursionesEntrePreciosActionPerformed(ActionEvent e) {
		ListarExcursionesEntrePrecios ventana = new ListarExcursionesEntrePrecios();
		ventana.setVisible(true);
	}
	
}
