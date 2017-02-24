package logica.valueobjects;

import logica.negocio.Buses;
import logica.negocio.Excursiones;

public class VOFachadaPersistencia {
	
	private Buses buses;
	private Excursiones excursiones;
	
	public VOFachadaPersistencia(Buses buses, Excursiones excursiones) {
		super();
		this.buses = buses;
		this.excursiones = excursiones;
	}
	
	public Buses getBuses() {
		return buses;
	}
	
	public void setBuses(Buses buses) {
		this.buses = buses;
	}
	
	public Excursiones getExcursiones() {
		return excursiones;
	}
	
	public void setExcursiones(Excursiones excursiones) {
		this.excursiones = excursiones;
	}
	
	
}
