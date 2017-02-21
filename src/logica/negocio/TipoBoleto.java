package logica.negocio;

public enum TipoBoleto {

    COMUN("Comun"),
    ESPECIAL("Especial");

    private final String tipo;

    private TipoBoleto(String type) {
        this.tipo = type;
    }

    @Override
    public String toString() {
        return tipo;
    }
}
