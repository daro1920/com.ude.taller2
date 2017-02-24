package logica.negocio;

import valueobjects.VOBoleto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Boletos {

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


    public VOBoleto listarBoletos(){
        //TODO falta implementacion
        return null;
    }

    public BigDecimal getRecaudacion(BigDecimal pre){
        //TODO falta implementac9oion
        return null;
    }
}