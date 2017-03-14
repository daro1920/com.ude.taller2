package pruebas;

import logica.negocio.Fachada;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class MainServidor {

    public static void main(String[] args) {
        try {

            LocateRegistry.createRegistry(1099);
            Fachada fachada = new Fachada();
            System.out.println("Antes de publicar");
            Naming.rebind("//localhost:1099/Fachada", fachada);
            System.out.println("Luego de publicar");

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
