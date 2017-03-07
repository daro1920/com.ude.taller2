package pruebas;

import logica.negocio.Boleto;
import logica.negocio.BoletoEspecial;
import logica.negocio.Boletos;
import logica.negocio.TipoBoleto;
import logica.valueobjects.VOBoletoEspecialSalida;
import logica.valueobjects.VOBoletoSalida;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Dario on 3/6/2017.
 */
public class PruebasBoletos {

    private List<String> ciudades = new ArrayList<String>();
    private List<String> celulares = new ArrayList<String>();
    private BigDecimal precioBase;

    public void correrPruebas(){
        Boletos boletos = new Boletos();

        initializeValues();

        System.out.println(boletos.esVacia()?"La lista esta vacia":"La lista tiene elementos");
        System.out.println();

        insentarBoletosComunes(boletos);
        System.out.println("Listar Boletos Comunes*********************");
        listarBoletosComunes(boletos);
        System.out.println("Fin Listar Boletos Comunes*********************");
        System.out.println();

        insentarBoletosEspeciales(boletos);
        System.out.println("Listar Boletos Especiales*********************");
        listarBoletosEspeciales(boletos);
        System.out.println("Fin Listar Boletos Especiales*********************");
        System.out.println();

        System.out.println("Listar Boletos Comunes Y Especiales*********************");
        listarBoletosComunes(boletos);
        listarBoletosEspeciales(boletos);
        System.out.println("Fin Listar Boletos Comunes Y Especiales*********************");
        System.out.println();

        System.out.println(boletos.esVacia()?"La lista esta vacia":"La lista tiene elementos");
        System.out.println();

        int kEsimo =  new Random().nextInt(boletos.largo());
        Boleto boletoEsimo = boletos.kEsimo(kEsimo);
        System.out.println("Imprimo el boleto numero "+kEsimo) ;
        imprimirBoleto(boletoEsimo);

        System.out.println("El precio base es :"+precioBase);
        System.out.println();

        System.out.println("El precio final del boleto numero "+kEsimo+" es :"+boletoEsimo.getPrecioFinal(precioBase));


    }
    private void initializeValues() {

        ciudades.add("Montevideo");
        ciudades.add("Madrid");
        ciudades.add("Buenos Aires");
        ciudades.add("Rio de Janeiro");
        ciudades.add("Santiago");
        ciudades.add("Lima");
        ciudades.add("New York");
        ciudades.add("Bogota");
        ciudades.add("Mexico DF");

        celulares.add("090514416");
        celulares.add("098955441");
        celulares.add("092522351");
        celulares.add("094113025");
        celulares.add("093664256");
        celulares.add("092331423");
        celulares.add("097777888");
        celulares.add("096541233");
        celulares.add("091212235");

        int randomNum = ThreadLocalRandom.current().nextInt(350, 800);
        precioBase = new BigDecimal(randomNum);
    }

    public void insentarBoletosEspeciales(Boletos boletos){

        String ciudad;
        String celular;
        int randomNum;
        BigDecimal descuento;

        Boleto boletoEsp;

        int tope = boletos.largo() + 10;
        int largo = boletos.largo() ;

        for(int i= largo ; i<=tope ;i++) {


            ciudad = ciudades.get(new Random().nextInt(ciudades.size()));
            celular = celulares.get(new Random().nextInt(celulares.size()));
            randomNum = ThreadLocalRandom.current().nextInt(5, 90 + 1);

            descuento = new BigDecimal(randomNum);

            boletoEsp = new BoletoEspecial(i,randomNum,ciudad,celular,descuento);

            boletos.insBack(boletoEsp);
        }
    }
    public void insentarBoletosComunes(Boletos boletos){

        String ciudad;
        String celular;
        int randomNum;

        Boleto boleto;

        int tope = boletos.largo() + 10;
        int largo = boletos.largo() ;

        for(int i = largo; i<= tope ;i++) {

            ciudad = ciudades.get(new Random().nextInt(ciudades.size()));
            celular = celulares.get(new Random().nextInt(celulares.size()));
            randomNum = ThreadLocalRandom.current().nextInt(5, 90 + 1);

            boleto = new Boleto(i,randomNum,ciudad,celular);

            boletos.insBack(boleto);
        }
    }

    public void listarBoletosComunes(Boletos boletos){

        List<VOBoletoSalida> listVOBoletoSalida =  boletos.listarBoletos(TipoBoleto.COMUN);
        for (VOBoletoSalida voBS :listVOBoletoSalida) {
            System.out.println("Numero:"+voBS.getNumero()+" Edad:"+voBS.getEdad()+" Cell:"+
                    voBS.getCelular()+" Proc:"+voBS.getProcedencia());
        }
    }

    public void listarBoletosEspeciales(Boletos boletos){
        List<VOBoletoSalida> listVOBoletoSalida =  boletos.listarBoletos(TipoBoleto.ESPECIAL);
        for (VOBoletoSalida voBS :listVOBoletoSalida) {
            VOBoletoEspecialSalida voBSEsp = (VOBoletoEspecialSalida) voBS;
            System.out.println("Numero:"+voBSEsp.getNumero()+" Edad:"+voBSEsp.getEdad()+" Cell:"+
                    voBSEsp.getCelular()+" Proc:"+voBSEsp.getProcedencia()+" Desc:"+voBSEsp.getDescuento());
        }
    }

    private void imprimirBoleto(Boleto boleto){
        if(boleto instanceof BoletoEspecial){
            BoletoEspecial boletoEspecial = (BoletoEspecial) boleto;
            System.out.println("Numero:"+boletoEspecial.getNumero()+" Edad:"+boletoEspecial.getEdad()+" Cell:"+
                    boletoEspecial.getCelular()+" Proc:"+boletoEspecial.getProcedencia()+" Desc:"+boletoEspecial.getDescuento());
        } else {
            System.out.println("Numero:"+boleto.getNumero()+" Edad:"+boleto.getEdad()+" Cell:"+
                    boleto.getCelular()+" Proc:"+boleto.getProcedencia());
        }
    }
}
