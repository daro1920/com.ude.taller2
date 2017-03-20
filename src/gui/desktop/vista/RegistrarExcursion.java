package gui.desktop.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.Choice;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarExcursion {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarExcursion window = new RegistrarExcursion();
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
	public RegistrarExcursion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.setBounds(100, 100, 482, 335);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCdigo.setBounds(12, 13, 72, 22);
		frame.getContentPane().add(lblCdigo);
		
		JLabel lblDestino = new JLabel("Destino:");
		lblDestino.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDestino.setBounds(12, 51, 72, 22);
		frame.getContentPane().add(lblDestino);
		
		JLabel lblFechaPartida = new JLabel("Fecha Partida:");
		lblFechaPartida.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFechaPartida.setBounds(12, 86, 103, 16);
		frame.getContentPane().add(lblFechaPartida);
		
		JLabel lblFechaRegreso = new JLabel("Fecha Regreso:");
		lblFechaRegreso.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFechaRegreso.setBounds(12, 115, 125, 16);
		frame.getContentPane().add(lblFechaRegreso);
		
		JLabel lblPrecioBase = new JLabel("Precio Base:");
		lblPrecioBase.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecioBase.setBounds(12, 144, 91, 16);
		frame.getContentPane().add(lblPrecioBase);
		
		JLabel lblBusAsignado = new JLabel("Bus Asignado:");
		lblBusAsignado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBusAsignado.setBounds(12, 173, 103, 16);
		frame.getContentPane().add(lblBusAsignado);
		
		JLabel lblBoletosVendidos = new JLabel("Boletos Vendidos:");
		lblBoletosVendidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBoletosVendidos.setBounds(12, 202, 125, 16);
		frame.getContentPane().add(lblBoletosVendidos);
		
		textField = new JTextField();
		textField.setBounds(75, 14, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		Choice choice = new Choice();
		choice.setBounds(90, 51, 116, 22);
		frame.getContentPane().add(choice);
		
		textField_1 = new JTextField();
		textField_1.setBounds(115, 142, 116, 22);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JList list = new JList();
		list.setBounds(115, 191, 116, -14);
		frame.getContentPane().add(list);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(147, 200, 59, 22);
		frame.getContentPane().add(spinner);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegistrar.setForeground(new Color(0, 0, 128));
		btnRegistrar.setBounds(75, 231, 131, 44);
		frame.getContentPane().add(btnRegistrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setForeground(new Color(0, 0, 128));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelar.setBounds(262, 231, 131, 44);
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

	public void actuarAnteErrorYaExisteExcursion() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("No implementado, aun");
	}

	public void actuarAnteErrorNoHayBusesDisponibles() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("No implementado, aun");
	}

	public void actuarAnteErrorPeriodoInvalido() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("No implementado, aun");
	}
	
}
