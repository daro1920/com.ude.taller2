package logica.negocio;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import logica.valueobjects.VOBusSalida;


@SuppressWarnings("serial")
public class Buses extends Diccionario<String, Bus> implements Serializable {
	
	public Buses() {
		super();
	}

	public void agregar(Bus bus) {
		poner(bus.getMatricula(), bus);
	}

	public Bus obtenerBusDisponible(Date fechaHoraPartida, Date fechaHoraRegreso){
		/*
		Bus auxiliar = buses.info;
		for(int i=0;i<auxiliar.excursionesAsignadas.lenght();i++){
			exAuxiliar = auxiliar.excursionesAsignadas[i];
			if(exAuxiliar.fechaHoraPartida > fechaHoraRegreso || exAuxiliar.fechaHoraRegreso < fechaHoraPardida)
				return auxiliar;
			else
				return obtenerBusDisponible( fechaHoraPartida, fechaHoraRegreso);
		}*/
		throw new UnsupportedOperationException("Metodo no implementado, aun");
		
	}
	
	public Bus obtenerOtroBusDisponible(Excursion excursion) {
		// TODO: Devolver el primer bus que, ademas de estar disponible, tenga
		// capacidad suficiente para la excursion y sea diferente del bus que ya tiene asignado.
		throw new UnsupportedOperationException("Metodo no implementado, aun");
	}
	
	public boolean hayBusDisponible(Date fechaHoraPartida, Date fechaHoraRegreso){
		/*boolean hayBus= false;
		Bus auxiliar = buses.info;
		for(int i=0;i<auxiliar.excursionesAsignadas.lenght();i++){
			exAuxiliar = auxiliar.excursionesAsignadas[i];
			if(exAuxiliar.fechaHoraPartida > fechaHoraRegreso || exAuxiliar.fechaHoraRegreso < fechaHoraPardida)
				hayBus =  true;
			else
				return hayBusDisponible( fechaHoraPartida, fechaHoraRegreso);
		}*/
		throw new UnsupportedOperationException("Metodo no implementado, aun");
	}
	
	public List<VOBusSalida> listarBuses() {
		throw new UnsupportedOperationException("Metodo no implementado, aun");
	}

}