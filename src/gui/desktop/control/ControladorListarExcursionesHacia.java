package gui.desktop.control;

import gui.desktop.vista.ListarExcursionesHacia;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import logica.excepciones.ConfiguracionException;
import logica.negocio.IFachada;
import logica.valueobjects.VOExcursionSalida;

public class ControladorListarExcursionesHacia {
	
	private ListarExcursionesHacia ventana;
	private IFachada fachada;
	
	public ControladorListarExcursionesHacia(ListarExcursionesHacia ventana) {
		this.ventana = ventana;
		try {
			fachada = FachadaWraper.getInstance().getFachada();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			ventana.actuarAnteErrorConexionInicial();
		} catch (ConfiguracionException e) {
			ventana.actuarAnteErrorConfiguracionInicial();
		}
	}
	
	public List<VOExcursionSalida> listadoExcursionesHacia(String destino) {
		try {
			return fachada.listarExcursionesHacia(destino);
		} catch (RemoteException e) {
			ventana.actuarAnteErrorConexionMetodo();
			return new ArrayList<VOExcursionSalida>();
		}
	}

}
