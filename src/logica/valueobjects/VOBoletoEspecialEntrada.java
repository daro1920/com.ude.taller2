package logica.valueobjects;

public class VOBoletoEspecialEntrada extends VOBoletoEntrada {

    private double descuento;

    public VOBoletoEspecialEntrada(double descuento,String codigoExcursion,int edad,String procedencia,String celular) {
        super( codigoExcursion,edad,procedencia,celular);
        this.descuento = descuento;
    }

    public double getDescuento() {
        return descuento;
    }

}
