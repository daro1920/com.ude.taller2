package logica.valueobjects;

import java.math.BigDecimal;

public class VOBoletoEspecialEntrada extends VOBoletoEntrada {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal descuento;

    public VOBoletoEspecialEntrada(BigDecimal descuento, String codigoExcursion,
    		int edad, String procedencia, String celular) {
        super( codigoExcursion,edad,procedencia,celular);
        this.descuento = descuento;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

}
