package logica.negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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
	
	}		 	
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