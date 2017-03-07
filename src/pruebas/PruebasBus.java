package pruebas;

import java.awt.List;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import logica.negocio.Bus;
import logica.negocio.Excursion;
import logica.negocio.Excursiones;
import logica.negocio.TipoBoleto;
import logica.valueobjects.VOBoletoEntrada;
import logica.valueobjects.VOBoletoEspecialEntrada;
import logica.valueobjects.VOBoletoSalida;
import logica.valueobjects.VOBusEntrada;
import logica.valueobjects.VOExcursionEntrada;
import util.FechaHora;

public class PruebasBus {

private ImpresoraPruebas impresora;
	
	public PruebasBus() {
		impresora = new ImpresoraPruebas();
	}
	
public void correrPruebas() {
		
		ContadorPruebas contadorGeneral = new ContadorPruebas();
		ContadorPruebas contadorAux;
		
		impresora.imprimirEncabezadoGeneral("Pruebas Bus");
		
		contadorAux = probarConstructorSinVO();
		contadorGeneral.sumarContador(contadorAux);
		
		contadorAux = probarConstructorConVO();
		contadorGeneral.sumarContador(contadorAux);
		
		contadorAux = probarListarBuses();
		contadorGeneral.sumarContador(contadorAux);

		impresora.imprimirResultadoGeneral("Fin Pruebas Bus", contadorGeneral);
		
	}
	
private ContadorPruebas probarConstructorSinVO() {
	
	ContadorPruebas contador = new ContadorPruebas();
	String matricula = "BUS1";
	String marca = "Marca 1";
	int capacidad = 15;
	Bus bus;
	boolean resultado;
	
	impresora.imprimirEncabezadoSeccion("Bus(matricula, marca, capacidad)");
	
	try {
		bus = new Bus(matricula, marca, capacidad);
	} catch (Exception e) {
		impresora.imprimirLinea("Excepcion inesperada:");
		impresora.imprimirLinea(e.getMessage());
		e.printStackTrace();
		
		return contador;
	}
	
	resultado = bus.getMatricula().equals(matricula);
	contador.agregarResultadoPrueba(resultado);
	impresora.imprimirResultadoIndividual("Prueba 1.1", resultado);
	
	resultado = bus.getMarca().equals(marca);
	contador.agregarResultadoPrueba(resultado);
	impresora.imprimirResultadoIndividual("Prueba 1.2", resultado);
	
	resultado = bus.getCapacidad() == capacidad;
	contador.agregarResultadoPrueba(resultado);
	impresora.imprimirResultadoIndividual("Prueba 1.3", resultado);
	
	
	impresora.imprimirResultadoSeccion(contador);
	 
	return contador;
	
}

private ContadorPruebas probarConstructorConVO() {
	
	ContadorPruebas contador = new ContadorPruebas();
	String matricula = "BUS2";
	String marca = "Marca 2";
	int capacidad = 30;
	
	VOBusEntrada voBus = new VOBusEntrada(matricula, marca,capacidad);
	Bus bus;
	boolean resultado;
	
	impresora.imprimirEncabezadoSeccion("Bus(voBus)");
	
	try {
		bus = new Bus(voBus);
	} catch (Exception e) {
		impresora.imprimirLinea("Excepcion inesperada:");
		impresora.imprimirLinea(e.getMessage());
		e.printStackTrace();
		
		return contador;
	}
	
	resultado = bus.getMatricula().equals(matricula);
	contador.agregarResultadoPrueba(resultado);
	impresora.imprimirResultadoIndividual("Prueba 2.1", resultado);
	
	resultado = bus.getMarca().equals(marca);
	contador.agregarResultadoPrueba(resultado);
	impresora.imprimirResultadoIndividual("Prueba 2.2", resultado);
	
	resultado = bus.getCapacidad() == capacidad;
	contador.agregarResultadoPrueba(resultado);
	impresora.imprimirResultadoIndividual("Prueba 2.3", resultado);
	

	impresora.imprimirResultadoSeccion(contador);
	 
	return contador;
	
}

private ContadorPruebas probarListarBuses() {
	
	ContadorPruebas contador = new ContadorPruebas();
	String codigo = "BUS3";
	String destino = "Marca 3";
	int capacidad = 35;
	Bus bus = new Bus("BUS3", "Marca 3", 35);
	Excursion excursion;
	VOBusEntrada voBusEntrada;
	
	boolean resultado;
	
	impresora.imprimirEncabezadoSeccion("listarBuses() : List<VOBusSalida>");
		
	try {
		bus = new bus(matricula, destino, fechaHoraPartida, fechaHoraRegreso, precioBase, bus);
	} catch (Exception e) {
		impresora.imprimirLinea("Excepcion inesperada:");
		impresora.imprimirLinea(e.toString());
		e.printStackTrace();
		
		return contador;
	}
/*	boletosEntrada = new ArrayList<VOBoletoEntrada>();
	boletosSalida = excursion.listarBoletos(TipoBoleto.COMUN);
	resultado = listasEquivalentesOrdenadas(boletosEntrada, boletosSalida);
	contador.agregarResultadoPrueba(resultado);
	impresora.imprimirResultadoIndividual("Prueba 3.1", resultado);
	
	impresora.imprimirResultadoSeccion(contador);
	
	return contador;
	*/
}
	
}
