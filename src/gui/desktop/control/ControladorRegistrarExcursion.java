package gui.desktop.control;

import gui.desktop.vista.RegistrarExcursion;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;

import logica.excepciones.ConfiguracionException;
import logica.excepciones.NoHayBusesDisponiblesException;
import logica.excepciones.PeriodoInvalidoException;
import logica.excepciones.YaExisteExcursionException;
import logica.negocio.IFachada;
import logica.valueobjects.VOExcursionEntrada;

public class ControladorRegistrarExcursion {
	
	private RegistrarExcursion ventana;
	private IFachada fachada;
	
	public ControladorRegistrarExcursion(RegistrarExcursion ventana) {
		this.ventana = ventana;
		try {
			fachada = FachadaWraper.getInstance().getFachada();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			ventana.actuarAnteErrorConexionInicial();
		} catch (ConfiguracionException e) {
			ventana.actuarAnteErrorConfiguracionInicial();
		}
	}
	
	public void registrarExcursion(String codigo, String destino, Date fechaHoraPartida,
			Date fechaHoraRegreso, BigDecimal precioBase) {
		
		VOExcursionEntrada voExcursion = new VOExcursionEntrada(codigo, destino,
				fechaHoraPartida, fechaHoraRegreso, precioBase);
		
		try {
			fachada.registrarExcursion(voExcursion);
			ventana.notificarRegistroExitoso();
		} catch (RemoteException e) {
			ventana.actuarAnteErrorConexionMetodo();
		} catch (YaExisteExcursionException e) {
			ventana.actuarAnteErrorYaExisteExcursion();
		} catch (NoHayBusesDisponiblesException e) {
			ventana.actuarAnteErrorNoHayBusesDisponibles();
		} catch (PeriodoInvalidoException e) {
			ventana.actuarAnteErrorPeriodoInvalido();
		}
		
	}
	
}
