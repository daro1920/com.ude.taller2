package gui.desktop.control;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import gui.desktop.vista.RecuperarDatos;
import logica.excepciones.ConfiguracionException;
import logica.excepciones.PersistenciaException;
import logica.negocio.IFachada;

public class ControladorRecuperarDatos {

	private RecuperarDatos ventana;
	private IFachada fachada;
	
	public ControladorRecuperarDatos(RecuperarDatos ventana) {
		this.ventana = ventana;
		try {
			fachada = FachadaWraper.getInstance().getFachada();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			ventana.actuarAnteErrorConexion();
		} catch (ConfiguracionException e) {
			ventana.actuarAnteErrorConfiguracion();
		}
	}
	
	public void recuperarDatos() {
		try {
			fachada.recuperar();
		} catch (RemoteException e) {
			ventana.actuarAnteErrorConexion();
		} catch (PersistenciaException e) {
			ventana.actuarAnteErrorPersistencia();
		} catch (ConfiguracionException e) {
			ventana.actuarAnteErrorConfiguracion();
		}
	}
	
}
