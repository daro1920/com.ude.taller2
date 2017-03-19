package gui.desktop.control;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import gui.desktop.vista.RespaldarDatos;
import logica.excepciones.ConfiguracionException;
import logica.excepciones.PersistenciaException;
import logica.negocio.IFachada;

public class ControladorRespaldarDatos {
	
	private RespaldarDatos ventana;
	private IFachada fachada;
	
	public ControladorRespaldarDatos(RespaldarDatos ventana) {
		this.ventana = ventana;
		try {
			fachada = FachadaWraper.getInstance().getFachada();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			ventana.actuarAnteErrorConexion();
		} catch (ConfiguracionException e) {
			ventana.actuarAnteErrorConfiguracion();
		}
	}
	
	public void respaldarDatos() {
		try {
			fachada.respaldar();
		} catch (RemoteException e) {
			ventana.actuarAnteErrorConexion();
		} catch (PersistenciaException e) {
			ventana.actuarAnteErrorPersistencia();
		} catch (ConfiguracionException e) {
			ventana.actuarAnteErrorConfiguracion();
		}
	}

}
