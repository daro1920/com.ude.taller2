package logica.valueobjects;

import java.util.Date;

public abstract class VOExcursion {
	
	private	String 	codigo;
	private	String	destino;
	private Date	fechaHoraPartida;
	private	Date	fechaHoraRegreso;
	
	public VOExcursion(String codigo, String destino, Date fechaHoraPartida,
			Date fechaHoraRegreso) {
		this.codigo = codigo;
		this.destino = destino;
		this.fechaHoraPartida = fechaHoraPartida;
		this.fechaHoraRegreso = fechaHoraRegreso;
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

}
