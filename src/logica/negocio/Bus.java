package logica.negocio;

import java.io.Serializable;
import java.util.List;

import logica.valueobjects.VOBusSalida;
import logica.valueobjects.VOExcursionSalida;

@SuppressWarnings("serial")
public class Bus implements Serializable {

	private String matricula;
	private String marca;
	private int capacidad;
	private Excursiones excursionesAsignadas;

	public Bus(String matricula,String marca, int capacidad){

		this.matricula = matricula;
		this.marca = marca;
		this.capacidad = capacidad;
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
	public int getCantidadExcursiones(){
		return excursionesAsignadas.tamanio();
	}
	public List<VOExcursionSalida> listarExcursionesAsignadas(){
		return excursionesAsignadas.listarExcursiones();
	}
	public void agregarExcursion(Excursion excursion){
		excursionesAsignadas.agregar(excursion);
	}
	public void borrarExcursion(String codigo){
		excursionesAsignadas.quitar(codigo);
	}
	@Override
	public boolean equals(Object obj ){
		return obj != null
				&& obj instanceof Bus
				&& ((Bus)obj).getMatricula().equals(matricula);

	}
	
	public boolean disponiblePara(Excursion excursion){
		
		boolean disponible = excursionesAsignadas.hayColisionCon(excursion);
		
		
		
		
	}

	public VOBusSalida voSalida() {
		// TODO Auto-generated method stub
		return null;
	}


}
