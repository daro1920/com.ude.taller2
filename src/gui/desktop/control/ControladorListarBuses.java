package gui.desktop.control;

import gui.desktop.vista.ListarBuses;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import logica.excepciones.ConfiguracionException;
import logica.negocio.IFachada;
import logica.valueobjects.VOBusSalida;

public class ControladorListarBuses {

	private ListarBuses ventana;
	private IFachada fachada;
	
	public ControladorListarBuses(ListarBuses ventana) {
		this.ventana = ventana;
		try {
			fachada = FachadaWraper.getInstance().getFachada();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			ventana.actuarAnteErrorConexionInicial();
		} catch (ConfiguracionException e) {
			ventana.actuarAnteErrorConfiguracionInicial();
		}
	}
	
	public List<VOBusSalida> listadoBuses() {
		try {
			return fachada.listarBuses();
		} catch (RemoteException e) {
			ventana.actuarAnteErrorConexionMetodo();
			return new ArrayList<VOBusSalida>();
		}
	}
	
	
}
