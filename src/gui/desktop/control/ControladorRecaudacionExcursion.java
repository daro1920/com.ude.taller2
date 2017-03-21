package gui.desktop.control;

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
			ventana.actuarAnteErrorConexionInicial();
		} catch (ConfiguracionException e) {
			ventana.actuarAnteErrorConfiguracionInicial();
		}
	}
	
	public BigDecimal recaudacionExcursion(String codigo) {
		try {
			return fachada.recaudacionExcursion(codigo);
		} catch (RemoteException e) {
			ventana.actuarAnteErrorConexionMetodo();
			return BigDecimal.ZERO;
		} catch (NoExisteExcursionException e) {
			ventana.actuarAnteErrorNoExisteExcursion();
			return BigDecimal.ZERO;
		}
	}

}
