package pruebas;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import logica.excepciones.CapacidadInsuficienteException;
import logica.negocio.Bus;
import logica.negocio.Excursion;
import logica.negocio.TipoBoleto;
import logica.valueobjects.VOBoletoEntrada;
import logica.valueobjects.VOBoletoEspecialEntrada;
import logica.valueobjects.VOBoletoEspecialSalida;
import logica.valueobjects.VOBoletoSalida;
import logica.valueobjects.VOExcursionEntrada;
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
		
		contadorAux = probarConstructorSinVO();
		contadorGeneral.sumarContador(contadorAux);
		
		contadorAux = probarConstructorConVO();
		contadorGeneral.sumarContador(contadorAux);
		
		contadorAux = probarListarBoletos();
		contadorGeneral.sumarContador(contadorAux);

		impresora.imprimirResultadoGeneral("Fin Pruebas Excursion", contadorGeneral);
		
	}

	private ContadorPruebas probarConstructorSinVO() {
		
		ContadorPruebas contador = new ContadorPruebas();
		String codigo = "EX1";
		String destino = "Destino 1";
		Date fechaHoraPartida = FechaHora.obtenerFechaHora(30, 1, 2017, 10, 30);
		Date fechaHoraRegreso = FechaHora.obtenerFechaHora(30, 1, 2017, 19, 00);
		BigDecimal precioBase = BigDecimal.valueOf(500);
		Bus bus = null;
		try {
			bus = new Bus("BUS1", "Marca 1", 15);
		} catch (CapacidadInsuficienteException e) {
			e.printStackTrace();
		}
		Excursion excursion;
		boolean resultado;
		
		impresora.imprimirEncabezadoSeccion("Excursion(codigo, destino, fechaHoraPartida,\n"
				+ "		fechaHoraRegreso, precioBase, bus)");
		
		try {
			excursion = new Excursion(codigo, destino, fechaHoraPartida, fechaHoraRegreso, precioBase, bus);
		} catch (Exception e) {
			impresora.imprimirLinea("Excepcion inesperada:");
			impresora.imprimirLinea(e.getMessage());
			e.printStackTrace();
			
			return contador;
		}
		
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
	
	private ContadorPruebas probarConstructorConVO() {
		
		ContadorPruebas contador = new ContadorPruebas();
		String codigo = "EX2";
		String destino = "Destino 2";
		Date fechaHoraPartida = FechaHora.obtenerFechaHora(26, 2, 2017, 11, 20);
		Date fechaHoraRegreso = FechaHora.obtenerFechaHora(26, 2, 2017, 20, 10);
		BigDecimal precioBase = BigDecimal.valueOf(255);
		Bus bus = null;
		try {
			bus = new Bus("BUS2", "Marca 2", 30);
		} catch (CapacidadInsuficienteException e) {
			e.printStackTrace();
		}
		VOExcursionEntrada voExcursion = new VOExcursionEntrada(codigo, destino,
				fechaHoraPartida, fechaHoraRegreso, precioBase);
		Excursion excursion;
		boolean resultado;
		
		impresora.imprimirEncabezadoSeccion("Excursion(voExcursion, bus)");
		
		try {
			excursion = new Excursion(voExcursion, bus);
		} catch (Exception e) {
			impresora.imprimirLinea("Excepcion inesperada:");
			impresora.imprimirLinea(e.getMessage());
			e.printStackTrace();
			
			return contador;
		}
		
		resultado = excursion.getCodigo().equals(codigo);
		contador.agregarResultadoPrueba(resultado);
		impresora.imprimirResultadoIndividual("Prueba 2.1", resultado);
		
		resultado = excursion.getDestino().equals(destino);
		contador.agregarResultadoPrueba(resultado);
		impresora.imprimirResultadoIndividual("Prueba 2.2", resultado);
		
		resultado = excursion.getFechaHoraPartida().equals(fechaHoraPartida);
		contador.agregarResultadoPrueba(resultado);
		impresora.imprimirResultadoIndividual("Prueba 2.3", resultado);
		
		resultado = excursion.getFechaHoraRegreso().equals(fechaHoraRegreso);
		contador.agregarResultadoPrueba(resultado);
		impresora.imprimirResultadoIndividual("Prueba 2.4", resultado);
		
		resultado = excursion.getPrecioBase().equals(precioBase);
		contador.agregarResultadoPrueba(resultado);
		impresora.imprimirResultadoIndividual("Prueba 2.5", resultado);
		
		resultado = excursion.getBus().equals(bus);
		contador.agregarResultadoPrueba(resultado);
		impresora.imprimirResultadoIndividual("Prueba 2.6", resultado);
		
		impresora.imprimirResultadoSeccion(contador);
		 
		return contador;
		
	}

	private ContadorPruebas probarListarBoletos() {
		
		ContadorPruebas contador = new ContadorPruebas();
		String codigo = "EX3";
		String destino = "Destino 3";
		Date fechaHoraPartida = FechaHora.obtenerFechaHora(26, 2, 2017, 11, 20);
		Date fechaHoraRegreso = FechaHora.obtenerFechaHora(26, 2, 2017, 20, 10);
		BigDecimal precioBase = BigDecimal.valueOf(255);
		Bus bus = null;
		try {
			bus = new Bus("BUS3", "Marca 3", 30);
		} catch (CapacidadInsuficienteException e) {
			e.printStackTrace();
		}
		Excursion excursion;
		VOBoletoEntrada voBoleto;
		VOBoletoEspecialEntrada voBoletoEspecial;
		List<VOBoletoEntrada> boletosEntrada;
		List<VOBoletoSalida> boletosSalida;
		boolean resultado;
		
		impresora.imprimirEncabezadoSeccion("listarBoletos(tipo) : List<VOBoletoSalida>");
		
		// Prueba 3.1 - tipo boleto comun lista vacia
		try {
			excursion = new Excursion(codigo, destino, fechaHoraPartida, fechaHoraRegreso, precioBase, bus);
		} catch (Exception e) {
			impresora.imprimirLinea("Excepcion inesperada:");
			impresora.imprimirLinea(e.toString());
			e.printStackTrace();
			
			return contador;
		}
		boletosEntrada = new ArrayList<VOBoletoEntrada>();
		boletosSalida = excursion.listarBoletos(TipoBoleto.COMUN);
		resultado = listasEquivalentesOrdenadas(boletosEntrada, boletosSalida);
		contador.agregarResultadoPrueba(resultado);
		impresora.imprimirResultadoIndividual("Prueba 3.1", resultado);
		
		impresora.imprimirResultadoSeccion(contador);
		
		return contador;
	}

	private boolean listasEquivalentesOrdenadas(List<VOBoletoEntrada> boletosEntrada,
			List<VOBoletoSalida> boletosSalida) {
		boolean equivalentes = false;
		
		if (mismoLargo(boletosEntrada, boletosSalida)) {
			equivalentes = true;
			Iterator<VOBoletoSalida> iteradorSalida = boletosSalida.iterator();
			VOBoletoSalida boletoSalida;
			for (VOBoletoEntrada boletoEntrada : boletosEntrada) {
				if (iteradorSalida.hasNext()) {
					boletoSalida = iteradorSalida.next();
					if(!boletosEquivalentes(boletoEntrada, boletoSalida)) {
						equivalentes = false;
						break;
					}
				} else {
					equivalentes = false;
					break;
				}
			}
		}
		
		return equivalentes;
	}

	private boolean mismoLargo(List<?> boletosEntrada,
			List<?> boletosSalida) {
		return boletosEntrada.size() == boletosSalida.size();
	}

	private boolean boletosEquivalentes(VOBoletoEntrada boletoEntrada,
			VOBoletoSalida boletoSalida) {
		return tipoBoletoEquivalente(boletoEntrada, boletoSalida)
				&& boletoEntrada.getEdad() == boletoSalida.getEdad()
				&& boletoEntrada.getProcedencia().equals(boletoSalida.getProcedencia())
				&& boletoEntrada.getCelular().equals(boletoSalida.getCelular());
	}

	private boolean tipoBoletoEquivalente(VOBoletoEntrada boletoEntrada,
			VOBoletoSalida boletoSalida) {
		boolean retorno = false;
		
		if (boletoEntrada instanceof VOBoletoEntrada) {
			retorno = boletoSalida instanceof VOBoletoSalida;
		} else if (boletoEntrada instanceof VOBoletoEspecialEntrada) {
			retorno = boletoSalida instanceof VOBoletoEspecialSalida;
		}
		
		return retorno;
	}

}
