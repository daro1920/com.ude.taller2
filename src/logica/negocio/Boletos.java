package logica.negocio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import logica.valueobjects.VOBoletoSalida;

@SuppressWarnings("serial")
public class Boletos implements Serializable {

    private List<Boleto> boletos =  new ArrayList<Boleto>();

    public void insBack(Boleto boleto){
        boletos.add(boleto);
    }

    public boolean esVacia(){
        return boletos.isEmpty();
    }

    public Boleto primero(){
        return boletos.get(0);
    }

    public void resto(){
        boletos.remove(0);
    }

    public int largo(){
        return boletos.size();
    }

    public Boleto kEsimo(int index){
        return boletos.get(index);
    }


    public List<VOBoletoSalida> listarBoletos(TipoBoleto tipo){
        
    	List<VOBoletoSalida> boletosSalida = new ArrayList<VOBoletoSalida>();
    	
    	for (Boleto boleto : boletos) {
    		if (boletoDeTipo(boleto, tipo)) {
        		boletosSalida.add(boleto.voSalida());
    		}
    	}
    	
        return boletosSalida;
    }

    private boolean boletoDeTipo(Boleto boleto, TipoBoleto tipo) {
    	boolean esDeTipo = false;
    	
    	if (tipo.equals(TipoBoleto.COMUN)) {
    		esDeTipo = boleto instanceof Boleto;
    	} else if (tipo.equals(TipoBoleto.ESPECIAL)) {
    		esDeTipo = boleto instanceof BoletoEspecial;
    	}
    	
		return esDeTipo;
	}

	public BigDecimal recaudacion(BigDecimal precioBase){
        
    	BigDecimal recaudacion = BigDecimal.ZERO;
    	
    	for (Boleto boleto : boletos) {
    		recaudacion.add(boleto.getPrecioFinal(precioBase));
    	}
    	
        return recaudacion;
    }
}