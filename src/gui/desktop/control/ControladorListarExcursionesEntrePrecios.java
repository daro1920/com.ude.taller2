package gui.desktop.control;

import gui.desktop.vista.ListarExcursionesEntrePrecios;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import logica.excepciones.ConfiguracionException;
import logica.negocio.IFachada;
import logica.valueobjects.VOExcursionSalida;

public class ControladorListarExcursionesEntrePrecios {
	
	private ListarExcursionesEntrePrecios ventana;
	private IFachada fachada;
	
	public ControladorListarExcursionesEntrePrecios(
			ListarExcursionesEntrePrecios ventana) {
		this.ventana = ventana;
		try {
			fachada = FachadaWraper.getInstance().getFachada();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			ventana.actuarAnteErrorConexionInicial();
		} catch (ConfiguracionException e) {
			ventana.actuarAnteErrorConfiguracionInicial();
		}
	}
	
	public List<VOExcursionSalida> listadoExcursionesEntre(BigDecimal precioMin, BigDecimal precioMax) {
		try {
			return fachada.listarExcursionesEntrePrecios(precioMin, precioMax);
		} catch (RemoteException e) {
			ventana.actuarAnteErrorConexionMetodo();
			return new ArrayList<VOExcursionSalida>();
		}
	}

}
