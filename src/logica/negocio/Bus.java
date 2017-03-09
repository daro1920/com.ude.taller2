package logica.negocio;

import java.io.Serializable;
import java.util.List;

import logica.excepciones.CapacidadInsuficienteException;
import logica.valueobjects.VOBusEntrada;
import logica.valueobjects.VOBusSalida;
import logica.valueobjects.VOExcursionSalida;

@SuppressWarnings("serial")
public class Bus implements Serializable {

	private String matricula;
	private String marca;
	private int capacidad;
	private Excursiones excursiones;

	public Bus(String matricula,String marca, int capacidad)throws CapacidadInsuficienteException {
		if (!(capacidad > 0)) {
			throw new CapacidadInsuficienteException("La capacidad del bus debe de ser mayor a cero");
		}

		this.matricula = matricula;
		this.marca = marca;
		this.capacidad = capacidad;
		this.excursiones = new Excursiones();
	}

	public String getMatricula(){
		return matricula;
	}

	public String getMarca(){
		return marca;
	}
	public int getCapacidad(){
		return capacidad;
	}
	
	public Bus(VOBusEntrada voBus) throws CapacidadInsuficienteException {
		this(voBus.getMatricula(), voBus.getMarca(), voBus.getCapacidad());
	}
	
	
	public int getCantidadExcursiones(){
		return excursiones.tamanio();
	}
	public List<VOExcursionSalida> listarExcursionesAsignadas(){
		return excursiones.listarExcursiones();
	}
	public void agregarExcursion(Excursion excursion){
		excursiones.agregar(excursion);
	}
	public void borrarExcursion(String codigo){
		excursiones.quitar(codigo);
	}
	@Override
	public boolean equals(Object obj ){
		return obj != null
				&& obj instanceof Bus
				&& ((Bus)obj).getMatricula().equals(matricula);

	}
	
	public boolean disponiblePara(Excursion excursion){
		
		return !excursiones.hayColisionCon(excursion);
	}

	public VOBusSalida voSalida() {
	
		return new VOBusSalida(matricula,marca,capacidad, getCantidadExcursiones());
	}


}
