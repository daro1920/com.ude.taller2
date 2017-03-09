package pruebas;

import logica.excepciones.*;
import logica.negocio.IFachada;
import logica.negocio.TipoBoleto;
import logica.valueobjects.VOBoletoEntrada;
import logica.valueobjects.VOBusEntrada;
import logica.valueobjects.VOExcursionEntrada;

import java.io.IOException;
import java.math.BigDecimal;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;



public class MainCliente {

    private static List<String> marcas = new ArrayList<String>();
    private static List<String> celulares = new ArrayList<String>();
    private static List<String> ciudades = new ArrayList<String>();
    private static List<String> matriculas = new ArrayList<String>();

    private static BigDecimal precioBase;
    private static final int numElementos = 10;

    public static void main(String[] args) {
        try {

            initializeValues();

            IFachada fachada = (IFachada) Naming.lookup("//localhost:1099/Fachada");

            registrarBuses(fachada);
            registrarExcursion(fachada);

            venderBoleto(fachada);

            String codigo = String.valueOf(ThreadLocalRandom.current().nextInt(0, 9));
            fachada.listarBoletosExcursion(codigo, TipoBoleto.COMUN);
            fachada.listarBoletosExcursion(codigo, TipoBoleto.ESPECIAL);

            System.out.println("Recaudacion: "+fachada.recaudacionExcursion(codigo));

            fachada.listarBuses();

            String matricula = matriculas.get(new Random().nextInt(matriculas.size()));
            fachada.listarExcursionesBus(matricula);

            int precioMin = ThreadLocalRandom.current().nextInt(350, 500);
            int precioMax = ThreadLocalRandom.current().nextInt(501, 800);
            fachada.listarExcursionesEntrePrecios(new BigDecimal(precioMin),new BigDecimal(precioMax));

            String destino = ciudades.get(new Random().nextInt(ciudades.size()));
            fachada.listarExcursionesHacia(destino);

            fachada.reasignarExcursion(codigo);

            fachada.respaldar();
            fachada.recuperar();




        }  catch (IOException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (NoExisteExcursionException e) {
            e.printStackTrace();
        } catch (YaExisteBusException e) {
            e.printStackTrace();
        } catch (PeriodoInvalidoException e) {
            e.printStackTrace();
        } catch (YaExisteExcursionException e) {
            e.printStackTrace();
        } catch (NoHayBusesDisponiblesException e) {
            e.printStackTrace();
        } catch (BusInexistenteException e) {
            e.printStackTrace();
        } catch (NoHayAsientosDisponiblesException e) {
            e.printStackTrace();
        } catch (ConfiguracionException e) {
            e.printStackTrace();
        } catch (PersistenciaException e) {
            e.printStackTrace();
        } catch (CapacidadInsuficienteException e) {
            e.printStackTrace();
        }
    }

    private static void registrarBuses(IFachada fachada) throws YaExisteBusException, RemoteException, CapacidadInsuficienteException {

        VOBusEntrada voBusEntrada;

        String marca;
        String matricula;
        int randomNum;

        for(int i=0; i<numElementos; i++){

            marca = marcas.get(new Random().nextInt(marcas.size()));
            matricula = matriculas.get(new Random().nextInt(matriculas.size()));
            randomNum = ThreadLocalRandom.current().nextInt(20, 90);

            voBusEntrada= new VOBusEntrada(matricula,marca,randomNum);
            fachada.registrarBus(voBusEntrada);
        }

    }

    private static void registrarExcursion(IFachada fachada) throws RemoteException, NoHayBusesDisponiblesException,
            YaExisteExcursionException, PeriodoInvalidoException {

        VOExcursionEntrada voExcursionEntrada;

        String ciudad;
        String codigo;

        for(int i=0; i<numElementos; i++){

            ciudad = ciudades.get(new Random().nextInt(ciudades.size()));

            voExcursionEntrada= new VOExcursionEntrada(String.valueOf(i),ciudad,new Date(),new Date(),precioBase);
            fachada.registrarExcursion(voExcursionEntrada);
        }

    }

    private static void venderBoleto(IFachada fachada) throws NoHayAsientosDisponiblesException, RemoteException,
            NoExisteExcursionException {

        VOBoletoEntrada voBoletoEntrada;

        int edad;
        String ciudad;
        String celular;

        for(int i=0; i<numElementos; i++){

            for(int j=0; j<numElementos; j++){

                ciudad = ciudades.get(new Random().nextInt(ciudades.size()));
                celular = celulares.get(new Random().nextInt(celulares.size()));
                edad = ThreadLocalRandom.current().nextInt(5, 90);

                voBoletoEntrada = new VOBoletoEntrada(String.valueOf(j),edad,ciudad,celular);
                fachada.venderBoleto(voBoletoEntrada);
            }


        }

    }

    private static void initializeValues() {

        marcas.add("Ford");
        marcas.add("Mercedes");
        marcas.add("Ferrari");
        marcas.add("Mitsubishi");
        marcas.add("Chevrolet");
        marcas.add("BMW");
        marcas.add("Audi");
        marcas.add("Fiat");
        marcas.add("Acura");

        matriculas.add("SAT 983541");
        matriculas.add("SAT 445562");
        matriculas.add("SAT 112233");
        matriculas.add("SAT 141414");
        matriculas.add("SAT 151687");
        matriculas.add("SAT 111222");
        matriculas.add("SAT 333321");
        matriculas.add("SAT 879546");
        matriculas.add("SAT 110100");

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
}
