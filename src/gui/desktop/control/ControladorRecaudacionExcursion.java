package gui.desktop.control;

import gui.desktop.excepciones.AccionNoConcretadaException;
import gui.desktop.vista.RecaudacionExcursion;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import logica.excepciones.ConfiguracionException;
import logica.excepciones.NoExisteExcursionException;
import logica.negocio.IFachada;

public class ControladorRecaudacionExcursion {
	
	private RecaudacionExcursion ventana;
	private IFachada fachada;
	
	public ControladorRecaudacionExcursion(RecaudacionExcursion ventana) {
		this.ventana = ventana;
		try {
			fachada = FachadaWraper.getInstance().getFachada();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			ventana.actuarAnteErrorConexion();
		} catch (ConfiguracionException e) {
			ventana.actuarAnteErrorConfiguracion();
		}
	}
	
	public BigDecimal recaudacionExcursion(String codigo) throws AccionNoConcretadaException {
		try {
			return fachada.recaudacionExcursion(codigo);
		} catch (RemoteException e) {
			ventana.actuarAnteErrorConexion();
			throw new AccionNoConcretadaException("No se pudo concretar la accion");
		} catch (NoExisteExcursionException e) {
			ventana.actuarAnteErrorNoExisteExcursion();
			throw new AccionNoConcretadaException("No se pudo concretar la accion");
		}
	}

}
