package cliente;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import logica.negocio.IFachada;

public class Cliente {
	public static void main (String [] args) {
		try
		{
			IFachada fachada = (IFachada) Naming.lookup("//localhost:1099/fachada");
			fachada.listarBuses();
		}
		catch (MalformedURLException e) {
			
		}
		catch (RemoteException e) {
			
		}
		catch (NotBoundException e) {
			
		}
	}
}