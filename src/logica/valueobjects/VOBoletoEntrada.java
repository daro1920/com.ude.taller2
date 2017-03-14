package logica.valueobjects;

import java.io.Serializable;

public class VOBoletoEntrada extends VOBoleto implements Serializable {

    private String codigoExcursion;

    public VOBoletoEntrada(String codigoExcursion,int edad,String procedencia,String celular) {
        super(edad,procedencia,celular);
        this.codigoExcursion = codigoExcursion;
    }

    public String getCodigoExcursion() {
        return codigoExcursion;
    }

}
