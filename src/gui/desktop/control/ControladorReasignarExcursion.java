package gui.desktop.control;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import gui.desktop.vista.ReasignarExcursion;
import logica.excepciones.ConfiguracionException;
import logica.excepciones.NoExisteExcursionException;
import logica.excepciones.NoHayBusesDisponiblesException;
import logica.negocio.IFachada;

public class ControladorReasignarExcursion {
	
	private ReasignarExcursion ventana;
	private IFachada fachada;
	
	public ControladorReasignarExcursion(ReasignarExcursion ventana) {
		this.ventana = ventana;
		try {
			fachada = FachadaWraper.getInstance().getFachada();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			ventana.actuarAnteErrorConexionInicial();
		} catch (ConfiguracionException e) {
			ventana.actuarAnteErrorConfiguracionInicial();
		}
	}
	
	public void reasignarExcursion(String codigo) {
		try {
			fachada.reasignarExcursion(codigo);
			ventana.notificarReasignacionExitosa();
		} catch (RemoteException e) {
			ventana.actuarAnteErrorConexionMetodo();
		} catch (NoExisteExcursionException e) {
			ventana.actuarAnteErrorNoExisteExcursion();
		} catch (NoHayBusesDisponiblesException e) {
			ventana.actuarAnteErrorNoHayBusesDisponibles();
		}
	}

}
