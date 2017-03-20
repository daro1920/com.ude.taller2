package gui.desktop.vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

public class ReasignarExcursion {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReasignarExcursion window = new ReasignarExcursion();
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
	public ReasignarExcursion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Reasignar Excursion");
		frame.setBounds(100, 100, 542, 234);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSeleccionarLaExcursion = new JLabel("Seleccione la Excursion a reasignar:");
		lblSeleccionarLaExcursion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSeleccionarLaExcursion.setBounds(12, 13, 245, 16);
		frame.getContentPane().add(lblSeleccionarLaExcursion);
		
		JList list = new JList();
		list.setBounds(12, 30, 485, 31);
		frame.getContentPane().add(list);
		
		JButton btnReasignar = new JButton("Reasignar");
		btnReasignar.setForeground(new Color(0, 0, 128));
		btnReasignar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReasignar.setBounds(12, 101, 97, 25);
		frame.getContentPane().add(btnReasignar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(0, 0, 128));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelar.setBounds(383, 88, 97, 25);
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

	public void actuarAnteErrorNoExisteExcursion() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("No implementado, aun");
	}

	public void actuarAnteErrorNoHayBusesDisponibles() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("No implementado, aun");
	}

}
