package logica.valueobjects;

public class VOBusEntrada {

private String matricula;
private String marca;
private int capacidad;

public VOBusEntrada(String matricula, String marca, int capacidad){}
public String getMatricula(){
	return this.matricula;
}
public String getMarca(){
	return this.marca;
}
public int getCapacidad(){
	return this.capacidad;
}
}