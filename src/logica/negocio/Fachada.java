package logica.negocio;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import configuracion.Configuracion;
import logica.excepciones.BusInexistenteException;
import logica.excepciones.ConfiguracionException;
import logica.excepciones.NoExisteExcursionException;
import logica.excepciones.NoHayAsientosDisponiblesException;
import logica.excepciones.NoHayBusesDisponiblesException;
import logica.excepciones.PeriodoInvalidoException;
import logica.excepciones.PersistenciaException;
import logica.excepciones.YaExisteExcursionException;
import logica.valueobjects.VOBoletoEntrada;
import logica.valueobjects.VOBoletoSalida;
import logica.valueobjects.VOBusSalida;
import logica.valueobjects.VOExcursionEntrada;
import logica.valueobjects.VOExcursionSalida;
import logica.valueobjects.VOFachadaPersistencia;
import persistencia.Persistencia;

@SuppressWarnings("serial")
public class Fachada extends UnicastRemoteObject implements IFachada {

	private Buses buses;
	private Excursiones excursiones;
	private Monitor monitor;
	
	public Fachada() throws RemoteException {
		buses = new Buses();
		excursiones = new Excursiones();
		monitor = new Monitor();
	}
	
//	+ registrarBus(VOBusEntrada. TipoError &) : void
	
	@Override
	public List<VOBusSalida> listarBuses() throws RemoteException {
		monitor.comienzoLectura();
		
		List<VOBusSalida> busesSalida = buses.listarBuses();
		
		monitor.terminoLectura();
		
		return busesSalida;
	}

	@Override
	public List<VOExcursionSalida> listarExcursionesBus(String matricula) throws RemoteException, BusInexistenteException {
		
		monitor.comienzoLectura();
		
		if (!excursiones.contiene(matricula)) {
			monitor.terminoLectura();
			throw new BusInexistenteException("No existe bus");
		}
		
		Bus bus = buses.obtener(matricula);
		List<VOExcursionSalida> excursionesBus = bus.listarExcursionesAsignadas();
		
		monitor.terminoLectura();
		
		return excursionesBus;
	}
	
	@Override
	public void registrarExcursion(VOExcursionEntrada voExcursion)
			throws RemoteException, YaExisteExcursionException,
			NoHayBusesDisponiblesException, PeriodoInvalidoException {
		
		monitor.comienzoEscritura();
		
		Excursion excursion;
		Bus busDisponible;
		
		if (excursiones.contiene(voExcursion.getCodigo())) {
			monitor.terminoEscritura();
			throw new YaExisteExcursionException("Ya existe una excursion con el mismo codigo");
		}
		
		try {
			excursion = new Excursion(voExcursion);
		} catch (PeriodoInvalidoException e) {
			monitor.terminoEscritura();
			throw e;
		}
		
		busDisponible = buses.obtenerBusDisponible(excursion);

		if (busDisponible == null) {
			monitor.terminoEscritura();
			throw new NoHayBusesDisponiblesException("No hay buses disponibles");
		}
		excursion.setBus(busDisponible);
		excursiones.agregar(excursion);
		busDisponible.agregarExcursion(excursion);
		
		monitor.terminoEscritura();
		
	}

	@Override
	public void reasignarExcursion(String codigo) throws RemoteException, NoExisteExcursionException, NoHayBusesDisponiblesException {
		
		monitor.comienzoEscritura();
		
		if(!excursiones.contiene(codigo)) {
			monitor.terminoEscritura();
			throw new NoExisteExcursionException("No existe la excursion");
		}
		
		Excursion excursion = excursiones.obtener(codigo);
		Bus busDisponible = buses.obtenerOtroBusDisponible(excursion);
		
		if (busDisponible == null) {
			monitor.terminoEscritura();
			throw new NoHayBusesDisponiblesException("No hay otro bus disponible");
		}
		
		Bus busAnterior = excursion.getBus();
		busAnterior.borrarExcursion(excursion.getCodigo());
		excursion.setBus(busDisponible);
		busDisponible.agregarExcursion(excursion);
		
		monitor.terminoEscritura();
	}
	
	@Override
	public void respaldar() throws RemoteException, PersistenciaException, ConfiguracionException {

		VOFachadaPersistencia voFachada;
		String nombreArchivo = Configuracion.getProperty("archivorRespaldo");
		Persistencia persistencia = new Persistencia();
		
		monitor.comienzoLectura();
		
		voFachada = new VOFachadaPersistencia(buses, excursiones);
		
		try {
			persistencia.respaldar(nombreArchivo,voFachada);
		} catch (PersistenciaException e) {
			monitor.terminoLectura();
			throw e;
		}
		
		monitor.terminoLectura();
	}
	
	@Override
	public void recuperar() throws RemoteException, PersistenciaException, ConfiguracionException {
		
		VOFachadaPersistencia voFachada = obtenerArchivoRecuperacion();
		
		monitor.comienzoEscritura();
		
		buses = voFachada.getBuses();
		excursiones = voFachada.getExcursiones();
		
		monitor.terminoEscritura();
	}
	
	private VOFachadaPersistencia obtenerArchivoRecuperacion() throws PersistenciaException, ConfiguracionException {
		
		VOFachadaPersistencia voFachada;
		Persistencia persistencia = new Persistencia();
		String nombreArchivo = Configuracion.getProperty("archivoRespaldo");
		
		voFachada = persistencia.recuperar(nombreArchivo);
		
		return voFachada;
	}
	
	@Override
	public void venderBoleto(VOBoletoEntrada voBoleto) throws RemoteException, NoExisteExcursionException, NoHayAsientosDisponiblesException {
		
		monitor.comienzoEscritura();
		
		if(!excursiones.contiene(voBoleto.getCodigoExcursion())) {
			monitor.terminoEscritura();
			throw new NoExisteExcursionException("No existe la excursion");
		}
		
		Excursion excursion = excursiones.obtener(voBoleto.getCodigoExcursion());
		
		if (!excursion.hayAsientosDisponibles()) {
			monitor.terminoEscritura();
			throw new NoHayAsientosDisponiblesException("No hay asientos disponibles");
		}
		
		excursion.agregarBoleto(voBoleto);
		
		monitor.terminoEscritura();
		
	}

	@Override
	public BigDecimal recaudacionExcursion(String codigo) throws RemoteException, NoExisteExcursionException {
		
		monitor.comienzoLectura();
		
		if(!excursiones.contiene(codigo)) {
			monitor.terminoEscritura();
			throw new NoExisteExcursionException("No existe la excursion");
		}
		
		Excursion excursion = excursiones.obtener(codigo);
		BigDecimal recaudacion = excursion.recaudacion();
		
		monitor.terminoLectura();
		
		return recaudacion;
	}

	@Override
	public List<VOBoletoSalida> listarBoletosExcursion(String codigo, TipoBoleto tipo) throws RemoteException, NoExisteExcursionException {
		
		monitor.comienzoLectura();
		
		if(!excursiones.contiene(codigo)) {
			monitor.terminoEscritura();
			throw new NoExisteExcursionException("No existe la excursion");
		}
		
		Excursion excursion = excursiones.obtener(codigo);
		List<VOBoletoSalida> excursionesSalida = excursion.listarBoletos(tipo);
		
		monitor.terminoLectura();
		
		return excursionesSalida;
	}
	
	@Override
	public List<VOExcursionSalida> listarExcursionesHacia(String destino) throws RemoteException {
		
		monitor.comienzoLectura();
		
		List<VOExcursionSalida> excursionesSalida = excursiones.listarExcursionesHacia(destino);
		
		monitor.terminoLectura();
		
		return excursionesSalida;
	}
	
	@Override
	public List<VOExcursionSalida> listarExcursionesEntrePrecios(BigDecimal precioMin, BigDecimal precioMax) throws RemoteException {

		monitor.comienzoLectura();
		
		List<VOExcursionSalida> excursionesSalida = excursiones.listarExcursionesEntrePrecios(precioMin, precioMax);
		
		monitor.terminoLectura();
		
		return excursionesSalida;
	}
	
}
