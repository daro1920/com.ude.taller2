package gui.desktop.control;

import gui.desktop.vista.ListarBoletosExcursion;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import logica.excepciones.ConfiguracionException;
import logica.excepciones.NoExisteExcursionException;
import logica.negocio.IFachada;
import logica.negocio.TipoBoleto;
import logica.valueobjects.VOBoletoSalida;

public class ControladorListarBoletosExcursion {
	
	private ListarBoletosExcursion ventana;
	private IFachada fachada;
	
	public ControladorListarBoletosExcursion(ListarBoletosExcursion ventana) {
		this.ventana = ventana;
		try {
			fachada = FachadaWraper.getInstance().getFachada();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			ventana.actuarAnteErrorConexionInicial();
		} catch (ConfiguracionException e) {
			ventana.actuarAnteErrorConfiguracionInicial();
		}
	}
	
	public List<VOBoletoSalida> listadoBoletosExcursion(String codigo, TipoBoleto tipo) {
		try {
			return fachada.listarBoletosExcursion(codigo, tipo);
		} catch (RemoteException e) {
			ventana.actuarAnteErrorConexionMetodo();
			return new ArrayList<VOBoletoSalida>();
		} catch (NoExisteExcursionException e) {
			ventana.actuarAnteErrorNoExisteExcursion();
			return new ArrayList<VOBoletoSalida>();
		}
	}

}
