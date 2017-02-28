package pruebas;

import java.io.PrintStream;

public class ImpresoraPruebas {
	
	private PrintStream out;
	
	public ImpresoraPruebas() {
		out = System.out;
	}
	
	public void imprimirEncabezadoGeneral(String texto) {
		out.println("############################################################");
		out.println(texto);
		out.println("############################################################");
		out.println("");
	}
	
	public void imprimirResultadoGeneral(String texto, ContadorPruebas contador) {
		out.println("");
		out.println("############################################################");
		out.println(texto);
		out.println("Pasadas: " + contador.getPasadas());
		out.println("Falladas: " + contador.getFalladas());
		out.println("Total: " + contador.getTotal());
		out.println("############################################################");
		out.println("");
	}
	
	public void imprimirEncabezadoSeccion(String texto) {
		out.println("------------------------------------------------------------");
		out.println(texto);
		out.println("------------------------------------------------------------");
		out.println("");
	}
	
	public void imprimirResultadoSeccion(ContadorPruebas contador) {
		out.println("");
		out.println("------------------------------------------------------------");
		out.println("Pasadas: " + contador.getPasadas());
		out.println("Falladas: " + contador.getFalladas());
		out.println("Total: " + contador.getTotal());
		out.println("------------------------------------------------------------");
		out.println("");
	}
	
	public void imprimirResultadoIndividual(String nombrePrueba, boolean pasada) {
		String resultado = pasada ? "pasada" : "fallada";
		out.println(nombrePrueba + ": " + resultado);
	}
	
	public void imprimirLinea(String texto) {
		out.println(texto);
	}

}
