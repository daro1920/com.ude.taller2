package pruebas;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import logica.excepciones.*;
import util.FechaHora;
import logica.negocio.Fachada;
import logica.valueobjects.VOBusEntrada;
import logica.valueobjects.VOBusSalida;
import logica.valueobjects.VOExcursionEntrada;
import logica.valueobjects.VOExcursionSalida;

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
		probarListarBuses(contadorGeneral);
		probarRegistrarExcursion(contadorGeneral);
		probarListarExcursionesBus(contadorGeneral);
		probarReasignarExcursion(contadorGeneral);
		probarRespaldar(contadorGeneral);
		probarRecuperar(contadorGeneral);
//		VenderBoleto
//		RecaudacionExcursion
//		ListarBoletosExcursion
//		ListarExcursionesHacia
//		ListarExcursionesEntrePrecios
		
		impresora.imprimirResultadoGeneral("Fin Pruebas Fachada", contadorGeneral);
		
	}

	private void probarRecuperar(ContadorPruebas contadorGeneral){
		ContadorPruebas contador;
		try {
			contador = probarRecuperar();
			contadorGeneral.sumarContador(contador);
		} catch (Exception e) {
			impresora.imprimirLinea("Excepcion inesperada:");
			impresora.imprimirLinea(e.getMessage());
			e.printStackTrace();
		}

	}

	private ContadorPruebas probarRecuperar() throws RemoteException {

		boolean resultado;
		ContadorPruebas contador = new ContadorPruebas();

		impresora.imprimirEncabezadoSeccion("recuperar()");

		Fachada fachada = new Fachada();
		try {
			fachada.recuperar();
			resultado = false;
		} catch (PersistenciaException e) {
			e.printStackTrace();
			resultado = false;
		} catch (ConfiguracionException e) {
			e.printStackTrace();
			resultado = false;
		}

		contador.agregarResultadoPrueba(resultado);
		impresora.imprimirResultadoIndividual("Prueba 8.1", resultado);

		return contador;
	}

	private void probarRespaldar(ContadorPruebas contadorGeneral){
		ContadorPruebas contador;
		try {
			contador = probarRespaldar();
			contadorGeneral.sumarContador(contador);
		} catch (Exception e) {
			impresora.imprimirLinea("Excepcion inesperada:");
			impresora.imprimirLinea(e.getMessage());
			e.printStackTrace();
		}

	}

	private ContadorPruebas probarRespaldar() throws RemoteException {

		boolean resultado;
		ContadorPruebas contador = new ContadorPruebas();

		impresora.imprimirEncabezadoSeccion("respaldar()");

		Fachada fachada = new Fachada();
		try {
			fachada.respaldar();
			resultado = false;
		} catch (PersistenciaException e) {
			e.printStackTrace();
			resultado = false;
		} catch (ConfiguracionException e) {
			e.printStackTrace();
			resultado = false;
		}

		contador.agregarResultadoPrueba(resultado);
		impresora.imprimirResultadoIndividual("Prueba 7.1", resultado);

		return contador;
	}

	private void probarReasignarExcursion(ContadorPruebas contadorGeneral){
		ContadorPruebas contador;
		try {
			contador = probrReasignarExcursion();
			contadorGeneral.sumarContador(contador);
		} catch (Exception e) {
			impresora.imprimirLinea("Excepcion inesperada:");
			impresora.imprimirLinea(e.getMessage());
			e.printStackTrace();
		}

	}
	private ContadorPruebas probrReasignarExcursion() throws RemoteException {

		boolean resultado;
		ContadorPruebas contador = new ContadorPruebas();

		impresora.imprimirEncabezadoSeccion("reasignarExcursion(VOBusEntrada voBus)");

		Fachada fachada = new Fachada();
		try {
			fachada.reasignarExcursion("EX31");
			resultado = false;
		} catch (NoExisteExcursionException e) {
			resultado = false;
			e.printStackTrace();
		} catch (NoHayBusesDisponiblesException e) {
			resultado = true;
			e.printStackTrace();
		}

		contador.agregarResultadoPrueba(resultado);
		impresora.imprimirResultadoIndividual("Prueba 6.1", resultado);

		return contador;
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
		
		impresora.imprimirEncabezadoSeccion("registrarBus(VOBusEntrada voBus)"); 
		
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
			resultado = fachada.listarBuses().isEmpty();
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
			resultado = fachada.listarBuses().isEmpty();
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
			resultado = fachada.listarBuses().isEmpty();
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

	private void probarListarBuses(ContadorPruebas contadorGeneral) {
		ContadorPruebas contador;
		try {
			contador = probarListarBuses();
			contadorGeneral.sumarContador(contador);
		} catch (Exception e) {
			impresora.imprimirLinea("Excepcion inesperada:");
			impresora.imprimirLinea(e.getMessage());
			e.printStackTrace();
		}
	}

	private ContadorPruebas probarListarBuses() throws RemoteException, YaExisteBusException, CapacidadInsuficienteException {
		ContadorPruebas contador = new ContadorPruebas();
		Fachada fachada;
		boolean resultado;
		VOBusEntrada voBus;
		VOBusSalida voBusSalida;
		List<VOBusSalida> buses;
		
		impresora.imprimirEncabezadoSeccion("listarBuses()"); 
		
		// Prueba 3.1 : Listar buses sin buses registrados
		// Resultado esperado: lista vacia
		fachada = new Fachada();
		resultado = fachada.listarBuses().isEmpty();
		contador.agregarResultadoPrueba(resultado);
		impresora.imprimirResultadoIndividual("Prueba 3.1", resultado);
		
		// Prueba 3.2 : Listar buses con un bus registrado
		// Resultado esperado: lista con el bus registrado
		fachada = new Fachada();
		voBus = new VOBusEntrada("111", "Marca 1", 10);
		fachada.registrarBus(voBus);
		voBusSalida = new VOBusSalida("111", "Marca 1", 10, 0);
		buses = fachada.listarBuses();
		resultado = buses.size() == 1 && buses.contains(voBusSalida);
		contador.agregarResultadoPrueba(resultado);
		impresora.imprimirResultadoIndividual("Prueba 3.2", resultado);
		
		// Prueba 3.3 : Listar buses con varios buses registrados en orden
		// Resultado esperado: lista con los buses ordenados
		fachada = new Fachada();
		voBus = new VOBusEntrada("111", "Marca 1", 10);
		fachada.registrarBus(voBus);
		voBus = new VOBusEntrada("222", "Marca 1", 10);
		fachada.registrarBus(voBus);
		voBus = new VOBusEntrada("333", "Marca 1", 10);
		fachada.registrarBus(voBus);
		buses = fachada.listarBuses();
		voBusSalida = new VOBusSalida("111", "Marca 1", 10, 0);
		resultado = buses.size() == 3 && buses.contains(voBusSalida);
		voBusSalida = new VOBusSalida("222", "Marca 1", 10, 0);
		resultado = resultado && buses.contains(voBusSalida);
		voBusSalida = new VOBusSalida("333", "Marca 1", 10, 0);
		resultado = resultado && buses.contains(voBusSalida);
		resultado = resultado && estanOrdenados(buses);
		contador.agregarResultadoPrueba(resultado);
		impresora.imprimirResultadoIndividual("Prueba 3.3", resultado);
		
		// Prueba 3.4 : Listar buses con varios buses registrados en desorden
		// Resultado esperado: lista con los buses ordenados
		fachada = new Fachada();
		voBus = new VOBusEntrada("222", "Marca 1", 10);
		fachada.registrarBus(voBus);
		voBus = new VOBusEntrada("111", "Marca 1", 10);
		fachada.registrarBus(voBus);
		voBus = new VOBusEntrada("333", "Marca 1", 10);
		fachada.registrarBus(voBus);
		buses = fachada.listarBuses();
		voBusSalida = new VOBusSalida("111", "Marca 1", 10, 0);
		resultado = buses.size() == 3 && buses.contains(voBusSalida);
		voBusSalida = new VOBusSalida("222", "Marca 1", 10, 0);
		resultado = resultado && buses.contains(voBusSalida);
		voBusSalida = new VOBusSalida("333", "Marca 1", 10, 0);
		resultado = resultado && buses.contains(voBusSalida);
		resultado = resultado && estanOrdenados(buses);
		contador.agregarResultadoPrueba(resultado);
		impresora.imprimirResultadoIndividual("Prueba 3.4", resultado);

		impresora.imprimirResultadoSeccion(contador);
		 
		return contador;
	}

	private boolean estanOrdenados(List<VOBusSalida> buses) {
		VOBusSalida busAnterior = null;
		String matricula;
		String matriculaAnterior;
		boolean ordenados = true;
		
		for (VOBusSalida bus : buses) {
			if (busAnterior != null) {
				matricula = bus.getMatricula();
				matriculaAnterior = busAnterior.getMatricula();
				ordenados = matricula.compareTo(matriculaAnterior) > 0;
				if (!ordenados) {
					break;
				}
			}
		}
		
		return ordenados;
	}

	private void probarRegistrarExcursion(ContadorPruebas contadorGeneral) {
		ContadorPruebas contador;
		try {
			contador = probarRegistrarExcursion();
			contadorGeneral.sumarContador(contador);
		} catch (Exception e) {
			impresora.imprimirLinea("Excepcion inesperada:");
			impresora.imprimirLinea(e.getMessage());
			e.printStackTrace();
		}
	}

	private ContadorPruebas probarRegistrarExcursion() throws RemoteException, YaExisteBusException, CapacidadInsuficienteException, BusInexistenteException {
		ContadorPruebas contador = new ContadorPruebas();
		Fachada fachada;
		boolean resultado;
		VOExcursionEntrada voExcursion;
		VOExcursionSalida voExcursionSalida;
		List<VOExcursionSalida> excursiones;
		Date fechaHoraPartida;
		Date fechaHoraRegreso;
		VOBusEntrada voBus;
		
		impresora.imprimirEncabezadoSeccion("registrarExcursion(VOExcursionEntrada voExcursion)"); 
		
		// Prueba 4.1 : No hay buses disponibles porque no se registraron
		// Resultado esperado: NoHayBusesDisponiblesException
		fachada = new Fachada();
		fechaHoraPartida = FechaHora.obtenerFechaHora(30, 1, 2017, 10, 30);
		fechaHoraRegreso = FechaHora.obtenerFechaHora(30, 1, 2017, 19, 00);
		voExcursion = new VOExcursionEntrada("EX1", "Destino 1", fechaHoraPartida,
				fechaHoraRegreso, BigDecimal.valueOf(100.0));
		try {
			fachada.registrarExcursion(voExcursion);
			resultado = false;
		} catch (NoHayBusesDisponiblesException e) {
			resultado = true;
		} catch (YaExisteExcursionException e) {
			// No debería pasar
			resultado = false;
			e.printStackTrace();
		} catch (PeriodoInvalidoException e) {
			// No debería pasar
			resultado = false;
		}
		contador.agregarResultadoPrueba(resultado);
		impresora.imprimirResultadoIndividual("Prueba 4.1", resultado);
		
		// Prueba 4.2 : No hay buses disponibles porque estan ocupados
		// Resultado esperado: NoHayBusesDisponiblesException
		fachada = new Fachada();
		voBus = new VOBusEntrada("222", "Marca 2", 10);
		fachada.registrarBus(voBus);
		fechaHoraPartida = FechaHora.obtenerFechaHora(30, 1, 2017, 10, 30);
		fechaHoraRegreso = FechaHora.obtenerFechaHora(30, 1, 2017, 19, 00);
		voExcursion = new VOExcursionEntrada("EX21", "Destino 21", fechaHoraPartida,
				fechaHoraRegreso, BigDecimal.valueOf(100.0));
		try {
			fachada.registrarExcursion(voExcursion);
		} catch (YaExisteExcursionException | NoHayBusesDisponiblesException
				| PeriodoInvalidoException e1) {
			// No debería pasar
			e1.printStackTrace();
		}
		fechaHoraPartida = FechaHora.obtenerFechaHora(30, 1, 2017, 15, 30);
		fechaHoraRegreso = FechaHora.obtenerFechaHora(30, 1, 2017, 21, 00);
		voExcursion = new VOExcursionEntrada("EX22", "Destino 22", fechaHoraPartida,
				fechaHoraRegreso, BigDecimal.valueOf(100.0));
		try {
			fachada.registrarExcursion(voExcursion);
			resultado = false;
		} catch (NoHayBusesDisponiblesException e) {
			resultado = true;
		} catch (YaExisteExcursionException e) {
			// No debería pasar
			resultado = false;
			e.printStackTrace();
		} catch (PeriodoInvalidoException e) {
			// No debería pasar
			resultado = false;
		}
		contador.agregarResultadoPrueba(resultado);
		impresora.imprimirResultadoIndividual("Prueba 4.2", resultado);
		
		// Prueba 4.3 : Excursion con periodo invalido
		// Resultado esperado: PeriodoInvalidoException
		fachada = new Fachada();
		voBus = new VOBusEntrada("333", "Marca 3", 10);
		fachada.registrarBus(voBus);
		fechaHoraPartida = FechaHora.obtenerFechaHora(30, 1, 2017, 10, 30);
		fechaHoraRegreso = FechaHora.obtenerFechaHora(30, 1, 2017, 19, 00);
		voExcursion = new VOExcursionEntrada("EX3", "Destino 3", fechaHoraRegreso,
				fechaHoraPartida, BigDecimal.valueOf(100.0));
		try {
			fachada.registrarExcursion(voExcursion);
			resultado = false;
		} catch (PeriodoInvalidoException e) {
			resultado = true;
		} catch (NoHayBusesDisponiblesException e) {
			// No debería pasar
			resultado = false;
		} catch (YaExisteExcursionException e) {
			// No debería pasar
			resultado = false;
			e.printStackTrace();
		}
		contador.agregarResultadoPrueba(resultado);
		impresora.imprimirResultadoIndividual("Prueba 4.3", resultado);
		
		// Prueba 4.4 : Ya existe excursion
		// Resultado esperado: YaExisteExcursionException
		fachada = new Fachada();
		voBus = new VOBusEntrada("444", "Marca 4", 10);
		fachada.registrarBus(voBus);
		fechaHoraPartida = FechaHora.obtenerFechaHora(30, 1, 2017, 10, 30);
		fechaHoraRegreso = FechaHora.obtenerFechaHora(30, 1, 2017, 19, 00);
		voExcursion = new VOExcursionEntrada("EX41", "Destino 41", fechaHoraPartida,
				fechaHoraRegreso, BigDecimal.valueOf(100.0));
		try {
			fachada.registrarExcursion(voExcursion);
		} catch (YaExisteExcursionException | NoHayBusesDisponiblesException
				| PeriodoInvalidoException e1) {
			// No debería pasar
			e1.printStackTrace();
		}
		fechaHoraPartida = FechaHora.obtenerFechaHora(30, 3, 2017, 10, 30);
		fechaHoraRegreso = FechaHora.obtenerFechaHora(30, 3, 2017, 11, 00);
		voExcursion = new VOExcursionEntrada("EX41", "Destino 42", fechaHoraPartida,
				fechaHoraRegreso, BigDecimal.valueOf(200.0));
		try {
			fachada.registrarExcursion(voExcursion);
			resultado = false;
		} catch (YaExisteExcursionException e) {
			resultado = true;
		} catch (NoHayBusesDisponiblesException e) {
			// No debería pasar
			resultado = false;
			e.printStackTrace();
		} catch (PeriodoInvalidoException e) {
			// No debería pasar
			resultado = false;
		}
		contador.agregarResultadoPrueba(resultado);
		impresora.imprimirResultadoIndividual("Prueba 4.4", resultado);
		
		// Prueba 4.5 : Registrar una excursion correcta
		// Resultado esperado: registro correcto
		fachada = new Fachada();
		voBus = new VOBusEntrada("555", "Marca 5", 10);
		fachada.registrarBus(voBus);
		fechaHoraPartida = FechaHora.obtenerFechaHora(30, 1, 2017, 10, 30);
		fechaHoraRegreso = FechaHora.obtenerFechaHora(30, 1, 2017, 19, 00);
		voExcursion = new VOExcursionEntrada("EX5", "Destino 5", fechaHoraPartida,
				fechaHoraRegreso, BigDecimal.valueOf(100.0));
		try {
			fachada.registrarExcursion(voExcursion);
		} catch (YaExisteExcursionException | NoHayBusesDisponiblesException
				| PeriodoInvalidoException e1) {
			// No debería pasar
			e1.printStackTrace();
		}
		excursiones = fachada.listarExcursionesBus("555");
		voExcursionSalida = new VOExcursionSalida("EX5", "Destino 5", fechaHoraPartida,
				fechaHoraRegreso, BigDecimal.valueOf(100.0), 10);
		resultado = excursiones.size() == 1 && excursiones.contains(voExcursionSalida);
		contador.agregarResultadoPrueba(resultado);
		impresora.imprimirResultadoIndividual("Prueba 4.5", resultado);
		
		// Prueba 4.6 : Registrar varias excursiones correctas
		// Resultado esperado: registro correcto
		fachada = new Fachada();
		voBus = new VOBusEntrada("666", "Marca 6", 10);
		fachada.registrarBus(voBus);
		fechaHoraPartida = FechaHora.obtenerFechaHora(30, 1, 2017, 10, 30);
		fechaHoraRegreso = FechaHora.obtenerFechaHora(30, 1, 2017, 19, 00);
		voExcursion = new VOExcursionEntrada("EX61", "Destino 61", fechaHoraPartida,
				fechaHoraRegreso, BigDecimal.valueOf(100.0));
		try {
			fachada.registrarExcursion(voExcursion);
			fechaHoraPartida = FechaHora.obtenerFechaHora(30, 3, 2017, 10, 30);
			fechaHoraRegreso = FechaHora.obtenerFechaHora(30, 3, 2017, 19, 00);
			voExcursion = new VOExcursionEntrada("EX62", "Destino 62", fechaHoraPartida,
					fechaHoraRegreso, BigDecimal.valueOf(200.0));
			fachada.registrarExcursion(voExcursion);
			fechaHoraPartida = FechaHora.obtenerFechaHora(30, 4, 2017, 10, 30);
			fechaHoraRegreso = FechaHora.obtenerFechaHora(30, 4, 2017, 19, 00);
			voExcursion = new VOExcursionEntrada("EX63", "Destino 63", fechaHoraPartida,
					fechaHoraRegreso, BigDecimal.valueOf(300.0));
			fachada.registrarExcursion(voExcursion);
		} catch (YaExisteExcursionException | NoHayBusesDisponiblesException
				| PeriodoInvalidoException e1) {
			// No debería pasar
			e1.printStackTrace();
		}
		excursiones = fachada.listarExcursionesBus("666");
		voExcursionSalida = new VOExcursionSalida("EX61", "Destino 61", fechaHoraPartida,
				fechaHoraRegreso, BigDecimal.valueOf(100.0), 10);
		resultado = excursiones.size() == 3 && excursiones.contains(voExcursionSalida);
		voExcursionSalida = new VOExcursionSalida("EX62", "Destino 62", fechaHoraPartida,
				fechaHoraRegreso, BigDecimal.valueOf(200.0), 10);
		resultado = resultado && excursiones.contains(voExcursionSalida);
		voExcursionSalida = new VOExcursionSalida("EX63", "Destino 63", fechaHoraPartida,
				fechaHoraRegreso, BigDecimal.valueOf(300.0), 10);
		resultado = resultado && excursiones.contains(voExcursionSalida);
		contador.agregarResultadoPrueba(resultado);
		impresora.imprimirResultadoIndividual("Prueba 4.6", resultado);
		
		
		impresora.imprimirResultadoSeccion(contador);
		 
		return contador;
	}
	
	private void probarListarExcursionesBus(ContadorPruebas contadorGeneral) {
		ContadorPruebas contador;
		try {
			contador = probarListarExcursionesBus();
			contadorGeneral.sumarContador(contador);
		} catch (Exception e) {
			impresora.imprimirLinea("Excepcion inesperada:");
			impresora.imprimirLinea(e.getMessage());
			e.printStackTrace();
		}
	}

	private ContadorPruebas probarListarExcursionesBus() throws RemoteException, YaExisteBusException, CapacidadInsuficienteException, YaExisteExcursionException, NoHayBusesDisponiblesException, PeriodoInvalidoException, BusInexistenteException {
		ContadorPruebas contador = new ContadorPruebas();
		Fachada fachada;
		boolean resultado;
		VOBusEntrada voBus;
		Date fechaHoraPartida;
		Date fechaHoraRegreso;
		VOExcursionEntrada voExcursion;
		VOExcursionSalida voExcursionSalida;
		List<VOExcursionSalida> excursiones;
		
		impresora.imprimirEncabezadoSeccion("listarBuses()"); 
		
		// Prueba 5.1 : Listar excursiones sin excursiones registradas
		// Resultado esperado: lista vacia
		fachada = new Fachada();
		voBus = new VOBusEntrada("111", "Marca 1", 10);
		fachada.registrarBus(voBus);
		try {
			resultado = fachada.listarExcursionesBus("111").isEmpty();
			contador.agregarResultadoPrueba(resultado);
			impresora.imprimirResultadoIndividual("Prueba 5.1", resultado);
		} catch (RemoteException | BusInexistenteException e) {
			// No debería pasar
			resultado = false;
			contador.agregarResultadoPrueba(resultado);
			impresora.imprimirResultadoIndividual("Prueba 5.1", resultado);
			e.printStackTrace();
		}
		
		// Prueba 5.2 : Listar excursiones con una excursion registrada
		// Resultado esperado: lista con la excursion registrada
		fachada = new Fachada();
		voBus = new VOBusEntrada("222", "Marca 2", 10);
		fachada.registrarBus(voBus);
		fechaHoraPartida = FechaHora.obtenerFechaHora(30, 1, 2017, 10, 30);
		fechaHoraRegreso = FechaHora.obtenerFechaHora(30, 1, 2017, 19, 00);
		voExcursion = new VOExcursionEntrada("EX2", "Destino 2", fechaHoraPartida,
				fechaHoraRegreso, BigDecimal.valueOf(200.0));
		fachada.registrarExcursion(voExcursion);
		try {
			excursiones = fachada.listarExcursionesBus("222");
			voExcursionSalida = new VOExcursionSalida("EX2", "Destino 2", fechaHoraPartida,
				fechaHoraRegreso, BigDecimal.valueOf(200.0), 10);
			resultado = excursiones.size() == 1 && excursiones.contains(voExcursionSalida);
			contador.agregarResultadoPrueba(resultado);
			impresora.imprimirResultadoIndividual("Prueba 5.2", resultado);
		} catch (BusInexistenteException e) {
			// No debería pasar
			resultado = false;
			contador.agregarResultadoPrueba(resultado);
			impresora.imprimirResultadoIndividual("Prueba 5.2", resultado);
			e.printStackTrace();
		}
		
		// Prueba 5.3 : Listar excursiones con varias excursiones registradas en orden
		// Resultado esperado: lista con las excursiones ordenadas
		fachada = new Fachada();
		voBus = new VOBusEntrada("333", "Marca 3", 10);
		fachada.registrarBus(voBus);
		fechaHoraPartida = FechaHora.obtenerFechaHora(30, 1, 2017, 10, 30);
		fechaHoraRegreso = FechaHora.obtenerFechaHora(30, 1, 2017, 19, 00);
		voExcursion = new VOExcursionEntrada("EX31", "Destino 31", fechaHoraPartida,
				fechaHoraRegreso, BigDecimal.valueOf(100.0));
		fachada.registrarExcursion(voExcursion);
		fechaHoraPartida = FechaHora.obtenerFechaHora(30, 3, 2017, 10, 30);
		fechaHoraRegreso = FechaHora.obtenerFechaHora(30, 3, 2017, 19, 00);
		voExcursion = new VOExcursionEntrada("EX32", "Destino 32", fechaHoraPartida,
				fechaHoraRegreso, BigDecimal.valueOf(200.0));
		fachada.registrarExcursion(voExcursion);
		fechaHoraPartida = FechaHora.obtenerFechaHora(30, 4, 2017, 10, 30);
		fechaHoraRegreso = FechaHora.obtenerFechaHora(30, 4, 2017, 19, 00);
		voExcursion = new VOExcursionEntrada("EX33", "Destino 33", fechaHoraPartida,
				fechaHoraRegreso, BigDecimal.valueOf(300.0));
		fachada.registrarExcursion(voExcursion);
		
		excursiones = fachada.listarExcursionesBus("333");
		voExcursionSalida = new VOExcursionSalida("EX31", "Destino 31", fechaHoraPartida,
				fechaHoraRegreso, BigDecimal.valueOf(100.0), 10);
		resultado = excursiones.size() == 3 && excursiones.contains(voExcursionSalida);
		voExcursionSalida = new VOExcursionSalida("EX32", "Destino 32", fechaHoraPartida,
				fechaHoraRegreso, BigDecimal.valueOf(200.0), 10);
		resultado = resultado && excursiones.contains(voExcursionSalida);
		voExcursionSalida = new VOExcursionSalida("EX33", "Destino 33", fechaHoraPartida,
				fechaHoraRegreso, BigDecimal.valueOf(300.0), 10);
		resultado = resultado && excursiones.contains(voExcursionSalida);
		resultado = resultado && estanOrdenadas(excursiones);
		contador.agregarResultadoPrueba(resultado);
		impresora.imprimirResultadoIndividual("Prueba 5.3", resultado);
		
		// Prueba 5.4 : Listar buses con varios buses registrados en desorden
		// Resultado esperado: lista con los buses ordenados
		fachada = new Fachada();
		voBus = new VOBusEntrada("333", "Marca 3", 10);
		fachada.registrarBus(voBus);
		fechaHoraPartida = FechaHora.obtenerFechaHora(30, 3, 2017, 10, 30);
		fechaHoraRegreso = FechaHora.obtenerFechaHora(30, 3, 2017, 19, 00);
		voExcursion = new VOExcursionEntrada("EX32", "Destino 32", fechaHoraPartida,
				fechaHoraRegreso, BigDecimal.valueOf(200.0));
		fachada.registrarExcursion(voExcursion);
		fechaHoraPartida = FechaHora.obtenerFechaHora(30, 1, 2017, 10, 30);
		fechaHoraRegreso = FechaHora.obtenerFechaHora(30, 1, 2017, 19, 00);
		voExcursion = new VOExcursionEntrada("EX31", "Destino 31", fechaHoraPartida,
				fechaHoraRegreso, BigDecimal.valueOf(100.0));
		fachada.registrarExcursion(voExcursion);
		fechaHoraPartida = FechaHora.obtenerFechaHora(30, 4, 2017, 10, 30);
		fechaHoraRegreso = FechaHora.obtenerFechaHora(30, 4, 2017, 19, 00);
		voExcursion = new VOExcursionEntrada("EX33", "Destino 33", fechaHoraPartida,
				fechaHoraRegreso, BigDecimal.valueOf(300.0));
		fachada.registrarExcursion(voExcursion);
		
		excursiones = fachada.listarExcursionesBus("333");
		voExcursionSalida = new VOExcursionSalida("EX31", "Destino 31", fechaHoraPartida,
				fechaHoraRegreso, BigDecimal.valueOf(100.0), 10);
		resultado = excursiones.size() == 3 && excursiones.contains(voExcursionSalida);
		voExcursionSalida = new VOExcursionSalida("EX32", "Destino 32", fechaHoraPartida,
				fechaHoraRegreso, BigDecimal.valueOf(200.0), 10);
		resultado = resultado && excursiones.contains(voExcursionSalida);
		voExcursionSalida = new VOExcursionSalida("EX33", "Destino 33", fechaHoraPartida,
				fechaHoraRegreso, BigDecimal.valueOf(300.0), 10);
		resultado = resultado && excursiones.contains(voExcursionSalida);
		resultado = resultado && estanOrdenadas(excursiones);
		contador.agregarResultadoPrueba(resultado);
		impresora.imprimirResultadoIndividual("Prueba 5.4", resultado);
	
		impresora.imprimirResultadoSeccion(contador);
		 
		return contador;
	}
	
	private boolean estanOrdenadas(List<VOExcursionSalida> excursiones) {
		VOExcursionSalida excursionAnterior = null;
		String codigo;
		String codigoAnterior;
		boolean ordenados = true;
		
		for (VOExcursionSalida excursion : excursiones) {
			if (excursionAnterior != null) {
				codigo = excursion.getCodigo();
				codigoAnterior = excursionAnterior.getCodigo();
				ordenados = codigo.compareTo(codigoAnterior) > 0;
				if (!ordenados) {
					break;
				}
			}
		}
		
		return ordenados;
	}
}
