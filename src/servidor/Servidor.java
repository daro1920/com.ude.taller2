package servidor;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import configuracion.Configuracion;
import logica.excepciones.ConfiguracionException;
import logica.negocio.Fachada;

public class Servidor {
	
	public static void main (String [] args) {
		
		String ipServidor;
		String puertoServidor;

		try {

			ipServidor = Configuracion.getProperty("ipServidor");
			puertoServidor = Configuracion.getProperty("puertoServidor");
			
			// pongo a correr el rmiregistry
			LocateRegistry.createRegistry(1099);
			// instancio mi Objeto Remoto y lo publico
			Fachada fachada = new Fachada();
			Naming.rebind("//" + ipServidor + ":" + puertoServidor + "/fachada", fachada);

		} catch (ConfiguracionException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
}