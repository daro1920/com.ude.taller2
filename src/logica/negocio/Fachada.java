package logica.negocio;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import logica.excepciones.BusInexistenteException;
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
	public List<VOBusSalida> listarBuses() {
		monitor.comienzoLectura();
		
		List<VOBusSalida> busesSalida = buses.listarBuses();
		
		monitor.terminoLectura();
		
		return busesSalida;
	}

	@Override
	public List<VOExcursionSalida> listarExcursionesBus(String matricula) throws BusInexistenteException {
		
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
	public void registrarExcursion(VOExcursionEntrada voExcursion) throws YaExisteExcursionException, NoHayBusesDisponiblesException {
		
		monitor.comienzoEscritura();
		
		if (excursiones.contiene(voExcursion.getCodigo())) {
			monitor.terminoEscritura();
			throw new YaExisteExcursionException("Ya existe una excursion con el mismo codigo");
		}
		
		Bus busDisponible = buses.obtenerBusDisponible(voExcursion.getFechaHoraPartida(),
				voExcursion.getFechaHoraRegreso());

		if (busDisponible == null) {
			monitor.terminoEscritura();
			throw new NoHayBusesDisponiblesException("No hay buses disponibles");
		}
		
		Excursion excursion = new Excursion(voExcursion, busDisponible);
		excursiones.agregar(excursion);
		busDisponible.agregarExcursion(excursion);
		
		monitor.terminoEscritura();
		
	}

	@Override
	public void reasignarExcursion(String codigo) throws NoExisteExcursionException, NoHayBusesDisponiblesException {
		
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
	public void respaldar() throws PersistenciaException {
		monitor.comienzoLectura();
		
		VOFachadaPersistencia voFachada = new VOFachadaPersistencia(buses, excursiones);
		try {
			Persistencia persistencia = new Persistencia();
			persistencia.respaldar("datos.dat",voFachada);
		} catch (PersistenciaException e) {
			monitor.terminoLectura();
			throw e;
		}
		
		monitor.terminoLectura();
	}
	
	@Override
	public void recuperar() throws PersistenciaException {
		monitor.comienzoEscritura();
		
		try {
			Persistencia persistencia = new Persistencia();
			VOFachadaPersistencia voFachada = persistencia.recuperar("datos.dat");
			buses = voFachada.getBuses();
			excursiones = voFachada.getExcursiones();
		} catch (PersistenciaException e) {
			monitor.terminoEscritura();
			throw e;
		}
		
		monitor.terminoEscritura();
	}
	
	@Override
	public void venderBoleto(VOBoletoEntrada voBoleto) throws NoExisteExcursionException, NoHayAsientosDisponiblesException {
		
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
	public BigDecimal recaudacionExcursion(String codigo) throws NoExisteExcursionException {
		
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
	public List<VOBoletoSalida> listarBoletosExcursion(String codigo, TipoBoleto tipo) throws NoExisteExcursionException {
		
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
	public List<VOExcursionSalida> listarExcursionesHacia(String destino) {
		
		monitor.comienzoLectura();
		
		List<VOExcursionSalida> excursionesSalida = excursiones.listarExcursionesHacia(destino);
		
		monitor.terminoLectura();
		
		return excursionesSalida;
	}
	
	@Override
	public List<VOExcursionSalida> excursionesEntrePrecios(BigDecimal precioMin, BigDecimal precioMax) {

		monitor.comienzoLectura();
		
		List<VOExcursionSalida> excursionesSalida = excursiones.listarExcursionesEntrePrecios(precioMin, precioMax);
		
		monitor.terminoLectura();
		
		return excursionesSalida;
	}
	
}
