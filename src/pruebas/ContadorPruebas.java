package pruebas;

public class ContadorPruebas {
	
	private int pasadas;
	private int falladas;
	
	public ContadorPruebas() {
		pasadas = 0;
		falladas = 0;
	}
	
	public int getPasadas() {
		return pasadas;
	}
	
	public int getFalladas() {
		return falladas;
	}
	
	public int getTotal() {
		return pasadas + falladas;
	}
	
	public void agregarPasada() {
		pasadas ++;
	}
	
	public void agregarFallada() {
		falladas ++;
	}
	
	public void sumarContador(ContadorPruebas contador) {
		pasadas += contador.getPasadas();
		falladas += contador.getFalladas();
	}
	
	public void agregarResultadoPrueba(boolean pasada) {
		if (pasada) {
			agregarPasada();
		} else {
			agregarFallada();
		}
	}

}
