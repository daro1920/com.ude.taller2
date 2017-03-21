package logica.valueobjects;

import java.io.Serializable;

public class VOBoletoEntrada extends VOBoleto  {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigoExcursion;

    public VOBoletoEntrada(String codigoExcursion,int edad,String procedencia,String celular) {
        super(edad,procedencia,celular);
        this.codigoExcursion = codigoExcursion;
    }

    public String getCodigoExcursion() {
        return codigoExcursion;
    }

}
