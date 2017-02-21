package valueobjects;

public class VOBoletoEspecialSalida  extends VOBoletoSalida {

    private double descuento;

    public VOBoletoEspecialSalida(double descuento, int numero,int edad,String procedencia,String celular) {
        super( numero,edad,procedencia,celular);
        this.descuento = descuento;
    }

    public double getDescuento() {
        return descuento;
    }
}
