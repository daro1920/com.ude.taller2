package logica.negocio;

public class BoletoEspecial extends Boleto {

    private int descuento;

    public BoletoEspecial(int numero, int edad, String procedencia,String celular,int descuento) {

        super(numero,edad,procedencia,celular);
        this.descuento = descuento;

    }

    public int getDescuento() {
        return descuento;
    }

    public double getPrecioFinal(double precioBase){

        return super.getPrecioFinal(precioBase) - descuento;
    }
}
