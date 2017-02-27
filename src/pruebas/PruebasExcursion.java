package pruebas;

import java.math.BigDecimal;
import java.util.Date;

import logica.negocio.Bus;
import logica.negocio.Excursion;
import util.FechaHora;

public class PruebasExcursion {
	
	private ImpresoraPruebas impresora;
	
	public PruebasExcursion() {
		impresora = new ImpresoraPruebas();
	}

	public void correrPruebas() {
		
		ContadorPruebas contadorGeneral = new ContadorPruebas();
		ContadorPruebas contadorAux;
		
		impresora.imprimirEncabezadoGeneral("Pruebas Excursion");
		
		contadorAux = correrPruebasConstructores();
		contadorGeneral.sumarContador(contadorAux);

		impresora.imprimirResultadoGeneral("Fin Pruebas Excursion", contadorGeneral);
		
	}

	private ContadorPruebas correrPruebasConstructores() {
		ContadorPruebas contador = new ContadorPruebas();
		String codigo;
		String destino;
		Date fechaHoraPartida;
		Date fechaHoraRegreso;
		BigDecimal precioBase;
		Bus bus;
		Excursion excursion;
		boolean resultado;
		
		impresora.imprimirEncabezadoSeccion("Excursion(codigo, destino, fechaHoraPartida,\n"
				+ "		fechaHoraRegreso, precioBase, bus)");
		
		codigo = "EX1";
		destino = "Destino 1";
		fechaHoraPartida = FechaHora.obtenerFechaHora(30, 1, 2017, 15, 30);
		fechaHoraRegreso = FechaHora.obtenerFechaHora(30, 1, 2017, 15, 30);
		precioBase = BigDecimal.valueOf(500);
		bus = new Bus("BUS1", "Marca 1", 15);
		
		excursion = new Excursion(codigo, destino, fechaHoraPartida, fechaHoraRegreso, precioBase, bus);
		
		resultado = excursion.getCodigo().equals(codigo);
		contador.agregarResultadoPrueba(resultado);
		impresora.imprimirResultadoIndividual("Prueba 1.1", resultado);
		
		resultado = excursion.getDestino().equals(destino);
		contador.agregarResultadoPrueba(resultado);
		impresora.imprimirResultadoIndividual("Prueba 1.2", resultado);
		
		resultado = excursion.getFechaHoraPartida().equals(fechaHoraPartida);
		contador.agregarResultadoPrueba(resultado);
		impresora.imprimirResultadoIndividual("Prueba 1.3", resultado);
		
		resultado = excursion.getFechaHoraRegreso().equals(fechaHoraRegreso);
		contador.agregarResultadoPrueba(resultado);
		impresora.imprimirResultadoIndividual("Prueba 1.4", resultado);
		
		resultado = excursion.getPrecioBase().equals(precioBase);
		contador.agregarResultadoPrueba(resultado);
		impresora.imprimirResultadoIndividual("Prueba 1.5", resultado);
		
		resultado = excursion.getBus().equals(bus);
		contador.agregarResultadoPrueba(resultado);
		impresora.imprimirResultadoIndividual("Prueba 1.6", resultado);
		
		impresora.imprimirResultadoSeccion(contador);
		 
		return contador;
		
	}

}
