package logica.negocio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import logica.valueobjects.VOBoletoEntrada;
import logica.valueobjects.VOBoletoEspecialEntrada;
import logica.valueobjects.VOBoletoSalida;
import logica.valueobjects.VOExcursionEntrada;
import logica.valueobjects.VOExcursionSalida;

@SuppressWarnings("serial")
public class Excursion implements Serializable {
	
	private	String		codigo;
	private	String		destino;
  	private Date 		fechaHoraPartida;
	private Date		fechaHoraRegreso;
	private BigDecimal	precioBase;
	private Bus			bus;
	private Boletos		boletos;
	private int			proximoNroBoleto;

	public Excursion(String codigo, String destino, Date fechaHoraPartida,
			Date fechaHoraRegreso, BigDecimal precioBase, Bus bus) {
		this.codigo = codigo;
		this.destino = destino;
		this.fechaHoraPartida = fechaHoraPartida;
		this.fechaHoraRegreso = fechaHoraRegreso;
		this.precioBase = precioBase;
		this.bus = bus;
		
		this.boletos = new Boletos();
		this.proximoNroBoleto = 1;
	}
	
	public Excursion(VOExcursionEntrada voExcursion, Bus bus) {
		this(voExcursion.getCodigo(), voExcursion.getDestino(), voExcursion.getFechaHoraPartida(),
				voExcursion.getFechaHoraRegreso(), voExcursion.getPrecioBase(), bus);
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
		return precioBase;
	}

	public Bus getBus() {
		return bus;
	}
	
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	
	public List<VOBoletoSalida> listarBoletos(TipoBoleto tipo) {
		return boletos.listarBoletos(tipo);
	}

	public int cantidadAsientosDisponibles() {
		return bus.getCapacidad() - boletos.largo();
	}
	
	public boolean hayAsientosDisponibles() {
		return cantidadAsientosDisponibles() > 0;
	}
	
	public BigDecimal recaudacion() {
		return boletos.recaudacion(precioBase);
	}
	
	public boolean colisionaCon(Excursion otraExcursion) {
		return otraExcursion.fechaHoraRegreso.compareTo(this.fechaHoraPartida) > 0
				&& otraExcursion.fechaHoraPartida.compareTo(this.fechaHoraRegreso) < 0;
	}
	
	public boolean vaHacia(String destino) {
		return this.destino.equals(destino);
	}
	
	public boolean precioEntre(BigDecimal precioMin, BigDecimal precioMax) {
		return this.precioBase.compareTo(precioMin) >= 0
				&& this.precioBase.compareTo(precioMax) <= 0;
	}
	
	public void agregarBoleto(VOBoletoEntrada voBoleto) {
		
		Boleto boleto;
		
		if (esBoletoEspecial(voBoleto)) {
			VOBoletoEspecialEntrada voBoletoEspecial = (VOBoletoEspecialEntrada)voBoleto;
			boleto = new BoletoEspecial(proximoNroBoleto, voBoletoEspecial.getEdad(),
					voBoletoEspecial.getProcedencia(), voBoletoEspecial.getCelular(),
					voBoletoEspecial.getDescuento());
		} else {
			boleto = new Boleto(proximoNroBoleto, voBoleto.getEdad(),
					voBoleto.getProcedencia(), voBoleto.getCelular());
		}
		
		boletos.insBack(boleto);
		
		proximoNroBoleto ++;
	}
	
	private boolean esBoletoEspecial(VOBoletoEntrada boleto) {
		return boleto instanceof VOBoletoEspecialEntrada; 
	}
	
	public VOExcursionSalida voSalida() {
		return new VOExcursionSalida(codigo, destino, fechaHoraPartida, fechaHoraRegreso,
				precioBase, cantidadAsientosDisponibles());
	}
	
	public boolean esDeBus(String matricula) {
		return bus.getMatricula().equals(matricula);
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj != null
				&& obj instanceof Excursion
				&& ((Excursion)obj).getCodigo().equals(codigo);
	}
	
}