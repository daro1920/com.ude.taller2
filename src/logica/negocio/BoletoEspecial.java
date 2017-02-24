package logica.negocio;

import java.math.BigDecimal;

import logica.valueobjects.VOBoletoEspecialSalida;
import logica.valueobjects.VOBoletoSalida;

public class BoletoEspecial extends Boleto {

    private BigDecimal descuento;

    public BoletoEspecial(int numero, int edad, String procedencia, String celular, BigDecimal descuento) {

        super(numero,edad,procedencia,celular);
        this.descuento = descuento;

    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    @Override
    public BigDecimal getPrecioFinal(BigDecimal precioBase) {

        return super.getPrecioFinal(precioBase).subtract(descuento);
        
    }
    
    @Override
    public VOBoletoSalida voSalida() {
    	return new VOBoletoEspecialSalida(getNumero(), getEdad(), getProcedencia(), getCelular(), descuento);
    }
}
