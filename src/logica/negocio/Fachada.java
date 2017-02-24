package logica.negocio;

import persistencia.Persistencia;
import logica.excepciones.PersistenciaException;
import logica.valueobjects.VOFachadaPersistencia;

public class Fachada {

	private Buses buses;
	private Excursiones excursiones;
	private Monitor monitor;
	
	public Fachada() {
		buses = new Buses();
		excursiones = new Excursiones();
		monitor = new Monitor();
	}
	
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
	
}
