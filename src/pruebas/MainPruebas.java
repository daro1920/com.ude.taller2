package pruebas;


public class MainPruebas {
	
	public static void main(String[] args) {
		
		correrPruebasExcursion();
		
	}

	private static void correrPruebasExcursion() {

//		PruebasExcursion pruebasExcursion = new PruebasExcursion();
//		pruebasExcursion.correrPruebas();
//
//		PruebasBoletos pruebasBoletos = new PruebasBoletos();
//		pruebasBoletos.correrPruebas();
		
		PruebasFachada pruebasFachada = new PruebasFachada();
		pruebasFachada.correrPruebas();

	} 

}
