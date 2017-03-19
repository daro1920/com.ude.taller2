package logica.valueobjects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class VOExcursionEntrada implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Date getFechaHoraPartida() {
		return fechaHoraPartida;
	}

	public void setFechaHoraPartida(Date fechaHoraPartida) {
		this.fechaHoraPartida = fechaHoraPartida;
	}

	public Date getFechaHoraRegreso() {
		return fechaHoraRegreso;
	}

	public void setFechaHoraRegreso(Date fechaHoraRegreso) {
		this.fechaHoraRegreso = fechaHoraRegreso;
	}

	public BigDecimal getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(BigDecimal precioBase) {
		this.precioBase = precioBase;
	}

	
}
