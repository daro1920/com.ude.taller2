package gui.desktop.control;

import gui.desktop.vista.RegistrarBus;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import logica.excepciones.CapacidadInsuficienteException;
import logica.excepciones.ConfiguracionException;
import logica.excepciones.YaExisteBusException;
import logica.negocio.IFachada;
import logica.valueobjects.VOBusEntrada;

public class ControladorRegistrarBus {
	
	private RegistrarBus ventana;
	private IFachada fachada;
	
	public ControladorRegistrarBus(RegistrarBus ventana) {
		this.ventana = ventana;
		try {
			fachada = FachadaWraper.getInstance().getFachada();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			ventana.actuarAnteErrorConexion();
		} catch (ConfiguracionException e) {
			ventana.actuarAnteErrorConfiguracion();
		}
	}
	
	public void registrarBus(String matricula, String marca, int capacidad) {

		VOBusEntrada voBus = new VOBusEntrada(matricula, marca, capacidad);
		
		try {
			fachada.registrarBus(voBus);
		} catch (CapacidadInsuficienteException e) {
			ventana.actuarAnteCapacidadInsuficiente();
		} catch (YaExisteBusException e) {
			ventana.actuarAnteBusYaExistente();
		} catch (RemoteException e) {
			ventana.actuarAnteErrorConexion();
		}
	}

}
