package pruebas;

import java.math.BigDecimal;
import java.rmi.RemoteException;

import logica.excepciones.CapacidadInsuficienteException;
import logica.excepciones.YaExisteBusException;
import logica.negocio.Fachada;
import logica.valueobjects.VOBusEntrada;
import logica.valueobjects.VOBusSalida;

public class PruebasFachada {
	
	private ImpresoraPruebas impresora;
	
	public PruebasFachada() {
		impresora = new ImpresoraPruebas();
	}
	
	public void correrPruebas() {
		
		ContadorPruebas contadorGeneral = new ContadorPruebas();
		
		
		impresora.imprimirEncabezadoGeneral("Pruebas Fachada");
		
		probarConstructor(contadorGeneral);
		probarRegistrarBus(contadorGeneral);
//		ListarBuses
//		ListarExcursionesBus
//		RegistrarExcursion
//		ReasignarExcursion
//		Respaldar
//		Recuperar
//		VenderBoleto
//		RecaudacionExcursion
//		ListarBoletosExcursion
//		ListarExcursionesHacia
//		ListarExcursionesEntrePrecios
		
		impresora.imprimirResultadoGeneral("Fin Pruebas Fachada", contadorGeneral);
		
	}
	
	private void probarConstructor(ContadorPruebas contadorGeneral) {
		ContadorPruebas contador;
		try {
			contador = probarConstructor();
			contadorGeneral.sumarContador(contador);
		} catch (Exception e) {
			impresora.imprimirLinea("Excepcion inesperada:");
			impresora.imprimirLinea(e.getMessage());
			e.printStackTrace();
		}
	}

	private ContadorPruebas probarConstructor() throws RemoteException {
		
		ContadorPruebas contador = new ContadorPruebas();
		Fachada fachada;
		boolean resultado;
		
		impresora.imprimirEncabezadoSeccion("Fachada()");
		
		fachada = new Fachada();
		
		resultado = fachada.listarBuses().size() == 0;
		contador.agregarResultadoPrueba(resultado);
		impresora.imprimirResultadoIndividual("Prueba 1.1", resultado);
		
		resultado = fachada.listarExcursionesEntrePrecios(BigDecimal.valueOf(Long.MIN_VALUE), BigDecimal.valueOf(Long.MAX_VALUE)).size() == 0;
		contador.agregarResultadoPrueba(resultado);
		impresora.imprimirResultadoIndividual("Prueba 1.2", resultado);
		
		impresora.imprimirResultadoSeccion(contador);
		 
		return contador;
	}
	
	private void probarRegistrarBus(ContadorPruebas contadorGeneral) {
		ContadorPruebas contador;
		try {
			contador = probarRegistrarBus();
			contadorGeneral.sumarContador(contador);
		} catch (Exception e) {
			impresora.imprimirLinea("Excepcion inesperada:");
			impresora.imprimirLinea(e.getMessage());
			e.printStackTrace();
		}
	}

	private ContadorPruebas probarRegistrarBus() throws RemoteException  {
		
		ContadorPruebas contador = new ContadorPruebas();
		Fachada fachada;
		boolean resultado;
		VOBusEntrada voBus;
		VOBusSalida voBusSalida;
		
		impresora.imprimirEncabezadoSeccion("registrarBus()"); 
		
		// Prueba 2.1 : Registrar bus capacidad 0
		// Resultado esperado: CapacidadInsuficienteException
		fachada = new Fachada();
		voBus = new VOBusEntrada("111", "Marca 1", 0);
		try {
			fachada.registrarBus(voBus);
			resultado = false;
		} catch (YaExisteBusException e) {
			// No debería pasar
			resultado = false;
			e.printStackTrace();
		} catch (CapacidadInsuficienteException e) {
			resultado = fachada.listarBuses().size() == 0;
		}
		contador.agregarResultadoPrueba(resultado);
		impresora.imprimirResultadoIndividual("Prueba 2.1", resultado);
		
		// Prueba 2.2 : Registrar bus capacidad -1
		// Resultado esperado: CapacidadInsuficienteException
		fachada = new Fachada();
		voBus = new VOBusEntrada("222", "Marca 2", -1);
		try {
			fachada.registrarBus(voBus);
			resultado = false;
		} catch (YaExisteBusException e) {
			// No debería pasar
			resultado = false;
			e.printStackTrace();
		} catch (CapacidadInsuficienteException e) {
			resultado = fachada.listarBuses().size() == 0;
		}
		contador.agregarResultadoPrueba(resultado);
		impresora.imprimirResultadoIndividual("Prueba 2.2", resultado);
		
		// Prueba 2.3 : Registrar bus capacidad < -1
		// Resultado esperado: CapacidadInsuficienteException
		fachada = new Fachada();
		voBus = new VOBusEntrada("333", "Marca 3", -38);
		try {
			fachada.registrarBus(voBus);
			resultado = false;
		} catch (YaExisteBusException e) {
			// No debería pasar
			resultado = false;
			e.printStackTrace();
		} catch (CapacidadInsuficienteException e) {
			resultado = fachada.listarBuses().size() == 0;
		}
		contador.agregarResultadoPrueba(resultado);
		impresora.imprimirResultadoIndividual("Prueba 2.3", resultado);
		
		// Prueba 2.4 : Registrar bus ya existente
		// Resultado esperado: YaExisteBusException
		fachada = new Fachada();
		voBus = new VOBusEntrada("444", "Marca 4", 10);
		try {
			fachada.registrarBus(voBus);
			voBus = new VOBusEntrada("444", "Marca X", 20);
			fachada.registrarBus(voBus);
			resultado = false;
		} catch (CapacidadInsuficienteException e) {
			// No debería pasar
			resultado = false;
			e.printStackTrace();
		} catch (YaExisteBusException e) {
			resultado = fachada.listarBuses().size() == 1;
		}
		contador.agregarResultadoPrueba(resultado);
		impresora.imprimirResultadoIndividual("Prueba 2.4", resultado);

		// Prueba 2.5 : Registrar un bus correcto
		// Resultado esperado: registro correcto
		fachada = new Fachada();
		voBus = new VOBusEntrada("555", "Marca 5", 5);
		try {
			fachada.registrarBus(voBus);
		} catch (CapacidadInsuficienteException e) {
			// No debería pasar
			resultado = false;
			e.printStackTrace();
		} catch (YaExisteBusException e) {
			// No debería pasar
			resultado = false;
			e.printStackTrace();
		}
		voBusSalida = new VOBusSalida("555", "Marca 5", 5, 0);
		resultado = resultado && fachada.listarBuses().contains(voBusSalida);
		contador.agregarResultadoPrueba(resultado);
		impresora.imprimirResultadoIndividual("Prueba 2.5", resultado);
		
		// Prueba 2.6 : Registrar varios buses correctos
		// Resultado esperado: registro correcto
		fachada = new Fachada();
		voBus = new VOBusEntrada("666A", "Marca A", 6);
		try {
			fachada.registrarBus(voBus);
			voBus = new VOBusEntrada("666B", "Marca B", 12);
			fachada.registrarBus(voBus);
			voBus = new VOBusEntrada("666C", "Marca C", 18);
			fachada.registrarBus(voBus);
		} catch (CapacidadInsuficienteException e) {
			// No debería pasar
			resultado = false;
			e.printStackTrace();
		} catch (YaExisteBusException e) {
			// No debería pasar
			resultado = false;
			e.printStackTrace();
		}
		voBusSalida = new VOBusSalida("666A", "Marca A", 6, 0);
		resultado = resultado&& fachada.listarBuses().contains(voBusSalida);
		voBusSalida = new VOBusSalida("666B", "Marca B", 12, 0);
		resultado = resultado&& fachada.listarBuses().contains(voBusSalida);
		voBusSalida = new VOBusSalida("666C", "Marca C", 18, 0);
		resultado = resultado&& fachada.listarBuses().contains(voBusSalida);
		contador.agregarResultadoPrueba(resultado);
		impresora.imprimirResultadoIndividual("Prueba 2.6", resultado);
		
		impresora.imprimirResultadoSeccion(contador);
		 
		return contador;
	}

}
