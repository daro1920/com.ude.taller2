package logica.valueobjects;


public class VOBusSalida extends VOBusEntrada implements Comparable<VOBusSalida>{

	private int cantidadExcursiones;
	
	public VOBusSalida(String matricula, String marca, int capacidad, int cantidadExcursiones) {
		super(matricula, marca, capacidad);
		this.cantidadExcursiones = cantidadExcursiones;
	}
	
	public int getCantidadExcursiones() {
		return this.cantidadExcursiones;
	}
	
	@Override
	public boolean equals(Object obj ){
		return obj != null
				&& obj instanceof VOBusSalida
				&& ((VOBusSalida)obj).getMatricula().equals(this.getMatricula());

	}
	
	@Override
	public int compareTo(VOBusSalida otroBus) {
		return this.getMatricula().compareTo(otroBus.getMatricula());
	}
}
