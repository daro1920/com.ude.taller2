package valueobjects;

public class VOBoletoSalida extends VOBoleto {


    private int numero;

    public VOBoletoSalida(int numero,int edad,String procedencia,String celular){
        super(edad,procedencia,celular);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
}
