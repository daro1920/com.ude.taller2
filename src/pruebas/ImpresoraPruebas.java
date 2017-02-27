package pruebas;

public class ImpresoraPruebas {
	
	public ImpresoraPruebas() {
		
	}
	
	public void imprimirEncabezadoGeneral(String texto) {
		System.out.println("############################################################");
		System.out.println(texto);
		System.out.println("############################################################");
		System.out.println("");
	}
	
	public void imprimirResultadoGeneral(String texto, ContadorPruebas contador) {
		System.out.println("");
		System.out.println("############################################################");
		System.out.println(texto);
		System.out.println("Pasadas: " + contador.getPasadas());
		System.out.println("Falladas: " + contador.getFalladas());
		System.out.println("Total: " + contador.getTotal());
		System.out.println("############################################################");
		System.out.println("");
	}
	
	public void imprimirEncabezadoSeccion(String texto) {
		System.out.println("------------------------------------------------------------");
		System.out.println(texto);
		System.out.println("------------------------------------------------------------");
		System.out.println("");
	}
	
	public void imprimirResultadoSeccion(ContadorPruebas contador) {
		System.out.println("");
		System.out.println("------------------------------------------------------------");
		System.out.println("Pasadas: " + contador.getPasadas());
		System.out.println("Falladas: " + contador.getFalladas());
		System.out.println("Total: " + contador.getTotal());
		System.out.println("------------------------------------------------------------");
		System.out.println("");
	}
	
	public void imprimirResultadoIndividual(String nombrePrueba, boolean pasada) {
		String resultado = pasada ? "pasada" : "fallada";
		System.out.println(nombrePrueba + ": " + resultado);
	}

}
