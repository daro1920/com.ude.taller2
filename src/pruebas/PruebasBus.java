package pruebas;

import java.awt.List;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import logica.excepciones.CapacidadInsuficienteException;
import logica.negocio.Boletos;
import logica.negocio.Bus;
import logica.negocio.Buses;
import logica.negocio.Excursion;
import logica.negocio.Excursiones;
import logica.negocio.TipoBoleto;
import logica.valueobjects.VOBoletoEntrada;
import logica.valueobjects.VOBoletoEspecialEntrada;
import logica.valueobjects.VOBoletoSalida;
import logica.valueobjects.VOBusEntrada;
import logica.valueobjects.VOBusSalida;
import logica.valueobjects.VOExcursionEntrada;
import util.FechaHora;

public class PruebasBus {

private ImpresoraPruebas impresora;
	
	public PruebasBus() {
		impresora = new ImpresoraPruebas();
	}
	
public void correrPruebas() {
		
		ContadorPruebas contadorGeneral = new ContadorPruebas();
		Buses buses = new Buses();
		ContadorPruebas contadorAux;
		
		impresora.imprimirEncabezadoGeneral("Pruebas Bus");
		
		contadorAux = probarConstructorSinVO();
		contadorGeneral.sumarContador(contadorAux);
		
		contadorAux = probarConstructorConVO();
		contadorGeneral.sumarContador(contadorAux);
		
		probarlistarBuses(buses);
	

		impresora.imprimirResultadoGeneral("Fin Pruebas Bus", contadorGeneral);
		
	}
	
private ContadorPruebas probarConstructorSinVO() {
	
	ContadorPruebas contador = new ContadorPruebas();
	String matricula = "BUS1";
	String marca = "Marca 1";
	int capacidad = 15;
	Bus bus;
	boolean resultado;
	Excursiones excursionesAsignadas = new Excursiones();
	
	impresora.imprimirEncabezadoSeccion("Bus(matricula, marca, capacidad, excursionesAsignadas)");
	
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
	
	resultado = bus.listarExcursionesAsignadas().equals(excursionesAsignadas);
	contador.agregarResultadoPrueba(resultado);
	impresora.imprimirResultadoIndividual("Prueba 1.4", resultado);
	
	impresora.imprimirResultadoSeccion(contador);
	 
	return contador;
	
}

private ContadorPruebas probarConstructorConVO() {
	
	ContadorPruebas contador = new ContadorPruebas();
	String matricula = "BUS2";
	String marca = "Marca 2";
	int capacidad = 30;
	Excursiones excursionesAsignadas = new Excursiones();
	
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
	
	resultado = bus.listarExcursionesAsignadas().equals(excursionesAsignadas);
	contador.agregarResultadoPrueba(resultado);
	impresora.imprimirResultadoIndividual("Prueba 2.3", resultado);
	
	impresora.imprimirResultadoSeccion(contador);
	 
	return contador;
	
}

private  void probarlistarBuses(Buses buses){

	 java.util.List<VOBusSalida> busesSalida = buses.listarBuses();
    for (VOBusSalida busS :busesSalida) {
        System.out.println("Matricula:"+busS.getMatricula()+" Marca:"+busS.getMarca()+"Capacidad:"+
                busS.getCapacidad()+" CantidadExcursiones:" + busS.getCantidadExcursiones());
    }
}
	
}
