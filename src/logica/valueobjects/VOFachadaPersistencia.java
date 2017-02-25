package logica.valueobjects;

import java.io.Serializable;

import logica.negocio.Buses;
import logica.negocio.Excursiones;

@SuppressWarnings("serial")
public class VOFachadaPersistencia implements Serializable {
	
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
