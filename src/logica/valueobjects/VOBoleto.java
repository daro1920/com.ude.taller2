package logica.valueobjects;

import java.io.Serializable;

public abstract class VOBoleto implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int edad;
    private String procedencia;
    private String celular;

    public VOBoleto(int edad,String procedencia,String celular) {

        this.edad = edad;
        this.procedencia = procedencia;
        this.celular = celular;
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

}
