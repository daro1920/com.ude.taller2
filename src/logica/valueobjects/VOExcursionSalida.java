package logica.valueobjects;

import java.math.BigDecimal;
import java.util.Date;

public class VOExcursionSalida extends VOExcursionEntrada implements Comparable<VOExcursionSalida> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int asientosDisponibles;
	
	public VOExcursionSalida(String codigo, String destino, Date fechaHoraPartida,
			Date fechaHoraRegreso, BigDecimal precioBase, int asientosDisponibles) {
		super(codigo, destino, fechaHoraPartida, fechaHoraRegreso, precioBase);
		this.asientosDisponibles = asientosDisponibles;
	}
	
	
	
	public int getAsientosDisponibles() {
		return asientosDisponibles;
	}



	public void setAsientosDisponibles(int asientosDisponibles) {
		this.asientosDisponibles = asientosDisponibles;
	}



	@Override
	public boolean equals(Object obj) {
		return obj != null
				&& obj instanceof VOExcursionSalida
				&& ((VOExcursionSalida)obj).getCodigo().equals(this.getCodigo());
	}

	@Override
	public int compareTo(VOExcursionSalida otraExcursion) {
		return this.getCodigo().compareTo(otraExcursion.getCodigo());
	}

}