package gui.desktop.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Color;

public class ReasignarExcursion {

	private JFrame frmReasignarExcursion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReasignarExcursion window = new ReasignarExcursion();
					window.frmReasignarExcursion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ReasignarExcursion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmReasignarExcursion = new JFrame();
		frmReasignarExcursion.setTitle("Reasignar Excursion");
		frmReasignarExcursion.setBounds(100, 100, 542, 234);
		frmReasignarExcursion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmReasignarExcursion.getContentPane().setLayout(null);
		
		JLabel lblSeleccionarLaExcursion = new JLabel("Seleccione la Excursion a reasignar:");
		lblSeleccionarLaExcursion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSeleccionarLaExcursion.setBounds(12, 13, 245, 16);
		frmReasignarExcursion.getContentPane().add(lblSeleccionarLaExcursion);
		
		JList list = new JList();
		list.setBounds(12, 30, 485, 31);
		frmReasignarExcursion.getContentPane().add(list);
		
		JButton btnReasignar = new JButton("Reasignar");
		btnReasignar.setForeground(new Color(0, 0, 128));
		btnReasignar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReasignar.setBounds(12, 101, 97, 25);
		frmReasignarExcursion.getContentPane().add(btnReasignar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(0, 0, 128));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelar.setBounds(383, 88, 97, 25);
		frmReasignarExcursion.getContentPane().add(btnCancelar);
	}

	public void actuarAnteErrorConexion() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("No implementado, aun");
	}

	public void actuarAnteErrorConfiguracion() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("No implementado, aun");
	}

	public void actuarAnteErrorNoExisteExcursion() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("No implementado, aun");
	}

	public void actuarAnteErrorNoHayBusesDisponibles() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("No implementado, aun");
	}

}
