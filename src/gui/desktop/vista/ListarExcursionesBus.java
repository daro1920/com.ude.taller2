package gui.desktop.vista;

import gui.desktop.control.ControladorListarExcursionesBus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import logica.valueobjects.VOExcursionSalida;

public class ListarExcursionesBus {
	
	private String matricula;
	
	private ControladorListarExcursionesBus controlador;
	private boolean inicioFallido;

	private JFrame frame;
	private JTable tableExcursiones;

	/**
	 * Create the application.
	 */
	@SuppressWarnings("unused")
	private ListarExcursionesBus() {
	}
	
	/**
	 * @wbp.parser.constructor
	 */
	public ListarExcursionesBus(String matricula) {
		initialize();
		
		this.matricula = matricula;
		
		inicioFallido = false;
		this.controlador = new ControladorListarExcursionesBus(this);
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

	public void actuarAnteErrorBusInexistente() {
		JOptionPane.showMessageDialog(frame,
                "No existe Bus",
                "Bus inexistente",
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
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnRefrescar = new JButton("Refrescar");
		btnRefrescar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRefrescarActionPerformed(e);
			}
		});
		btnRefrescar.setBounds(572, 13, 110, 25);
		frame.getContentPane().add(btnRefrescar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelarActionPerformed(e);
			}
		});
		btnCancelar.setBounds(572, 427, 110, 25);
		frame.getContentPane().add(btnCancelar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 548, 439);
		frame.getContentPane().add(scrollPane);
		
		tableExcursiones = new JTable();
		scrollPane.setViewportView(tableExcursiones);
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

	private void btnRefrescarActionPerformed(ActionEvent e) {
		refrescarTablaExcursiones();
	}

	private void btnCancelarActionPerformed(ActionEvent e) {
    	frame.dispose();
	}
	
    // #########################################################################
    // # METODOS AUXILIARES                                                    #
    // #########################################################################
	
	@SuppressWarnings("serial")
	private void refrescarTablaExcursiones() {
		List<VOExcursionSalida> excursiones = controlador.listadoExcursionesBus(matricula);
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
