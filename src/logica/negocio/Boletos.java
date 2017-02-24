package logica.negocio;

import java.util.ArrayList;
import java.util.List;

public class Boletos {

    private List<Boleto> boletos =  new ArrayList();

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

}
