package logica.negocio;
import logica.valueobjects.*;

import java.io.*;
import java.awt.*;

public class Bus {
	
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
	return excursionesAsignadas.lenght();
}
public List<VOExcursionSalida> listarExcursionesAsignadas(){
	return excursionesAsignadas.listarExcursiones();
}
public void agregarExcursion(Excursion excursion){
	return excursionesAsignadas.agregarExcrusion();
}
public void borrarExcursion(String matricula){
	Excursion auxiliar = Excursiones.obtenerExcursion(matricula);
	excursionesAsignadas.delete(auxiliar);
}


}
