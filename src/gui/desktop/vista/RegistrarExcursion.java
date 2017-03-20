package gui.desktop.vista;

import gui.desktop.control.ControladorRegistrarExcursion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class RegistrarExcursion {
	
	private ControladorRegistrarExcursion controlador;
	private boolean inicioFallido;
	private SimpleDateFormat formatoFechaHora;

	private JFrame frame;
	private JTextField textFieldCodigo;
	private JTextField textFieldDestino;
	private JFormattedTextField formattedTextFieldPartida;
	private JFormattedTextField formattedTextFieldRegreso;
	private JSpinner spinnerPrecioBase;

	/**
	 * Create the application.
	 */
	public RegistrarExcursion() {
		formatoFechaHora = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		initialize();
		
		inicioFallido = false;
		this.controlador = new ControladorRegistrarExcursion(this);
	}
	
    // #########################################################################
    // # METODOS PUBLICOS                                                      #
    // #########################################################################

	public void notificarRegistroExitoso() {
		JOptionPane.showMessageDialog(frame,
            "Excursion registrada con exito.",
            "Registro exitoso",
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

	public void actuarAnteErrorYaExisteExcursion() {
		JOptionPane.showMessageDialog(frame,
                "Ya existe una excursion con el mismo código.",
                "Excursión ya existente",
                JOptionPane.ERROR_MESSAGE);
	}

	public void actuarAnteErrorNoHayBusesDisponibles() {
		JOptionPane.showMessageDialog(frame,
                "No hay buses disponibles para el período indicado.",
                "Sin buses disponibles",
                JOptionPane.ERROR_MESSAGE);
	}

	public void actuarAnteErrorPeriodoInvalido() {
		JOptionPane.showMessageDialog(frame,
                "El período indicado es inválido.",
                "Período inválido",
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
		frame.setTitle("Registrar Excursi\u00F3n");
		frame.setBounds(100, 100, 415, 270);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo *");
		lblCdigo.setBounds(12, 13, 51, 16);
		frame.getContentPane().add(lblCdigo);
		
		JLabel lblDestino = new JLabel("Destino *");
		lblDestino.setBounds(12, 42, 59, 16);
		frame.getContentPane().add(lblDestino);
		
		JLabel lblPartida = new JLabel("Partida * (dd/MM/yyyy hh:mm)");
		lblPartida.setBounds(12, 71, 179, 16);
		frame.getContentPane().add(lblPartida);
		
		JLabel lblPrecioBase = new JLabel("Precio Base *");
		lblPrecioBase.setBounds(12, 129, 91, 16);
		frame.getContentPane().add(lblPrecioBase);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setBounds(210, 10, 175, 22);
		frame.getContentPane().add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		JList list = new JList();
		list.setBounds(115, 191, 116, -14);
		frame.getContentPane().add(list);
		
		spinnerPrecioBase = new JSpinner();
		spinnerPrecioBase.setModel(new SpinnerNumberModel(new Double(1), new Double(1), null, new Double(1)));
		spinnerPrecioBase.setBounds(210, 126, 175, 22);
		frame.getContentPane().add(spinnerPrecioBase);
		
		textFieldDestino = new JTextField();
		textFieldDestino.setBounds(210, 39, 175, 22);
		frame.getContentPane().add(textFieldDestino);
		textFieldDestino.setColumns(10);
		
		JLabel lblRegresoddmmyyyy = new JLabel("Regreso * (dd/MM/yyyy hh:mm)");
		lblRegresoddmmyyyy.setBounds(12, 100, 186, 16);
		frame.getContentPane().add(lblRegresoddmmyyyy);
		
		formattedTextFieldPartida = new JFormattedTextField(formatoFechaHora);
		formattedTextFieldPartida.setBounds(210, 68, 175, 22);
		frame.getContentPane().add(formattedTextFieldPartida);
		
		formattedTextFieldRegreso = new JFormattedTextField(formatoFechaHora);
		formattedTextFieldRegreso.setBounds(210, 97, 175, 22);
		frame.getContentPane().add(formattedTextFieldRegreso);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRegistrarActionPerformed(e);
			}
		});
		btnRegistrar.setBounds(12, 184, 97, 25);
		frame.getContentPane().add(btnRegistrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelarActionPerformed(e);
			}
		});
		btnCancelar.setBounds(288, 184, 97, 25);
		frame.getContentPane().add(btnCancelar);
		
		JLabel labelCamposObligatorios = new JLabel("(*) Campos obligatorios");
		labelCamposObligatorios.setBounds(12, 158, 308, 16);
		frame.getContentPane().add(labelCamposObligatorios);
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

	private void btnRegistrarActionPerformed(ActionEvent e) {
		if(camposObligatoriosCompletados()) {
			boolean formatoFechasCorrecto = true;
			String partidaTxt = formattedTextFieldPartida.getText();
			String regresoTxt = formattedTextFieldRegreso.getText();
			Date partida = null;
			Date regreso = null;
			try {
				partida = formatoFechaHora.parse(partidaTxt);
				regreso = formatoFechaHora.parse(regresoTxt);
			} catch (ParseException e1) {
				formatoFechasCorrecto = false;
			}
			
			if (formatoFechasCorrecto) {
				String codigo = textFieldCodigo.getText();
				String destino = textFieldDestino.getText();
				double precioBaseDbl = (Double) spinnerPrecioBase.getValue();
				BigDecimal precioBase = BigDecimal.valueOf(precioBaseDbl);
				controlador.registrarExcursion(codigo, destino, partida, regreso, precioBase);
			} else {
				JOptionPane.showMessageDialog(frame,
	                    "Al menos una de las fechas no tienen el formato correcto.",
	                    "Formato fecha incorrecto",
	                    JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(frame,
                    "Los campos marcados con asterisco (*) son obligatorios.",
                    "Faltan campos obligatorios",
                    JOptionPane.ERROR_MESSAGE);
		}
	}

	private void btnCancelarActionPerformed(ActionEvent e) {
    	frame.dispose();
	}
	
    // #########################################################################
    // # METODOS AUXILIARES                                                    #
    // #########################################################################
	
    private boolean camposObligatoriosCompletados() {
		boolean codigoCompletado = !textFieldCodigo.getText().trim().isEmpty();
		boolean destinoCompletado = !textFieldDestino.getText().trim().isEmpty();
		boolean partidaCompletada = !formattedTextFieldPartida.getText().trim().isEmpty();
		boolean regresoCompletado = !formattedTextFieldRegreso.getText().trim().isEmpty();
		// No es posible dejar vacio el spinner, por lo que no se verifica
		return codigoCompletado
				&& destinoCompletado
				&& partidaCompletada
				&& regresoCompletado;
	}
}
