package logica.negocio;

import java.math.BigDecimal;

public class BoletoEspecial extends Boleto {

    private BigDecimal descuento;

    public BoletoEspecial(int numero, int edad, String procedencia, String celular, BigDecimal descuento) {

        super(numero,edad,procedencia,celular);
        this.descuento = descuento;

    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public BigDecimal getPrecioFinal(BigDecimal precioBase) {

        return super.getPrecioFinal(precioBase).subtract(descuento);
        
    }
}
