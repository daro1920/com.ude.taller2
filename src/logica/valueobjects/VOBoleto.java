package logica.valueobjects;

public abstract class VOBoleto {

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
