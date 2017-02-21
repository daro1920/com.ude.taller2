package logica.negocio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import logica.valueobjects.VOExcursionSalida;

public class Excursiones extends Diccionario<String, Excursion>{

	public Excursiones() {
		super();
	}
	
	public void agregar(Excursion excursion) {
		this.poner(excursion.getCodigo(), excursion);
	}
	
	public List<VOExcursionSalida> listarExcursionesHacia(String destino) {
		
		Excursion excursion;
		VOExcursionSalida excursionSalida;
		Iterator<Excursion> iteradorExcursiones = this.iterador();
		List<VOExcursionSalida> excursionesSalida = new ArrayList<VOExcursionSalida>();
		
		while (iteradorExcursiones.hasNext()) {
			excursion = iteradorExcursiones.next();
			if (excursion.vaHacia(destino)) {
				excursionSalida = convertirEnExcursionSalida(excursion);
				excursionesSalida.add(excursionSalida);
			}
		}
		
		Collections.sort(excursionesSalida);
		
		return excursionesSalida;
	}
	
	public List<VOExcursionSalida> listarExcursionesEntrePrecios(BigDecimal precioMin, BigDecimal precioMax) {
		
		Excursion excursion;
		VOExcursionSalida excursionSalida;
		Iterator<Excursion> iteradorExcursiones = this.iterador();
		List<VOExcursionSalida> excursionesSalida = new ArrayList<VOExcursionSalida>();
		
		while (iteradorExcursiones.hasNext()) {
			excursion = iteradorExcursiones.next();
			if (excursion.precioEntre(precioMin, precioMax)) {
				excursionSalida = convertirEnExcursionSalida(excursion);
				excursionesSalida.add(excursionSalida);
			}
		}
		
		Collections.sort(excursionesSalida);
		
		return excursionesSalida;
	}

	private VOExcursionSalida convertirEnExcursionSalida(Excursion excursion) {
		
		VOExcursionSalida excursionSalida = new VOExcursionSalida(excursion.getCodigo(),
				excursion.getDestino(), excursion.getFechaHoraPartida(),
				excursion.getFechaHoraRegreso(), excursion.getPrecioBase(),
				excursion.cantidadAsientosDisponibles());
		
		return excursionSalida;
	}
	
}
