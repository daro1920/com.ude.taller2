package logica.valueobjects;

import java.math.BigDecimal;
import java.util.Date;

public class VOExcursionSalida extends VOExcursionEntrada implements Comparable<VOExcursionSalida> {

	private int asientosDisponibles;
	
	public VOExcursionSalida(String codigo, String destino, Date fechaHoraPartida,
			Date fechaHoraRegreso, BigDecimal precioBase, int asientosDisponibles) {
		super(codigo, destino, fechaHoraPartida, fechaHoraRegreso, precioBase);
		this.asientosDisponibles = asientosDisponibles;
	}
	
	public int getAsientosDisponibles() {
		return this.asientosDisponibles;
	}

	@Override
	public int compareTo(VOExcursionSalida otraExcursion) {
		return this.getCodigo().compareTo(otraExcursion.getCodigo());
	}
}
