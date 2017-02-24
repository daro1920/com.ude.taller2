
package logica.negocio;

import java.math.BigDecimal;

public class Boleto {

    private int numero;
    private int edad;
    private String procedencia;
    private String celular;

    public Boleto(int numero, int edad, String procedencia, String celular){

        this.numero = numero;
        this.edad = edad;
        this.procedencia = procedencia;
        this.celular = celular;

    }

    public int getNumero() {
        return numero;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public String getProcedencia() {
        return procedencia;
    }
    
    public String getCelular() {
        return celular;
    }

    public BigDecimal getPrecioFinal(BigDecimal precioBase) {

        BigDecimal precioFinal = edad > 12 ? precioBase : precioBase.multiply(BigDecimal.valueOf(0.80));

        return precioFinal;
    }
}
