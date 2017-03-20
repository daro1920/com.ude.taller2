package gui.desktop.vista;

import gui.desktop.control.ControladorListarExcursionesHacia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import logica.valueobjects.VOExcursionSalida;

public class ListarExcursionesHacia {
	
	private ControladorListarExcursionesHacia controlador;
	boolean inicioFallido;

	private JFrame frame;
	private JTextField textFieldDestino;
	private JTable tableExcursiones;

	/**
	 * Create the application.
	 */
	public ListarExcursionesHacia() {
		initialize();
		
		inicioFallido = false;
		this.controlador = new ControladorListarExcursionesHacia(this);
		if (!inicioFallido) {
			refrescarTablaExcursiones();
		}
	}
	
    // #########################################################################
    // # METODOS PUBLICOS                                                      #
    // #########################################################################

	public void actuarAnteErrorConexionInicial() {
		inicioFallido = true;
		JOptionPane.showMessageDialog(frame,
                "No fue posible conectarse al servidor.",
                "Error de conexión",
                JOptionPane.ERROR_MESSAGE);
	}

	public void actuarAnteErrorConfiguracionInicial() {
		inicioFallido = true;
		JOptionPane.showMessageDialog(frame,
                "No fue posible cargar la configuración.",
                "Error de configuración",
                JOptionPane.ERROR_MESSAGE);
	}

	public void actuarAnteErrorConexionMetodo() {
		JOptionPane.showMessageDialog(frame,
                "No fue posible conectarse al servidor.\n"
                + "Intentelo más tarde",
                "Error de conexión",
                JOptionPane.ERROR_MESSAGE);
	}

	// #########################################################################
    // # INITIALIZE Y SET VISIBLE                                              #
    // #########################################################################

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Listado de Excursiones hacia Destino");
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDestino = new JLabel("Destino");
		lblDestino.setBounds(12, 13, 56, 16);
		frame.getContentPane().add(lblDestino);
		
		textFieldDestino = new JTextField();
		textFieldDestino.setBounds(80, 10, 493, 22);
		frame.getContentPane().add(textFieldDestino);
		textFieldDestino.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 42, 670, 410);
		frame.getContentPane().add(scrollPane);
		
		tableExcursiones = new JTable();
		scrollPane.setViewportView(tableExcursiones);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConsultarActionPerformed(e);
			}
		});
		btnConsultar.setBounds(585, 9, 97, 25);
		frame.getContentPane().add(btnConsultar);
	}

	/* Indico si deseo que la ventana sea visible o no */
	public void setVisible (boolean visible) {
		if (inicioFallido) {
			frame.dispose();
		} else {
			frame.setVisible(visible);
		}
	}
	
	// #########################################################################
    // # EVENT HANDLERS                                                        #
    // #########################################################################

	private void btnConsultarActionPerformed(ActionEvent e) {
		refrescarTablaExcursiones();
	}
	
    // #########################################################################
    // # METODOS AUXILIARES                                                    #
    // #########################################################################
	
	@SuppressWarnings("serial")
	private void refrescarTablaExcursiones() {
		String destino = textFieldDestino.getText();
		List<VOExcursionSalida> excursiones = controlador.listadoExcursionesHacia(destino);
		String[] encabezados = {"Código", "Destino", "Partida", "Regreso", "Precio base", "Asientos Disp."};
		String[][] datos = new String[excursiones.size()][];
		int index = 0;
		SimpleDateFormat formatoFechaHora = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String fechaHoraPartida;
		String fechaHoraRegreso;
		
		for (VOExcursionSalida excursion : excursiones) { 
			fechaHoraPartida = formatoFechaHora.format(excursion.getFechaHoraPartida());
			fechaHoraRegreso = formatoFechaHora.format(excursion.getFechaHoraRegreso());
			datos[index] = new String[]{excursion.getCodigo(), excursion.getDestino(),
					fechaHoraPartida, fechaHoraRegreso, excursion.getPrecioBase().toPlainString(),
					excursion.getAsientosDisponibles() + ""};
			
			index ++;
		}
		
		tableExcursiones.setModel(new DefaultTableModel(datos, encabezados) {
            // Evita que se puedan editar las celdas.
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
		
	}

}
