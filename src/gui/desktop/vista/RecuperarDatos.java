package gui.desktop.vista;

import gui.desktop.control.ControladorRecuperarDatos;
import gui.desktop.control.ControladorRespaldarDatos;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class RecuperarDatos {
	
	private ControladorRecuperarDatos controlador;
	private boolean inicioFallido;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RespaldarDatos window = new RespaldarDatos();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public RecuperarDatos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Respaldar Datos");
		frame.setBounds(100, 100, 450, 134);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnRespaldarDatos = new JButton("Recuperar Datos");
		btnRespaldarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRespaldarActionPerformed(e);
			}
		});
		btnRespaldarDatos.setForeground(new Color(0, 0, 128));
		btnRespaldarDatos.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRespaldarDatos.setBounds(12, 45, 167, 25);
		frame.getContentPane().add(btnRespaldarDatos);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelarActionPerformed(e);
			}
		});
		btnCancelar.setForeground(new Color(0, 0, 128));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelar.setBounds(237, 45, 167, 25);
		frame.getContentPane().add(btnCancelar);
	}
	
	private void btnRespaldarActionPerformed(ActionEvent e) {
		controlador.recuperarDatos();
	}

	private void btnCancelarActionPerformed(ActionEvent e) {
    	frame.dispose();
	}

	/* Indico si deseo que la ventana sea visible o no */
	public void setVisible (boolean visible) {
		if (inicioFallido) {
			frame.dispose();
		} else {
			frame.setVisible(visible);
		}
	}
	
	public void notificarRegistroExitoso() {
		JOptionPane.showMessageDialog(frame,
            "Se ha recuperado con exito.",
            "Recuperacion exitosa",
            JOptionPane.INFORMATION_MESSAGE);
	}

	public void actuarAnteErrorConexionInicial() {
		inicioFallido = true;
		JOptionPane.showMessageDialog(frame,
                "No fue posible conectarse al servidor.",
                "Error de conexión",
                JOptionPane.ERROR_MESSAGE);
	}

	public void actuarAnteErrorConfiguracion() {
		inicioFallido = true;
		JOptionPane.showMessageDialog(frame,
                "No fue posible cargar la configuración.",
                "Error de configuración",
                JOptionPane.ERROR_MESSAGE);
	}

	public void actuarAnteErrorPersistencia() {
		inicioFallido = true;
		JOptionPane.showMessageDialog(frame,
                "Hubo un error al recuperar.",
                "Error en la lectura",
                JOptionPane.ERROR_MESSAGE);
	}
	
	public void actuarAnteErrorConexionMetodo() {
		JOptionPane.showMessageDialog(frame,
                "No fue posible conectarse al servidor.\n"
                + "Intentelo más tarde",
                "Error de conexión",
                JOptionPane.ERROR_MESSAGE);
	}

}
