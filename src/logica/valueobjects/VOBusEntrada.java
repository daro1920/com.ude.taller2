package logica.valueobjects;

import java.io.Serializable;

public class VOBusEntrada implements Serializable {

private String matricula;
private String marca;
private int capacidad;

public VOBusEntrada(String matricula, String marca, int capacidad){
	
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
}