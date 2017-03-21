package gui.desktop.vista;

import gui.desktop.control.ControladorListarBoletosExcursion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import logica.negocio.TipoBoleto;
import logica.valueobjects.VOBoletoEspecialSalida;
import logica.valueobjects.VOBoletoSalida;

public class ListarBoletosExcursion {
	
	private ControladorListarBoletosExcursion controlador;
	private boolean inicioFallido;

	private JFrame frame;
	private JTextField textFieldCodigoExcursion;
	private final ButtonGroup buttonGroupTipoBoleto = new ButtonGroup();
	private JTable tableBoletos;
	JRadioButton rdbtnComn;
	JRadioButton rdbtnEspecial;

	/**
	 * Create the application.
	 */
	public ListarBoletosExcursion() {
		initialize();
		inicioFallido = false;
		controlador = new ControladorListarBoletosExcursion(this);
	}
	
    // #########################################################################
    // # METODOS PUBLICOS                                                      #
    // #########################################################################

	public void notificarReasignacionExitosa() {
		JOptionPane.showMessageDialog(frame,
	            "Excursión reasignada con éxito.",
	            "Reasignación exitosa",
	            JOptionPane.INFORMATION_MESSAGE);
	}

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

	public void actuarAnteErrorNoExisteExcursion() {
		JOptionPane.showMessageDialog(frame,
                "No existe una excursión con el código dado.",
                "Excursión inexistente",
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
		frame.setTitle("Boletos Vendidos Excursi\u00F3n");
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConsultarActionPerformed(e);
			}
		});
		btnConsultar.setBounds(497, 9, 185, 25);
		frame.getContentPane().add(btnConsultar);
		
		JLabel lblCodigoExcursion = new JLabel("C\u00F3digo Excursi\u00F3n");
		lblCodigoExcursion.setBounds(12, 13, 97, 16);
		frame.getContentPane().add(lblCodigoExcursion);
		
		textFieldCodigoExcursion = new JTextField();
		textFieldCodigoExcursion.setBounds(121, 10, 116, 22);
		frame.getContentPane().add(textFieldCodigoExcursion);
		textFieldCodigoExcursion.setColumns(10);
		
		rdbtnComn = new JRadioButton("Com\u00FAn");
		buttonGroupTipoBoleto.add(rdbtnComn);
		rdbtnComn.setBounds(326, 9, 69, 25);
		frame.getContentPane().add(rdbtnComn);
		
		rdbtnEspecial = new JRadioButton("Especial");
		buttonGroupTipoBoleto.add(rdbtnEspecial);
		rdbtnEspecial.setBounds(399, 9, 75, 25);
		frame.getContentPane().add(rdbtnEspecial);
		
		JLabel lblTipoBoleto = new JLabel("Tipo boleto:");
		lblTipoBoleto.setBounds(249, 13, 69, 16);
		frame.getContentPane().add(lblTipoBoleto);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 42, 670, 410);
		frame.getContentPane().add(scrollPane);
		
		tableBoletos = new JTable();
		scrollPane.setViewportView(tableBoletos);
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

	protected void btnConsultarActionPerformed(ActionEvent e) {
		String codigo = textFieldCodigoExcursion.getText();
		List<VOBoletoSalida> boletos;
		if (rdbtnComn.isSelected()) {
			boletos = controlador.listadoBoletosExcursion(codigo, TipoBoleto.COMUN);
			refrescarTablaBoletosComunes(boletos);
		} else {
			boletos = controlador.listadoBoletosExcursion(codigo, TipoBoleto.ESPECIAL);
			refrescarTablaBoletosEspeciales(boletos);
		}
	}
	
    // #########################################################################
    // # METODOS AUXILIARES                                                    #
    // #########################################################################
	
	@SuppressWarnings("serial")
	private void refrescarTablaBoletosComunes(List<VOBoletoSalida> boletos) {
		String[] encabezados = {"Número", "Edad", "Procedencia", "Celular"};
		String[][] datos = new String[boletos.size()][];
		int index = 0;
		
		for (VOBoletoSalida boleto : boletos) {
			datos[index] = new String[]{boleto.getNumero() + "", boleto.getEdad() + "",
					boleto.getProcedencia(), boleto.getCelular()};
			index ++;
		}
		
		tableBoletos.setModel(new DefaultTableModel(datos, encabezados) {
            // Evita que se puedan editar las celdas.
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
	}
	
	@SuppressWarnings("serial")
	private void refrescarTablaBoletosEspeciales(List<VOBoletoSalida> boletos) {
		String[] encabezados = {"Número", "Edad", "Procedencia", "Celular", "Descuento"};
		String[][] datos = new String[boletos.size()][];
		int index = 0;
		
		for (VOBoletoSalida boleto : boletos) {
			datos[index] = new String[]{boleto.getNumero() + "", boleto.getEdad() + "",
					boleto.getProcedencia(), boleto.getCelular(),
					((VOBoletoEspecialSalida)boleto).getDescuento().toPlainString()};
			index ++;
		}
		
		tableBoletos.setModel(new DefaultTableModel(datos, encabezados) {
            // Evita que se puedan editar las celdas.
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
	}
}
