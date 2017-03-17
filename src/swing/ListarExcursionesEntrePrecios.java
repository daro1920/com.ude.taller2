package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import javax.swing.JMenuBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class ListarExcursionesEntrePrecios {

	private JFrame frmMenuPrincipal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarExcursionesEntrePrecios window = new ListarExcursionesEntrePrecios();
					window.frmMenuPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ListarExcursionesEntrePrecios() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenuPrincipal = new JFrame();
		frmMenuPrincipal.setTitle("Menu Principal");
		frmMenuPrincipal.setBounds(100, 100, 669, 300);
		frmMenuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		menuBar.setToolTipText("");
		frmMenuPrincipal.setJMenuBar(menuBar);
		
		JMenu mnRegistrarExcursin = new JMenu("Registrar Excursi\u00F3n");
		menuBar.add(mnRegistrarExcursin);
		
		JMenu mnRegistrarBus = new JMenu("Registrar Bus");
		menuBar.add(mnRegistrarBus);
		
		JMenu mnVenderBoleto = new JMenu("Vender Boleto");
		menuBar.add(mnVenderBoleto);
		
		JMenu mnListarBuses = new JMenu("Listar Buses");
		menuBar.add(mnListarBuses);
		
		JMenu mnListarExcursionesHacia = new JMenu("Listar Excursiones Hacia Destino");
		menuBar.add(mnListarExcursionesHacia);
		
		JMenu mnListarExcursionesEntre = new JMenu("Listar Excursiones entre Precios");
		menuBar.add(mnListarExcursionesEntre);
		
		Button button_1 = new Button("Salir");
		button_1.setFont(new Font("Arial", Font.BOLD, 12));
		button_1.setForeground(new Color(0, 102, 204));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frmMenuPrincipal.getContentPane().add(button_1, BorderLayout.CENTER);
	}

}
