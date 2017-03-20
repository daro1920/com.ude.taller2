package gui.desktop.vista;

import gui.desktop.control.ControladorListarExcursionesEntrePrecios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import logica.valueobjects.VOExcursionSalida;

public class ListarExcursionesEntrePrecios {
	
	private ControladorListarExcursionesEntrePrecios controlador;
	private boolean inicioFallido;

	private JFrame frame;
	private JTable tableExcursiones;
	private JSpinner spinnerPrecioMinimo;
	private JSpinner spinnerPrecioMaximo;

	/**
	 * Create the application.
	 */
	public ListarExcursionesEntrePrecios() {
		initialize();
		
		inicioFallido = false;
		this.controlador = new ControladorListarExcursionesEntrePrecios(this);
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
		frame.setTitle("Listar Excursiones entre Precios");
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPrecioMinimo = new JLabel("Precio M\u00EDnimo");
		lblPrecioMinimo.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecioMinimo.setBounds(12, 13, 97, 16);
		frame.getContentPane().add(lblPrecioMinimo);
		
		JLabel lblPrecioMaximo = new JLabel("Precio M\u00E1ximo");
		lblPrecioMaximo.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecioMaximo.setBounds(286, 13, 97, 16);
		frame.getContentPane().add(lblPrecioMaximo);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConsultarActionPerformed(e);
			}
		});
		btnConsultar.setBounds(585, 9, 97, 25);
		frame.getContentPane().add(btnConsultar);
		
		spinnerPrecioMinimo = new JSpinner();
		spinnerPrecioMinimo.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		spinnerPrecioMinimo.setBounds(121, 10, 99, 22);
		frame.getContentPane().add(spinnerPrecioMinimo);
		
		spinnerPrecioMaximo = new JSpinner();
		spinnerPrecioMaximo.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		spinnerPrecioMaximo.setBounds(395, 10, 99, 22);
		frame.getContentPane().add(spinnerPrecioMaximo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 42, 670, 410);
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

	private void btnConsultarActionPerformed(ActionEvent e) {
		refrescarTablaExcursiones();
	}
	
    // #########################################################################
    // # METODOS AUXILIARES                                                    #
    // #########################################################################
	
	@SuppressWarnings("serial")
	private void refrescarTablaExcursiones() {
		double precioMinDbl = (Double) spinnerPrecioMinimo.getValue();
		double precioMaxDbl = (Double) spinnerPrecioMaximo.getValue();
		BigDecimal precioMin = BigDecimal.valueOf(precioMinDbl);
		BigDecimal precioMax = BigDecimal.valueOf(precioMaxDbl);
		List<VOExcursionSalida> excursiones = controlador.listadoExcursionesEntre(precioMin, precioMax);
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
