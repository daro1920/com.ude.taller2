package logica.negocio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import logica.valueobjects.VOExcursionSalida;

@SuppressWarnings("serial")
public class Excursiones extends Diccionario<String, Excursion> implements Serializable {

	public Excursiones() {
		super();
	}
	
	public void agregar(Excursion excursion) {
		poner(excursion.getCodigo(), excursion);
	}
	
	public List<VOExcursionSalida> listarExcursiones() {
		
		Excursion excursion;
		Iterator<Excursion> iteradorExcursiones = iterador();
		List<VOExcursionSalida> excursionesSalida = new ArrayList<VOExcursionSalida>();
		
		while (iteradorExcursiones.hasNext()) {
			excursion = iteradorExcursiones.next();
			excursionesSalida.add(excursion.voSalida());
		}
		
		Collections.sort(excursionesSalida);
		
		return excursionesSalida;
	}
	
	public List<VOExcursionSalida> listarExcursionesHacia(String destino) {
		
		Excursion excursion;
		Iterator<Excursion> iteradorExcursiones = this.iterador();
		List<VOExcursionSalida> excursionesSalida = new ArrayList<VOExcursionSalida>();
		
		while (iteradorExcursiones.hasNext()) {
			excursion = iteradorExcursiones.next();
			if (excursion.vaHacia(destino)) {
				excursionesSalida.add(excursion.voSalida());
			}
		}
		
		Collections.sort(excursionesSalida);
		
		return excursionesSalida;
	}
	
	public List<VOExcursionSalida> listarExcursionesEntrePrecios(BigDecimal precioMin, BigDecimal precioMax) {
		
		Excursion excursion;
		Iterator<Excursion> iteradorExcursiones = this.iterador();
		List<VOExcursionSalida> excursionesSalida = new ArrayList<VOExcursionSalida>();
		
		while (iteradorExcursiones.hasNext()) {
			excursion = iteradorExcursiones.next();
			if (excursion.precioEntre(precioMin, precioMax)) {
				excursionesSalida.add(excursion.voSalida());
			}
		}
		
		Collections.sort(excursionesSalida);
		
		return excursionesSalida;
	}
	
	public List<VOExcursionSalida> listarExcursionesBus(String matricula) {
		
		Excursion excursion;
		Iterator<Excursion> iteradorExcursiones = this.iterador();
		List<VOExcursionSalida> excursionesSalida = new ArrayList<VOExcursionSalida>();
		
		while (iteradorExcursiones.hasNext()) {
			excursion = iteradorExcursiones.next();
			if (excursion.esDeBus(matricula)) {
				excursionesSalida.add(excursion.voSalida());
			}
		}
		
		Collections.sort(excursionesSalida);
		
		return excursionesSalida;
	}
}
