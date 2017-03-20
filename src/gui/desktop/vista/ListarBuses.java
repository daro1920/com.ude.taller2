package gui.desktop.vista;

import gui.desktop.control.ControladorListarBuses;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import logica.valueobjects.VOBusSalida;

public class ListarBuses {
	
	private ControladorListarBuses controlador;
	private boolean inicioFallido;

	private JFrame 		frame;
	private JButton 	btnRefrescar;
	private JButton 	btnCancelar;
	private JButton 	btnListarExcursiones;
	private JScrollPane scrollPaneBuses;
	private JTable 		tableBuses;

	/**
	 * Create the application.
	 */
	public ListarBuses() {
		initialize();
		inicioFallido = false;
		this.controlador = new ControladorListarBuses(this);
		if (!inicioFallido) {
			refrescarTablaBuses();
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
		frame.setTitle("Buses");
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnRefrescar = new JButton("Refrescar");
		btnRefrescar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRefrescarActionPerformed(e);
			}
		});
		btnRefrescar.setBounds(503, 13, 167, 25);
		frame.getContentPane().add(btnRefrescar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelarActionPerformed(e);
			}
		});
		btnCancelar.setBounds(503, 415, 167, 25);
		frame.getContentPane().add(btnCancelar);
		
		btnListarExcursiones = new JButton("Listar Excursiones ");
		btnListarExcursiones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnListarExcursionesActionPerformed(e);
			}
		});
		btnListarExcursiones.setBounds(503, 51, 167, 25);
		frame.getContentPane().add(btnListarExcursiones);
		
		scrollPaneBuses = new JScrollPane();
		scrollPaneBuses.setBounds(12, 13, 479, 427);
		frame.getContentPane().add(scrollPaneBuses);
		
		tableBuses = new JTable();
		scrollPaneBuses.setViewportView(tableBuses);
		tableBuses.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
		refrescarTablaBuses();
	}

	private void btnListarExcursionesActionPerformed(ActionEvent e) {
		if (hayBusSeleccionado()) {
			String matricula = obtenerMatriculaBusSeleccionado();
			
			ListarExcursionesBus ventana = new ListarExcursionesBus(matricula);
			ventana.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(frame,
					"Debe seleccionar un Bus.",
	                "No hay buses seleccionados",
	                JOptionPane.ERROR_MESSAGE);
		}
		
	}

	private void btnCancelarActionPerformed(ActionEvent e) {
    	frame.dispose();
	}
	
    // #########################################################################
    // # METODOS AUXILIARES                                                    #
    // #########################################################################
	
	@SuppressWarnings("serial")
	private void refrescarTablaBuses() {
		List<VOBusSalida> buses = controlador.listadoBuses();
		String[] encabezados = {"Matrícula", "Marca", "Capacidad", "Cant. Excursiones"};
		String[][] datos = new String[buses.size()][];
		int index = 0;
		
		for (VOBusSalida bus : buses) {
			datos[index] = new String[]{bus.getMatricula(), bus.getMarca(),
					bus.getCapacidad() + "", bus.getCantidadExcursiones() + ""};
			
			index ++;
		}
		
		tableBuses.setModel(new DefaultTableModel(datos, encabezados) {
            // Evita que se puedan editar las celdas.
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
		
	}

	private boolean hayBusSeleccionado() {
		return tableBuses.getSelectedRow() != -1;
	}

	private String obtenerMatriculaBusSeleccionado() {
		String matricula = null;
		int index = tableBuses.getSelectedRow();
		
		if (index != -1) {
			matricula = (String)tableBuses.getModel().getValueAt(index, 0);
		}
		
		return matricula;
	}
}
