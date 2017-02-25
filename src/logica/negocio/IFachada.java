package logica.negocio;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import logica.excepciones.BusInexistenteException;
import logica.excepciones.ConfiguracionException;
import logica.excepciones.NoExisteExcursionException;
import logica.excepciones.NoHayAsientosDisponiblesException;
import logica.excepciones.NoHayBusesDisponiblesException;
import logica.excepciones.PersistenciaException;
import logica.excepciones.YaExisteExcursionException;
import logica.valueobjects.VOBoletoEntrada;
import logica.valueobjects.VOBoletoSalida;
import logica.valueobjects.VOBusSalida;
import logica.valueobjects.VOExcursionEntrada;
import logica.valueobjects.VOExcursionSalida;

public interface IFachada extends Remote {

	public List<VOBusSalida> listarBuses() throws RemoteException;

	public List<VOExcursionSalida> listarExcursionesBus(String matricula)
			throws BusInexistenteException, RemoteException;

	public void registrarExcursion(VOExcursionEntrada voExcursion)
			throws YaExisteExcursionException, NoHayBusesDisponiblesException,
			RemoteException;

	public void reasignarExcursion(String codigo)
			throws NoExisteExcursionException, NoHayBusesDisponiblesException,
			RemoteException;

	public void respaldar() throws PersistenciaException, RemoteException, ConfiguracionException;

	public void recuperar() throws PersistenciaException, RemoteException, ConfiguracionException;

	public void venderBoleto(VOBoletoEntrada voBoleto)
			throws NoExisteExcursionException,
			NoHayAsientosDisponiblesException, RemoteException;

	public BigDecimal recaudacionExcursion(String codigo)
			throws NoExisteExcursionException, RemoteException;

	public List<VOBoletoSalida> listarBoletosExcursion(String codigo,
			TipoBoleto tipo) throws NoExisteExcursionException, RemoteException;

	public List<VOExcursionSalida> listarExcursionesHacia(String destino) throws RemoteException;

	public List<VOExcursionSalida> listarExcursionesEntrePrecios(
			BigDecimal precioMin, BigDecimal precioMax) throws RemoteException;

}