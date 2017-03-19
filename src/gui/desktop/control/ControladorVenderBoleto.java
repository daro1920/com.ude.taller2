package gui.desktop.control;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import gui.desktop.vista.VenderBoleto;
import logica.excepciones.ConfiguracionException;
import logica.negocio.IFachada;

public class ControladorVenderBoleto {
	
	private VenderBoleto ventana;
	private IFachada fachada;
	
	public ControladorVenderBoleto(VenderBoleto ventana) {
		this.ventana = ventana;
		try {
			fachada = FachadaWraper.getInstance().getFachada();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			ventana.actuarAnteErrorConexion();
		} catch (ConfiguracionException e) {
			ventana.actuarAnteErrorConfiguracion();
		}
	}
	
	public void venderBoleto() {
		// TODO Falta implementar
		throw new UnsupportedOperationException("No implementado, aun");
	}

}
