package logica.valueobjects;

import java.math.BigDecimal;

public class VOBoletoEspecialSalida extends VOBoletoSalida {

	private	BigDecimal descuento;

    public VOBoletoEspecialSalida(int numero,int edad, String procedencia, String celular, BigDecimal descuento) {
        super(numero, edad, procedencia, celular);
        this.descuento = descuento;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }
    
}
