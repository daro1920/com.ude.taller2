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
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;

public class ListarExcursionesEntrePrecios {

	private JFrame frmMenuPrincipal;
	private JTextField textField;
	private JTextField textField_1;

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
		frmMenuPrincipal.setTitle("Listar Excursiones entre Precios");
		frmMenuPrincipal.setBounds(100, 100, 669, 300);
		frmMenuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenuPrincipal.getContentPane().setLayout(null);
		
		JLabel lblPrecio = new JLabel("Precio 1:");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrecio.setBounds(12, 13, 73, 16);
		frmMenuPrincipal.getContentPane().add(lblPrecio);
		
		JLabel lblPrecio_1 = new JLabel("Precio 2:");
		lblPrecio_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrecio_1.setBounds(226, 13, 99, 16);
		frmMenuPrincipal.getContentPane().add(lblPrecio_1);
		
		textField = new JTextField();
		textField.setBounds(81, 10, 116, 22);
		frmMenuPrincipal.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(295, 10, 116, 22);
		frmMenuPrincipal.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblListadoDeExcursiones = new JLabel("Listado de Excursiones en el rango de precios ingresados:");
		lblListadoDeExcursiones.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblListadoDeExcursiones.setBounds(12, 57, 392, 16);
		frmMenuPrincipal.getContentPane().add(lblListadoDeExcursiones);
		
		JList list = new JList();
		list.setBounds(22, 86, 598, 37);
		frmMenuPrincipal.getContentPane().add(list);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setForeground(new Color(0, 0, 128));
		btnListar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnListar.setBounds(22, 169, 97, 25);
		frmMenuPrincipal.getContentPane().add(btnListar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancelar.setForeground(new Color(0, 0, 128));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelar.setBounds(523, 169, 97, 25);
		frmMenuPrincipal.getContentPane().add(btnCancelar);
	}
}
