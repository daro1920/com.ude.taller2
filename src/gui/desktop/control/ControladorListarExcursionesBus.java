package gui.desktop.control;

import gui.desktop.vista.ListarExcursionesBus;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import logica.excepciones.BusInexistenteException;
import logica.excepciones.ConfiguracionException;
import logica.negocio.IFachada;
import logica.valueobjects.VOExcursionSalida;

public class ControladorListarExcursionesBus {
	
	private ListarExcursionesBus ventana;
	private IFachada fachada;
	
	public ControladorListarExcursionesBus(ListarExcursionesBus ventana) {
		this.ventana = ventana;
		try {
			fachada = FachadaWraper.getInstance().getFachada();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			ventana.actuarAnteErrorConexionInicial();
		} catch (ConfiguracionException e) {
			ventana.actuarAnteErrorConfiguracionInicial();
		}
	}
	
	public List<VOExcursionSalida> listadoExcursionesBus(String matricula) {
		try {
			return fachada.listarExcursionesBus(matricula);
		} catch (RemoteException e) {
			ventana.actuarAnteErrorConexionMetodo();
			return new ArrayList<VOExcursionSalida>();
		} catch (BusInexistenteException e) {
			ventana.actuarAnteErrorBusInexistente();
			return new ArrayList<VOExcursionSalida>();
		}
	}

}
