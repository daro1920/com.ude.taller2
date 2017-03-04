package logica.negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import logica.valueobjects.VOBusSalida;
import logica.valueobjects.VOExcursionSalida;


@SuppressWarnings("serial")
public class Buses extends Diccionario<String, Bus> implements Serializable {
	
	public Buses() {
		super();
	}

	public void agregar(Bus bus) {
		poner(bus.getMatricula(), bus);
	}

	public Bus obtenerBusDisponible(Excursion excursion){

		Iterator<Bus> iteradorBus = iterador();
		Bus bus;
		while (iteradorBus.hasNext()) {
			bus = iteradorBus.next();
			if (bus.disponiblePara(excursion)  ){
				return bus;
			}
		}
		return null;
		
	}
	
	public Bus obtenerOtroBusDisponible(Excursion excursion) {
		
		
		Iterator<Bus> iteradorBus = iterador();
		Bus bus;
		while (iteradorBus.hasNext()) {
			bus = iteradorBus.next();
			if (!bus.equals(excursion.getBus()) && bus.disponiblePara(excursion)  ){
				return bus;
			}
		}
		return null;
		// TODO: Devolver el primer bus que, ademas de estar disponible, tenga
		// capacidad suficiente para la excursion y sea diferente del bus que ya tiene asignado.
		//throw new UnsupportedOperationException("Metodo no implementado, aun");
	}
	
	/*public boolean hayBusDisponible(Date fechaHoraPartida, Date fechaHoraPartida){
		boolean haybus= false;
		boolean colisiona = true;
		Bus bus;
		Iterator<Bus> iteradorBus = iterador();
		List<VOBusSalida> busesSalida = new ArrayList<VOBusSalida>();
		
		while (iteradorBus.hasNext()) {
			bus = iteradorBus.next();
			Excursion excursion;
			Iterator<Excursion> iteradorExcursiones = this.iterador();
			List<VOExcursionSalida> excursionesSalida = new ArrayList<VOExcursionSalida>();
			
			while (iteradorExcursiones.hasNext()) {
				excursion = iteradorExcursiones.next();
				colisiona = fechaHoraRegreso.compareTo(excursion.fechaHoraPartida) > 0
						&& fechaHoraPartida.compareTo(excursion.fechaHoraRegreso) < 0;
				if (colisiona == false){
					haybus = true;
		
				}		 
			}
		}
		return haybus;
		
	
		//throw new UnsupportedOperationException("Metodo no implementado, aun");

	
	}*/
	
	public List<VOBusSalida> listarBuses() {
		//throw new UnsupportedOperationException("Metodo no implementado, aun");
		Bus bus;
		Iterator<Bus> iteradorBus = iterador();
		List<VOBusSalida> busesSalida = new ArrayList<VOBusSalida>();
		
		while (iteradorBus.hasNext()) {
			bus = iteradorBus.next();
			busesSalida.add(bus.voSalida());
		}
		
		Collections.sort(busesSalida);
		
		return busesSalida;
		
		
	}


	
}	

}