package logica.valueobjects;

public class VOBoletoEntrada extends VOBoleto {

    private String codigoExcursion;

    public VOBoletoEntrada(String codigoExcursion,int edad,String procedencia,String celular) {
        super(edad,procedencia,celular);
        this.codigoExcursion = codigoExcursion;
    }

    public String getCodigoExcursion() {
        return codigoExcursion;
    }

}
