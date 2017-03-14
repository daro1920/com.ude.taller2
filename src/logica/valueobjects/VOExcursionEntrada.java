package logica.valueobjects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class VOExcursionEntrada implements Serializable {
	
	private	String 	codigo;
	private	String	destino;
	private Date	fechaHoraPartida;
	private	Date	fechaHoraRegreso;
	private BigDecimal precioBase;
	
	public VOExcursionEntrada(String codigo, String destino, Date fechaHoraPartida,
			Date fechaHoraRegreso, BigDecimal precioBase) {

		this.codigo = codigo;
		this.destino = destino;
		this.fechaHoraPartida = fechaHoraPartida;
		this.fechaHoraRegreso = fechaHoraRegreso;
		this.precioBase = precioBase;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDestino() {
		return destino;
	}

	public Date getFechaHoraPartida() {
		return fechaHoraPartida;
	}

	public Date getFechaHoraRegreso() {
		return fechaHoraRegreso;
	}
	
	public BigDecimal getPrecioBase() {
		return this.precioBase;
	}
	
}
